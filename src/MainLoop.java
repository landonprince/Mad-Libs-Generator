import java.util.*;
/**
 * MainLoop class provides the main execution logic for a Mad Libs game in Java.
 * This class includes methods for starting the game, handling user input, and generating stories.
 */
public class MainLoop {
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
                System.out.println("1. Play\n2. Quit");
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
        System.out.println("Welcome to Mad Libs!\n\nHere's how it works:");
        System.out.println("""
                I'll generate a story template based on your specifications,
                and you'll fill in the blank spaces to make a wacky tale!
                """);
        while (true) {
            System.out.println("Are you ready to make a Mad Libs?");
            System.out.println("1. I'm ready!\n2. Go back");
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
     * of words and the theme. Then generates and displays the story.
     * @param scanner Scanner object for user input.
     */
    private static void startRound(Scanner scanner) {
        int sentenceCount = getNumSentences(scanner);
        int blankCount = getNumBlanks(scanner);
        String theme = getTheme(scanner);
        System.out.print("\nNice choices! ");
        System.out.println("I will now create a " + theme.toLowerCase() + " themed story with " +
                sentenceCount + " sentences.\n");
        loadingText(3, "Generating story template");
        StoryFactory storyFactory = new StoryFactory(theme, sentenceCount, blankCount);
        List<String> story = storyFactory.generateStory();
        int lineLength = 0;
        int maxLength = 80;
        for (String s : story) {
            if (lineLength + s.length() > maxLength) {
                System.out.println();
                lineLength = 0;
            }
            System.out.print(s);
            lineLength += s.length();
        }
    }
    /**
     * Prompts the player to enter the number of sentences for the story.
     * Validates the input to ensure it's an integer between 1 and 20.
     * @param scanner Scanner object for user input.
     * @return The number of sentences in story.
     */
    private static int getNumSentences(Scanner scanner) {
        int sentenceCount;
        System.out.println("\nFantastic! To begin, I must ask some questions...\n");
        System.out.print("Firstly, ");

        while (true) {
            System.out.println("how long would you like the story to be?");
            System.out.print("Enter number of sentences (1-20): ");
            String input = scanner.nextLine();
            if (isInteger(input)) {
                sentenceCount = Integer.parseInt(input);
                if (sentenceCount > 20 || sentenceCount < 1) {
                    System.out.println("\nMust be between 1 and 20. Please try again.\n");
                } else {
                    break;
                }
            } else {
                System.out.println("\nMust be an integer between 1 and 20. Please try again.\n");
            }
        }
        return sentenceCount;
    }
    /**
     * Prompts the player to enter the number of words to fill in the story.
     * Validates the input to ensure it's an integer between 1 and 10.
     * @param scanner Scanner object for user input.
     * @return The number of blank spaces in story.
     */
    private static int getNumBlanks(Scanner scanner) {
        int blankCount;
        System.out.print("\nGreat! Next, ");
        while (true) {
            System.out.println("how many words would you like to fill in?");
            System.out.print("Enter number of blank spaces (1-10): ");
            String input = scanner.nextLine();
            if (isInteger(input)) {
                blankCount = Integer.parseInt(input);
                if (blankCount > 10 || blankCount < 1) {
                    System.out.println("\nMust be between 1 and 10. Please try again.\n");
                } else {
                    break;
                }
            } else {
                System.out.println("\nMust be an integer between 1 and 10. Please try again.\n");
            }
        }
        return blankCount;
    }
    /**
     * Prompts the player to choose a theme for the story.
     * Validates the input to ensure it's a valid theme choice.
     * @param scanner Scanner object for user input.
     * @return The chosen theme for the story.
     */
    private static String getTheme(Scanner scanner) {
        String theme;
        System.out.print("\nPerfect! Lastly, ");
        label:
        while (true) {
            System.out.println("Which theme would you like the story to be?");
            System.out.println("1. Space\n2. Western\n3. Pirate\n4. All");
            String input = scanner.nextLine();
            switch (input) {
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
