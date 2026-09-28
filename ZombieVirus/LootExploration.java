import java.util.Scanner;

/** Stage 2: the abandoned building and the loot box. */
public class LootExploration {

    // PART 2 EXPLORE THE ABANDONED BUILDING
    public static int lootExploration(Scanner input) {

        System.out.println("-------------------------------------------------");
        System.out.println("\n Your party moves through the ruined streets and\n     comes across an abandoned building.");
        System.out.println(" Inside, tucked behind some rubble, you spot a \n                   loot box.");
        System.out.println(" ");
        System.out.println("-------------------------------------------------");

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        //OPENING OMG....
        System.out.print("Would you like to open the loot box? (yes/no): ");
        String openLoot = input.next();

        int lootChoice = 0;

        //CHOICES IF YES
        if (openLoot.equalsIgnoreCase("yes")) {

            System.out.println(" ");
            System.out.println("-------------------------------------------------");
            System.out.println("You pry open the loot box and find several useful\nitems:");

            System.out.println("1. Metal Scraps");
            System.out.println("2. Mask");
            System.out.println("3. Mystery Syringe");
            System.out.println("4. Invincibility Cloak");
            System.out.println("5. Talisman");

            System.out.println("-------------------------------------------------");
            System.out.println(" ");

            System.out.println("Oh no, your inventory is full, you must only get \none. Which one are you choosing?");
            System.out.println(" ");

            System.out.print("Enter your choice (1-5): ");
            if (!input.hasNextInt()) {
                System.out.println("Invalid input, please enter a number.");
                input.nextLine(); // Clear the invalid input
                return lootExploration(input);
            }

            lootChoice = input.nextInt();

            switch (lootChoice) {
                case 1:
                    System.out.println(" ");
                    System.out.println("=================================================");
                    System.out.println("          You have chosen Metal Scraps!         ");
                    System.out.println("=================================================");
                    System.out.println(" ");
                    break;

                case 2:
                    System.out.println(" ");
                    System.out.println("=================================================");
                    System.out.println("              You have chosen Mask!             ");
                    System.out.println("=================================================");
                    System.out.println(" ");
                    break;

                case 3:
                    System.out.println(" ");
                    System.out.println("=================================================");
                    System.out.println("        You have chosen Mystery Syringe!        ");
                    System.out.println("=================================================");
                    System.out.println(" ");
                    break;

                case 4:
                    System.out.println(" ");
                    System.out.println("=================================================");
                    System.out.println("           You have chosen Invincibility Cloak!           ");
                    System.out.println("=================================================");
                    System.out.println(" ");
                    break;

                case 5:
                    System.out.println(" ");
                    System.out.println("=================================================");
                    System.out.println("             You have chosen Talisman!           ");
                    System.out.println("=================================================");
                    System.out.println(" ");
                    break;

                default:
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("Invalid choice. You leave the loot box untouched.");
            }

        // CHOSE NOT TO OPEN
        } else {

            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

            System.out.println("You decide not to open the loot box and continue on.");
        }
        return lootChoice;
    }
}
