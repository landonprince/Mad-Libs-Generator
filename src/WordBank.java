import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * WordBank class represents a bank of words used in Mad Libs stories.
 * It provides methods to retrieve random words and word lists.
 */
public class WordBank {
    protected List<List<String>> words = new ArrayList<>();
    protected Random random = new Random();

    /**
     * Constructor for WordBank class.
     * Initializes the word bank and sets the seed for randomization.
     */
    public WordBank() {
        long seed = System.currentTimeMillis();
        random.setSeed(seed);
        fillBank();
    }

    /**
     * Fills the word bank with empty lists for different word types
     * (nouns, verbs, adjectives, adverbs).
     */
    protected void fillBank() {
        words.add(new ArrayList<>()); // nouns
        words.add(new ArrayList<>()); // verbs
        words.add(new ArrayList<>()); // adjectives
        words.add(new ArrayList<>()); // adverbs
    }

    /**
     * Retrieves the list of nouns from the word bank.
     * @return List of nouns.
     */
    public List<String> getNouns() {
        return words.get(0);
    }

    /**
     * Retrieves the list of verbs from the word bank.
     * @return List of verbs.
     */
    public List<String> getVerbs() {
        return words.get(1);
    }

    /**
     * Retrieves the list of adjectives from the word bank.
     * @return List of adjectives.
     */
    public List<String> getAdjectives() {
        return words.get(2);
    }

    /**
     * Retrieves the list of adverbs from the word bank.
     * @return List of adverbs.
     */
    public List<String> getAdverbs() {
        return words.get(3);
    }

    /**
     * Retrieves a random noun from the word bank.
     * @return Random noun.
     */
    public String getRandomNoun() {
        List<String> nouns = getNouns();
        return getRandomElement(nouns);
    }

    /**
     * Retrieves a random verb from the word bank.
     * @return Random verb.
     */
    public String getRandomVerb() {
        List<String> verbs = getVerbs();
        return getRandomElement(verbs);
    }

    /**
     * Retrieves a random adjective from the word bank.
     * @return Random adjective.
     */
    public String getRandomAdjective() {
        List<String> adjectives = getAdjectives();
        return getRandomElement(adjectives);
    }

    /**
     * Retrieves a random adverb from the word bank.
     * @return Random adverb.
     */
    public String getRandomAdverb() {
        List<String> adverbs = getAdverbs();
        return getRandomElement(adverbs);
    }

    /**
     * Retrieves a random noun from any theme-specific word bank.
     * @return Random noun from any theme.
     */
    public String getRandomNounAll() {
        int bankIndex = random.nextInt(3);
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
    public String getRandomVerbAll() {
        int bankIndex = random.nextInt(3);
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
    public String getRandomAdjectiveAll() {
        int bankIndex = random.nextInt(3);
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
    public String getRandomAdverbAll() {
        int bankIndex = random.nextInt(3);
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
    private String getRandomElement(List<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}








