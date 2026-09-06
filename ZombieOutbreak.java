import java.util.Scanner;

public class ZombieOutbreak {

    static String potionClass = "";

    public static void title() {
        System.out.println("==================================");
        System.out.println("         ZOMBIE OUTBREAK          ");
        System.out.println("==================================");
        System.out.println(" ");
        System.out.println("Welcome to the Zombie Outbreak Simulation!");
        System.out.println("The world has fallen into chaos as a zombie virus spreads rapidly.");
        System.out.println("Your mission is to survive and find a cure for the virus.");
        System.out.println("Will you be able to save humanity, or will you fall into the hands of the zombies?");
        System.out.println("---------------------------------------");
    }

    public static boolean identification(Scanner input) {
        System.out.println(" ");
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        if (name.trim().isEmpty()) {
            System.out.println("Name cannot be empty. Please enter a valid name.");
            return false;
        }

        System.out.print("Enter your age: ");
        int age = input.nextInt();
        if (age < 0) {
            System.out.println("Age cannot be negative. Please enter a valid age.");
            return false;
        }

        if (!(age >= 18)) {
            System.out.println("---------------------------------------");
            System.out.println("Sorry, " + name + ". You are not eligible to participate in the simulation.");
            return false;
        } else {
            System.out.println("---------------------------------------");
            System.out.println("Welcome, " + name + "! You are eligible to participate in the simulation.");
            return true;
        }
    }

    public static int role(Scanner input) {
        System.out.println("---------------------------------------");
        System.out.println("\nChoose a role:");
        System.out.println("1. Warrior");
        System.out.println("2. Artillery");
        System.out.println("3. Medic");
        System.out.println("4. Engineer");
        System.out.println("5. Scientist");
        System.out.print("Enter your choice (1-5): ");
        int role = input.nextInt();

        switch (role) {
            case 1:
                System.out.println("---------------------------------------");
                System.out.println("You have chosen the Warrior class. You excel in close combat.");
                break;
            case 2:
                System.out.println("---------------------------------------");
                System.out.println("You have chosen the Artillery class. You are skilled in long-range attacks.");
                break;
            case 3:
                System.out.println("---------------------------------------");
                System.out.println("You have chosen the Medic class. You are skilled in healing and support.");
                break;
            case 4:
                System.out.println("---------------------------------------");
                System.out.println("You have chosen the Engineer class. You are skilled in building and repairing.");
                break;
            case 5:
                System.out.println("---------------------------------------");
                System.out.println("You have chosen the Scientist class. You are skilled in research and development.");
                break;
            default:
                System.out.println("---------------------------------------");
                System.out.println("Invalid choice. Please select a class to continue.");
        }
        return role;
    }

    public static int firstAttack(Scanner input) {
        System.out.println("---------------------------------------");
        System.out.println("\nA zombie appeared out of nowhere and attacked your party!");
        System.out.println("You had been bitten. HP down to 20.");

        int hp = 20;

        System.out.println("---------------------------------------");
        System.out.print("Would you like to use a health potion? (yes/no): ");
        String potion = input.next();
        if (potion.trim().isEmpty()) {
            System.out.println("Input cannot be empty. Please enter 'yes' or 'no'.");
        }

        if (potion.equalsIgnoreCase("yes")) {
            System.out.println("---------------------------------------");
            System.out.print("Would you like to use A-Class (100 HP and flight), B-Class (80 HP and additional protection), or C-Class (50 HP and 50 damage) health potion? (A/B/C): ");
            potionClass = input.next();

            if (potionClass.equalsIgnoreCase("A")) {
                potionClass = "A";
                hp += 100;
                System.out.println("---------------------------------------");
                System.out.println("You have used an A-Class health potion, +100 HP and flight.");
            } else if (potionClass.equalsIgnoreCase("B")) {
                potionClass = "B";
                hp += 80;
                System.out.println("---------------------------------------");
                System.out.println("You have used a B-Class health potion, +80 HP and additional protection.");
            } else if (potionClass.equalsIgnoreCase("C")) {
                potionClass = "C";
                hp += 50;
                System.out.println("---------------------------------------");
                System.out.println("You have used a C-Class health potion, +50 HP and 50 damage.");
            } else {
                System.out.println("Invalid choice. Please enter A, B, or C.");
            }
        } else if (potion.equalsIgnoreCase("no")) {
            System.out.println("You have chosen not to use a health potion. Your HP remains at 20.");
        }

        System.out.println("---------------------------------------");
        System.out.println("Current HP: " + hp);
        System.out.println("---------------------------------------");

        System.out.println("Would you like to continue to the next stage? (yes/no): ");
        String continueGame = input.next();

        if (continueGame.equalsIgnoreCase("no")) {
            System.out.println("You have chosen to exit the simulation. Game Over.");
            System.exit(0);
        }

        return hp;
    }

    public static void bossFight(Scanner input, int role, int hp) {
        System.out.println("---------------------------------------");
        System.out.println("\nYou have reached the base of the Zombie King, the final boss.");
        System.out.println("Preparing for the final battle...");
        System.out.println("---------------------------------------");
        System.out.println("Your attacks seem to have no effect on the Zombie King.");
        System.out.println("Your party is in a predicament.");

        System.out.println("---------------------------------------");
        System.out.println("\nA legendary sword has appeared in front of you, capable of defeating the Zombie King.");
        System.out.println("However, certain conditions must be met in order to wield the sword.");

        System.out.println("---------------------------------------");
        System.out.println("Would you like to attempt to wield the legendary sword? (yes/no): ");
        String attemptSword = input.next();

        if (attemptSword.equalsIgnoreCase("yes")) {
            System.out.println("To use the legendary sword, you must meet the following conditions:");
            System.out.println("1. You must be a Warrior (role 1).");
            System.out.println("2. Your HP must be at least 80.");
            System.out.println("3. You must have an additional Protection.");

            if (role == 1 && potionClass.equalsIgnoreCase("B")) {
                System.out.println("---------------------------------------");
                System.out.println("You have met the conditions to wield the legendary sword.");
                System.out.println("---------------------------------------");
                System.out.println("With one strike, you have taken down the Zombie King!");
                System.out.println("The zombie outbreak has ended and humanity has been saved.");
                System.out.println("---------------------------------------");
                System.out.println("Congratulations, player! You have completed the Zombie Outbreak Simulation.");
            } else {
                System.out.println("---------------------------------------");
                System.out.println("You have not met the conditions to wield the legendary sword.");
                System.out.println("The Zombie King has defeated you and your party.");
                System.out.println("Once again, humanity has lost its hope.");
                System.out.println("---------------------------------------");
                System.out.println("Game Over.");
            }
        }

        if (attemptSword.equalsIgnoreCase("no")) {
            System.out.println("---------------------------------------");
            System.out.println("You have chosen not to attempt to wield the legendary sword.");
            System.out.println("The Zombie King has defeated you and your party.");
            System.out.println("Once again, humanity has lost its hope.");
            System.out.println("---------------------------------------");
            System.out.println("Game Over.");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        title();

        boolean eligible = identification(input);

        if (eligible) {

            int playerRole = role(input);

            int playerHP = firstAttack(input);

            bossFight(input, playerRole, playerHP);
        }

        System.out.println("---------------------------------------");
        System.out.println("Would you like to play again? (yes/no): ");
        String playAgain = input.next();

        if (playAgain.equalsIgnoreCase("yes")) {
            main(args);
        } else {
            System.out.println("Thank you for playing the Zombie Outbreak Simulation!");
        }

        input.close();
    }
}