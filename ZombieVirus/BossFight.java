import java.util.Scanner;

/** Final stage: the Zombie King. */
public class BossFight {

    // BOSS FIGHT
    public static boolean bossFight(Scanner input, int role, int potionClass, int lootChoice, String syringeChoice) {
        boolean won = false;
        System.out.println(" ");
        System.out.println("-------------------------------------------------");
        System.out.println("\n  You have reached the base of the Zombie King, \n               the final boss.");
        System.out.println(" ");
        System.out.println("        Preparing for the final battle...");
        System.out.println(" ");
        System.out.println("-------------------------------------------------");
        System.out.println(" ");
        System.out.println("Your attacks seem to have no effect on the Zombie\n                      King.");
        System.out.println(" ");
        System.out.println("Your party is in a predicament...");
        System.out.println(" ");
        System.out.println("-------------------------------------------------");
        System.out.println("\n  Different materials has appeared in front of\n   you, capable of defeating the Zombie King.");
        System.out.println(" ");
        System.out.println("Would you like to attempt to use them? (yes/no): ");

        String attemptMaterial = input.next();
        while (attemptMaterial.trim().isEmpty()) {
            System.out.println("Input cannot be empty. Please enter 'yes' or 'no'.");
            attemptMaterial = input.next();
        }

        if (attemptMaterial.equalsIgnoreCase("no")) {

            System.out.println(" ");
            System.out.println("-------------------------------------------------");
            System.out.println(" ");
            System.out.println("You have chosen not to attempt to use the materials.");
            System.out.println(" ");
            System.out.println("The Zombie King has defeated you and your party.");
            System.out.println(" ");
            System.out.println("Once again, humanity has lost its hope...");
            System.out.println(" ");
            System.out.println("-------------------------------------------------");
            System.out.println("               [[ Game Over. ]]");

            return false;
        }

        if (!attemptMaterial.equalsIgnoreCase("yes")) {

            System.out.println(" ");
            System.out.println("-------------------------------------------------");
            System.out.println("Invalid input. The Zombie King has defeated you\n            and your party.");
            System.out.println("Once again, humanity has lost its hope...");
            System.out.println("-------------------------------------------------");
            System.out.println("Game Over.");

            return false;
        }

        if (attemptMaterial.equalsIgnoreCase("yes")) {

            System.out.println(" ");
            System.out.println("-------------------------------------------------");
            System.out.println("You have chosen to attempt to use the materials.");
            System.out.println("Choose one material you would like to use:");
            System.out.println(" ");

            System.out.println("1. Excalibur");
            System.out.println("2. Hunter Strike");
            System.out.println("3. Toxic Device");
            System.out.println("4. Poisonous Smoke");
            System.out.println("5. Elixir of Life");

            System.out.println(" ");

            System.out.print("Enter your choice (1-5): ");
            while (!input.hasNextInt()) {
                System.out.println("Invalid input, please enter a number.");
                input.next();
                System.out.print("Enter your choice (1-5): ");
            }
            int materialChoice = input.nextInt();

            switch (materialChoice) {
                // EXCALIBUR
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
                    System.out.println("-------------------------------------------------");

                    System.out.println("Would you like to attempt to wield the Excalibur? (yes/no): ");

                    String attemptSword = input.next();

                    if (attemptSword.equalsIgnoreCase("yes")) {

                        if (role == 1 && potionClass == 3 && lootChoice == 5) {
                            System.out.println(" ");
                            System.out.println("-------------------------------------------------");
                            System.out.println("You have successfully wielded the Excalibur!");
                            System.out.println(" ");
                            System.out.println("The Excalibur has defeated the Zombie King!");
                            System.out.println(" ");
                            System.out.println("Congratulations! You have saved humanity!");
                            System.out.println(" ");
                            System.out.println("-------------------------------------------------");
                            won = true;

                        } else {
                            System.out.println(" ");
                            System.out.println("-------------------------------------------------");
                            System.out.println(" ");
                            System.out.println("   You do not meet the conditions to wield the \n                 Excalibur.");
                            System.out.println("The Zombie King has defeated you and your party.");
                            System.out.println(" ");
                            System.out.println("Once again, humanity has lost its hope...");
                            System.out.println(" ");
                            System.out.println("-------------------------------------------------");

                        }


                    } else {
                        System.out.println(" ");
                        System.out.println("-------------------------------------------------");
                        System.out.println(" You have chosen not to attempt to wield the \nLegendary Sword.");
                        System.out.println(" The Zombie King has defeated you and your party.");
                        System.out.println(" ");
                        System.out.println("Once again, humanity has lost its hope....");
                        System.out.println(" ");
                        System.out.println("-------------------------------------------------");
                    }
                    break;

                // HUNTER STRIKE
                case 2:
                    System.out.println(" ");
                    System.out.println("=================================================");
                    System.out.println("       You have chosen the Hunter Strike!");
                    System.out.println("=================================================");
                    System.out.println(" ");
                    System.out.println("To use the Hunter Strike, you must meet the \nfollowing conditions:");
                    System.out.println(" ");
                    System.out.println("1. You must be an Assassin class.");
                    System.out.println("2. You must have 50 hp.");
                    System.out.println("3. You must have the Invisibility cloak.");
                    System.out.println(" ");
                    System.out.println("Would you like to attempt to use the Hunter Strike? (yes/no): ");

                    String attemptGun = input.next();

                    if (attemptGun.equalsIgnoreCase("yes")) {
                        if (role == 2 && potionClass == 4 && lootChoice == 4) {
                            System.out.println(" ");
                            System.out.println("-------------------------------------------------");
                            System.out.println(" ");
                            System.out.println("   You have successfully used the Hunter Strike!");
                            System.out.println("  The Hunter Strike has defeated the Zombie King!");
                            System.out.println(" ");
                            System.out.println("    Congratulations! You have saved humanity!");
                            System.out.println(" ");
                            System.out.println("-------------------------------------------------");
                            won = true;
                        } else {

                            System.out.println(" ");
                            System.out.println("-------------------------------------------------");
                            System.out.println(" ");
                            System.out.println("You do not meet the conditions to use the Hunter Strike.");
                            System.out.println("The Hunter Strike has defeated you and your party.");
                            System.out.println(" ");
                            System.out.println("Once again, humanity has lost its hope.....");
                            System.out.println(" ");
                            System.out.println("-------------------------------------------------");
                        }

                    } else {
                        System.out.println(" ");
                        System.out.println("-------------------------------------------------");
                        System.out.println(" ");
                        System.out.println("You have chosen not to attempt to use the Hunter Strike.");
                        System.out.println("The Zombie King has defeated you and your party.");
                        System.out.println(" ");
                        System.out.println("Once again, humanity has lost its hope...");
                        System.out.println(" ");
                        System.out.println("-------------------------------------------------");
                    }
                    break;


                // TOXIC DEVICE
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
                            System.out.println(" ");
                            System.out.println("  You have successfully used the Toxic Device!");
                            System.out.println("\n The Toxic Device has defeated the Zombie King!");
                            System.out.println(" ");
                            System.out.println("Congratulations! You have saved humanity!");
                            System.out.println(" ");
                            System.out.println("-------------------------------------------------");
                            won = true;

                        } else {
                            System.out.println(" ");
                            System.out.println("-------------------------------------------------");
                            System.out.println(" ");
                            System.out.println("You do not meet the conditions to use the Toxic Device.");
                            System.out.println("\nThe Zombie King has defeated you and your party.");
                            System.out.println(" ");
                            System.out.println("Once again, humanity has lost its hope...");
                            System.out.println(" ");
                            System.out.println("-------------------------------------------------");
                        }

                    } else {
                        System.out.println(" ");
                        System.out.println("-------------------------------------------------");
                        System.out.println(" ");
                        System.out.println("You have chosen not to attempt to use the Toxic Device.");
                        System.out.println("\nThe Zombie King has defeated you and your party.");
                        System.out.println(" ");
                        System.out.println("Once again, humanity has lost its hope...");
                        System.out.println(" ");
                        System.out.println("-------------------------------------------------");
                    }
                    break;

                // POISONOUS SMOKE
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
                            System.out.println(" ");
                            System.out.println("You have successfully used the Poisonous Smoke!");
                            System.out.println("\nThe Poisonous Smoke makes the Zombie King vulnerable!");
                            System.out.println(" ");
                            System.out.println("Would you like to capture the Zombie King and extract his DNA or kill him? (extract/kill): ");
                            System.out.println(" ");
                            System.out.println("-------------------------------------------------");
                            String extract = input.next();
                            if (extract.equalsIgnoreCase("extract")) {
                                System.out.println(" ");
                                System.out.println("-------------------------------------------------");
                                System.out.println(" ");
                                System.out.println("You have successfully extracted the Zombie King's DNA!");
                                System.out.println("After the battle, you go back to your laboratory to analyze the sample. You unexpectedly spill the sample on your wound.");
                                System.out.println("You feel a strange sensation, and you look at the mirror and see that you become the new Zombie King.");
                                System.out.println(" ");
                                System.out.println("Congratulations! You saved humanity...... or did you?");
                                System.out.println(" ");
                                System.out.println("-------------------------------------------------");
                            } else {
                                System.out.println(" ");
                                System.out.println("-------------------------------------------------");
                                System.out.println(" ");
                                System.out.println("You have chosen to kill the Zombie King.");
                                System.out.println("\nThe Zombie King has been defeated, but his DNA is lost forever.");
                                System.out.println(" ");
                                System.out.println("Congratulations! You have saved humanity, but at a great cost.");
                                System.out.println(" ");
                                System.out.println("-------------------------------------------------");
                            }
                            won = true;

                        } else {
                            System.out.println("-------------------------------------------------");
                            System.out.println(" ");
                            System.out.println("You do not meet the conditions to use the Poisonous\n                    Smoke.");
                            System.out.println(  "\nThe Zombie King has defeated you and your party.");
                            System.out.println(" ");
                            System.out.println("Once again, humanity has lost its hope...");
                            System.out.println(" ");
                            System.out.println("-------------------------------------------------");
                        }

                    } else {
                        System.out.println(" ");
                        System.out.println("-------------------------------------------------");
                        System.out.println(" ");
                        System.out.println("You have chosen not to attempt to use the Poisonous\n                    Smoke.");
                        System.out.println("The Zombie King has defeated you and your party.");
                        System.out.println(" ");
                        System.out.println("Once again, humanity has lost its hope...");
                        System.out.println(" ");
                        System.out.println("-------------------------------------------------");
                    }
                    break;


                // Elixir of Life
                case 5:
                    System.out.println(" ");
                    System.out.println("=================================================");
                    System.out.println("       You have chosen the Elixir of Life!     ");
                    System.out.println("=================================================");
                    System.out.println("To use the Elixir of Life, you must meet the\n following conditions:");
                    System.out.println(" ");
                    System.out.println("1. You must be a Medic class.");
                    System.out.println("2. You must have 120 hp.");
                    System.out.println("3. You must have the Mystery Syringe, if you gave \nthe Mystery Syringe to other survivor, you will not be able to use it.");
                    System.out.println(" ");
                    System.out.println("Would you like to attempt to use the Elixir of Life? (yes/no): ");

                    String attemptSyringe = input.next();
                    if (attemptSyringe.equalsIgnoreCase("yes")) {
                        if (role == 3 && potionClass == 2 && lootChoice == 3 && syringeChoice.equalsIgnoreCase("save")) {
                           System.out.println(" ");
                            System.out.println("-------------------------------------------------");
                            System.out.println(" ");
                            System.out.println("You lower your weapon.");
                            System.out.println("\nInstead of striking the Zombie King, you plunge the \nElixir of Life into him, hoping that it \n                  can still save him.");
                            System.out.println(" ");
                            System.out.println("The virus burns away, his skin slowly returns to normal, and his empty, dead eyes slowly get their color back.");
                            System.out.println(" ");
                            System.out.println("The Zombie King collapses to his knees... once a monster, now a man.");
                            System.out.println(" ");
                            System.out.println("=================================================");
                            System.out.println("              * SECRET ENDING *              ");
                            System.out.println("     You found the true cure, and saved humanity   ");
                            System.out.println("            without spilling more blood.          ");
                            System.out.println("=================================================");
                            System.out.println(" ");
                            System.out.println("Congratulations! You have saved humanity... and \n                redeemed a King.");
                            System.out.println(" ");
                            System.out.println("-------------------------------------------------");
                            won = true;

                        } else {
                            System.out.println(" ");
                            System.out.println("-------------------------------------------------");
                            System.out.println(" ");
                            System.out.println( "You do not meet the conditions to use the Poisoned\n                   Syringe.");
                            System.out.println( "The Zombie King has defeated you and your party.");
                            System.out.println(" ");
                            System.out.println( "Once again, humanity has lost its hope...");
                            System.out.println(" ");
                            System.out.println("-------------------------------------------------");
                        }

                    } else {
                        System.out.println(" ");
                        System.out.println("-------------------------------------------------");
                        System.out.println(" ");
                        System.out.println("You have chosen not to attempt to use the Poisoned\n Syringe.");
                        System.out.println("\nThe Zombie King has defeated you and your party.");
                        System.out.println(" ");
                        System.out.println(   "Once again, humanity has lost its hope...");
                        System.out.println(" ");
                        System.out.println("-------------------------------------------------");
                    }
                    break;

                default:
                    System.out.println(" ");
                    System.out.println("-------------------------------------------------");
                    System.out.println(" ");
                    System.out.println(" Invalid choice. The Zombie King has defeated you \n        band your party.");
                    System.out.println(" ");
                    System.out.println("     Once again, humanity has lost its hope...");
                    System.out.println(" ");
                    System.out.println("-------------------------------------------------");
            }
        }
        return won;
    }
}