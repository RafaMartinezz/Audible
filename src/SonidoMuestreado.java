import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

/**
 * Manages sampled audio playback, providing methods to play audio files, adjust
 * volume,
 * and track playback completion. Implements `LineListener` to listen for audio
 * line events.
 */
public class SonidoMuestreado implements LineListener {
    private Clip clip; // Audio clip to be played
    private AudioInputStream audioIn; // Stream for audio data
    private boolean finCancion; // Flag to indicate when the song has finished

    /**
     * Constructs a `SonidoMuestreado` instance by initializing the audio clip.
     *
     * @throws LineUnavailableException if a suitable line for playback is
     *                                  unavailable.
     */
    public SonidoMuestreado() throws LineUnavailableException {
        clip = AudioSystem.getClip(); // Initialize the audio clip
    }

    /**
     * Plays the specified audio file. Closes any previous audio streams and clips
     * before
     * starting playback of the new file.
     *
     * @param file The audio file to play.
     * @throws UnsupportedAudioFileException if the audio file format is not
     *                                       supported.
     * @throws IOException                   if an I/O error occurs while accessing
     *                                       the file.
     * @throws LineUnavailableException      if a suitable line for playback is
     *                                       unavailable.
     */
    public void play(File file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // Close previous audio input stream and clip if they are active
        if (audioIn != null) {
            audioIn.close();
        }
        if (clip != null) {
            clip.close();
        }

        // Open the new audio file and start playback
        audioIn = AudioSystem.getAudioInputStream(file);
        clip.open(audioIn);
        clip.start();

        finCancion = false; // Reset the end-of-song flag
        clip.addLineListener(this); // Add a listener to monitor playback status

        // Wait for playback to complete by periodically checking `finCancion`
        while (!finCancion) {
            try {
                Thread.sleep(500); // Check every 500 milliseconds
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        clip.close(); // Close the clip after playback completes
    }

    /**
     * Adjusts the volume of the current audio playback.
     *
     * @param ganancia The amount to increase or decrease the volume. Positive
     *                 values
     *                 increase volume, negative values decrease volume.
     */
    public void volumen(float ganancia) {
        if (clip.isRunning()) { // Only adjust volume if clip is currently playing
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float volActual = volume.getValue();
            System.out.println("Volumen actual " + volActual);

            // Adjust volume within the valid range
            if (volActual + ganancia > -10 && volActual + ganancia < 6.01) {
                volume.setValue(volActual + ganancia);
            } else if (volActual >= -10 && ganancia < 0) {
                volume.setValue(-80); // Set to minimum volume if reducing below -10
            } else if (volActual == -80 && ganancia > 0) {
                volume.setValue(-9); // Reset to a default low volume if increasing from minimum
            }
        }
    }

    /**
     * Called when the audio line changes state. Sets `finCancion` to true when
     * playback stops.
     *
     * @param event The event triggered by a change in line status.
     */
    @Override
    public void update(LineEvent event) {
        if (event.getType() == LineEvent.Type.STOP) {
            finCancion = true; // Mark the song as finished when playback stops
        }
    }
}
