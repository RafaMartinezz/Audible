import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

/**
 * Plays a sequence of synthesized musical notes for a specified MIDI
 * instrument.
 * This class uses the Java MIDI system to generate sounds for different
 * instruments.
 */
class SonidoSintetizado {

    /**
     * Constructs a `SonidoSintetizado` object that plays a short melody using the
     * specified
     * MIDI instrument.
     *
     * @param instrumento The MIDI instrument code to use for playback.
     *                    Example: 0 for Acoustic Grand Piano, 73 for Flute, etc.
     */
    public SonidoSintetizado(int instrumento) {
        try {
            // Initialize the MIDI synthesizer
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open(); // Open the synthesizer to start playing sounds

            MidiChannel miCanal = synth.getChannels()[0]; // Get the first MIDI channel

            int volume = 80; // Set volume level (0 to 127)
            int duration = 200; // Duration of each note in milliseconds

            // Set the instrument on the MIDI channel
            miCanal.programChange(instrumento);

            // Define a series of notes to play (a simple scale)
            int[] notas = { 60, 62, 64, 65, 67, 69, 71, 72 }; // C4 to C5 scale

            // Play each note in the sequence
            for (int nota : notas) {
                miCanal.noteOn(nota, volume); // Start playing the note
                Thread.sleep(duration); // Wait for the note's duration
                miCanal.noteOff(nota); // Stop playing the note
            }

            // Wait a moment before closing the synthesizer
            Thread.sleep(500);
            synth.close(); // Close the synthesizer after playback is complete

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
