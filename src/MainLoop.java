import java.util.Scanner;
import java.util.List;

/**
 * MainLoop class provides the main execution logic for a Mad Libs game in Java.
 * It includes methods for starting the game, handling user input, and generating stories.
 */
public class MainLoop {
    private static MadLibFactory madLibFactory;

    /**
     * The main method, entry point of the program.
     * It initializes the game and starts the launcher.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println("-- Mad Libs (Java Edition) --");
        System.out.println("     By: Landon Prince\n");
        startLauncher();
    }

    /**
     * Starts the launcher, which prompts the user to begin the game or quit.
     * If the user chooses to play, it starts the game.
     */
    private static void startLauncher() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter '1' or '2'");
                System.out.println("""
                        1. Play
                        2. Quit""");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("1")) {
                    loadingText(1, "\nStarting game");
                    startGame(scanner);
                    break;
                } else if (choice.equalsIgnoreCase("2")) {
                    loadingText(1, "\nClosing game");
                    break;
                } else {
                    System.out.println("\nInvalid choice. Please try again.\n");
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
                startLauncher();
                break;
            } else {
                System.out.println("\nInvalid choice. Please try again.\n");
            }
        }
    }

    /**
     * Starts a new round of the game, prompting the player to choose the number
     * of words and the theme. Then generates and displays the Mad Lib.
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
        if (blankFrequency == 0.0) {
            System.out.println("and no blank spaces.\n");
        } else if (blankFrequency == 0.1) {
            System.out.println("and few blank spaces.\n");
        } else if (blankFrequency == 0.25) {
            System.out.println("and some blank spaces.\n");
        } else if (blankFrequency == 0.5) {
            System.out.println("and many blank spaces.\n");
        } else {
            System.out.println("and all blank spaces.\n");
        }
        loadingText(5, "Generating Mad Lib template");
        madLibFactory = new MadLibFactory(theme, sentenceCount, blankFrequency);
        List<String> madLib = madLibFactory.generateMadLib();
        System.out.println("Mad Lib successfully generated. Woo-hoo!\n");
        while (true) {
            System.out.println("Would you like to see the Mad Lib " +
                    "before filling in the blank spaces?");
            System.out.println("""
                    1. Yes, show me
                    2. No, surprise me""");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("1")) {
                madLibFactory.printMadLib(madLib);
                break;
            } else if (choice.equalsIgnoreCase("2")) {
                break;
            } else {
                System.out.println("\nInvalid choice. Please try again.\n");
            }
        }
        fillBlanks(madLib);
    }

    /**
     * Fills the blank spaces in the Mad Lib with user input.
     * @param madLib Mad Lib containing blank spaces
     */
    private static void fillBlanks(List<String> madLib) {
        int numBlanks = madLibFactory.countBlanks(madLib);
        System.out.println(numBlanks);
    }

    /**
     * Prompts the player to enter the number of sentences for the Mad Lib.
     * Validates the input to ensure it's an integer between 1 and 20.
     * @param scanner Scanner object for user input.
     * @return The number of sentences in the Mad Lib.
     */
    private static int getSentenceCount(Scanner scanner) {
        int sentenceCount;
        System.out.println("\nFantastic! To begin, I must ask some questions...\n");
        System.out.print("Firstly, ");
        while (true) {
            System.out.println("How long would you like the Mad Lib to be?");
            System.out.print("Enter number of sentences (1 - 50): ");
            String choice = scanner.nextLine();
            if (isInteger(choice)) {
                sentenceCount = Integer.parseInt(choice);
                if (sentenceCount > 50 || sentenceCount < 1) {
                    System.out.println("\nMust be between 1 and 50. Please try again.\n");
                } else {
                    break;
                }
            } else {
                System.out.println("\nMust be an integer between 1 and 50. Please try again.\n");
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
                    1. No blank spaces
                    2. Few blank spaces
                    3. Some blank spaces
                    4. Many blank spaces
                    5. All blank spaces""");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    return 0.0;
                }
                case "2" -> {
                    return 0.1;
                }
                case "3" -> {
                    return 0.25;
                }
                case "4" -> {
                    return 0.5;
                }
                case "5" -> {
                    return 1.0;
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
        label:
        while (true) {
            System.out.println("Which theme would you like the Mad Lib to be?");
            System.out.println("""
                    1. Space
                    2. Western
                    3. Pirate
                    4. All""");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    theme = "space";
                    break label;
                case "2":
                    theme = "western";
                    break label;
                case "3":
                    theme = "pirate";
                    break label;
                case "4":
                    theme = "all";
                    break label;
                default:
                    System.out.println("\nTheme not found. Please try again.\n");
                    break;
            }
        }
        return theme;
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
                e.printStackTrace();
            }
        }
        System.out.println("\n");
    }
}
