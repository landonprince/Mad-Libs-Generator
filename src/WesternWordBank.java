import java.util.List;
import java.util.Arrays;

/**
 * WesternWordBank class represents a bank of words specific to the western theme used in Mad Libs stories.
 * It extends the WordBank class and fills the word bank with western-themed words.
 */
public class WesternWordBank extends WordBank {
    /**
     * Constructor for WesternWordBank class.
     * Calls the superclass constructor to initialize the word bank.
     */
    protected WesternWordBank() {
        fillBank();
    }

    /**
     * Fills the western-themed word bank with nouns, verbs, adjectives, and adverbs related to western.
     */
    @Override
    protected void fillBank() {
        super.fillBank();
        List<String> nouns = getNouns();
        nouns.addAll(Arrays.asList(
                "cowboy", "horse", "saloon", "sheriff", "outlaw", "cattle", "gun", "desert", "prairie", "gold", "mine",
                "stagecoach", "railroad", "pistol", "rifle", "whiskey", "lasso", "rodeo", "canyon", "bandit", "bounty",
                "prospector", "ranch", "wagon", "frontier", "duel", "tumbleweed", "buffalo", "campfire", "cactus",
                "saddle", "spurs", "chaps", "marshal", "posse", "stampede", "tent", "trail", "wells fargo", "gallows",
                "holster", "indian", "jail", "kerosene", "lever-action", "moccasin", "nugget", "oasis", "panning",
                "quicksand", "revolver", "shotgun", "tepee", "undertaker", "varmint", "winchester", "yucca", "zebu",
                "alamo", "buckaroo", "cherokee", "derringer", "eagle", "fandango", "grizzly", "homestead", "injun",
                "jackrabbit", "kiowa", "longhorn", "mustang", "navajo", "outpost", "pony", "quiver", "rattlesnake",
                "sioux", "tomahawk", "ute", "vigilante", "wampum", "xerophyte", "yawl", "zephyr", "apache", "bison",
                "cochise", "dodge city", "evergreen", "fort apache", "geronimo", "hitching post", "iroquois", "jerky",
                "klondike", "lariat", "mesquite", "nez perce", "oklahoma", "pemmican", "quartz", "remington",
                "sarsaparilla", "totem", "ulysses", "vulture", "wyatt earp", "yosemite", "zuni"
        ));
        List<String> verbs = getVerbs();
        verbs.addAll(Arrays.asList(
                "ambush", "brand", "camp", "defend", "explore", "fight", "gallop", "hunt", "invade", "journey",
                "kidnap", "lasso", "mine", "navigate", "outrun", "prospect", "quarrel", "ride", "shoot", "trade",
                "unearth", "venture", "wander", "yield", "zoom", "attack", "brawl", "chase", "duel", "escape", "forage",
                "gamble", "herd", "intimidate", "jump", "knock", "lurk", "mosey", "negotiate", "occupy", "pioneer",
                "question", "rustle", "scout", "tame", "undermine", "vanquish", "whistle", "yodel", "arrest", "blaze",
                "cattle-drive", "dig", "elope", "flee", "grit", "hitch", "infiltrate", "jail", "kick", "loot",
                "migrate", "neglect", "outlaw", "plunder", "quick-draw", "retreat", "survive", "thrive", "uproot",
                "vex", "wrangle", "yearn", "aim", "boil", "claim", "dash", "erect", "forge", "grapple", "haggle",
                "inspect", "jeer", "kneel", "lynch", "muster", "nest", "overpower", "pursue", "quench", "rescue",
                "saddle", "track", "unleash", "voyage", "wrestle", "yank", "anticipate", "bargain", "conquer", "dodge",
                "enlist", "fend", "guard", "hoist", "ignite", "jostle", "keel", "linger", "march", "nominate",
                "observe", "patrol", "quake", "rebel", "stalk", "trudge", "unmask", "veer", "wade", "yelp", "zone"
        ));
        List<String> adjectives = getAdjectives();
        adjectives.addAll(Arrays.asList(
                "arid", "dusty", "rugged", "wild", "frontier", "desolate", "gritty", "tough", "sturdy", "weathered",
                "rustic", "deserted", "lonely", "remote", "barren", "sun-baked", "windy", "rocky", "mountainous",
                "prairie", "sagebrush", "cactus", "cowboy", "outlaw", "pioneer", "gold-rush", "wagon", "railroad",
                "horseback", "gun-slinging", "lasso", "cattle", "rodeo", "saloon", "sheriff", "bandit", "prospector",
                "miner", "homesteader", "rancher", "bunkhouse", "corrals", "saddle", "spurs", "chaps", "stetson",
                "poncho", "six-shooter", "winchester", "stampede", "canyon", "mesa", "butte", "gulch", "badlands",
                "chaparral", "tumbleweed", "drought", "blazing", "sundown", "moonlit", "starlit", "twilight", "dawn",
                "dusk", "sunrise", "sunset", "midday", "midnight", "shadowy", "silhouetted", "echoing", "howling",
                "whistling", "rustling", "creaking", "clattering", "neighing", "galloping", "cantering", "bucking",
                "rearing", "snorting", "grazing", "herding", "branding", "roping", "roundup", "drive", "trail",
                "crossing", "ford", "pass", "bluff", "ridge", "peak", "summit", "plateau", "valley", "river", "stream",
                "spring", "waterhole", "well", "mine", "shaft", "tunnel", "vein", "ore", "nugget", "dust", "claim",
                "stake", "boomtown", "ghost-town"
        ));
        List<String> adverbs = getAdverbs();
        adverbs.addAll(Arrays.asList(
                "abruptly", "absently", "accusingly", "admiringly", "anxiously", "awkwardly", "boldly", "briskly",
                "brutally", "cautiously", "cheerfully", "clearly", "closely", "coldly", "constantly", "continually",
                "coolly", "courageously", "curiously", "daringly", "defiantly", "deliberately", "desperately",
                "determinedly", "diligently", "eagerly", "easily", "endlessly", "energetically", "enthusiastically",
                "equally", "especially", "eventually", "exactly", "excitedly", "fiercely", "firmly", "forcefully",
                "frantically", "freely", "frequently", "furiously", "generally", "gracefully", "gratefully", "happily",
                "harshly", "hastily", "heartily", "heavily", "helplessly", "honestly", "hopelessly", "immediately",
                "innocently", "intensely", "joyfully", "jubilantly", "justly", "keenly", "kindly", "lazily", "lightly",
                "loudly", "lovingly", "loyally", "madly", "majestically", "mightily", "mysteriously", "naturally",
                "nervously", "noisily", "obediently", "obviously", "occasionally", "openly", "painfully", "patiently",
                "peacefully", "perfectly", "persistently", "powerfully", "quickly", "quietly", "rapidly", "rarely",
                "readily", "really", "recklessly", "regularly", "reluctantly", "repeatedly", "respectfully", "rudely",
                "sadly", "safely", "seriously", "silently", "simply", "slowly", "smoothly", "solemnly", "speedily",
                "steadily", "sternly", "strongly", "suddenly", "surely", "surprisingly", "suspiciously", "swiftly",
                "tensely", "thoughtfully", "tightly", "truly", "typically", "unhappily", "usually", "viciously",
                "warmly", "wearily", "wildly", "wisely", "yearningly", "zealously"
        ));
    }
}
