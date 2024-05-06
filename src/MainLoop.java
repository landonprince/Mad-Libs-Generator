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
        System.out.print("-- Mad Libs (Java Edition) --");
        System.out.println(" By: Landon Prince");
        startLauncher();
    }
    /**
     * Starts the launcher, which prompts the user to begin the game or quit.
     * If the user chooses to play, it starts the game.
     */
    private static void startLauncher() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter 'play' to begin or 'quit' to close the game.");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("play")) {
                    loadingText(1, "Starting game");
                    startGame(scanner);
                    break;
                } else if (choice.equalsIgnoreCase("quit")) {
                    loadingText(1, "Closing game");
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
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
        System.out.println("You'll provide the words, and I'll create a fun story with them!\n");
        while (true) {
            System.out.println("Are you ready to start a round? Enter 'yes' or 'no'.");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                startRound(scanner);
                break;
            } else if (choice.equalsIgnoreCase("no")) {
                System.out.println("Okay, maybe next time!");
                startLauncher();
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    /**
     * Starts a new round of the game, prompting the player to choose the number
     * of words and the theme. Then generates and displays the story.
     * @param scanner Scanner object for user input.
     */
    private static void startRound(Scanner scanner) {
        int wordCount = getNumWords(scanner);
        String theme = getTheme(scanner);
        System.out.println("Fantastic choice!");
        System.out.println("I will now create a " + theme.toLowerCase() + " themed story with " +
                wordCount + " blanks.\n");
        loadingText(3, "Generating story template");
        StoryFactory storyFactory = new StoryFactory(theme, wordCount);
        List<String> story = storyFactory.generateStory();
        for (String s : story) {
            System.out.print(s);
        }
    }
    /**
     * Prompts the player to enter the number of words to provide for the story.
     * Validates the input to ensure it's an integer between 1 and 20.
     * @param scanner Scanner object for user input.
     * @return The number of words provided by the player.
     */
    private static int getNumWords(Scanner scanner) {
        int wordCount;
        System.out.print("Splendid! ");
        while (true) {
            System.out.println("How many words would you like to provide? (1-20)");
            String input = scanner.nextLine();
            if (isInteger(input)) {
                wordCount = Integer.parseInt(input);
                if (wordCount > 20 || wordCount < 1) {
                    System.out.println("Must be between 1 and 20. Please try again.");
                } else {
                    break;
                }
            } else {
                System.out.println("Must be an integer between 1 and 20. Please try again.");
            }
        }
        return wordCount;
    }
    /**
     * Prompts the player to choose a theme for the story.
     * Validates the input to ensure it's a valid theme choice.
     * @param scanner Scanner object for user input.
     * @return The chosen theme for the story.
     */
    private static String getTheme(Scanner scanner) {
        String theme;
        System.out.print("Perfect! Next, ");
        while (true) {
            System.out.println("Which theme would you like for the story?");
            System.out.println("1. Space\n2. Western\n3. Pirate\n4. All");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Space") || input.equals("1")) {
                theme = "space";
                break;
            } else if (input.equalsIgnoreCase("Western") || input.equals("2")) {
                theme = "western";
                break;
            } else if (input.equalsIgnoreCase("Pirate") || input.equals("3")) {
                theme = "pirate";
                break;
            } else if (input.equalsIgnoreCase("All") || input.equals("4")) {
                theme = "all";
                break;
            } else {
                System.out.println("Theme not found. Please try again.");
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
