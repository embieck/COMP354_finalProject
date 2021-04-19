package edu.ithaca;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class Party {

    private ArrayList<PartyMember> characters;
    private int partySize;

    public void addCharacter(PartyMember newMember){
        characters.add(newMember);
    }

    public int getPartySize(){
        return partySize;
    }

    public PartyMember getCharacter(int placeInList){
        return characters.get(placeInList);
    }

    public PartyMember findCharacterByName(String name){
        for(int i = 0; i < characters.size(); i++){
            PartyMember currentCharacter = characters.get(i);
            if(currentCharacter.getName().equals(name)){
                return currentCharacter;
            }
        }
        return null;

    }

    public PartyMember findCharacterByClass(CharacterClass cc){
        for(int i = 0; i < characters.size(); i++){
            PartyMember currentCharacter = characters.get(i);
            if(currentCharacter.getCharacterClass().equals(cc)){
                return currentCharacter;
            }
        }
        return null;
    }

    /**
     * Constructor
     * @param characters - arraylist of all characters in the party
     * @param partySize - int representing number of characters in the party
     */
    public Party(ArrayList<PartyMember> characters, int partySize){
        this.characters = characters;
        this.partySize = partySize;
        
    }

    public Party(ArrayList<PartyMember> characters){
        this.characters = characters;
        this.partySize = characters.size();
        
    }


    
}
