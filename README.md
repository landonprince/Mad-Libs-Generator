# Mad Libs Generator
**By: Landon Prince (5/4/2024)**

Welcome! This program allows the player to generate their own _custom Mad Lib templates_, and then fill in the blank spaces to create fun stories. 
Players can choose the number of sentences, frequency of blank spaces, and the overall theme of the Mad Lib.

# Example
```
+-----------------------------------------------------------+
| Mad Lib                                                   |
+-----------------------------------------------------------+
| I defend the [adjective] [noun].                          |
|                                                           |
| After [verb] the cannon, shakily, I [verb] the kraken.    |
|                                                           |
| As it shreaks [adverb], I prepare to attack.              |
|                                                           |
| It took the privateer and began to destroy the sails.     |
|                                                           |
| After [noun] swam quickly, it [verb] the ship.            |
+-----------------------------------------------------------+

Pirate themed Mad Lib with 5 sentences and some blank spaces
```
# Classes
**MainLoop:** Entry point of the program, provides the main execution logic for the Mad Libs game 

**MadLibFactory:** Creates a randomly generated Mad Lib based on the player's specifications

**SentenceFactory:** Creates a randomly generated sentence based on the player's specifications

**WordBank:** Base class for all themed word banks to be used in sentence construction

**ThemedWordBanks:** Multiple WordBank subclasses to provide themed words (i.e. PirateWordBank)

# Skills
- Advanced string manipulation
- Factory design pattern                      
- Input validation & exception handling
- Lists & StringBuilder objects
- Inheritance
- Dynamic binding & polymorphism
- Inversion of control
