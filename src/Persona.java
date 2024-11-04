import java.io.File;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Represents a person with a specified name and gender.
 * Implements the `Audible` interface, allowing the person to produce a sound
 * based on their gender.
 * The sound played varies depending on whether the person is male or female.
 */
public class Persona implements Audible {
    private String nombre; // Name of the person
    private String sexo; // Gender of the person ("Hombre" or "Mujer")

    /**
     * Constructs a Persona instance with a specified name and gender.
     *
     * @param nombre The name of the person.
     * @param sexo   The gender of the person ("Hombre" for male, "Mujer" for
     *               female).
     */
    public Persona(String nombre, String sexo) {
        this.nombre = nombre;
        this.sexo = sexo;
    }

    /**
     * Plays a sound associated with the person's gender.
     * Male and female sounds are played from different audio files.
     *
     * @throws UnsupportedAudioFileException If the audio file format is not
     *                                       supported.
     * @throws IOException                   If an I/O error occurs while accessing
     *                                       the file.
     * @throws LineUnavailableException      If the audio line cannot be opened.
     */
    @Override
    public void sonar() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (this.sexo.equals("Hombre")) {
            // Play male laughter sound
            new SonidoMuestreado().play(new File("Hombre_risa.wav"));
        } else {
            // Play female laughter sound
            new SonidoMuestreado().play(new File("Mujeres_risas.wav"));
        }
    }
}
