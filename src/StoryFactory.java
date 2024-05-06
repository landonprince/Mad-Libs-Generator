import java.util.*;
/**
 * StoryFactory class generates stories based on a provided theme and sentence count.
 */
public class StoryFactory {
    private final String theme;
    private final int sentenceCount;
    private final int blankCount;
    private final Random random = new Random();

    private final SentenceFactory sentenceFactory;
    /**
     * Constructor for StoryFactory class.
     * Initializes the theme and sentence count, and creates a SentenceFactory instance.
     * @param theme The theme for the story.
     * @param sentenceCount The number of sentences in the story.
     */
    public StoryFactory(String theme, int sentenceCount, int blankCount) {
        this.theme = theme;
        this.sentenceCount = sentenceCount;
        this.blankCount = blankCount;
        this.sentenceFactory = new SentenceFactory(theme);
        long seed = System.currentTimeMillis();
        random.setSeed(seed);
    }
    /**
     * Generates a story based on the provided theme and sentence count.
     * @return A list of strings representing the generated story.
     */
    public List<String> generateStory() {
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
        List<String> story = new ArrayList<>();
        for (int i = 0; i < sentenceCount; i++) {
            StringBuilder sentence = sentenceFactory.buildSentence(wordBank);
            story.add(sentence.toString());
            if (i < sentenceCount - 1) {
                story.add(" ");
            }
        }
        addBlankSpaces(story, blankCount);
        return story;
    }
    public void addBlankSpaces(List<String> story, int blankCount) {
        int count = 0;
        int storySize = story.size();
        while (count < blankCount) {
            int randomIndex = random.nextInt(storySize);
            story.set(randomIndex, "_____");
            count++;
        }
    }
}