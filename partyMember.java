import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

enum CharacterClass {BARBARIAN, BARD, CLERIC, DRUID, FIGHTER, MONK, PALADIN, RANGER, ROGUE, SORCERER, 
    WARLOCK, WIZARD}

enum CharacterRace {DRAGONBORNE, DWARF, ELF, GNOME, HALFELF, HALFLING, HALFORC, HUMAN, TIEFLING}     

public class partyMember {

    private String name;
    private CharacterClass CharacterClass;
    private CharacterRace CharacterRace;

    public String getName(){
        return name;
    }

    public CharacterClass getCharacterClass(){
        return CharacterClass;
    }

    public CharacterRace getCharacterRace(){
        return CharacterRace;
    }

    /**
     * Constructor
     * @param name - String that contains name of the character
     * @param CharacterClass - enum that indicates class of the character
     * @param CharacterRace - enum that indicates race of the character
     */
    // public partyMember(String name, CharacterClass characterClass, CharacterRace characterRace){
    //     String name = "";
    //     this.characterClass = characterClass;
    //     this.characterRace = characterRace;
        
    // }

}


