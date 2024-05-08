// By: Landon Prince (5/4/2024)

import java.util.List;
import java.util.Arrays;

/**
 * SpaceWordBank class represents a bank of words specific to the space theme used in Mad Libs stories.
 * It extends the WordBank class and fills the word bank with space-themed words.
 */
public class SpaceWordBank extends WordBank {
    /**
     * Constructor for SpaceWordBank class.
     * Calls the superclass constructor to initialize the word bank.
     */
    protected SpaceWordBank() {
        fillBank();
    }

    /**
     * Fills the space-themed word bank with nouns, verbs, adjectives, and adverbs related to space.
     */
    @Override
    protected void fillBank() {
        super.fillBank();
        List<String> nouns = getNouns();
        nouns.addAll(Arrays.asList(
                "asteroid", "atmosphere", "aurora", "axis", "black hole", "capsule", "celestial", "cluster", "comet",
                "constellation", "cosmos", "crater", "eclipse", "ellipse", "equinox", "galaxy", "gas", "gravity",
                "hemisphere", "impact", "ionosphere", "jupiter", "kuiper belt", "light-year", "lunar", "magnetosphere",
                "mars", "meteor", "meteorite", "milky way", "moon", "nebula", "neptune", "nova", "orbit", "orion",
                "parallax", "perihelion", "planet", "plasma", "pulsar", "quasar", "radiation", "radio wave",
                "red giant", "revolution", "rotation", "satellite", "saturn", "solar", "solstice", "space",
                "spacecraft", "spaceship", "spectrum", "star", "supernova", "telescope", "universe", "vacuum",
                "venus", "vortex", "white dwarf", "wormhole", "zodiac", "alpha centauri", "andromeda", "apogee",
                "asterism", "astronaut", "big bang", "binary star", "ceres", "dark matter", "dwarf planet", "ecliptic",
                "exoplanet", "extraterrestrial", "hubble", "interstellar", "kepler", "light speed", "magnetar",
                "messier", "multiverse", "nebulae", "neutron star", "oort cloud", "parsec", "proxima centauri",
                "pulsar", "quark", "singularity", "space-time", "string theory", "tidal force", "titan", "ultraviolet",
                "variable star", "vesta", "x-ray", "yellow dwarf", "zenith"
        ));
        List<String> verbs = getVerbs();
        verbs.addAll(Arrays.asList(
                "accelerate", "align", "analyze", "ascend", "astronavigate", "blast", "burst", "calculate", "circle",
                "collide", "colonize", "communicate", "compress", "compute", "conduct", "connect", "conserve",
                "construct", "contain", "control", "coordinate", "count", "cover", "crash", "create", "cruise",
                "decelerate", "decompress", "deploy", "descend", "design", "detect", "determine", "develop", "direct",
                "discover", "dock", "drift", "eclipse", "eject", "enter", "escape", "estimate", "evaluate", "examine",
                "expand", "explore", "extract", "float", "fly", "follow", "form", "generate", "guide", "illuminate",
                "implement", "improve", "increase", "inflate", "inspect", "install", "integrate", "interact",
                "intercept", "interpret", "investigate", "launch", "locate", "maintain", "measure", "monitor",
                "navigate", "observe", "operate", "orbit", "organize", "orient", "penetrate", "pilot", "predict",
                "prepare", "preserve", "probe", "process", "produce", "program", "propel", "protect", "provide",
                "pulse", "pursue", "radiate", "receive", "record", "reflect", "reinforce", "release", "research",
                "resist", "resolve", "revolve", "rotate", "scan", "search", "secure", "send", "signal", "simulate",
                "stabilize", "study", "supply", "survey", "synchronize", "transmit", "travel", "validate", "vary",
                "venture", "verify", "view", "voyage", "weigh", "zoom"
        ));
        List<String> adjectives = getAdjectives();
        adjectives.addAll(Arrays.asList(
                "aerial", "alien", "astronomical", "atmospheric", "celestial", "circular", "cometary", "cosmic", "dark",
                "distant", "ecliptic", "extraterrestrial", "galactic", "gaseous", "geocentric", "geosynchronous",
                "gravitational", "heliocentric", "interplanetary", "interstellar", "lunar", "magnetic", "martian",
                "meteoritic", "nebular", "orbital", "planetary", "radiant", "satellite", "solar", "spatial", "spectral",
                "stellar", "telescopic", "terrestrial", "universal", "vast", "venusian", "weightless", "zodiacal",
                "astrophysical", "binary", "black", "bright", "celestial", "charged", "cold", "colossal", "deep",
                "dense", "dwarf", "eccentric", "elliptical", "eternal", "expanding", "extragalactic", "frozen",
                "giant", "glowing", "heavy", "hot", "huge", "infinite", "light", "massive", "milky", "miniature",
                "nuclear", "outer", "parallel", "polar", "pulsating", "quasar", "radioactive", "red", "revolving",
                "rotating", "shining", "spherical", "spiral", "starlit", "supernova", "translucent", "transparent",
                "twinkling", "ultraviolet", "vacuum", "variable", "vibrant", "visible", "white", "wormhole", "x-ray",
                "yellow", "zenith"
        ));
        List<String> adverbs = getAdverbs();
        adverbs.addAll(Arrays.asList(
                "above", "astronomically", "beyond", "brightly", "celestially", "circularly", "cosmically", "distantly",
                "down", "east", "eternally", "externally", "far", "galactically", "globally", "heavenly", "high",
                "horizontally", "immensely", "inwardly", "lightly", "low", "lunarly", "magnificently", "meteoricly",
                "nebulously", "north", "orbitally", "out", "outwardly", "over", "planetary", "radiantly", "rapidly",
                "round", "satellitely", "sideways", "silently", "solarly", "south", "spatially", "spherically",
                "stellarly", "telescopically", "terrestrially", "universally", "up", "vastly", "vertically", "west",
                "widely", "above", "astrally", "brightly", "centrally", "constantly", "deeply", "directly",
                "downwardly", "eastwardly", "externally", "farther", "globally", "heavenwardly", "highly", "inwardly",
                "laterally", "lower", "meteoricly", "northwardly", "outwardly", "planetary", "radiantly", "rapidly",
                "sideways", "southwardly", "stellarly", "telescopically", "upwardly", "vertically", "westwardly",
                "widely", "zodiacally", "aerially", "astronomically", "brightly", "celestially", "cosmically",
                "distantly", "eternally", "far", "galactically", "heavenly", "immensely", "lightly", "lunarly",
                "nebulously", "orbitally", "radiantly", "sideways", "spatially", "stellarly", "universally", "vastly",
                "widely"
        ));
    }
}