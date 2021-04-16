package edu.ithaca;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PartyMember {

    private String name;
    private CharacterClass characterClass;
    private CharacterRace characterRace;

    public String getName(){
        return name;
    }

    public CharacterClass getCharacterClass(){
        return characterClass;
    }

    public CharacterRace getCharacterRace(){
        return characterRace;
    }

    /**
     * Constructor
     * @param name - String that contains name of the character
     * @param CharacterClass - enum that indicates class of the character
     * @param CharacterRace - enum that indicates race of the character
     */
    public PartyMember(String name, CharacterClass characterClass, CharacterRace characterRace){
        this.name = "";
        this.characterClass = characterClass;
        this.characterRace = characterRace;
        
    }

}


