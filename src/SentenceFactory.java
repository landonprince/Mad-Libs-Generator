import java.util.*;
/**
 * SentenceFactory class generates sentences based on provided templates and word bank.
 */
public class SentenceFactory {
    private final String theme;
    private final List<String> templates = new ArrayList<>();
    /**
     * Constructor for SentenceFactory class.
     * Initializes the theme and builds templates.
     * @param theme The theme for the sentences.
     */
    public SentenceFactory(String theme) {
        this.theme = theme;
        buildTemplates();
    }
    /**
     * Generates a sentence based on a provided word bank.
     * @param wordBank The word bank containing words for the sentence.
     * @return A StringBuilder object representing the generated sentence.
     */
    public StringBuilder buildSentence(WordBank wordBank) {
        StringBuilder sentence = new StringBuilder();
        Random random = new Random();
        long seed = System.currentTimeMillis();
        random.setSeed(seed);
        Collections.shuffle(templates, random);
        String template = templates.get(0);
        for (char symbol : template.toCharArray()) {
            switch (symbol) {
                case '$' -> {
                    String noun = theme.equalsIgnoreCase("all") ?
                            wordBank.getRandomNounAll() : wordBank.getRandomNoun();
                    sentence.append(noun);
                }
                case '#' -> {
                    String verb = theme.equalsIgnoreCase("all") ?
                            wordBank.getRandomVerbAll() : wordBank.getRandomVerb();
                    sentence.append(verb);
                }
                case '@' -> {
                    String adjective = theme.equalsIgnoreCase("all") ?
                            wordBank.getRandomAdjectiveAll() : wordBank.getRandomAdjective();
                    sentence.append(adjective);
                }
                case '%' -> {
                    String adverb = theme.equalsIgnoreCase("all") ?
                            wordBank.getRandomAdverbAll() : wordBank.getRandomAdverb();
                    sentence.append(adverb);
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
                "I # the $ %.", "You are very @, you # the $.", "They # the $ %.", "We # the $ on the @ day.",
                "The $ # in the @ light.", "The @ $ # %.", "I # the @ $.", "You # the $ %.", "He # the @ $.",
                "She # the $ %.", "It # the @ $.", "We # the $ %.", "They # the @ $.", "The $ # % in the @ morning.",
                "I # the $ in the @ afternoon.", "You # the @ $ during the night.", "He # the $ %.", "She # the @ $.",
                "It # the $ %.", "We # the @ $.", "They # the $ %.", "The @ $ #.", "I # the $ %.", "You # the @ $.",
                "He # the $ %.", "She # the @ $.", "It # the $ %.", "We # the @ $.", "They # the $ %.", "The $ # %.",
                "I # the @ $.", "You # the $ %.", "He # the @ $.", "She # the $ %.", "It # the @ $.", "We # the $ %.",
                "They # the @ $.", "The $ # %.", "I # the @ $.", "You # the $ %.", "He # the @ $.", "She # the $ %.",
                "It # the @ $.", "We # the $ %.", "They # the @ $.", "The $ # %.", "I # the @ $.", "You # the $ %.",
                "He # the @ $.", "She # the $ %.", "It # the @ $.", "We # the $ %.", "They # the @ $.", "The $ # %.",
                "I # the @ $.", "You # the $ %.", "He # the @ $.", "She # the $ %.", "It # the @ $.", "We # the $ %.",
                "They # the @ $.", "The $ # %.", "I # the @ $.", "You # the $ %.", "He # the @ $.", "She # the $ %.",
                "It # the @ $.", "We # the $ %.", "They # the @ $.", "The $ # %.", "You # the $ %.", "He # the @ $.",
                "She # the $ %.", "It # the @ $.", "We # the $ %.", "They # the @ $.", "The $ # %.", "I # the @ $.",
                "You # the $ %.", "He # the @ $.", "She # the $ %.", "It # the @ $.", "We # the $ %.",
                "They # the @ $.", "The $ # %.", "I # the @ $.", "You # the $ %.", "He # the @ $.", "She # the $ %.",
                "It # the @ $.", "We # the $ %.", "They # the @ $.", "The $ # %.", "I # the @ $.", "You # the $ %.",
                "He # the @ $.", "She # the $ %.", "It # the @ $.", "We # the $ %.", "They # the @ $.", "The $ # %.",
                "I # the @ $.", "You # the $ %.", "He # the @ $.", "She # the $ %.", "It # the @ $.", "We # the $ %.",
                "They # the @ $.", "The $ # %.", "I # the @ $.", "You # the $ %."
        ));

    }
}