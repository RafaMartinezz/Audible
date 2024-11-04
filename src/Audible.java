/**
 * Audible interface that defines a contract for objects capable of producing
 * sound.
 * Classes implementing this interface must provide an implementation of the
 * `sonar` method,
 * which is expected to play a sound associated with the object.
 */
public interface Audible {
    /**
     * Plays the sound associated with the implementing object.
     * This method may throw exceptions related to audio playback, such as file
     * handling
     * or unsupported formats.
     *
     * @throws Exception if an error occurs during audio playback.
     */
    void sonar() throws Exception;
}
