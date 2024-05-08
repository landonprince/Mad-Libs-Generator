// By: Landon Prince (5/4/2024)


import java.util.List;
import java.util.ArrayList;

/**
 * MadLibFactory class generates Mad Libs based on a provided theme,
 * sentence count, and blank frequency
 */
public class MadLibFactory {
    private final String THEME;
    private final int SENTENCE_COUNT;
    private int maxSentenceLength;
    private final SentenceFactory sentenceFactory;

    /**
     * Constructor for MadLibFactory class.
     * Initializes the parameters, and creates a SentenceFactory instance.
     * @param theme The theme for the Mad Lib.
     * @param sentenceCount The number of sentences in the Mad Lib.
     * @param blankFrequency The amount of blank spaces in the Mad Lib
     */
    protected MadLibFactory(String theme, int sentenceCount, double blankFrequency) {
        this.THEME = theme;
        this.SENTENCE_COUNT = sentenceCount;
        this.maxSentenceLength = 0;
        this.sentenceFactory = new SentenceFactory(theme, blankFrequency);
    }

    /**
     * Generates a Mad Lib based on the provided theme and sentence count.
     * @return A list of strings representing the generated Mad Lib.
     */
    protected List<String> generateMadLib() {
        WordBank wordBank;
        if (THEME.equalsIgnoreCase("space")) {
            wordBank = new SpaceWordBank();
        } else if (THEME.equalsIgnoreCase("western")) {
            wordBank = new WesternWordBank();
        } else if (THEME.equalsIgnoreCase("pirate")) {
            wordBank = new PirateWordBank();
        } else {
            wordBank = new WordBank();
        }
        List<String> madLib = new ArrayList<>();
        for (int i = 0; i < SENTENCE_COUNT; i++) {
            String sentence = sentenceFactory.buildSentence(wordBank);
            if (sentence.length() > maxSentenceLength) {
                maxSentenceLength = sentence.length();
            }
            madLib.add(sentence);
            if (i < SENTENCE_COUNT - 1) {
                madLib.add(" ");
            }
        }
        return madLib;
    }

    /**
     * Returns a list of the blank space word types from the Mad Lib template
     * @return A list of word types (noun/ver/adjective/adverb).
     */
    protected List<String> getWordTypes() {
        return sentenceFactory.getWordTypes();
    }

    /**
     * Prints the filled or unfilled Mad Lib to console
     */
    protected void printMadLib(List<String> madLib) {
        int borderLength = maxSentenceLength + 4;
        System.out.println();
        String border = "+" + "-".repeat(borderLength - 2) + "+";
        System.out.println(border);
        String header = "Mad Lib";
        System.out.println("| " + header + " ".repeat(
                borderLength - header.length() - 4) + " |");
        System.out.println(border);
        for (String s : madLib) {
            int start = 0;
            while (start < s.length()) {
                int end = Math.min(start + maxSentenceLength, s.length());
                String part = s.substring(start, end);
                System.out.println("| " + part + " ".repeat(
                        maxSentenceLength - part.length()) + " |");
                start += maxSentenceLength;
            }
        }
        System.out.println(border + "\n");
    }

    /**
     * Prints a filled or unfilled Mad Lib to console
     */
    protected List<String> fillBlanks(List<String> madLib, List<String> responses) {
        int responseIndex = 0;
        for (int i = 0; i < madLib.size(); i++) {
            String sentence = madLib.get(i);
            while (sentence.contains("[noun]") || sentence.contains("[verb]") ||
                    sentence.contains("[adjective]") || sentence.contains("[adverb]")) {
                if (sentence.contains("[noun]") && responseIndex < responses.size()) {
                    sentence = sentence.replaceFirst("\\[noun]", responses.get(responseIndex++));
                }
                if (sentence.contains("[verb]") && responseIndex < responses.size()) {
                    sentence = sentence.replaceFirst("\\[verb]", responses.get(responseIndex++));
                }
                if (sentence.contains("[adjective]") && responseIndex < responses.size()) {
                    sentence = sentence.replaceFirst("\\[adjective]", responses.get(responseIndex++));
                }
                if (sentence.contains("[adverb]") && responseIndex < responses.size()) {
                    sentence = sentence.replaceFirst("\\[adverb]", responses.get(responseIndex++));
                }
            }
            madLib.set(i, sentence);
        }
        return madLib;
    }
}
