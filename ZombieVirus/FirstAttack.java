import java.util.Scanner;

/** Stage 1: the first zombie attack and the health potion choice. */
public class FirstAttack {

    // Potion picked during the first attack (0 = none). Read later by the boss fight.
    static int potionClass = 0;

    //THE FIRST ATTACK
    public static int firstAttack(Scanner input) {

        System.out.println("-------------------------------------------------");
        System.out.println("\n  A zombie appeared out of nowhere and attacked \n                your party!");
        System.out.println(" ");
        System.out.println("    [You had been bitten. HP down to 20.]");

        int hp = 20;

        System.out.println(" ");
        System.out.println("-------------------------------------------------");
        System.out.println(" ");

        System.out.print("Would you like to use a health potion? (yes/no): ");
        String potionUse = input.next();

        System.out.println(" ");

        if (potionUse.trim().isEmpty()) {
            System.out.println("Input cannot be empty. Please enter 'yes' or 'no'.");
            return firstAttack(input);
        }

        //POTION CHOICES IF YES
        if (potionUse.equalsIgnoreCase("yes")) {

            System.out.println(" ");
            System.out.println("=================================================");
            System.out.println("              CHOOSE YOUR POTION                ");
            System.out.println("=================================================");
            System.out.println("Choose wisely, each potion has a hidden effects.");

            System.out.println("\n1. Blue Potion (+80 HP)");
            System.out.println("2. Red Potion (+100 HP)");
            System.out.println("3. Orange Potion (+50 HP)");
            System.out.println("4. Black Potion (+30 HP)");
            System.out.println("5. White Potion (+60 HP)");

            System.out.print("\nEnter your choice (1-5): ");
            if (!input.hasNextInt()) {
                System.out.println("Invalid input, please enter a number.");
                input.nextLine(); // Clear the invalid input
                return firstAttack(input);
            }
            potionClass = input.nextInt();

            switch (potionClass) {
                case 1:
                    hp += 80;
                    potionClass = 1;

                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("-------------------------------------------------");
                    System.out.println("   You have used blue health potion, +80 HP.");
                    break;

                case 2:
                    hp += 100;
                    potionClass = 2;

                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("-------------------------------------------------");
                    System.out.println("   You have used red health potion, +100 HP.");
                    break;

                case 3:
                    hp += 50;
                    potionClass = 3;

                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("-------------------------------------------------");
                    System.out.println("   You have used orange health potion, +50 HP.");
                    break;

                case 4:
                    hp += 30;
                    potionClass = 4;

                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("-------------------------------------------------");
                    System.out.println("   You have used black health potion, +30 HP.");
                    break;

                case 5:
                    hp += 60;
                    potionClass = 5;

                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("-------------------------------------------------");
                    System.out.println("   You have used white health potion, +60 HP.");
                    break;

                default:
                    System.out.println(" ");
                    System.out.println("Invalid choice. No potion applied.");
                    potionClass = 0;
                    return potionClass;
            }
        }

        System.out.println("-------------------------------------------------");
        System.out.println("               !!!REMEMBER!!!                    ");
        System.out.println("               Current HP: " + hp);
        System.out.println("-------------------------------------------------");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Would you like to continue to the next stage? (yes/no): ");
        String continueGame = input.next();

        //IF NO
        if (continueGame.equalsIgnoreCase("no")) {
            System.out.println("You have chosen to exit the simulation. Game Over.");
            System.exit(0);
        }

        return hp;
    }
}
