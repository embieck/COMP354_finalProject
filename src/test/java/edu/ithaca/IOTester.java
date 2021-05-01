package edu.ithaca;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.jupiter.api.Test;

import edu.ithaca.dragon.util.JsonUtil;

import static org.junit.jupiter.api.Assertions.*;

public class IOTester {
    // @Test
    // void readFileTest() throws FileNotFoundException, JsonProcessingException{
    //     Party p = UserInterfaceMain.readPartyFile("/Users/erb/Comp354_AI/COMP354_finalProject/src/test/java/edu/ithaca/resources/uitest1.csv");
    //     assertEquals(3,p.getPartySize());
        
    // }

    // @Test
    // void writeFileTest() throws RuntimeException, IOException{
    //     //Party p = UserInterfaceMain.readPartyFile("uitest1.csv");
    //     ArrayList<PartyMember> chars = new ArrayList<>();
    //     Party party = new Party(chars);
    //     party.addCharacter(new PartyMember("Finn",CharacterClass.FIGHTER,CharacterRace.HUMAN));
    //     //file uitest2.csv should be blank to start
    //     UserInterfaceMain.writePartyFile("/Users/erb/Comp354_AI/COMP354_finalProject/src/test/java/edu/ithaca/resources/uitest2.csv", party);
    //     UserInterfaceMain.writePartyFile("/Users/erb/Comp354_AI/COMP354_finalProject/src/test/java/edu/ithaca/resources/uitest3.csv", party);
        
    //     party.addCharacter(new PartyMember("Marceline",CharacterClass.BARD, CharacterRace.ELF));
    //     UserInterfaceMain.writePartyFile("/Users/erb/Comp354_AI/COMP354_finalProject/src/test/java/edu/ithaca/resources/uitest3.csv", party);
    //     Party newP = UserInterfaceMain.readPartyFile("/Users/erb/Comp354_AI/COMP354_finalProject/src/test/java/edu/ithaca/resources/uitest3.csv");
    //     assertEquals(2,newP.getPartySize());
    // }
    @Test
    void writeJsonFileFromPMList() throws IOException{
        ArrayList<PartyMember> chars = new ArrayList<>();
        Party party = new Party(chars);
        party.addCharacter(new PartyMember("Finn",CharacterClass.FIGHTER,CharacterRace.HUMAN,2));
        party.addCharacter(new PartyMember("Marceline",CharacterClass.BARD, CharacterRace.ELF,7));
        party.addCharacter(new PartyMember("Neptor",CharacterClass.BARBARIAN, CharacterRace.GNOME,new QualatativeStats(Alignment.CHAOTICGOOD,Size.SMALL, "Common,Infernal",','), new QuantativeStats(40, 11, 25, 12, 14, 10, 7, 10, 11)));
        JsonUtil.toJsonFile("/Users/erb/Comp354_AI/COMP354_finalProject/src/test/java/edu/ithaca/resources/test1.json", chars);

    }
    @Test
    void readJsonFileToPMList() throws IOException{
        ArrayList<PartyMember> chars = (ArrayList<PartyMember>) JsonUtil.listFromJsonFile("/Users/erb/Comp354_AI/COMP354_finalProject/src/test/java/edu/ithaca/resources/test1.json",PartyMember.class);
        for(int i=0;i<chars.size();i++){
            System.out.println(chars.get(i).getName());
            System.out.println(chars.get(i).getCharacterRace().name());
            System.out.println(chars.get(i).getCharacterClass().name());
            System.out.println(chars.get(i).getLevel());
            System.out.println(chars.get(i).getQualStats().getAlign().name());
            System.out.println(chars.get(i).getQualStats().getSize().name());
            System.out.println(chars.get(i).getQualStats().getLanguages().get(0));
            System.out.println(chars.get(i).getQuanStats().getMoveSpeed());
            System.out.println(chars.get(i).getQuanStats().getArmorClass());
            System.out.println(chars.get(i).getQuanStats().getHp());
            System.out.println(chars.get(i).getQuanStats().getCon());
            System.out.println(chars.get(i).getQuanStats().getStr());
            System.out.println(chars.get(i).getQuanStats().getWis());
            System.out.println(chars.get(i).getQuanStats().getIntel());
            System.out.println(chars.get(i).getQuanStats().getDex());
            System.out.println(chars.get(i).getQuanStats().getCha());
            
        }
    }
}
