import java.util.Scanner;

/** Role-specific side quests (Warrior, Medic, Engineer). */
public class SideQuests {

    //WARRIOR SIDE QUEST
    public static String warriorScenario(Scanner input, int roleChoice, int potionClass, int lootChoice) {
        String talismanChoice = "";
        if (roleChoice == 1 && lootChoice == 5) {
            System.out.println(" ");
            System.out.println("-------------------------------------------------");
            System.out.println(" ");
            System.out.println("\nAs you continue forward, you encounter a child that is battered and asking for help.");
            System.out.println("You still have the Talisman. It might be of help to him.");
            System.out.println(" ");
            System.out.println("-------------------------------------------------");
            System.out.println(" ");
            System.out.println("Would you like to use the Talisman to help him? (yes/no): ");

            talismanChoice = input.next();
            if (talismanChoice.trim().isEmpty() || (!talismanChoice.equalsIgnoreCase("yes") && !talismanChoice.equalsIgnoreCase("no"))) {
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("INPUT CANNOT BE EMPTY! Please enter 'yes' or 'no'.");
                warriorScenario(input, roleChoice, potionClass, lootChoice);

            }

            if (talismanChoice.equalsIgnoreCase("yes")) {
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println("[You use the Talisman to help the child. He is saved and thank you for your bravery.]");
                System.out.println("[However, you no longer have the Talisman for what lies ahead]");
                System.out.println(" ");
                System.out.println("-------------------------------------------------");

            } else {
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println("[You decide not to use the Talisman. The child's cries fade behind you as you press on.]");
                System.out.println("[You continue forward, but you hear distant screams. You cannot help him as you have no means to do so]");
                System.out.println("[You press on, hoping to find a way to save humanity]");
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
            }
        }
   return talismanChoice;
    }

    public static String assassinScenario(Scanner input, int roleChoice, int potionClass, int lootChoice) {
        String daggerChoice = "";
        if (roleChoice == 2 && lootChoice == 4) {
            System.out.println(" ");
            System.out.println("-------------------------------------------------");
            System.out.println(" ");
            System.out.println("\nAs you continue forward, you encounter thousands of zombies that are blocking your path.");
            System.out.println("You still have the Invincibility Cloak. It might be able to help you clear the way.");
            System.out.println(" ");
            System.out.println("-------------------------------------------------");
            System.out.println(" ");
            System.out.println("Would you like to use the Invincibility Cloak to get past them? (yes/no): ");

            daggerChoice = input.next();
            if (daggerChoice.trim().isEmpty() || (!daggerChoice.equalsIgnoreCase("yes") && !daggerChoice.equalsIgnoreCase("no"))) {
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("INPUT CANNOT BE EMPTY! Please enter 'yes' or 'no'.");
                assassinScenario(input, roleChoice, potionClass, lootChoice);

            }

            if (daggerChoice.equalsIgnoreCase("yes")) {
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println("[You use the Invincibility Cloak to clear the way. You can now continue forward and face the challenges ahead.]");
                System.out.println("[However, you no longer have the Invincibility Cloak for what lies ahead]");
                System.out.println(" ");
                System.out.println("-------------------------------------------------");

            } else {
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println("[You decide not to use the Invincibility Cloak. You don't have any choice but to fight them.]");
                System.out.println("[When fighting the zombies, you lost your Invincibility Cloak.]");
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
            }
        }
   return daggerChoice;
    }
    // MEDIC SIDE QUEST
    public static String medicScenario(Scanner input, int roleChoice, int potionClass, int lootChoice) {
        String syringeChoice = "";

        if (roleChoice == 3 && lootChoice == 3) {
            System.out.println(" ");
            System.out.println("-------------------------------------------------");
            System.out.println(" ");
            System.out.println("\nAs you continue forward, you hear screaming. A group \n   of survivors is trapped and begging for help.");
            System.out.println("You still have the Mystery Syringe. It might be able \n                  to help them.");
            System.out.println(" ");
            System.out.println("-------------------------------------------------");
            System.out.println(" ");
            System.out.println("Would you like to give them the syringe, or save it for\nthe fight ahead? (give/save): ");

            syringeChoice = input.next();
            if (syringeChoice.trim().isEmpty() || (!syringeChoice.equalsIgnoreCase("give") && !syringeChoice.equalsIgnoreCase("save"))) {
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("INPUT CANNOT BE EMPTY! Please enter 'give' or 'save'.");
                return medicScenario(input, roleChoice, potionClass, lootChoice);
            }

            if (syringeChoice.equalsIgnoreCase("give")) {
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println("[You hand over the Mystery Syringe. The survivors are \nsaved and thank you for your kindness]");
                System.out.println("[However, you no longer have the syringe for what lies \nahead]");
                System.out.println(" ");
                System.out.println("-------------------------------------------------");

            } else {
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println(" [You decide to save the syringe. The survivors' \n         cries fade behind you as you press on.");
                System.out.println("\nYou continue forward, but you hear distant screams. \nYou cannot help them as you have no means to do so]");
                System.out.println(" ");
                System.out.println("[You press on, hoping to find a way to save humanity]");
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
            }
        }
        return syringeChoice;
    }

