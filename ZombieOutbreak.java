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
        input.nextLine(); // consume leftover newline after nextInt()

        if (age < 0) {
            System.out.println("Age cannot be negative. Please enter a valid age.");
            return false;
        }

        if (age < 18) {
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
        int chosenRole = input.nextInt();

        switch (chosenRole) {
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
        return chosenRole;
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
            System.out.print("Would you like to use: ");
            System.out.println("A. Blue Potion (+80 HP)");   // engineer
            System.out.println("B. Red Potion (+100 HP)");   // medic
            System.out.println("C. Orange Potion (+50 HP)"); // warrior
            System.out.println("D. Black Potion (+30 HP)");  // cowboy
            System.out.println("E. White Potion (+60 HP)");  // scientist
            System.out.print("\nEnter your choice (A-E): ");
            String choice = input.next().trim().toUpperCase();

            switch (choice) {
                case "A":
                    hp += 80;
                    System.out.println("---------------------------------------");
                    System.out.println("You have used blue health potion, +80 HP.");
                    potionClass = "A";
                    break;
                case "B":
                    hp += 100;
                    System.out.println("---------------------------------------");
                    System.out.println("You have used red health potion, +100 HP.");
                    potionClass = "B";
                    break;
                case "C":
                    hp += 50;
                    System.out.println("---------------------------------------");
                    System.out.println("You have used orange health potion, +50 HP.");
                    potionClass = "C";
                    break;
                case "D":
                    hp += 30;
                    System.out.println("---------------------------------------");
                    System.out.println("You have used black health potion, +30 HP.");
                    potionClass = "D";
                    break;
                case "E":
                    hp += 60;
                    System.out.println("---------------------------------------");
                    System.out.println("You have used white health potion, +60 HP.");
                    potionClass = "E";
                    break;
                default:
                    System.out.println("Invalid choice. No potion applied.");
                    potionClass = "";
            }
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

     // PART 2: explore abandoned building, open loot box, pick ONE item
    public static void lootExploration(Scanner input) {
        System.out.println("---------------------------------------");
        System.out.println("\nYour party moves through the ruined streets and comes across an abandoned building.");
        System.out.println("Inside, tucked behind some rubble, you spot a loot box.");
        System.out.println("---------------------------------------");
        System.out.print("Would you like to open the loot box? (yes/no): ");

        String openLoot = input.next();

        if (openLoot.equalsIgnoreCase("yes")) {
            System.out.println("---------------------------------------");
            System.out.println("You pry open the loot box and find several useful items:");
            System.out.println("1. Metal Scraps");
            System.out.println("2. Additional Protection");
            System.out.println("3. Gunpowder");
            System.out.println("4. Mystery Syringe");
            System.out.println("5. Mask");
            System.out.println("---------------------------------------");
            System.out.println("Oh no, your inventory is full, you must only get one. Which one are you choosing?");
            System.out.print("Enter your choice (1-5): ");
            String lootChoice = input.next();

            if (lootChoice.equals("1")) {
                System.out.println("---------------------------------------");
                System.out.println("You picked up Metal Scraps.");
            } else if (lootChoice.equals("2")) {
                System.out.println("---------------------------------------");
                System.out.println("You picked up Armor.");
            } else if (lootChoice.equals("3")) {
                System.out.println("---------------------------------------");
                System.out.println("You picked up Gunpowder.");
            } else if (lootChoice.equals("4")) {
                System.out.println("---------------------------------------");
                System.out.println("You picked up a Mystery Syringe. It hums faintly in your hand.");
            } else if (lootChoice.equals("5")) {
                System.out.println("---------------------------------------");
                System.out.println("You picked up a Mask.");
            } else {
                System.out.println("---------------------------------------");
                System.out.println("Invalid choice. You leave the loot box empty-handed.");
            }
        } else {
            System.out.println("You decide not to open the loot box and continue on.");
        }

        System.out.println("---------------------------------------");
    }

    // MEDIC-ONLY: only reachable if role == Medic and they actually picked up the syringe
    public static void survivorScenario(Scanner input, int chosenRole, String lootChoice) {
        if (chosenRole == 3 || !lootChoice.equals("5")) {
            return; // Only proceed if the player is a Medic and has the Mystery Syringe
        }
        System.out.println("---------------------------------------");
        System.out.println("\nAs you continue forward, you hear screaming. A group of survivors is trapped and begging for help.");
        System.out.println("You still have the Mystery Syringe. It might be able to help them.");
        System.out.println("---------------------------------------");
        System.out.print("Would you like to give them the syringe, or save it for the fight ahead? (give/save): ");
        String choice = input.next();

        if (choice.equalsIgnoreCase("give")) {
            System.out.println("---------------------------------------");
            System.out.println("You hand over the Mystery Syringe. The survivors are saved and thank you for your kindness.");
            System.out.println("However, you no longer have the syringe for what lies ahead.");
        } else {
            System.out.println("---------------------------------------");
            System.out.println("You decide to save the syringe. The survivors' cries fade behind you as you press on.");
        }

        System.out.println("---------------------------------------");
    }

    public static void bossFight(Scanner input, int role, int hp, String potionClass) {
        System.out.println("---------------------------------------");
        System.out.println("\nYou have reached the base of the Zombie King, the final boss.");
        System.out.println("Preparing for the final battle...");
        System.out.println("---------------------------------------");
        System.out.println("Your attacks seem to have no effect on the Zombie King.");
        System.out.println("Your party is in a predicament.");

        System.out.println("---------------------------------------");
        System.out.println("\nDifferent materials has appeared in front of you, capable of defeating the Zombie King.");
        System.out.println("Would you like to attempt to use them? (yes/no): ");
        String attemptMaterial = input.next();

        if (attemptMaterial.equalsIgnoreCase("no")) {
            System.out.println("---------------------------------------");
            System.out.println("You have chosen not to attempt to use the materials.");
            System.out.println("The Zombie King has defeated you and your party.");
            System.out.println("Once again, humanity has lost its hope.");
            System.out.println("---------------------------------------");
            System.out.println("Game Over.");
            return;
        }

        if (!attemptMaterial.equalsIgnoreCase("yes")) {
            System.out.println("---------------------------------------");
            System.out.println("Invalid input. The Zombie King has defeated you and your party.");
            System.out.println("Once again, humanity has lost its hope.");
            System.out.println("---------------------------------------");
            System.out.println("Game Over.");
            return;
        }

        System.out.println("---------------------------------------");
        System.out.println("You have chosen to attempt to use the materials.");
        System.out.println("Choose one materials you would like to use:");
        System.out.println("1. Legendary Sword");
        System.out.println("2. Bullet");
        System.out.println("3. Poisoned Syringe");
        System.out.println("4. Biohazard Device");
        System.out.println("5. Poisonous Smoke");
        System.out.print("Enter your choice (1-5): ");
        String materialChoice = input.next();

        switch (materialChoice) {
            case "1":
                System.out.println("---------------------------------------");
                System.out.println("You have chosen the Legendary Sword.");
                System.out.println("To wield the legendary sword, you must meet the following conditions:");
                System.out.println("1. You must be a Warrior class.");
                System.out.println("2. You must have at least 80 hp.");
                System.out.println("3. You must have an additional protection.");
                System.out.println("Would you like to attempt to wield the Legendary Sword? (yes/no): ");
                String attemptSword = input.next();

                if (attemptSword.equalsIgnoreCase("yes")) {
                    if (role == 1 && potionClass == "C") {
                        System.out.println("---------------------------------------");
                        System.out.println("You have successfully wielded the Legendary Sword!");
                        System.out.println("The Legendary Sword has defeated the Zombie King!");
                        System.out.println("Congratulations! You have saved humanity!");
                    } else {
                        System.out.println("---------------------------------------");
                        System.out.println("You do not meet the conditions to wield the Legendary Sword.");
                        System.out.println("The Zombie King has defeated you and your party.");
                        System.out.println("Once again, humanity has lost its hope.");
                    }
                } else {
                    System.out.println("---------------------------------------");
                    System.out.println("You have chosen not to attempt to wield the Legendary Sword.");
                    System.out.println("The Zombie King has defeated you and your party.");
                    System.out.println("Once again, humanity has lost its hope.");
                }
                break;
            case "2":
                System.out.println("---------------------------------------");
                System.out.println("You have chosen the Bullet.");
               
                break;
            case "3":
                System.out.println("---------------------------------------");
                System.out.println("You have chosen the Poisoned Syringe.");
                System.out.println("The Poisoned Syringe has defeated the Zombie King!");
                System.out.println("Congratulations! You have saved humanity!");
                break;
            case "4":
                System.out.println("---------------------------------------");
                System.out.println("You have chosen the Biohazard Device.");
                System.out.println("The Biohazard Device has defeated the Zombie King!");
                System.out.println("Congratulations! You have saved humanity!");
                break;
            case "5":
                System.out.println("---------------------------------------");
                System.out.println("You have chosen the Poisonous Smoke.");
                System.out.println("The Poisonous Smoke has defeated the Zombie King!");
                System.out.println("Congratulations! You have saved humanity!");
                break;
            default:
                System.out.println("---------------------------------------");
                System.out.println("Invalid choice. The Zombie King has defeated you and your party.");
                System.out.println("Once again, humanity has lost its hope.");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        title();

        boolean eligible = identification(input);

        if (eligible) {
            int playerRole = role(input);
            int playerHP = firstAttack(input);
            bossFight(input, playerRole, playerHP, potionClass);
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
