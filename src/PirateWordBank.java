// By: Landon Prince (5/4/2024 - 5/8/2024)

import java.util.List;
import java.util.Arrays;

/**
 * PirateWordBank class represents a bank of words specific to the pirate theme used in Mad Libs stories.
 * It extends the WordBank class and fills the word bank with pirate-themed words.
 */
public class PirateWordBank extends WordBank {
    /**
     * Constructor for PirateWordBank class.
     * Calls the superclass constructor to initialize the word bank.
     */
    protected PirateWordBank() {
        fillBank();
    }
    /**
     * Fills the pirate-themed word bank with nouns, verbs, adjectives, and adverbs related to pirate.
     */
    @Override
    protected void fillBank() {
        super.fillBank();
        List<String> nouns = getNouns();
        nouns.addAll(Arrays.asList(
                "anchor", "armada", "bandana", "barrel", "beard", "booty", "bounty", "brig", "brigantine", "buccaneer",
                "cannon", "capstan", "captain", "caravel", "cargo", "chest", "clipper", "compass", "corsair", "crew",
                "crossbones", "cutlass", "deck", "doubloon", "ensign", "eye-patch", "fathom", "flag", "flintlock",
                "galleon", "gangplank", "gold", "gunpowder", "harbor", "hatch", "hook", "horizon", "island", "jewels",
                "jolly-roger", "keel", "kraken", "lagoon", "latitude", "legend", "loot", "longitude", "lookout",
                "mainsail", "maroon", "mast", "matey", "mermaid", "musket", "mutiny", "nautical", "navigation", "ocean",
                "parrot", "peg-leg", "pennant", "pillage", "pirate", "plank", "plunder", "porthole", "privateer",
                "quartermaster", "quarterdeck", "quest", "raft", "rigging", "rum", "sail", "schooner", "sea", "seadog",
                "seafarer", "ship", "shipmate", "shipwreck", "skull", "spyglass", "storm", "swab", "sword", "treasure",
                "tricorn", "trident", "voyage", "wreck", "x-marks-the-spot", "yacht", "yar"
        ));
        List<String> verbs = getVerbs();
        verbs.addAll(Arrays.asList(
                "abandon", "advance", "attack", "bargain", "barter", "battle", "betray", "board", "bury", "capture",
                "chart", "climb", "commandeer", "conquer", "cross", "defend", "dig", "discover", "dodge", "drink",
                "escape", "explore", "fight", "flee", "follow", "guard", "hide", "hoist", "hunt", "invade", "journey",
                "kidnap", "kill", "land", "loot", "maneuver", "maroon", "navigate", "obey", "observe", "overcome",
                "overpower", "overthrow", "parley", "pillage", "plunder", "pursue", "raid", "ransack", "rebel",
                "reclaim", "recover", "recruit", "rescue", "retreat", "revolt", "rob", "row", "sail", "scavenge",
                "scurry", "search", "seize", "set-sail", "shoot", "shout", "signal", "sink", "smuggle", "spy", "steal",
                "storm", "struggle", "surrender", "survive", "swab", "swim", "swing", "threaten", "throw", "trade",
                "trek", "trespass", "uncover", "unload", "vanquish", "venture", "visit", "wage-war", "wander", "warn",
                "watch", "whisper", "win", "withdraw", "wreck", "yell"
        ));
        List<String> adjectives = getAdjectives();
        adjectives.addAll(Arrays.asList(
                "ancient", "angry", "armed", "audacious", "barbaric", "barbarous", "bearded", "bitter", "bold", "brave",
                "brutal", "buried", "courageous", "cruel", "cunning", "curious", "dangerous", "daring", "deadly",
                "deceitful", "decisive", "defiant", "desperate", "determined", "dirty", "disloyal", "distant",
                "dreaded", "drunken", "eerie", "evil", "exotic", "fearless", "ferocious", "fierce", "fiery", "filthy",
                "foolhardy", "forgotten", "frightening", "ghostly", "gloomy", "greedy", "gruesome", "gruff", "harsh",
                "haunted", "hidden", "horrifying", "hostile", "infamous", "intrepid", "invisible", "irate", "jolly",
                "lawless", "legendary", "lonely", "looming", "lost", "loud", "loyal", "lurking", "menacing",
                "mysterious", "nasty", "naughty", "noisy", "notorious", "ominous", "outlawed", "outrageous",
                "overbearing", "persistent", "piercing", "plundering", "powerful", "ragged", "rampant", "reckless",
                "relentless", "ruthless", "savage", "scandalous", "scarred", "scary", "scheming", "seafaring",
                "secretive", "shadowy", "sinister", "sly", "smelly", "sneaky", "spooky", "stormy", "strange",
                "terrifying", "thieving", "threatening", "treacherous", "uncontrolled", "undiscovered", "unforgiving",
                "unpredictable", "unseen", "vicious", "violent", "wandering", "wild", "wily", "windswept", "wrecked"
        ));
        List<String> adverbs = getAdverbs();
        adverbs.addAll(Arrays.asList(
                "aboard", "abruptly", "absently", "aggressively", "aimlessly", "angrily", "anxiously", "audaciously",
                "boldly", "bravely", "briefly", "briskly", "brutally", "carefully", "cautiously", "cheerfully",
                "clearly", "closely", "constantly", "continually", "courageously", "cunningly", "dangerously",
                "defiantly", "deliberately", "desperately", "determinedly", "diligently", "eagerly", "easily",
                "endlessly", "energetically", "enthusiastically", "equally", "especially", "eventually", "exactly",
                "excitedly", "fearlessly", "fiercely", "firmly", "forcefully", "frantically", "freely", "frequently",
                "furiously", "generally", "gracefully", "gratefully", "greedily", "happily", "harshly", "hastily",
                "heartily", "heavily", "helplessly", "honestly", "hopelessly", "immediately", "innocently", "intensely",
                "joyfully", "jubilantly", "justly", "keenly", "kindly", "lazily", "lightly", "loudly", "lovingly",
                "loyally", "madly", "majestically", "mightily", "mysteriously", "naturally", "nervously", "noisily",
                "obediently", "obviously", "occasionally", "openly", "painfully", "patiently", "peacefully",
                "perfectly", "persistently", "powerfully", "quickly", "quietly", "rapidly", "rarely", "readily",
                "really", "recklessly", "regularly", "reluctantly", "repeatedly", "respectfully", "rudely", "sadly",
                "safely", "seriously", "silently", "simply", "slowly", "smoothly", "solemnly", "speedily", "steadily",
                "sternly", "strongly", "suddenly", "surely", "surprisingly", "suspiciously", "swiftly", "tensely",
                "thoughtfully", "tightly", "truly", "typically", "unhappily", "usually", "viciously", "warmly",
                "wearily", "wildly", "wisely", "yearningly", "zealously"
        ));
    }
}
