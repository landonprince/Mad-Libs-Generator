import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * WordBank class represents a bank of words used in Mad Libs stories.
 * It provides methods to retrieve random words and word lists.
 */
public class WordBank {
    private final List<List<String>> WORDS = new ArrayList<>();
    private final Random RANDOM = new Random();

    /**
     * Constructor for WordBank class.
     * Initializes the word bank and sets the seed for randomization.
     */
    protected WordBank() {
        long seed = System.currentTimeMillis();
        RANDOM.setSeed(seed);
        fillBank();
    }

    /**
     * Fills the word bank with empty lists for different word types
     * (nouns, verbs, adjectives, adverbs).
     */
    protected void fillBank() {
        WORDS.add(new ArrayList<>()); // nouns
        WORDS.add(new ArrayList<>()); // verbs
        WORDS.add(new ArrayList<>()); // adjectives
        WORDS.add(new ArrayList<>()); // adverbs
    }

    /**
     * Retrieves the list of nouns from the word bank.
     * @return List of nouns.
     */
    protected List<String> getNouns() {
        return WORDS.get(0);
    }

    /**
     * Retrieves the list of verbs from the word bank.
     * @return List of verbs.
     */
    protected List<String> getVerbs() {
        return WORDS.get(1);
    }

    /**
     * Retrieves the list of adjectives from the word bank.
     * @return List of adjectives.
     */
    protected List<String> getAdjectives() {
        return WORDS.get(2);
    }

    /**
     * Retrieves the list of adverbs from the word bank.
     * @return List of adverbs.
     */
    protected List<String> getAdverbs() {
        return WORDS.get(3);
    }

    /**
     * Retrieves a random noun from the word bank.
     * @return Random noun.
     */
    protected String getRandomNoun() {
        List<String> nouns = getNouns();
        return getRandomElement(nouns);
    }

    /**
     * Retrieves a random verb from the word bank.
     * @return Random verb.
     */
    protected String getRandomVerb() {
        List<String> verbs = getVerbs();
        return getRandomElement(verbs);
    }

    /**
     * Retrieves a random adjective from the word bank.
     * @return Random adjective.
     */
    protected String getRandomAdjective() {
        List<String> adjectives = getAdjectives();
        return getRandomElement(adjectives);
    }

    /**
     * Retrieves a random adverb from the word bank.
     * @return Random adverb.
     */
    protected String getRandomAdverb() {
        List<String> adverbs = getAdverbs();
        return getRandomElement(adverbs);
    }

    /**
     * Retrieves a random noun from any theme-specific word bank.
     * @return Random noun from any theme.
     */
    protected String getRandomNounFromAny() {
        int bankIndex = RANDOM.nextInt(3);
        List<String> nouns;
        if (bankIndex == 0) {
            nouns = new SpaceWordBank().getNouns();
        } else if (bankIndex == 1) {
            nouns = new WesternWordBank().getNouns();
        } else {
            nouns = new PirateWordBank().getNouns();
        }
        return getRandomElement(nouns);
    }

    /**
     * Retrieves a random verb from any theme-specific word bank.
     * @return Random verb from any theme.
     */
    protected String getRandomVerbFromAny() {
        int bankIndex = RANDOM.nextInt(3);
        List<String> verbs;
        if (bankIndex == 0) {
            verbs = new SpaceWordBank().getVerbs();
        } else if (bankIndex == 1) {
            verbs = new WesternWordBank().getVerbs();
        } else {
            verbs = new PirateWordBank().getVerbs();
        }
        return getRandomElement(verbs);
    }

    /**
     * Retrieves a random adjective from any theme-specific word bank.
     * @return Random adjective from any theme.
     */
    protected String getRandomAdjectiveFromAny() {
        int bankIndex = RANDOM.nextInt(3);
        List<String> adjectives;
        if (bankIndex == 0) {
            adjectives = new SpaceWordBank().getAdjectives();
        } else if (bankIndex == 1) {
            adjectives = new WesternWordBank().getAdjectives();
        } else {
            adjectives = new PirateWordBank().getAdjectives();
        }
        return getRandomElement(adjectives);
    }

    /**
     * Retrieves a random adverb from any theme-specific word bank.
     * @return Random adverb from any theme.
     */
    protected String getRandomAdverbFromAny() {
        int bankIndex = RANDOM.nextInt(3);
        List<String> adverbs;
        if (bankIndex == 0) {
            adverbs = new SpaceWordBank().getAdverbs();
        } else if (bankIndex == 1) {
            adverbs = new WesternWordBank().getAdverbs();
        } else {
            adverbs = new PirateWordBank().getAdverbs();
        }
        return getRandomElement(adverbs);
    }

    /**
     * Retrieves a random element from a given list.
     * @param list The list from which to retrieve the random element.
     * @return Random element from the list.
     */
    protected String getRandomElement(List<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        int randomIndex = RANDOM.nextInt(list.size());
        return list.get(randomIndex);
    }
}








