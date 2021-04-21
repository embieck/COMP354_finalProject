package edu.ithaca;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.jupiter.api.Test;

import edu.ithaca.dragon.util.JsonUtil;

import static org.junit.jupiter.api.Assertions.*;

public class UITester {
    @Test
    void readFileTest() throws FileNotFoundException, JsonProcessingException{
        Party p = UserInterfaceMain.readPartyFile("uitest1.csv");
        assertEquals(3,p.getPartySize());
        for (int i=0;i<p.getPartySize();i++){
            System.out.println(JsonUtil.toJsonString(p.getCharacter(i)));
        }

    }

    @Test
    void writeFileTest() throws RuntimeException, IOException{
        Party p = UserInterfaceMain.readPartyFile("uitest1.csv");
        //file uitest2.csv should be blank to start
        UserInterfaceMain.writePartyFile("uitest2.csv", p);
        //time to check file
        int time = 10000000;
        while(time>0){
            time/=2.0;
        }
        p.addCharacter(new PartyMember("Marceline",CharacterClass.BARD, CharacterRace.HUMAN));
        UserInterfaceMain.writePartyFile("uitest2.csv", p);
        Party newP = UserInterfaceMain.readPartyFile("uitest2.csv");
        assertEquals(4,newP.getPartySize());
    }
    
}
