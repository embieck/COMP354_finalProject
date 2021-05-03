package edu.ithaca;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class Party {

    public ArrayList<PartyMember> characters;
    private int partySize;

    /**
     * Constructor
     * 
     * @param characters - arraylist of all characters in the party
     * @param partySize  - int representing number of characters in the party
     */
    public Party(ArrayList<PartyMember> characters, int partySize) {
        this.characters = characters;
        this.partySize = partySize;
    }

    /**
     * Constructor
     * 
     * @param characters - arraylist of all characters in the party
     */
    public Party(ArrayList<PartyMember> characters) {
        this.characters = characters;
        this.partySize = characters.size();
    }

    /**
     * Adds a party member to the party (i.e. characters list)
     * 
     * @param newMember - Party member to add
     */
    public void addCharacter(PartyMember newMember) {
        this.characters.add(newMember);
        this.partySize=this.characters.size();
    }

    public int getPartySize() {
        return partySize;
    }

    /**
     * Returns a party member given their index in the party member list
     * (characters)
     * 
     * @param placeInList - index of party member to return
     * @return - party member at specified index, null if index is larger than party
     *         size
     */
    public PartyMember getCharacter(int placeInList) {
        if (placeInList >= characters.size()) {
            return null;
        }
        return characters.get(placeInList);
    }

    /**
     * Iterates through list of Party members and returns the first member with the
     * given name
     * 
     * @param name - name of character to search for
     * @return - Party member with specified name, null if none exists in the party
     *         (characters list)
     */
    public PartyMember findCharacterByName(String name) {
        for (int i = 0; i < characters.size(); i++) {
            PartyMember currentCharacter = characters.get(i);
            if (currentCharacter.getName().equals(name)) {
                return currentCharacter;
            }
        }
        return null;
    }

    /**
     * Iterates through list of Party members and returns the first member of the
     * given class
     * 
     * @param cc - enum of character class to search by
     * @return - Party member of Character Class cc, null if none exists in the
     *         party (characters list)
     */
    public PartyMember findCharacterByClass(CharacterClass cc) {
        for (int i = 0; i < characters.size(); i++) {
            PartyMember currentCharacter = characters.get(i);
            if (currentCharacter.getCharacterClass().equals(cc)) {
                return currentCharacter;
            }
        }
        return null;
    }

	public String toStringMembers() {
        String finalString = "";
		for (int i = 0; i < this.partySize; i++){
            finalString += characters.get(i).getName() + "  ";
        }
        return finalString;
	}
}