    // ENGINEER SIDE QUEST
    public static String engineerScenario(Scanner input, int roleChoice, int potionClass, int lootChoice) {
        String bridgeChoice = "";
        if (roleChoice == 4 && lootChoice == 1) {
            System.out.println(" ");
            System.out.println("-------------------------------------------------");
            System.out.println(" ");
            System.out.println("\nAs you continue forward, you encounter a broken bridge that \nblocks your path. You still have the Metal Scraps.");
            System.out.println("It might be able to repair the bridge and allow you to \ncontinue forward.");
            System.out.println(" ");
            System.out.println("-------------------------------------------------");
            System.out.println(" ");
            System.out.println("Would you like to use the Metal Scraps to repair the bridge? (yes/no): ");

            bridgeChoice = input.next();
            if (bridgeChoice.trim().isEmpty() || (!bridgeChoice.equalsIgnoreCase("yes") && !bridgeChoice.equalsIgnoreCase("no"))) {
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("INPUT CANNOT BE EMPTY! Please enter 'yes' or 'no'.");
                engineerScenario(input, roleChoice, potionClass, lootChoice);

            }

            if (bridgeChoice.equalsIgnoreCase("yes")) {
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println("[You use the Metal Scraps to repair the bridge. You can now \ncontinue forward and face the challenges ahead.]");
                System.out.println("[However, you no longer have the Metal Scraps for what lies ahead]");
                System.out.println(" ");
                System.out.println("-------------------------------------------------");

            } else {
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println("[You decide not to use the Metal Scraps. The broken bridge \nblocks your path and you must find another way forward.]");
                System.out.println("[You continue forward, but you hear distant screams. You cannot \nhelp them as you have no means to do so]");
                System.out.println("[You press on, hoping to find a way to save humanity]");
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
            }
        }
   return bridgeChoice;
    }
public static String scientistScenario(Scanner input, int roleChoice, int potionClass, int lootChoice) {;
String maskChoice = "";
        if (roleChoice == 5 && lootChoice == 2) {
            System.out.println(" ");
            System.out.println("-------------------------------------------------");
            System.out.println(" ");
            System.out.println("Before fighting the Zombie King, you go back to your laboratory to prepare for the final battle.");
            System.out.println("You unexpectedly saw a lying folder hanging around the table, titled: Road to Immortality");
            System.out.println(" ");
            System.out.println("-------------------------------------------------");
            System.out.println(" ");
            System.out.println("Would you like to read it? (yes/no): ");

            maskChoice = input.next();
            if (maskChoice.trim().isEmpty() || (!maskChoice.equalsIgnoreCase("yes") && !maskChoice.equalsIgnoreCase("no"))) {
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("INPUT CANNOT BE EMPTY! Please enter 'yes' or 'no'.");
                return scientistScenario(input, roleChoice, potionClass, lootChoice);
            }

            if (maskChoice.equalsIgnoreCase("yes")) {
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println("[You read the folder and found out that the Zombie King's DNA is the key to immortality.]");
                System.out.println("[You can now save humanities greatest fear, death.]");
                System.out.println(" ");
                System.out.println("-------------------------------------------------");

            } else {
                System.out.println(" ");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println("[You decide to not read the folder, and continue to prepare for the final battle.]");
                System.out.println("-------------------------------------------------");
            }
        }
        return maskChoice;
    }
}
