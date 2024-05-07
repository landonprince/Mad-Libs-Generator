import java.util.List;
import java.util.ArrayList;

/**
 * MadLibFactory class generates Mad Libs based on a provided theme,
 * sentence count, and blank frequency
 */
public class MadLibFactory {
    private final String theme;
    private final int sentenceCount;
    private final SentenceFactory sentenceFactory;

    /**
     * Constructor for MadLibFactory class.
     * Initializes the theme and sentence count, and creates a SentenceFactory instance.
     * @param theme The theme for the Mad Lib.
     * @param sentenceCount The number of sentences in the Mad Lib.
     * @param blankFrequency The amount of blank spaces in the Mad Lib
     */
    public MadLibFactory(String theme, int sentenceCount, double blankFrequency) {
        this.theme = theme;
        this.sentenceCount = sentenceCount;
        this.sentenceFactory = new SentenceFactory(theme, blankFrequency);
    }

    /**
     * Generates a Mad Lib based on the provided theme and sentence count.
     * @return A list of strings representing the generated Mad Lib.
     */
    public List<String> generateMadLib() {
        WordBank wordBank;
        if (theme.equalsIgnoreCase("space")) {
            wordBank = new SpaceWordBank();
        } else if (theme.equalsIgnoreCase("western")) {
            wordBank = new WesternWordBank();
        } else if (theme.equalsIgnoreCase("pirate")) {
            wordBank = new PirateWordBank();
        } else {
            wordBank = new WordBank();
        }
        List<String> madLib = new ArrayList<>();
        for (int i = 0; i < sentenceCount; i++) {
            StringBuilder sentence = sentenceFactory.buildSentence(wordBank);
            madLib.add(sentence.toString());
            if (i < sentenceCount - 1) {
                madLib.add(" ");
            }
        }
        return madLib;
    }
    public void printMadLib(List<String> madLib) {
        int lineLength = 0;
        int maxLength = 20;
        for (String s : madLib) {
            if (lineLength + s.length() > maxLength) {
                System.out.println();
                lineLength = 0;
            }
            System.out.print(s);
            lineLength += s.length();
        }
    }
    public int countBlanks(List<String> madLib) {
        int count = 0;
        for (String sentence : madLib) {
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == '[') {
                    count++;
                }
            }
        }
        return count;
        // instead just keep track of blank count in sentence factory, and add them all up here
    }
}