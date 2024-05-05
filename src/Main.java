import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("-- Mad Libs (Java Edition) --");
        startLauncher();
    }

    private static void startLauncher() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter 'play' to begin or 'quit' to close the game.");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("play")) {
                    fakeLoading(1, "Starting game");
                    startGame(scanner);
                    break;
                } else if (choice.equalsIgnoreCase("quit")) {
                    fakeLoading(1, "Closing game");
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static void startGame(Scanner scanner) {
        System.out.println("Welcome to Mad Libs!\n\nHere's how it works:");
        System.out.println("You provide the words, and I'll create a fun story with them!\n");
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

    private static void startRound(Scanner scanner) {
        int wordCount = getNumWords(scanner);
        String theme = getTheme(scanner);
        System.out.println("Fantastic choice!");
        System.out.println("I will now create a " + theme.toLowerCase() + " themed story with " +
                wordCount + " blanks.\n");
        fakeLoading(3, "Generating story template");
//        while (true) {
//            System.out.println("Are you ready to provide the " + wordCount +
//                    " wacky words? Enter 'yes' or 'no'.");
//        }
    }

    private static int getNumWords(Scanner scanner) {
        int wordCount;
        System.out.print("Great! ");
        while (true) {
            System.out.println("How many words would you like to provide? (1-10)");
            String input = scanner.nextLine();
            if (isInteger(input)) {
                wordCount = Integer.parseInt(input);
                if (wordCount > 10 || wordCount < 1) {
                    System.out.println("Must be between 1 and 10. Please try again.");
                } else {
                    break;
                }
            } else {
                System.out.println("Must be a number between 1 and 10. Please try again.");
            }
        }
        return wordCount;
    }

    private static String getTheme(Scanner scanner) {
        String theme;
        System.out.print("Perfect! Next, ");
        while (true) {
            System.out.println("What theme would you like for the story?");
            System.out.println("1. Sci-Fi\n2. Old West\n3. Pirate");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Space") || input.equals("1")) {
                theme = "Space";
                break;
            } else if (input.equalsIgnoreCase("Western") || input.equals("2")) {
                theme = "Western";
                break;
            } else if (input.equalsIgnoreCase("Pirate") || input.equals("3")) {
                theme = "Pirate";
                break;
            } else {
                System.out.println("Theme not found. Please try again.");
            }
        }
        return theme;
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private static void fakeLoading(int seconds, String message) {
        System.out.print(message);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(seconds * 250L);
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
