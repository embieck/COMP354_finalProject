package edu.ithaca;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.jupiter.api.Test;

import edu.ithaca.dragon.util.JsonUtil;

import static org.junit.jupiter.api.Assertions.*;

public class UITester {
    @Test
    void readFileTest() throws FileNotFoundException, JsonProcessingException{
        Party p = UserInterfaceMain.readPartyFile("/Users/erb/Comp354_AI/COMP354_finalProject/src/test/java/edu/ithaca/resources/uitest1.csv");
        assertEquals(3,p.getPartySize());
        
    }

    @Test
    void writeFileTest() throws RuntimeException, IOException{
        //Party p = UserInterfaceMain.readPartyFile("uitest1.csv");
        ArrayList<PartyMember> chars = new ArrayList<>();
        Party party = new Party(chars);
        party.addCharacter(new PartyMember("Finn",CharacterClass.FIGHTER,CharacterRace.HUMAN));
        //file uitest2.csv should be blank to start
        UserInterfaceMain.writePartyFile("/Users/erb/Comp354_AI/COMP354_finalProject/src/test/java/edu/ithaca/resources/uitest2.csv", party);
        //time to check file
        int time = 10000000;
        while(time>0){
            time/=2.0;
        }
        party.addCharacter(new PartyMember("Marceline",CharacterClass.BARD, CharacterRace.HUMAN));
        UserInterfaceMain.writePartyFile("/Users/erb/Comp354_AI/COMP354_finalProject/src/test/java/edu/ithaca/resources/uitest2.csv", party);
        Party newP = UserInterfaceMain.readPartyFile("/Users/erb/Comp354_AI/COMP354_finalProject/src/test/java/edu/ithaca/resources/uitest2.csv");
        assertEquals(2,newP.getPartySize());
    }
    
}
