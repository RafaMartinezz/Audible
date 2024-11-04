/**
 * Represents a flute instrument that can produce a sound.
 * Extends the `Instrumento` class and provides an implementation of the `sonar`
 * method,
 * which generates a synthesized sound specific to the flute.
 */
public class Flauta extends Instrumento {

    /**
     * Plays a synthesized sound specific to the flute by calling
     * `SonidoSintetizado` with a
     * MIDI instrument code.
     * The code `73` represents the flute sound in General MIDI.
     */
    @Override
    public void sonar() {
        new SonidoSintetizado(73); // Code 73 represents a flute sound in MIDI
    }
}
