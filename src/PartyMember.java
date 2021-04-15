package src;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

<<<<<<< HEAD:partyMember.java
enum CharacterClass {BARBARIAN, BARD, CLERIC, DRUID, FIGHTER, MONK, PALADIN, RANGER, ROGUE, SORCERER, 
    WARLOCK, WIZARD}

enum CharacterRace {DRAGONBORNE, DWARF, ELF, GNOME, HALFELF, HALFLING, HALFORC, HUMAN, TIEFLING}     

public class partyMember {
=======
public class PartyMember {
>>>>>>> d9e2c802cf42c5559e494caf624764e1dcff7c75:src/PartyMember.java

    private String name;
    private CharacterClass CharacterClass;
    private CharacterRace CharacterRace;



<<<<<<< HEAD:partyMember.java
    // /**
    //  * Default constructor
    //  */
    // public partyMember(){
    //     name = "Jack";
=======
    /**
     * Default constructor
     */
    public PartyMember(){
        name = "Jack";
>>>>>>> d9e2c802cf42c5559e494caf624764e1dcff7c75:src/PartyMember.java
        
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


