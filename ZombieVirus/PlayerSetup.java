import java.util.Scanner;

/** Asks for the player's name/age and lets them choose a role. */
public class PlayerSetup {

    //PLAYER INFO
    public static String identification(Scanner input) {
        System.out.println(" ");
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        if (name.trim().isEmpty()) {
            System.out.println("Name cannot be empty. Please enter a valid name.");
            return identification(input);
        }

        System.out.print("Enter your age: ");
        if (!input.hasNextInt()) {
            System.out.println("-------------------------------------------------");
            System.out.println("Invalid input, please enter a number.");
            input.nextLine(); // Clear the invalid input
            return identification(input);
        }

        int age = input.nextInt();
        input.nextLine();


        if (!(age >= 18)) {
            System.out.println(" ");
            System.out.println("-------------------------------------------------");
            System.out.println(" ");
            System.out.println("Sorry, " + name + ". You are not eligible to participate \n    in the simulation.Try Again Next Time.");
            System.out.println(" ");
            return identification(input);
        } else {
            System.out.println(" ");
            System.out.println("-------------------------------------------------");
            System.out.println(" ");
            System.out.println("WELCOME, " + name + "! You are eligible to participate\n              in the simulation.");
            System.out.println(" ");
            return name;
        }
    }

    public static int role(Scanner input) {
        System.out.println(" ");
        System.out.println(" ");

        //THE ROLE CHOICES
        System.out.println("=================================================");
        System.out.println("                CHOOSE YOUR ROLE                ");
        System.out.println("=================================================");
        System.out.println("1. Warrior");
        System.out.println("2. Assassin");
        System.out.println("3. Medic");
        System.out.println("4. Engineer");
        System.out.println("5. Scientist");
        System.out.println(" ");

        System.out.print("Enter your choice (1-5): ");
         if (!input.hasNextInt()) {
            System.out.println("-------------------------------------------------");
            System.out.println("Invalid input, please enter a number.");
            input.nextLine(); // Clear the invalid input
            return role(input);
         }

        int roleChoice = input.nextInt();

        switch (roleChoice) {
            case 1:
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println(" You have chosen the WARRIOR class. You excel in \n              close combat.");
                System.out.println(" ");
                break;

            case 2:
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println("You have chosen the ASSASSIN class. You are skilled\n      in stealth and precision kills.");
                System.out.println(" ");
                break;

            case 3:
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println("You have chosen the MEDIC class. You are skilled \n           in healing and support.");
                System.out.println(" ");
                break;

            case 4:
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println("   You have chosen the ENGINEER class. You are \n      skilled in building and repairing.");
                System.out.println(" ");
                break;

            case 5:
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println("  You have chosen the SCIENTIST class. You are \n     skilled in research and development.");
                System.out.println(" ");
                break;

            default:
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println("Invalid choice. Please select a class to continue.");
                System.out.println(" ");
                return role(input);
        }

        return roleChoice;
    }
}
