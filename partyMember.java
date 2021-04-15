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



    // /**
    //  * Default constructor
    //  */
    // public partyMember(){
    //     name = "Jack";
        
    // }
    


    public String getName(){
        return name;
    }

    public CharacterClass getCharacterClass(){
        return CharacterClass;
    }

    public CharacterRace getCharacterRace(){
        return CharacterRace;
    }

}


