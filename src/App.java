/**
 * App class that demonstrates the use of the `Audible` interface.
 * Creates an array of `Audible` objects, including various types (persons,
 * instruments, animals, and events),
 * and plays the sound associated with each object.
 */
public class App {
    public static void main(String[] args) {
        // Create an array of Audible objects, each representing a different sound
        // source
        Audible[] sonidos = new Audible[7];

        sonidos[0] = new Persona("Emilio", "Hombre"); // Person named Emilio with a male voice
        sonidos[1] = new Piano(); // Piano sound
        sonidos[2] = new Persona("Sara", "Mujer"); // Person named Sara with a female voice
        sonidos[3] = new Flauta(); // Flute sound
        sonidos[4] = new Animal("mi caballo", "Caballo.wav"); // Animal sound of a horse
        sonidos[5] = new Animal("mi gallo", "Gallo.wav"); // Animal sound of a rooster
        sonidos[6] = new Evento("Lanzamiento Apollo", "lanzamientoApollo.wav"); // Sound event of the Apollo launch

        // Iterate through each Audible object and play its sound
        for (Audible sonido : sonidos) {
            try {
                sonido.sonar(); // Play sound for each object
            } catch (Exception e) {
                e.printStackTrace(); // Print stack trace if an exception occurs
            }
        }
    }
}
