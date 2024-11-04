/**
 * Represents a piano instrument that can produce a sound.
 * Extends the `Instrumento` class and provides an implementation of the `sonar`
 * method,
 * which generates a synthesized sound specific to the piano.
 */
public class Piano extends Instrumento {

    /**
     * Plays a synthesized sound specific to the piano by calling
     * `SonidoSintetizado` with a
     * MIDI instrument code.
     * The code `2` represents the piano sound in General MIDI.
     */
    @Override
    public void sonar() {
        new SonidoSintetizado(2); // Code 2 represents a piano sound in MIDI
    }
}
