import java.util.*;
/**
 * SentenceFactory class generates sentences based on provided templates and word bank.
 */
public class SentenceFactory {
    private final String theme;
    private final double blankFrequency;
    private final List<String> templates = new ArrayList<>();
    private final Random random = new Random();

    /**
     * Constructor for SentenceFactory class.
     * Initializes the theme and builds templates.
     * @param theme The theme for the sentences.
     */
    public SentenceFactory(String theme, double blankFrequency) {
        this.theme = theme;
        this.blankFrequency = blankFrequency;
        long seed = System.currentTimeMillis();
        random.setSeed(seed);
        buildTemplates();
    }
    /**
     * Generates a sentence based on a provided word bank.
     * @param wordBank The word bank containing words for the sentence.
     * @return A StringBuilder object representing the generated sentence.
     */
    public StringBuilder buildSentence(WordBank wordBank) {
        StringBuilder sentence = new StringBuilder();
        Collections.shuffle(templates, random);
        String template = templates.get(0);
        for (char symbol : template.toCharArray()) {
            switch (symbol) {
                case '$' -> { // noun
                    if (random.nextDouble() < blankFrequency) {
                        sentence.append("[noun]");
                    } else {
                        String noun = theme.equalsIgnoreCase("all") ?
                                wordBank.getRandomNounAll() : wordBank.getRandomNoun();
                        sentence.append(noun);
                    }
                }
                case '#' -> { // verb
                    if (random.nextDouble() < blankFrequency) {
                        sentence.append("[verb]");
                    } else {
                        String verb = theme.equalsIgnoreCase("all") ?
                                wordBank.getRandomVerbAll() : wordBank.getRandomVerb();
                        sentence.append(verb);
                    }
                }
                case '@' -> { // adjective
                    if (random.nextDouble() < blankFrequency) {
                        sentence.append("[adjective]");
                    } else {
                        String adjective = theme.equalsIgnoreCase("all") ?
                                wordBank.getRandomAdjectiveAll() : wordBank.getRandomAdjective();
                        sentence.append(adjective);
                    }
                }
                case '%' -> { // adverb
                    if (random.nextDouble() < blankFrequency) {
                        sentence.append("[adverb]");
                    } else {
                        String adverb = theme.equalsIgnoreCase("all") ?
                                wordBank.getRandomAdverbAll() : wordBank.getRandomAdverb();
                        sentence.append(adverb);
                    }
                }
                default -> sentence.append(symbol);
            }
        }
        return sentence;
    }
    /**
     * Builds sentence templates.
     */
    public void buildTemplates() {
        templates.addAll(Arrays.asList(
                "The $ # %.", "It is @ to # a $.", "She # the $ %.", "He was so @, he # the $.", "I # the @ $.",
                "You are very @, you # the $.", "They # the $ %.", "We # the $ on the @ day.",
                "The $ # in the @ light.", "The @ $ # %.", "I # the @ $.", "You # the $ %.", "He # the @ $.",
                "She # the $ %.", "It # the @ $.", "We # the $ %.", "They # the @ $.",
                "After # the $, %, I # the $.", "Although $ # %, I # the $.", "I # the $ %, but they # the $.",
                "We # the $ %, yet they # the $.", "Before $ # %, I # the $.", "Since $ # %, they # the $.",
                "When $ # %, I # the $.", "While $ # %, they # the $.", "Not only did $ # %, but also they # the $.",
                "Either $ # % or they # the $.", "Neither $ # % nor they # the $.", "Both $ # % and they # the $.",
                "Whether $ # % or they # the $.", "As $ # %, I # the $.", "Until $ # %, they # the $.",
                "Even though $ # %, I # the $.", "After $ # %, they # the $.", "As soon as $ # %, I # the $.",
                "Before $ # %, they # the $.", "Since $ # %, I # the $.", "When $ # %, they # the $.",
                "Having # the $ %, I # the $.", "Despite $ # %, I # the $.", "Given that $ # %, I # the $.",
                "Owing to $ # %, I # the $.", "On account of $ # %, I # the $.", "In case $ # %, I # the $.",
                "As a result of $ # %, I # the $.", "Thanks to $ # %, I # the $.", "In spite of $ # %, I # the $.",
                "In the event that $ # %, I # the $.", "Supposing $ # %, I # the $.", "Provided that $ # %, I # the $.",
                "If $ # %, I # the $.", "Unless $ # %, I # the $.", "As long as $ # %, I # the $.",
                "So $ # % that I # the $.", "Such $ # % that I # the $.", "So $ # % that they # the $.",
                "Such $ # % that they # the $.", "In order to $ # %, I # the $.", "So as to $ # %, I # the $.",
                "In order that $ # %, I # the $.", "So that $ # %, I # the $.", "Such that $ # %, I # the $.",
                "Such that $ # %, they # the $.", "So that $ # %, they # the $.",
                "In such a way that $ # %, I # the $.", "In such a manner that $ # %, I # the $."
        ));
    }
}