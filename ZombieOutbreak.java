import java.util.Scanner;

public class ZombieTerminal_1 {

    static String lootItem = "";
    static boolean gaveSyringeAway = false;

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
        System.out.println("1. Engineer");
        System.out.println("2. Medic");
        System.out.println("3. Warrior");
        System.out.println("4. Cowboy");
        System.out.println("5. Scientist");
        System.out.print("Enter your choice (1-5): ");
        int role = input.nextInt();

        switch (role) {
            case 1:
                System.out.println("---------------------------------------");
                System.out.println("You have chosen the Engineer class. You are skilled in building and repairing.");
                break;
            case 2:
                System.out.println("---------------------------------------");
                System.out.println("You have chosen the Medic class. You are skilled in healing and support");
                break;
            case 3:
                System.out.println("---------------------------------------");
                System.out.println("You have chosen the Warrior class. You excel in close combat.");
                break;
            case 4:
                System.out.println("---------------------------------------");
                System.out.println("You have chosen the Cowboy class. You are skilled in long-range attacks.");
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

    // PART 1: first attack + HP-only potion choice
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
            System.out.println("Would you like to use: ");
            System.out.println("Blue Potion"); // engineer
            System.out.println("Red Potion (+100 HP)"); // medic
            System.out.println("Orange Potion (+50 HP)"); // warrior
            System.out.println("Black Potion (+30 HP)"); // cowboy
            System.out.println("White Potion (+60 HP)"); // scientist
            System.out.print("Enter your choice (Choose Color): ");
            String hpPotion = input.next();

            if (hpPotion.equalsIgnoreCase("Blue")) {
                hp += 80;
                System.out.println("---------------------------------------");
                System.out.println("You have used an A-Class health potion, +80 HP.");
            } else if (hpPotion.equalsIgnoreCase("Red")) {
                hp += 100;
                System.out.println("---------------------------------------");
                System.out.println("You have used a B-Class health potion, +100 HP.");
            } else if (hpPotion.equalsIgnoreCase("Orange")) {
                hp += 50;
                System.out.println("---------------------------------------");
                System.out.println("You have used a C-Class health potion, +50 HP.");
            } else if (hpPotion.equalsIgnoreCase("Black")) {
                hp += 30;
                System.out.println("---------------------------------------");
                System.out.println("You have used a D-Class health potion, +30 HP.");
            } else if (hpPotion.equalsIgnoreCase("White")) {
                hp += 60;
                System.out.println("---------------------------------------");
                System.out.println("You have used an E-Class health potion, +60 HP.");
            } else {
                System.out.println("Invalid choice. No health potion used.");
            }
        } else if (potion.equalsIgnoreCase("no")) {
            System.out.println("You have chosen not to use a health potion. Your HP remains at 20.");
        }

        System.out.println("---------------------------------------");
        System.out.println("Current HP: " + hp);
        System.out.println("---------------------------------------");
        
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

