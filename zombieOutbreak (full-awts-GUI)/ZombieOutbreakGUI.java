import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ZombieOutbreakGUI {

    // =========================================================
    // WINDOW SETTINGS
    // =========================================================
    int boardWidth = 750;
    int boardHeight = 600;

    // COLORS
    Color darkGreen = new Color(25, 55, 35);
    Color green = new Color(70, 130, 85);
    Color lightGreen = new Color(180, 220, 185);

    Color darkRed = new Color(100, 25, 25);
    Color red = new Color(180, 55, 55);
    Color lightRed = new Color(245, 190, 190);

    Color darkGray = new Color(35, 35, 35);
    Color lightGray = new Color(235, 235, 235);

    Color white = Color.WHITE;

    // =========================================================
    // GAME VARIABLES  (mirrors the variables passed around the
    // terminal version's methods: name, playerRole, potionClass,
    // lootChoice, syringeChoice, hp)
    // =========================================================
    String playerName;
    int playerAge;
    int playerRole;      // 1 Warrior, 2 Cowboy, 3 Medic, 4 Engineer, 5 Scientist
    int playerHP = 20;
    int potionClass = 0; // 1 Blue, 2 Red, 3 Orange, 4 Black, 5 White
    int lootChoice = 0;  // 1 Metal Scraps, 2 Mask, 3 Mystery Syringe, 4 Gun Powder, 5 Talisman
    String syringeChoice = ""; // "give" or "save", only relevant for Medic + Mystery Syringe

    // ROLE NAMES (index 0-4 -> role 1-5)
    String[] roles = { "Warrior", "Cowboy", "Medic", "Engineer", "Scientist" };

    // MAIN WINDOW
    JFrame frame = new JFrame("!!! Zombie Outbreak !!!");
    JPanel mainPanel = new JPanel();
    JLabel titleLabel = new JLabel();
    JLabel storyLabel = new JLabel();

    // CONSTRUCTOR
    ZombieOutbreakGUI() {
        frame.setSize(boardWidth, boardHeight);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel.setBackground(darkGray);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
        frame.add(mainPanel);

        frame.setVisible(true);
        showTitleScreen();
    }

    // =========================================================
    // HELPERS
    // =========================================================

    JLabel makeTitle(String text, String fontName, int fontSize, Color bg, Color fg, int padTop, int padSide) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, Font.BOLD, fontSize));
        label.setForeground(fg);
        label.setBackground(bg);
        label.setOpaque(true);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(padTop, padSide, 20, padSide));
        return label;
    }

    JLabel makeHtmlLabel(String htmlInner, int fontSize, boolean bold) {
        JLabel label = new JLabel("<html><div style='text-align:center;'>" + htmlInner + "</div></html>");
        label.setFont(new Font("Arial", bold ? Font.BOLD : Font.PLAIN, fontSize));
        label.setForeground(white);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    void sizeButton(JButton b, int w, int h) {
        b.setPreferredSize(new Dimension(w, h));
        b.setMaximumSize(new Dimension(w, h));
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    JPanel makeButtonPanel(LayoutManager layout, JButton... buttons) {
        JPanel panel = new JPanel();
        panel.setBackground(darkGray);
        if (layout != null) panel.setLayout(layout);
        for (JButton b : buttons) panel.add(b);
        return panel;
    }

    void info(String message, String title) {
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    void warn(String message, String title) {
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.WARNING_MESSAGE);
    }

    JButton createButton(String text, Color background, Color foreground) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
                g2.dispose();
                super.paintComponent(g);
            }
        };

        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(background);
        button.setForeground(foreground);
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return button;
    }

    void refreshScreen() {
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    // =========================================================
    // TITLE SCREEN
    // =========================================================

    void showTitleScreen() {
        mainPanel.removeAll();

        titleLabel = makeTitle("!!! ZOMBIE OUTBREAK !!!", "Arial", 34, darkRed, white, 20, 15);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        storyLabel = makeHtmlLabel(
            "Welcome to the Zombie Outbreak Simulation!<br><br>" +
            "The world has fallen into chaos as a zombie<br>virus spreads rapidly.<br><br>" +
            "Your mission is to survive and kill all the zombies,<br>" +
            "or find a cure for the virus.<br><br>" +
            "Will you be able to save humanity,<br>or will you fall into the hands of the zombies?",
            17, false
        );
        storyLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0));
        mainPanel.add(storyLabel, BorderLayout.CENTER);

        JButton startButton = createButton("START GAME", green, white);
        JButton exitButton = createButton("EXIT", darkRed, white);
        sizeButton(startButton, 450, 55);
        sizeButton(exitButton, 450, 55);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(darkGray);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(startButton);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(exitButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        startButton.addActionListener(e -> showIdentificationScreen());
        exitButton.addActionListener(e -> System.exit(0));

        refreshScreen();
    }

    // =========================================================
    // IDENTIFICATION SCREEN
    // =========================================================

    void showIdentificationScreen() {
        mainPanel.removeAll();

        titleLabel = makeTitle("PLAYER IDENTIFICATION", "Arial", 26, darkGreen, white, 20, 45);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setBackground(darkGray);
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 45, 20, 45));

        JLabel nameLabel = new JLabel("Enter your name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setForeground(white);

        JTextField nameField = new JTextField(playerName == null ? "" : playerName);
        nameField.setFont(new Font("Arial", Font.PLAIN, 20));
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 34));

        JLabel ageLabel = new JLabel("Enter your age:");
        ageLabel.setFont(new Font("Arial", Font.BOLD, 18));
        ageLabel.setForeground(white);

        JTextField ageField = new JTextField();
        ageField.setFont(new Font("Arial", Font.PLAIN, 20));
        ageField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 34));

        formPanel.add(nameLabel);
        formPanel.add(Box.createVerticalStrut(5));
        formPanel.add(nameField);
        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(ageLabel);
        formPanel.add(Box.createVerticalStrut(5));
        formPanel.add(ageField);
        mainPanel.add(formPanel, BorderLayout.CENTER);

        JButton continueButton = createButton("CONTINUE", green, white);
        JButton backButton = createButton("BACK", darkRed, white);
        mainPanel.add(makeButtonPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0), backButton, continueButton), BorderLayout.SOUTH);

        backButton.addActionListener(e -> showTitleScreen());

        continueButton.addActionListener(e -> {
            String enteredName = nameField.getText().trim();

            if (enteredName.isEmpty()) {
                warn("Name cannot be empty. Please enter a valid name.", "Missing Information");
                return;
            }

            int enteredAge;
            try {
                enteredAge = Integer.parseInt(ageField.getText().trim());
            } catch (NumberFormatException ex) {
                warn("Invalid input, please enter a number.", "Invalid Age");
                return;
            }

            if (enteredAge < 18) {
                warn("Sorry, " + enteredName + ". You are not eligible to participate\nin the simulation. Try Again Next Time.", "Not Eligible");
                return; // stays on this screen, same as identification()'s recursive re-prompt
            }

            playerName = enteredName;
            playerAge = enteredAge;
            info("WELCOME, " + playerName + "! You are eligible to participate\nin the simulation.", "Welcome");
            showRoleScreen();
        });

        refreshScreen();
    }

    // =========================================================
    // ROLE SCREEN
    // =========================================================

    void showRoleScreen() {
        mainPanel.removeAll();

        titleLabel = makeTitle("CHOOSE YOUR ROLE", "Arial", 28, darkRed, white, 20, 30);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        String[] roleBlurbs = {
            "You excel in close combat.",
            "You are skilled in quick draws and marksmanship.",
            "You are skilled in healing and support.",
            "You are skilled in building and repairing.",
            "You are skilled in research and development."
        };

        JPanel rolePanel = new JPanel();
        rolePanel.setBackground(darkGray);
        rolePanel.setLayout(new GridLayout(5, 1, 0, 10));
        rolePanel.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));

        for (int i = 0; i < roles.length; i++) {
            int roleNumber = i + 1;
            JButton roleButton = createButton(roleNumber + ". " + roles[i], green, white);
            rolePanel.add(roleButton);

            roleButton.addActionListener(e -> {
                playerRole = roleNumber;
                info("You have chosen the " + roles[playerRole - 1].toUpperCase() + " class.\n" + roleBlurbs[playerRole - 1], "Role Selected");
                showFirstAttackScreen();
            });
        }

        mainPanel.add(rolePanel, BorderLayout.CENTER);
        refreshScreen();
    }

    // =========================================================
    // FIRST ATTACK SCREEN  (mirrors firstAttack())
    // =========================================================

    void showFirstAttackScreen() {
        mainPanel.removeAll();

        titleLabel = makeTitle("!!! ZOMBIE ATTACK !!!", "Arial", 28, darkRed, white, 25, 15);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        storyLabel = makeHtmlLabel(
            "A zombie appeared out of nowhere and<br>attacked your party!<br><br>" +
            "<b><font color='#ff6666'>You have been bitten.</font></b><br>" +
            "HP down to:<br><font size='6'>20 HP</font><br><br>" +
            "Would you like to use a health potion?",
            18, false
        );
        mainPanel.add(storyLabel, BorderLayout.CENTER);

        JButton potionButton = createButton("YES - USE A HEALTH POTION", green, white);
        JButton skipButton = createButton("NO - CONTINUE WITHOUT ONE", darkRed, white);
        mainPanel.add(makeButtonPanel(new GridLayout(2, 1, 10, 15), potionButton, skipButton), BorderLayout.SOUTH);

        potionButton.addActionListener(e -> showPotionScreen());
        skipButton.addActionListener(e -> {
            playerHP = 20;
            potionClass = 0;
            showCurrentHPScreen();
        });

        refreshScreen();
    }

    // =========================================================
    // POTION SCREEN
    // =========================================================

    void showPotionScreen() {
        mainPanel.removeAll();

        titleLabel = makeTitle("CHOOSE YOUR POTION", "Arial", 26, darkGreen, white, 20, 15);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        storyLabel = makeHtmlLabel("Choose wisely, each potion has hidden effects.", 17, false);
        mainPanel.add(storyLabel, BorderLayout.CENTER);

        String[] potionNames = { "BLUE POTION  (+80 HP)", "RED POTION  (+100 HP)", "ORANGE POTION  (+50 HP)",
                                  "BLACK POTION  (+30 HP)", "WHITE POTION  (+60 HP)" };
        int[] potionBonus = { 80, 100, 50, 30, 60 };
        Color[] potionColors = { new Color(60, 90, 200), new Color(180, 40, 40), new Color(215, 120, 30),
                                  new Color(40, 40, 40), lightGray };
        Color[] potionFg = { white, white, white, white, darkGray };
        String[] potionWordNames = { "blue", "red", "orange", "black", "white" };

        JPanel potionPanel = new JPanel();
        potionPanel.setBackground(darkGray);
        potionPanel.setLayout(new GridLayout(5, 1, 0, 8));
        potionPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        for (int i = 0; i < potionNames.length; i++) {
            int choice = i + 1;
            JButton potionButton = createButton(choice + ". " + potionNames[i], potionColors[i], potionFg[i]);
            potionPanel.add(potionButton);

            potionButton.addActionListener(e -> {
                potionClass = choice;
                playerHP = 20 + potionBonus[choice - 1];
                info("You have used the " + potionWordNames[choice - 1] + " health potion, +" + potionBonus[choice - 1] + " HP.", "Potion Used");
                showCurrentHPScreen();
            });
        }

        mainPanel.add(potionPanel, BorderLayout.SOUTH);
        refreshScreen();
    }

    // =========================================================
    // CURRENT HP SCREEN
    // =========================================================

    void showCurrentHPScreen() {
        mainPanel.removeAll();

        titleLabel = makeTitle("!!! REMEMBER !!!", "Arial", 28, darkGreen, white, 20, 15);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JLabel hpLabel = makeHtmlLabel(
            "Player:<br><font size='6'>" + playerName + "</font><br><br>" +
            "Role:<br><font size='5'>" + roles[playerRole - 1] + "</font><br><br>" +
            "Current HP:<br><font size='6'>" + playerHP + " HP</font>",
            18, true
        );
        mainPanel.add(hpLabel, BorderLayout.CENTER);

        JButton continueButton = createButton("CONTINUE TO NEXT STAGE", green, white);
        JButton exitButton = createButton("EXIT SIMULATION", darkRed, white);
        mainPanel.add(makeButtonPanel(new GridLayout(2, 1, 0, 10), continueButton, exitButton), BorderLayout.SOUTH);

        continueButton.addActionListener(e -> showLootScreen());
        exitButton.addActionListener(e -> {
            info("You have chosen to exit the simulation. Game Over.", "Game Over");
            System.exit(0);
        });

        refreshScreen();
    }

    // =========================================================
    // LOOT EXPLORATION  (mirrors lootExploration())
    // =========================================================

    void showLootScreen() {
        mainPanel.removeAll();

        titleLabel = makeTitle("ABANDONED BUILDING", "Arial", 26, darkGreen, white, 20, 15);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        storyLabel = makeHtmlLabel(
            "Your party moves through the ruined streets<br>and comes across an abandoned building.<br><br>" +
            "Inside, tucked behind some rubble,<br>you spot a loot box.<br><br>" +
            "Would you like to open the loot box?",
            18, false
        );
        mainPanel.add(storyLabel, BorderLayout.CENTER);

        JButton openButton = createButton("YES - OPEN THE LOOT BOX", green, white);
        JButton skipButton = createButton("NO - LEAVE IT UNTOUCHED", darkRed, white);
        mainPanel.add(makeButtonPanel(new GridLayout(2, 1, 10, 15), openButton, skipButton), BorderLayout.SOUTH);

        openButton.addActionListener(e -> showLootItemsScreen());
        skipButton.addActionListener(e -> {
            lootChoice = 0;
            info("You decide not to open the loot box and continue on.", "Loot Box");
            afterLoot();
        });

        refreshScreen();
    }

    void showLootItemsScreen() {
        mainPanel.removeAll();

        titleLabel = makeTitle("CHOOSE ONE ITEM", "Arial", 26, darkGreen, white, 20, 15);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        storyLabel = makeHtmlLabel(
            "You pry open the loot box and find several<br>useful items.<br><br>" +
            "Oh no, your inventory is full, you must only<br>get one. Which one are you choosing?",
            17, false
        );
        mainPanel.add(storyLabel, BorderLayout.CENTER);

        String[] itemNames = { "Metal Scraps", "Mask", "Mystery Syringe", "Gun Powder", "Talisman" };

        JPanel itemPanel = new JPanel();
        itemPanel.setBackground(darkGray);
        itemPanel.setLayout(new GridLayout(5, 1, 0, 8));
        itemPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        for (int i = 0; i < itemNames.length; i++) {
            int choice = i + 1;
            JButton itemButton = createButton(choice + ". " + itemNames[i], green, white);
            itemPanel.add(itemButton);

            itemButton.addActionListener(e -> {
                lootChoice = choice;
                info("You have chosen " + itemNames[choice - 1] + "!", "Item Selected");
                afterLoot();
            });
        }

        mainPanel.add(itemPanel, BorderLayout.SOUTH);
        refreshScreen();
    }

    // Decides whether the medic side-quest (survivorScenario()) applies,
    // otherwise goes straight to the boss fight intro.
    void afterLoot() {
        if (playerRole == 3 && lootChoice == 3) {
            showSurvivorScreen();
        } else {
            syringeChoice = "";
            showBossIntroScreen();
        }
    }

    // =========================================================
    // SURVIVOR SCENARIO  (mirrors survivorScenario(), medic-only)
    // =========================================================

    void showSurvivorScreen() {
        mainPanel.removeAll();

        titleLabel = makeTitle("SURVIVORS IN NEED", "Arial", 26, darkGreen, white, 20, 15);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        storyLabel = makeHtmlLabel(
            "As you continue forward, you hear screaming.<br>" +
            "A group of survivors is trapped and begging<br>for help.<br><br>" +
            "You still have the Mystery Syringe.<br>It might be able to help them.<br><br>" +
            "Would you like to give them the syringe,<br>or save it for the fight ahead?",
            17, false
        );
        mainPanel.add(storyLabel, BorderLayout.CENTER);

        JButton giveButton = createButton("GIVE THE SYRINGE", green, white);
        JButton saveButton = createButton("SAVE IT FOR THE FIGHT", darkRed, white);
        mainPanel.add(makeButtonPanel(new GridLayout(2, 1, 10, 15), giveButton, saveButton), BorderLayout.SOUTH);

        giveButton.addActionListener(e -> {
            syringeChoice = "give";
            info("You hand over the Mystery Syringe. The survivors are saved\nand thank you for your kindness.\n\n" +
                 "However, you no longer have the syringe for what lies ahead.", "Syringe Given");
            showBossIntroScreen();
        });

        saveButton.addActionListener(e -> {
            syringeChoice = "save";
            info("You decide to save the syringe. The survivors' cries fade\nbehind you as you press on.\n\n" +
                 "You continue forward, but you hear distant screams.\nYou cannot help them as you have no means to do so.", "Syringe Saved");
            showBossIntroScreen();
        });

        refreshScreen();
    }

    // =========================================================
    // BOSS FIGHT INTRO  (mirrors the start of bossFight())
    // =========================================================

    void showBossIntroScreen() {
        mainPanel.removeAll();

        titleLabel = makeTitle("!!! THE ZOMBIE KING !!!", "Arial", 28, darkRed, white, 20, 15);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        storyLabel = makeHtmlLabel(
            "You have reached the base of the<br><b>Zombie King</b>, the final boss.<br><br>" +
            "Preparing for the final battle...<br><br>" +
            "Your attacks seem to have no effect<br>on the Zombie King.<br>" +
            "Your party is in a predicament...<br><br>" +
            "Different materials have appeared in front<br>of you, capable of defeating the Zombie King.<br><br>" +
            "Would you like to attempt to use them?",
            17, false
        );
        mainPanel.add(storyLabel, BorderLayout.CENTER);

        JButton attemptButton = createButton("YES - ATTEMPT TO USE THEM", green, white);
        JButton giveUpButton = createButton("NO - GIVE UP", darkRed, white);
        mainPanel.add(makeButtonPanel(new GridLayout(2, 1, 10, 15), attemptButton, giveUpButton), BorderLayout.SOUTH);

        attemptButton.addActionListener(e -> showMaterialScreen());
        giveUpButton.addActionListener(e -> showGameOver(
            "You have chosen not to attempt to use the materials.\n\n" +
            "The Zombie King has defeated you and your party.\n\n" +
            "Once again, humanity has lost its hope..."
        ));

        refreshScreen();
    }

    // =========================================================
    // MATERIAL SELECTION
    // =========================================================

    void showMaterialScreen() {
        mainPanel.removeAll();

        titleLabel = makeTitle("CHOOSE YOUR MATERIAL", "Arial", 24, darkRed, white, 20, 15);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        storyLabel = makeHtmlLabel("Choose one material you would like to use:", 17, false);
        mainPanel.add(storyLabel, BorderLayout.CENTER);

        String[] materialNames = { "Excalibur", "Annihilator", "Toxic Device", "Poisonous Smoke", "Elixir of Life" };

        JPanel materialPanel = new JPanel();
        materialPanel.setBackground(darkGray);
        materialPanel.setLayout(new GridLayout(5, 1, 0, 8));
        materialPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        for (int i = 0; i < materialNames.length; i++) {
            int choice = i + 1;
            JButton materialButton = createButton(choice + ". " + materialNames[i], green, white);
            materialPanel.add(materialButton);
            materialButton.addActionListener(e -> showMaterialConditionScreen(choice));
        }

        mainPanel.add(materialPanel, BorderLayout.SOUTH);
        refreshScreen();
    }

    // =========================================================
    // MATERIAL CONDITIONS + ATTEMPT
    // (mirrors each case of the switch inside bossFight())
    // =========================================================

    void showMaterialConditionScreen(int materialChoice) {
        mainPanel.removeAll();

        String materialName;
        String conditionsHtml;

        switch (materialChoice) {
            case 1:
                materialName = "Excalibur";
                conditionsHtml = "1. You must be a Warrior class.<br>2. You must have the Orange Potion (70 HP).<br>3. You must have the Talisman.";
                break;
            case 2:
                materialName = "Annihilator";
                conditionsHtml = "1. You must be a Cowboy class.<br>2. You must have the Black Potion (50 HP).<br>3. You must have the Gun Powder.";
                break;
            case 3:
                materialName = "Toxic Device";
                conditionsHtml = "1. You must be an Engineer class.<br>2. You must have the Blue Potion (100 HP).<br>3. You must have the Metal Scraps.";
                break;
            case 4:
                materialName = "Poisonous Smoke";
                conditionsHtml = "1. You must be a Scientist class.<br>2. You must have the White Potion (80 HP).<br>3. You must have the Mask.";
                break;
            default:
                materialName = "Elixir of Life";
                conditionsHtml = "1. You must be a Medic class.<br>2. You must have the Red Potion (120 HP).<br>3. You must have the Mystery Syringe " +
                                  "(if you gave it to the survivors, you will not be able to use it).";
                break;
        }

        titleLabel = makeTitle("You have chosen the " + materialName + "!", "Arial", 20, darkRed, white, 20, 15);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        storyLabel = makeHtmlLabel(
            "To use the " + materialName + ", you must meet the<br>following conditions:<br><br>" + conditionsHtml +
            "<br><br>Would you like to attempt to use it?",
            15, false
        );
        mainPanel.add(storyLabel, BorderLayout.CENTER);

        JButton attemptButton = createButton("YES - ATTEMPT IT", green, white);
        JButton backButton = createButton("NO - CHOOSE ANOTHER", darkRed, white);
        mainPanel.add(makeButtonPanel(new GridLayout(2, 1, 10, 15), attemptButton, backButton), BorderLayout.SOUTH);

        attemptButton.addActionListener(e -> resolveMaterial(materialChoice));
        backButton.addActionListener(e -> showGameOver(
            "You have chosen not to attempt to use the " + materialName + ".\n\n" +
            "The Zombie King has defeated you and your party.\n\n" +
            "Once again, humanity has lost its hope..."
        ));

        refreshScreen();
    }

    // Checks the win conditions for the chosen material, exactly matching
    // the terminal version's if-statements inside bossFight().
    void resolveMaterial(int materialChoice) {
        switch (materialChoice) {
            case 1: // Excalibur
                if (playerRole == 1 && potionClass == 3 && lootChoice == 5) {
                    showVictoryScreen("The Excalibur has defeated the Zombie King!", false);
                } else {
                    showGameOver(
                        "You do not meet the conditions to wield the Excalibur.\n\n" +
                        "The Zombie King has defeated you and your party.\n\n" +
                        "Once again, humanity has lost its hope..."
                    );
                }
                break;

            case 2: // Annihilator
                if (playerRole == 2 && potionClass == 4 && lootChoice == 4) {
                    showVictoryScreen("The Annihilator has defeated the Zombie King!", false);
                } else {
                    showGameOver(
                        "You do not meet the conditions to use the Annihilator.\n\n" +
                        "The Zombie King has defeated you and your party.\n\n" +
                        "Once again, humanity has lost its hope..."
                    );
                }
                break;

            case 3: // Toxic Device
                if (playerRole == 4 && potionClass == 1 && lootChoice == 1) {
                    showVictoryScreen("The Toxic Device has defeated the Zombie King!", false);
                } else {
                    showGameOver(
                        "You do not meet the conditions to use the Toxic Device.\n\n" +
                        "The Zombie King has defeated you and your party.\n\n" +
                        "Once again, humanity has lost its hope..."
                    );
                }
                break;

            case 4: // Poisonous Smoke
                if (playerRole == 5 && potionClass == 5 && lootChoice == 2) {
                    showVictoryScreen("The Poisonous Smoke has defeated the Zombie King!", false);
                } else {
                    showGameOver(
                        "You do not meet the conditions to use the Poisonous Smoke.\n\n" +
                        "The Zombie King has defeated you and your party.\n\n" +
                        "Once again, humanity has lost its hope..."
                    );
                }
                break;

            default: // Elixir of Life - secret ending
                if (playerRole == 3 && potionClass == 2 && lootChoice == 3 && syringeChoice.equalsIgnoreCase("save")) {
                    showVictoryScreen(
                        "You lower your weapon. Instead of striking the Zombie King, you plunge\n" +
                        "the Elixir of Life into him, hoping that it can still save him.\n\n" +
                        "The virus burns away, his skin slowly returns to normal, and his empty,\n" +
                        "dead eyes slowly get their color back.\n\n" +
                        "The Zombie King collapses to his knees... once a monster, now a man.\n\n" +
                        "You found the true cure, and saved humanity without spilling more blood.\n\n" +
                        "Congratulations! You have saved humanity... and redeemed a King.",
                        true
                    );
                } else {
                    showGameOver(
                        "You do not meet the conditions to use the Poisoned Syringe.\n\n" +
                        "The Zombie King has defeated you and your party.\n\n" +
                        "Once again, humanity has lost its hope..."
                    );
                }
                break;
        }
    }

    // =========================================================
    // VICTORY SCREEN
    // =========================================================

    void showVictoryScreen(String outcomeMessage, boolean secretEnding) {
        mainPanel.removeAll();

        titleLabel = makeTitle(secretEnding ? "*** SECRET ENDING ***" : "! HUMANITY IS SAVED !",
                                "Arial", 24, darkGreen, white, 20, 15);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JLabel victoryLabel = makeHtmlLabel(
            outcomeMessage.replace("\n", "<br>") + "<br><br>" +
            (secretEnding ? "" : "Congratulations! You have saved humanity!<br><br>") +
            "Your journey has come to an end...",
            15, false
        );
        mainPanel.add(victoryLabel, BorderLayout.CENTER);

        // Original: once won, the only real path forward is Reincarnate
        // (choosing anything else simply accepts the ending).
        JButton reincarnateButton = createButton("REINCARNATE", green, white);
        JButton acceptButton = createButton("ACCEPT YOUR FATE", darkRed, white);
        mainPanel.add(makeButtonPanel(new GridLayout(2, 1, 0, 10), reincarnateButton, acceptButton), BorderLayout.SOUTH);

        reincarnateButton.addActionListener(e -> reincarnate());
        acceptButton.addActionListener(e -> showAcceptFateScreen());

        refreshScreen();
    }

    // =========================================================
    // GAME OVER
    // =========================================================

    void showGameOver(String message) {
        mainPanel.removeAll();

        titleLabel = makeTitle("-- GAME OVER --", "Arial", 30, darkGreen, lightRed, 20, 15);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JLabel messageLabel = makeHtmlLabel(
            message.replace("\n", "<br>") + "<br><br>But this is not necessarily your final fate.",
            16, false
        );
        mainPanel.add(messageLabel, BorderLayout.CENTER);

        JButton backInTimeButton = createButton("Go Back in Time - Change your fate and correct your mistakes.", green, white);
        JButton reincarnateButton = createButton("Reincarnate - Create a new fate as a different survivor.", lightGreen, darkGreen);
        JButton acceptButton = createButton("ACCEPT YOUR FATE", darkRed, white);
        mainPanel.add(makeButtonPanel(new GridLayout(3, 1, 0, 10), backInTimeButton, reincarnateButton, acceptButton), BorderLayout.SOUTH);

        backInTimeButton.addActionListener(e -> goBackInTime());
        reincarnateButton.addActionListener(e -> reincarnate());
        acceptButton.addActionListener(e -> showAcceptFateScreen());

        refreshScreen();
    }

    // "Go Back in Time" - replays from the first zombie attack onward,
    // keeping the same name and role (mirrors continueStory()'s fate==1 branch).
    void goBackInTime() {
        playerHP = 20;
        potionClass = 0;
        lootChoice = 0;
        syringeChoice = "";

        info("The clock turns backward...\nYou are given another chance to change your fate.", "Go Back In Time");
        showFirstAttackScreen();
    }

    // "Reincarnate" - full restart with a brand new name & role
    // (mirrors reincarnate()).
    void reincarnate() {
        playerName = null;
        playerAge = 0;
        playerRole = 0;
        playerHP = 20;
        potionClass = 0;
        lootChoice = 0;
        syringeChoice = "";

        info("Your current life fades away...\nA new life begins in a world still threatened by the outbreak.", "Reincarnate");
        showTitleScreen();
    }

    // =========================================================
    // ACCEPT FATE  (mirrors acceptFate())
    // =========================================================

    void showAcceptFateScreen() {
        mainPanel.removeAll();

        titleLabel = makeTitle("YOUR FATE IS SEALED", "Arial", 26, darkGray, lightGray, 20, 15);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JLabel messageLabel = makeHtmlLabel(
            "You have chosen to accept your fate.<br><br>[The story ends here.]",
            20, false
        );
        mainPanel.add(messageLabel, BorderLayout.CENTER);

        JButton exitButton = createButton("EXIT", darkRed, white);
        sizeButton(exitButton, 450, 55);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(darkGray);
        bottomPanel.add(exitButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        exitButton.addActionListener(e -> System.exit(0));

        refreshScreen();
    }

    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ZombieOutbreakGUI();
        });
    }
}
