import java.io.File;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Represents an event with an associated audio recording.
 * Implements the `Audible` interface, allowing the event to play its sound when invoked.
 */
public class Evento implements Audible {
    private String nombre; // Name of the event
    private String audio;  // Path to the audio file associated with the event

    /**
     * Constructs an Evento with a specified name and audio file.
     *
     * @param nombre The name of the event.
     * @param audio The path to the .wav file containing the event's sound.
     */
    public Evento(String nombre, String audio) {
        this.nombre = nombre;
        this.audio = audio;
    }

    /**
     * Plays the sound associated with the event using the specified .wav file.
     * This method requires handling potential audio-related exceptions.
     *
     * @throws UnsupportedAudioFileException If the audio file format is not supported.
     * @throws IOException If an I/O error occurs while accessing the file.
     * @throws LineUnavailableException If the audio line cannot be opened.
     */
    @Override
    public void sonar() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        new SonidoMuestreado().play(new File(this.audio)); // Plays the audio file for the event
    }
}
