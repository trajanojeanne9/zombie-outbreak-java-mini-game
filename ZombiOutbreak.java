import java.util.Scanner;

public class ZombieOutbreak_2 {

    static int potionClass = 0;

    public static void title() {
        System.out.println("=================================================");
        System.out.println("                 ZOMBIE OUTBREAK                 ");
        System.out.println("=================================================");
        System.out.println(" ");
        System.out.println("  Welcome to the Zombie Outbreak Simulation!");
        System.out.println("  The world has fallen into chaos as a zombie \n         virus spreads rapidly.");
        System.out.println(" ");
        System.out.println(" Your mission is to survive and find a cure for \n                 the virus.");
        System.out.println(" Will you be able to save humanity, or will you \n     fall into the hands of the zombies?");
        System.out.println(" ");
        System.out.println("-------------------------------------------------");
    }

    public static String identification(Scanner input) {
        System.out.println(" ");
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        if (name.trim().isEmpty()) {
            System.out.println("Name cannot be empty. Please enter a valid name.");
            return identification(input);
        }

        System.out.print("Enter your age: ");
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
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("=================================================");
        System.out.println("                CHOOSE YOUR ROLE                ");
        System.out.println("=================================================");
        System.out.println("1. Warrior");
        System.out.println("2. Cowboy");
        System.out.println("3. Medic");
        System.out.println("4. Engineer");
        System.out.println("5. Scientist");
        System.out.println(" ");
        System.out.print("Enter your choice (1-5): ");
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
                System.out.println("You have chosen the Cowboy class. You are skilled\n      in quick draws and marksmanship.");
                System.out.println(" ");
                break;
            case 3:
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println("You have chosen the Medic class. You are skilled \n           in healing and support.");
                System.out.println(" ");
                break;
            case 4:
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println("   You have chosen the Engineer class. You are \n      skilled in building and repairing.");
                System.out.println(" ");
                break;
            case 5:
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println("  You have chosen the Scientist class. You are \n     skilled in research and development.");
                System.out.println(" ");
                break;
            default:
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println("Invalid choice. Please select a class to continue.");
                System.out.println(" ");
        }
        return roleChoice;
    }

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
        }

        if (potionUse.equalsIgnoreCase("yes")) {
            System.out.println(" ");
            System.out.println("=================================================");
            System.out.println("              CHOOSE YOUR POTION                ");
            System.out.println("=================================================");
            System.out.println("\n1. Blue Potion (+80 HP)");   // engineer
            System.out.println("2. Red Potion (+100 HP)");   // medic
            System.out.println("3. Orange Potion (+50 HP)"); // warrior
            System.out.println("4. Black Potion (+30 HP)");  // cowboy
            System.out.println("5. White Potion (+60 HP)");  // scientist
            System.out.print("\nEnter your choice (1-5): ");
            int potionChoice = input.nextInt();

            switch (potionChoice) {
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

        if (continueGame.equalsIgnoreCase("no")) {
            System.out.println("You have chosen to exit the simulation. Game Over.");
            System.exit(0);
        }

        return hp;
    }

     // PART 2: explore abandoned building, open loot box!!!!!
    public static int lootExploration(Scanner input) {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("-------------------------------------------------");
        System.out.println("\n Your party moves through the ruined streets and\n     comes across an abandoned building.");
        System.out.println(" Inside, tucked behind some rubble, you spot a \n                   loot box.");
        System.out.println(" ");
        System.out.println("-------------------------------------------------");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.print("Would you like to open the loot box? (yes/no): ");
        String openLoot = input.next();

        int lootChoice = 0; 

        if (openLoot.equalsIgnoreCase("yes")) {
            System.out.println(" ");
            System.out.println("-------------------------------------------------");
            System.out.println("You pry open the loot box and find several useful\nitems:");
            System.out.println("1. Metal Scraps");
            System.out.println("2. Mask");
            System.out.println("3. Mystery Syringe");
            System.out.println("4. Gun Powder");
            System.out.println("5. Talisman");
            System.out.println("-------------------------------------------------");
            System.out.println(" ");
            System.out.println("Oh no, your inventory is full, you must only get \none. Which one are you choosing?");
            System.out.println(" ");
            System.out.print("Enter your choice (1-5): ");
            lootChoice = input.nextInt();

            switch (lootChoice) {
                case 1:
                    System.out.println("-------------------------------------------------");
                    System.out.println("You have chosen Metal Scraps.");
                    break;
                case 2:
                    System.out.println("-------------------------------------------------");
                    System.out.println("You have chosen Mask.");
                    break;
                case 3:
                    System.out.println("-------------------------------------------------");
                    System.out.println("You have chosen Mystery Syringe.");
                    break;
                case 4:
                    System.out.println("-------------------------------------------------");
                    System.out.println("You have chosen Gun Powder.");
                    break;
                case 5:
                    System.out.println("-------------------------------------------------");
                    System.out.println("You have chosen Talisman.");
                    break;
                default:
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("Invalid choice. You leave the loot box untouched.");
            }
        } else {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("You decide not to open the loot box and continue on.");
        }
        return lootChoice; 
    }

    // MEDIC SIDE QUEST
    public static String survivorScenario(Scanner input, int roleChoice,int potionClass, int lootChoice) {
        String syringeChoice = "";
        if (roleChoice == 3 && lootChoice == 3) {
             System.out.println("-------------------------------------------------");
        System.out.println("\nAs you continue forward, you hear screaming. A group \nof survivors is trapped and begging for help.");
        System.out.println("You still have the Mystery Syringe. It might be able \nto help them.");
        System.out.println("-------------------------------------------------");
        System.out.println("Would you like to give them the syringe, or save it for\n the fight ahead? (give/save): ");
        syringeChoice = input.next();

        if (syringeChoice.equalsIgnoreCase("give")) {
            System.out.println("-------------------------------------------------");
            System.out.println("You hand over the Mystery Syringe. The survivors are \nsaved and thank you for your kindness.");
            System.out.println("However, you no longer have the syringe for what lies \nahead.");
        } else {
            System.out.println("-------------------------------------------------");
            System.out.println("  You decide to save the syringe. The survivors' \n  cries fade behind you as you press on.");
            System.out.println("\nYou continue forward, but you hear distant screams. You cannot help them as you have no means to do so.");
            System.out.println("You press on, hoping to find a way to save humanity.");
            System.out.println("-------------------------------------------------");
        }
        } 
        return syringeChoice;
        }

    public static void bossFight(Scanner input, int role, int potionClass, int lootChoice, String syringeChoice) {
        System.out.println("-------------------------------------------------");
        System.out.println("\nYou have reached the base of the Zombie King, \n               the final boss.");
        System.out.println(" ");
        System.out.println("      Preparing for the final battle...");
        System.out.println(" ");
        System.out.println("-------------------------------------------------");
        System.out.println(" ");
        System.out.println("Your attacks seem to have no effect on the Zombie\n                      King.");
        System.out.println("       Your party is in a predicament...");
        System.out.println(" ");
        System.out.println("-------------------------------------------------");
        System.out.println("\n  Different materials has appeared in front of\n   you, capable of defeating the Zombie King.");
        System.out.println(" ");
        System.out.println("Would you like to attempt to use them? (yes/no): ");
        String attemptMaterial = input.next();

        if (attemptMaterial.equalsIgnoreCase("no")) {
            System.out.println("-------------------------------------------------");
            System.out.println("You have chosen not to attempt to use the materials.");
            System.out.println("The Zombie King has defeated you and your party.");
            System.out.println("Once again, humanity has lost its hope...");
            System.out.println("-------------------------------------------------");
            System.out.println("Game Over.");
            return;
        }

        if (!attemptMaterial.equalsIgnoreCase("yes")) {
            System.out.println("-------------------------------------------------");
            System.out.println("Invalid input. The Zombie King has defeated you\n            and your party.");
            System.out.println("Once again, humanity has lost its hope...");
            System.out.println("-------------------------------------------------");
            System.out.println("Game Over.");
            return;
        }

        if (attemptMaterial.equalsIgnoreCase("yes")) {  
        System.out.println("-------------------------------------------------");
        System.out.println("You have chosen to attempt to use the materials.");
        System.out.println("Choose one material you would like to use:");
        System.out.println(" ");
        System.out.println("1. Excalibur");
        System.out.println("2. Annihilator");
        System.out.println("3. Toxic Device");
        System.out.println("4. Poisonous Smoke");
        System.out.println("5. Poisonous Syringe");
        System.out.println(" ");
        System.out.print("Enter your choice (1-5): ");
        int materialChoice = input.nextInt();

        switch (materialChoice) {
            case 1:
                System.out.println(" ");
                System.out.println("=================================================");
                System.out.println("         You have chosen the Excalibur!");
                System.out.println("=================================================");
                System.out.println(" ");
                System.out.println("To wield the Excalibur, you must meet the following\nconditions:");
                System.out.println(" ");
                System.out.println("1. You must be a Warrior class.");
                System.out.println("2. You must have 70 hp.");
                System.out.println("3. You must have the Talisman.");
                System.out.println(" ");
                System.out.println("Would you like to attempt to wield the Excalibur? (yes/no): ");
                String attemptSword = input.next();

                if (attemptSword.equalsIgnoreCase("yes")) {
                    if (role == 1 && potionClass == 3 && lootChoice == 5) {
                        System.out.println(" ");
                        System.out.println("-------------------------------------------------");
                        System.out.println("You have successfully wielded the Excalibur!");
                        System.out.println("The Excalibur has defeated the Zombie King!");
                        System.out.println("Congratulations! You have saved humanity!");
                        System.out.println(" ");
                    } else {
                        System.out.println("-------------------------------------------------");
                        System.out.println(" ");
                        System.out.println("You do not meet the conditions to wield the \nExcalibur.");
                        System.out.println("The Zombie King has defeated you and your party.");
                        System.out.println("Once again, humanity has lost its hope...");
                        System.out.println(" ");
                    }
                } else {
                    System.out.println(" ");
                    System.out.println("-------------------------------------------------");
                    System.out.println("You have chosen not to attempt to wield the \nLegendary Sword.");
                    System.out.println("The Zombie King has defeated you and your party.");
                    System.out.println(" ");
                    System.out.println("Once again, humanity has lost its hope....");
                    System.out.println(" ");
                }
                break;
            case 2:
                System.out.println(" ");
                System.out.println("=================================================");
                System.out.println("       You have chosen the Annihilator!");
                System.out.println("=================================================");
                System.out.println(" ");
                System.out.println("To use the Annihilator, you must meet the \nfollowing conditions:");
                System.out.println(" ");
                System.out.println("1. You must be a Cowboy class.");
                System.out.println("2. You must have 50 hp.");
                System.out.println("3. You must have the Gun Powder.");
                System.out.println(" ");
                System.out.println("Would you like to attempt to use the Annihilator? (yes/no): ");
                String attemptGun = input.next();

                if (attemptGun.equalsIgnoreCase("yes")) {
                    if (role == 2 && potionClass == 4 && lootChoice == 4) {
                        System.out.println(" ");
                        System.out.println("-------------------------------------------------");
                        System.out.println(" ");
                        System.out.println("You have successfully used the Annihilator!");
                        System.out.println("The Annihilator has defeated the Zombie King!");
                        System.out.println(" ");
                        System.out.println("Congratulations! You have saved humanity!");
                        System.out.println(" ");
                    } else {
                        System.out.println(" ");
                        System.out.println("-------------------------------------------------");
                        System.out.println("You do not meet the conditions to use the Annihilator.");
                        System.out.println("The Zombie King has defeated you and your party.");
                        System.out.println(" ");
                        System.out.println("Once again, humanity has lost its hope.....");
                        System.out.println(" ");
                    }
                } else {
                    System.out.println(" ");
                    System.out.println("-------------------------------------------------");
                    System.out.println("You have chosen not to attempt to use the Annihilator.");
                    System.out.println("The Zombie King has defeated you and your party.");
                    System.out.println(" ");
                    System.out.println("Once again, humanity has lost its hope...");
                    System.out.println(" ");
                }
                break;
            case 3:
                System.out.println(" ");
                System.out.println("=================================================");
                System.out.println("      You have chosen the Toxic Device!");
                System.out.println("=================================================");
                System.out.println(" ");
                System.out.println("To use the Toxic Device, you must meet the \nfollowing conditions:");
                System.out.println(" ");
                System.out.println("1. You must be an Engineer class.");
                System.out.println("2. You must have 100 hp.");
                System.out.println("3. You must have the Metal Scraps.");
                System.out.println(" ");
                System.out.println("Would you like to attempt to use the Toxic Device? (yes/no): ");
                String attemptDevice = input.next();

                if (attemptDevice.equalsIgnoreCase("yes")) {
                    if (role == 4 && potionClass == 1 && lootChoice == 1) {
                        System.out.println(" ");
                        System.out.println("-------------------------------------------------");
                        System.out.println("You have successfully used the Toxic Device!");
                        System.out.println("\nThe Toxic Device has defeated the Zombie King!");
                        System.out.println(" ");
                        System.out.println("Congratulations! You have saved humanity!");
                        System.out.println(" ");
                    } else {
                        System.out.println(" ");
                        System.out.println("-------------------------------------------------");
                        System.out.println("You do not meet the conditions to use the Toxic Device.");
                        System.out.println("\nThe Zombie King has defeated you and your party.");
                        System.out.println(" ");
                        System.out.println("Once again, humanity has lost its hope...");
                        System.out.println(" ");
                    }
                } else {
                    System.out.println(" ");
                    System.out.println("-------------------------------------------------");
                    System.out.println("You have chosen not to attempt to use the Toxic Device.");
                    System.out.println("\nThe Zombie King has defeated you and your party.");
                    System.out.println(" ");
                    System.out.println("Once again, humanity has lost its hope...");
                    System.out.println(" ");
                }
                break;
            case 4:
                System.out.println(" ");
                System.out.println("=================================================");
                System.out.println("       You have chosen the Poisonous Smoke!      ");
                System.out.println("=================================================");
                System.out.println(" ");
                System.out.println("To use the Poisonous Smoke, you must meet the \nfollowing conditions:");
                System.out.println(" ");
                System.out.println("1. You must be a Scientist class.");
                System.out.println("2. You must have 80 hp.");
                System.out.println("3. You must have the Mask.");
                System.out.println(" ");
                System.out.println("Would you like to attempt to use the Poisonous Smoke? (yes/no): ");
                String attemptSmoke = input.next();

                if (attemptSmoke.equalsIgnoreCase("yes")) {
                    if (role == 5 && potionClass == 5 && lootChoice == 2) {
                        System.out.println(" ");
                        System.out.println("-------------------------------------------------");
                        System.out.println("You have successfully used the Poisonous Smoke!");
                        System.out.println("\nThe Poisonous Smoke has defeated the Zombie King!");
                        System.out.println(" ");
                        System.out.println("Congratulations! You have saved humanity!");
                        System.out.println(" ");
                    } else {
                        System.out.println("-------------------------------------------------");
                        System.out.println("You do not meet the conditions to use the Poisonous\n Smoke.");
                        System.out.println("\nThe Zombie King has defeated you and your party.");
                        System.out.println(" ");
                        System.out.println("Once again, humanity has lost its hope...");
                        System.out.println(" ");
                    }
                } else {
                    System.out.println(" ");
                    System.out.println("-------------------------------------------------");
                    System.out.println("You have chosen not to attempt to use the Poisonous\n Smoke.");
                    System.out.println("The Zombie King has defeated you and your party.");
                    System.out.println(" ");
                    System.out.println("Once again, humanity has lost its hope...");
                    System.out.println(" ");
                }
                break;
            case 5:
                System.out.println(" ");
                System.out.println("=================================================");
                System.out.println("       You have chosen the Poisoned Syringe!     ");
                System.out.println("=================================================");
                System.out.println("To use the Poisoned Syringe, you must meet the\n following conditions:");
                System.out.println(" ");
                System.out.println("1. You must be a Medic class.");
                System.out.println("2. You must have 120 hp.");
                System.out.println("3. You must have the Mystery Syringe, if you gave \nthe Mystery Syringe to other survivor, you will not be able to use it.");
                System.out.println(" ");
                System.out.println("Would you like to attempt to use the Poisoned Syringe? (yes/no): ");
                String attemptSyringe = input.next();

                if (attemptSyringe.equalsIgnoreCase("yes")) {
                    if (role == 3 && potionClass == 2 && lootChoice == 3 && syringeChoice == "give") {
                        System.out.println(" ");
                        System.out.println("-------------------------------------------------");
                        System.out.println("You have successfully used the Poisoned Syringe!");
                        System.out.println("\nThe Poisoned Syringe has defeated the Zombie King!");
                        System.out.println(" ");
                        System.out.println("Congratulations! You have saved humanity!");
                        System.out.println(" ");
                    } else {
                        System.out.println(" ");
                        System.out.println("-------------------------------------------------");
                        System.out.println("You do not meet the conditions to use the Poisoned\nSyringe.");
                        System.out.println("The Zombie King has defeated you and your party.");
                        System.out.println(" ");
                        System.out.println("Once again, humanity has lost its hope...");
                        System.out.println(" ");
                    }
                } else {
                    System.out.println(" ");
                    System.out.println("-------------------------------------------------");
                    System.out.println("You have chosen not to attempt to use the Poisoned\n Syringe.");
                    System.out.println("\nThe Zombie King has defeated you and your party.");
                    System.out.println(" ");
                    System.out.println("Once again, humanity has lost its hope...");
                    System.out.println(" ");
                }
                break;
            default:
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
                System.out.println("Invalid choice. The Zombie King has defeated you \band your party.");
                System.out.println(" ");
                System.out.println("Once again, humanity has lost its hope...");
                System.out.println(" ");
        }
}
        
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        title();

        String name = identification(input);

        if (!name.isEmpty()) {
            int playerRole = role(input);
            int potionClass = firstAttack(input);
            int lootChoice = lootExploration(input);
            String syringeChoice = survivorScenario(input, playerRole, potionClass, lootChoice);
            bossFight(input, playerRole, potionClass, lootChoice, syringeChoice);
        }

        System.out.println("-------------------------------------------------");
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
