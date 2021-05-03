package edu.ithaca;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
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
    @Test
    void EnemyFromStringTest()throws FileNotFoundException{
        Scanner scan = new Scanner(new File("/Users/erb/Comp354_AI/COMP354_finalProject/src/test/java/edu/ithaca/resources/EnemyDb.csv"));
        scan.nextLine(); //removes header
        String enemyString = scan.nextLine();
        EnemyDataBaseList emptyList = new EnemyDataBaseList();
        Enemy e = emptyList.csvLineToEnemy(enemyString);
        //Almiraj,Small,FALSE,unaligned,13,3,50,0,0,2,16,10,2,14,10,"None","Perception, Stealth","None",0.00,"Keen Hearing, Keen Sight"
        assertEquals("Almiraj",e.getName());
        assertEquals(Size.SMALL,e.getSize());
        assertEquals(false,e.getIsHumanoid());
        assertEquals(Alignment.UNALIGNED,e.getAlignment());
        assertEquals(13,e.getArmorClass());
        assertEquals(3,e.getHP());
        assertEquals(50,e.getGroundSpeed());
        assertEquals(0,e.getFlySpeed());
        assertEquals(0,e.getSwimSpeed());
        assertEquals(2,e.getStr());
        assertEquals(16,e.getDex());
        assertEquals(10,e.getCon());
        assertEquals(2,e.getIntel());
        assertEquals(14,e.getWis());
        assertEquals(10,e.getCha());
        assertEquals("None",e.getSavingThrows());
        assertEquals("Perception, Stealth",e.getSkills());
        assertEquals("None",e.getLanguage(0));
        assertEquals(0.0,e.getCr());
        assertEquals("Keen Hearing, Keen Sight",e.getAdditional());
        

    }
    @Test
    void EnemyDataBaseListTest() throws IOException{
        EnemyDataBaseList enemyDBList = new EnemyDataBaseList("/Users/erb/Comp354_AI/COMP354_finalProject/src/test/java/edu/ithaca/resources/EnemyDb.csv");
        JsonUtil.toJsonFile("/Users/erb/Comp354_AI/COMP354_finalProject/src/test/java/edu/ithaca/resources/test2.json", enemyDBList.head(5));
        

    }
}
