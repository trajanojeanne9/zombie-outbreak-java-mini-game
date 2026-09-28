import java.util.Scanner;

/** Entry point for the Zombie Outbreak simulation. */
public class ZombieVirus {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Intro.title(); // introductory

        String name = PlayerSetup.identification(input); // player info

        if (!name.isEmpty()) {

            int playerRole = PlayerSetup.role(input); // player role part

            GameFlow.continueStory(input, name, playerRole); // runs the rest of the story, including fate loop
        }

        input.close();
    }
}