            if (lootChoice.equalsIgnoreCase("1")) {
                lootItem = "Metal Scraps";
                System.out.println("---------------------------------------");
                System.out.println("You picked up Metal Scraps.");
            } else if (lootChoice.equalsIgnoreCase("2")) {
                lootItem = "Armor";
                System.out.println("---------------------------------------");
                System.out.println("You picked up Armor.");
            } else if (lootChoice.equalsIgnoreCase("3")) {
                lootItem = "Gunpowder";
                System.out.println("---------------------------------------");
                System.out.println("You picked up Gunpowder.");
            } else if (lootChoice.equalsIgnoreCase("4")) {
                lootItem = "Mystery Syringe";
                System.out.println("---------------------------------------");
                System.out.println("You picked up a Mystery Syringe. It hums faintly in your hand.");
            } else if (lootChoice.equalsIgnoreCase("5")) {
                lootItem = "Mask";
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
    public static void survivorScenario(Scanner input) {
        System.out.println("---------------------------------------");
        System.out.println("\nAs you continue forward, you hear screaming. A group of survivors is trapped and begging for help.");
        System.out.println("You still have the Mystery Syringe. It might be able to help them.");
        System.out.println("---------------------------------------");
        System.out.print("Would you like to give them the syringe, or save it for the fight ahead? (give/save): ");

        String choice = input.next();

        if (choice.equalsIgnoreCase("give")) {
            gaveSyringeAway = true;
            System.out.println("---------------------------------------");
            System.out.println("You hand over the Mystery Syringe. The survivors are saved and thank you for your kindness.");
            System.out.println("However, you no longer have the syringe for what lies ahead.");
        } else {
            System.out.println("---------------------------------------");
            System.out.println("You decide to save the syringe. The survivors' cries fade behind you as you press on.");
        }

        System.out.println("---------------------------------------");
    }

    public static void bossFight(Scanner input, int role, int hp) {

       System.out.println("---------------------------------------");
            System.out.println("God sent you a divine chest: Choose one of the following items to help you in the final battle:");
            System.out.println("Excalibur (Legendary Sword)");
            System.out.println("Annihilator (Legendary Gun)");
            System.out.println("Venomous Cloud (Legendary Poisonous Smoke)");
            System.out.println("");
            System.out.println("---------------------------------------");
        System.out.print("Would you like to attempt to wield the 'sword', the 'gun', the 'poisonous-smoke', the 'syringe', or 'neither'? (sword/gun/poisonous-smoke/syringe/neither): ");

        String attemptWeapon = input.next();

        if (attemptWeapon.equalsIgnoreCase("sword")) {

            if (role == 3) {

                System.out.println("---------------------------------------");
                System.out.println("You have met the conditions to wield the legendary sword.");
                System.out.print("Would you like to strike the Zombie King? (yes/no): ");
                System.out.println("---------------------------------------");

                String strike = input.next();
                if (strike.equalsIgnoreCase("yes")) {
                    System.out.println("With one strike, you have taken down the Zombie King!");
                    System.out.println("The zombie outbreak has ended and humanity has been saved.");
                    System.out.println("---------------------------------------");
                    System.out.println("Congratulations, player! You have completed the Zombie Outbreak Simulation.");
                } else {
                    System.out.println("You have chosen not to strike the Zombie King. The Zombie King has defeated you and your party.");
                    System.out.println("Once again, humanity has lost its hope.");
                    System.out.println("---------------------------------------");
                    System.out.println("Game Over.");
                }

            } else {
                System.out.println("To use the legendary sword, you must meet the following conditions:");
                System.out.println("1. You must be a Warrior.");
                System.out.println("You do not meet the conditions to wield the legendary sword.");
                System.out.println("The Zombie King is running after you.");
                System.out.println("GAME OVER!.");
            }

        } else if (attemptWeapon.equalsIgnoreCase("gun")) {

            if (role == 4 && lootItem.equalsIgnoreCase("Gunpowder")) {

                System.out.println("---------------------------------------");
                System.out.println("You have met the conditions to wield the legendary gun.");
                System.out.print("Would you like to fire the legendary gun at the Zombie King? (yes/no): ");
                System.out.println("---------------------------------------");

                String fire = input.next();
                if (fire.equalsIgnoreCase("yes")) {
                    System.out.println("With a devastating blast, you have taken down the Zombie King!");
                    System.out.println("The zombie outbreak has ended and humanity has been saved.");
                    System.out.println("---------------------------------------");
                    System.out.println("Congratulations, player! You have completed the Zombie Outbreak Simulation.");
                } else {
                    System.out.println("You have chosen not to fire the legendary gun. The Zombie King has defeated you and your party.");
                    System.out.println("Once again, humanity has lost its hope.");
                    System.out.println("---------------------------------------");
                    System.out.println("Game Over.");
                }

            } else {
                System.out.println("To use the legendary gun, you must meet the following conditions:");
                System.out.println("1. You must be an Artillery.");
                System.out.println("2. You must have Gunpowder.");
                System.out.println("You do not meet the conditions to wield the legendary gun.");
                System.out.println("The Zombie King is running after you.");
                System.out.println("GAME OVER!.");
            }

        } else if (attemptWeapon.equalsIgnoreCase("poisonous-smoke")) {

            if (role == 5 && lootItem.equalsIgnoreCase("Mask")) {

                System.out.println("---------------------------------------");
                System.out.println("You have met the conditions to wield the poisonous smoke.");
                System.out.print("Would you like to cast the poisonous smoke at the Zombie King? (yes/no): ");
                System.out.println("---------------------------------------");

                String cast = input.next();
                if (cast.equalsIgnoreCase("yes")) {
                    System.out.println("With a deadly cloud of poisonous smoke, you have taken down the Zombie King!");
                    System.out.println("The zombie outbreak has ended and humanity has been saved.");
                    System.out.println("\n---------------------------------------");
                    System.out.println("Congratulations, player! You have completed the Zombie Outbreak Simulation.");
                } else {
                    System.out.println("You have chosen not to cast the poisonous smoke. The Zombie King has defeated you and your party.");
                    System.out.println("Once again, humanity has lost its hope.");
                    System.out.println("---------------------------------------");
                    System.out.println("Game Over.");
                }

            } else {
                System.out.println("To use the poisonous smoke, you must meet the following conditions:");
                System.out.println("1. You must be a Scientist.");
                System.out.println("2. You must have a Mask.");
                System.out.println("You do not meet the conditions to wield the poisonous smoke.");
                System.out.println("The Zombie King is running after you.");
                System.out.println("GAME OVER!.");
            }

        } else if (attemptWeapon.equalsIgnoreCase("syringe")) {

            if (role == 2 && lootItem.equalsIgnoreCase("Mystery Syringe") && !gaveSyringeAway) {

                System.out.println("---------------------------------------");
                System.out.println("You still have the Mystery Syringe. This might be the cure the world has been waiting for.");
                System.out.print("Would you like to inject the Zombie King with the Mystery Syringe? (yes/no): ");
                System.out.println("---------------------------------------");

                String inject = input.next();
                if (inject.equalsIgnoreCase("yes")) {
                    System.out.println("The Mystery Syringe works! The Zombie King is cured of the virus and returns to being human.");
                    System.out.println("The zombie outbreak has ended and humanity has been saved, without a single life lost.");
                    System.out.println("---------------------------------------");
                    System.out.println("Congratulations, player! You have completed the Zombie Outbreak Simulation with the true ending.");
                } else {
                    System.out.println("You have chosen not to use the Mystery Syringe. The Zombie King has defeated you and your party.");
                    System.out.println("Once again, humanity has lost its hope.");
                    System.out.println("---------------------------------------");
                    System.out.println("Game Over.");
                }

            } else {
                System.out.println("To use the Mystery Syringe, you must meet the following conditions:");
                System.out.println("1. You must be a Medic.");
                System.out.println("2. You must have picked up the Mystery Syringe.");
                System.out.println("3. You must not have given it away to the survivors.");
                System.out.println("You do not meet the conditions to use the syringe.");
                System.out.println("The Zombie King is running after you.");
                System.out.println("GAME OVER!.");
            }

        } else {
            System.out.println("You have chosen not to attempt to wield any weapon.");
            System.out.println("The Zombie King has defeated you and your party.");
            System.out.println("GAME OVER!.");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        title();

        boolean eligible = identification(input);

        if (eligible) {

            int playerRole = role(input);

            int playerHP = firstAttack(input);

            lootExploration(input);

            if (playerRole == 2 && lootItem.equalsIgnoreCase("Mystery Syringe")) {
                survivorScenario(input);
            }

            System.out.println("---------------------------------------");
            System.out.print("Would you like to continue to the next stage? (yes/no): ");
            String continueGame = input.next();
            if (continueGame.equalsIgnoreCase("no")) {
                System.out.println("You have chosen to exit the simulation. Game Over.");
                System.exit(0);
            }

            System.out.println("---------------------------------------");
            System.out.println("\nYou have reached the base of the Zombie King, the final boss.");
            System.out.println("Preparing for the final battle...");
            System.out.println("---------------------------------------");
            System.out.println("Your attacks seem to have no effect on the Zombie King.");
            System.out.println("Your party is in a predicament.");

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
