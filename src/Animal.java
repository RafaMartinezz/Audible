import java.io.File;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Represents an animal that can produce a sound.
 * Implements the `Audible` interface, which requires the `sonar` method to play an audio file.
 */
public class Animal implements Audible {
    private String nombre;       // Name of the animal
    private String ficheroWav;   // Path to the .wav audio file representing the animal's sound

    /**
     * Constructs an Animal with a specified name and associated sound file.
     *
     * @param nombre The name of the animal.
     * @param ficheroWav The path to the .wav file containing the sound the animal makes.
     */
    public Animal(String nombre, String ficheroWav) {
        this.nombre = nombre;
        this.ficheroWav = ficheroWav;
    }

    /**
     * Plays the sound associated with the animal by using the specified .wav file.
     * The method requires handling potential audio-related exceptions.
     *
     * @throws UnsupportedAudioFileException If the audio file format is not supported.
     * @throws IOException If an I/O error occurs while accessing the file.
     * @throws LineUnavailableException If the audio line cannot be opened.
     */
    @Override
    public void sonar() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        new SonidoMuestreado().play(new File(ficheroWav)); // Plays the audio file for the animal sound
    }
}
