// By: Landon Prince (5/4/2024)

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 * MainLoop class provides the main execution logic for a Mad Libs game.
 * It includes methods for facilitating a full game of Mad Libs.
 */
public class MainLoop {
    private static final int MAX_SENTENCES = 25;
    private static final int MIN_SENTENCES = 1;
    private static MadLibFactory madLibFactory;

    /**
     * The main method, entry point of the program.
     * It initializes the game and starts the launcher.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        startLauncher();
    }

    /**
     * Starts the launcher, which prompts the user to begin the game or quit.
     * If the user chooses to play, it starts the game.
     */
    private static void startLauncher() {
        System.out.println("\n-- Mad Libs (Java Edition) --");
        System.out.println("     By: Landon Prince\n");
        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("Enter '1' or '2'");
                System.out.println("""
                        1. Play
                        2. Quit""");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1" -> {
                        loadingText(1, "\nStarting game");
                        startGame(scanner);
                        return;
                    }
                    case "2" -> {
                        loadingText(1, "\nClosing game");
                        return;
                    }
                    default -> System.out.println("\nInvalid choice. Please try again.\n");
                }
            }
        }
    }

    /**
     * Starts the game, providing instructions to the player.
     * If the player chooses to start a round, it begins a new round.
     * @param scanner Scanner object for user input.
     */
    private static void startGame(Scanner scanner) {
        System.out.println("Welcome to Mad Libs!\n");
        System.out.println("""
                Here's how it works:
                I'll generate a MadLib template based on your specifications,
                and you'll fill in the blank spaces to make a wacky tale!
                """);

        while (true) {
            System.out.println("Are you ready to make a Mad Lib?");
            System.out.println("""
                    1. I'm ready!
                    2. Go back""");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("1")) {
                startRound(scanner);
                break;
            } else if (choice.equalsIgnoreCase("2")) {
                System.out.println("\nOkay, maybe next time!\n");
                return;
            } else {
                System.out.println("\nInvalid choice. Please try again.\n");
            }
        }
    }

    /**
     * Starts a new round of the game, prompting the player to choose the number
     * of sentences, blank frequency, and theme. Then generates and displays the Mad Lib.
     * @param scanner Scanner object for user input.
     */
    private static void startRound(Scanner scanner) {
        int sentenceCount = getSentenceCount(scanner);
        double blankFrequency = getBlankFrequency(scanner);
        String theme = getTheme(scanner);

        System.out.print("\nGreat choices! ");
        System.out.print("I will now create " +
                (theme.equalsIgnoreCase("all") ? "an all theme Mad Lib" :
                        "a " + theme.toLowerCase() + " themed Mad Lib") +
                "\nwith " + sentenceCount + " sentences ");
        if (blankFrequency == 0.1) {
            System.out.println("and few blank spaces.\n");
        } else if (blankFrequency == 0.25) {
            System.out.println("and some blank spaces.\n");
        } else {
            System.out.println("and many blank spaces.\n");
        }

        loadingText(3, "Generating Mad Lib template");
        madLibFactory = new MadLibFactory(theme, sentenceCount, blankFrequency);
        List<String> madLib = madLibFactory.generateMadLib();
        System.out.println("Mad Lib template successfully generated!\n");

        while (true) {
            System.out.println("Would you like to see the Mad Lib " +
                    "before filling in the blank spaces?");
            System.out.println("""
                    1. Yes, show me
                    2. No, surprise me""");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("1")) {
                madLibFactory.printMadLib(madLib);
                System.out.print("Looks good! ");
                break;
            } else if (choice.equalsIgnoreCase("2")) {
                System.out.print("\nOkay! ");
                break;
            } else {
                System.out.println("\nInvalid choice. Please try again.\n");
            }
        }

        List<String> responses = getResponses(scanner);
        System.out.println("""

                Great picks! I will now insert your words into the Mad Lib template!
                """);
        loadingText(3, "Completing Mad Lib");
        List<String> filledMadLib = madLibFactory.fillBlanks(madLib, responses);
        System.out.println("Mad Lib successfully completed!\n");

        while (true) {
            System.out.println("Enter '1' to display the full Mad Lib");
            System.out.println("1. Display results!");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("1")) {
                madLibFactory.printMadLib(filledMadLib);
                break;
            } else {
                System.out.println("\nInvalid choice. Please try again.\n");
            }
        }
        System.out.println("Thank you for generating a Mad Lib!\n");

        while (true) {
            System.out.println("Enter '1' to return to menu");
            System.out.println("1. Return to menu");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("1")) {
                startLauncher();
                break;
            } else {
                System.out.println("\nInvalid choice. Please try again.\n");
            }
        }
    }

    /**
     * Gathers word responses from user used to fill blanks
     * @param scanner Scanner object for user input.
     */
    private static List<String> getResponses(Scanner scanner) {
        int count = 0;
        List<String> responses = new ArrayList<>();
        List<String> wordTypes = madLibFactory.getWordTypes();
        int numBlanks = wordTypes.size();
        System.out.println("I will now ask you to fill in " + numBlanks + " blank spaces " +
                "to complete the story.");

        for (String type : wordTypes) {
            while (true) {
                System.out.print("\n(" + count + "/" + numBlanks + ") ");
                System.out.print("Please provide a [" + type.toLowerCase() + "]: ");
                String choice = scanner.nextLine().trim();
                if (!choice.isEmpty()) {
                    responses.add(choice);
                    count++;
                    break;
                }
            }
        }
        return responses;
    }

    /**
     * Prompts the player to enter the number of sentences for the Mad Lib.
     * Validates the input to ensure it's an integer between 1 and 25.
     * @param scanner Scanner object for user input.
     * @return The number of sentences in the Mad Lib.
     */
    private static int getSentenceCount(Scanner scanner) {
        int sentenceCount;
        System.out.println("\nFantastic! To begin, I must ask some questions...\n");
        System.out.print("Firstly, ");

        while (true) {
            System.out.println("How long would you like the Mad Lib to be?");
            System.out.print("Enter number of sentences (" + MIN_SENTENCES +
                    " - " + MAX_SENTENCES + "): ");
            String choice = scanner.nextLine();
            if (isInteger(choice)) {
                sentenceCount = Integer.parseInt(choice);
                if (sentenceCount > MAX_SENTENCES || sentenceCount < MIN_SENTENCES) {
                    System.out.println("\nMust be between " + MIN_SENTENCES + " and " +
                            MAX_SENTENCES + ". Please try again.\n");
                } else {
                    break;
                }
            } else {
                System.out.println("\nMust be an integer between " + MIN_SENTENCES +
                        " and " + MAX_SENTENCES + ". Please try again.\n");
            }
        }
        return sentenceCount;
    }

    /**
     * Prompts the player to enter the frequency of blank spaces in the Mad Lib.
     * Validates the input and sets the blank frequency accordingly.
     * @param scanner Scanner object for user input.
     * @return The amount of blank spaces in the Mad Lib.
     */
    private static double getBlankFrequency(Scanner scanner) {
        System.out.print("\nNice! Next, ");

        while (true) {
            System.out.println("How many blank spaces would you like in the Mad Lib?");
            System.out.println("""
                    1. Few blank spaces
                    2. Some blank spaces
                    3. Many blank spaces""");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    return 0.1;
                }
                case "2" -> {
                    return 0.25;
                }
                case "3" -> {
                    return 0.5;
                }
                default -> System.out.println("\nInvalid choice. Please try again.\n");
            }
        }
    }

    /**
     * Prompts the player to choose a theme for the Mad Lib.
     * Validates the input to ensure it's a valid theme choice.
     * @param scanner Scanner object for user input.
     * @return The chosen theme for the Mad Lib.
     */
    private static String getTheme(Scanner scanner) {
        String theme;
        System.out.print("\nPerfect! Lastly, ");

        while (true) {
            System.out.println("Which theme would you like the Mad Lib to be?");
            System.out.println("""
                    1. Space
                    2. Western
                    3. Pirate
                    4. All""");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    theme = "space";
                    return theme;
                }
                case "2" -> {
                    theme = "western";
                    return theme;
                }
                case "3" -> {
                    theme = "pirate";
                    return theme;
                }
                case "4" -> {
                    theme = "all";
                    return theme;
                }
                default -> System.out.println("\nTheme not found. Please try again.\n");
            }
        }
    }

    /**
     * Checks if a given string can be parsed as an integer.
     * @param input The input string to check.
     * @return True if the string can be parsed as an integer, false otherwise.
     */
    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Displays a loading message with a specified duration.
     * @param seconds The duration of the loading message in seconds.
     * @param message The message to display during loading.
     */
    private static void loadingText(int seconds, String message) {
        System.out.print(message);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(seconds * 250L);
                System.out.print(".");
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.println("\n");
    }
}
