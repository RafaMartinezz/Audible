/**
 * Abstract class representing a musical instrument that can produce sound.
 * Implements the `Audible` interface, requiring a `sonar` method that each
 * specific instrument
 * subclass must implement to produce its unique sound.
 */
abstract class Instrumento implements Audible {

    /**
     * Abstract method that subclasses must implement to play the sound of the
     * instrument.
     * The implementation details will vary depending on the type of instrument.
     */
    @Override
    public abstract void sonar();
}
