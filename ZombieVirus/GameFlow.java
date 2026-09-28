import java.util.Scanner;

/** Runs the story from the first attack onward, plus the "fate" menu after the ending. */
public class GameFlow {

    // Runs everything from the first zombie attack (potion choice) onward.
    // "Go Back in Time" loops back to this same method (same name & role kept).
    // "Reincarnate" goes back to title/identification/role first, then calls this fresh.
    public static void continueStory(Scanner input, String name, int playerRole) {

        FirstAttack.firstAttack(input); // attack, damage, declaration of potions

        int lootChoice = LootExploration.lootExploration(input); // abandoned building, loot choice

        String syringeChoice = // only applies to medics
                    SideQuests.medicScenario(
                        input,
                        playerRole,
                        FirstAttack.potionClass,
                        lootChoice);
    SideQuests.scientistScenario(
            input,
            playerRole,
            FirstAttack.potionClass,
            lootChoice);
    SideQuests.warriorScenario(
            input,
            playerRole,
            FirstAttack.potionClass,
            lootChoice);
    SideQuests.assassinScenario(
            input,
            playerRole,
            FirstAttack.potionClass,
            lootChoice);
    SideQuests.engineerScenario(
            input,
            playerRole,
            FirstAttack.potionClass,
            lootChoice);


        boolean won = BossFight.bossFight( // final boss fight
                input,
                playerRole,
                FirstAttack.potionClass,
                lootChoice,
                syringeChoice);

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("-------------------------------------------------");
        System.out.println("       Your journey has come to an end...");
        System.out.println("");

        if (won) {
            System.out.println(" Congratualations! You have already saved humanity, but life goes on.");
            System.out.println("");
            System.out.println("[1] Reincarnate - Create a new fate as a different survivor.");
            System.out.println(" ");
            System.out.print("Choose your fate: ");
            System.out.println(" ");

            int fate = input.nextInt();
            input.nextLine();

            if (fate == 1) {
                reincarnate(input);
            } else {
                acceptFate();
            }

        } else {
            System.out.println("  But this is not necessarily your final fate.");
            System.out.println("");
            System.out.println("[1] Go Back in Time - Change your fate and correct your mistakes.");
            System.out.println("[2] Reincarnate - Create a new fate as a different survivor.");
            System.out.println(" ");
            System.out.print("Choose your fate: ");
            System.out.println(" ");

            int fate = input.nextInt();
            input.nextLine();

            if (fate == 1) { // go back in time -> replay from the potion choice onward, same name & role
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("=================================================");
                System.out.println("           You chose to Go back in Time.         ");
                System.out.println("=================================================");
                System.out.println(" ");
                System.out.println("          The clock turns backward...");
                System.out.println("You are given another chance to change your fate.");
                System.out.println(" ");
                System.out.println("-------------------------------------------------");

                continueStory(input, name, playerRole); // back to firstAttack only, name & role stay the same
            } else if (fate == 2) { // reincarnate
                reincarnate(input);
            } else { // other
                acceptFate();
            }
        }
    }

    public static void reincarnate(Scanner input) {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("=================================================");
        System.out.println("           You chose to Reincarnate.             ");
        System.out.println("=================================================");
        System.out.println(" ");
        System.out.println("      Your current life fades away...");
        System.out.println("A new life begins in a world still threatened by\n                   the outbreak.");
        System.out.println(" ");
        System.out.println("-------------------------------------------------");
        System.out.println(" ");
        System.out.println(" ");

        Intro.title(); // introductory, shown again from scratch
        String newName = PlayerSetup.identification(input); // player info, asked again

        if (!newName.isEmpty()) {
            int newRole = PlayerSetup.role(input); // role, chosen again
            continueStory(input, newName, newRole); // brand new run, starting at the very beginning
        }
    }

    public static void acceptFate() {
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println("    You have chosen to accept your fate.");
        System.out.println("           [The story ends here.]");
        System.out.println("-------------------------------------------------");
    }
}
