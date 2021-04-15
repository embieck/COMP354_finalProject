import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class party {

    private ArrayList<partyMember> characters;
    private int partySize;

    // /**
    //  * Default constructor
    //  */
    // public party(){
    //     characters = null;
    //     partySize = 5;
        
    // }

    public void addCharacter(partyMember newMember){
        characters.add(newMember);
    }

    public int getPartySize(){
        return partySize;
    }

    public partyMember getCharacter(int placeInList){
        return characters.get(placeInList);
    }

    public partyMember findCharacterByName(String name){
        for(int i = 0; i < characters.size(); i++){
            partyMember currentCharacter = characters.get(i);
            if(currentCharacter.getName().equals(name)){
                return currentCharacter;
            }
        }
        return null;

    }

    public partyMember findCharacterByClass(CharacterClass cc){
        for(int i = 0; i < characters.size(); i++){
            partyMember currentCharacter = characters.get(i);
            if(currentCharacter.getCharacterClass().equals(cc)){
                return currentCharacter;
            }
        }
        return null;
    }


    
}
