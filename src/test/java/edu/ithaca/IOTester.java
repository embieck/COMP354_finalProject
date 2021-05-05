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
    @Test
    void writeJsonFileFromPMList() throws IOException{
        ArrayList<PartyMember> chars = new ArrayList<>();
        Party party = new Party(chars);
        party.addCharacter(new PartyMember("Finn",CharacterClass.FIGHTER,CharacterRace.HUMAN,2));
        party.addCharacter(new PartyMember("Marceline",CharacterClass.BARD, CharacterRace.ELF,7));
        party.addCharacter(new PartyMember("Neptor",CharacterClass.BARBARIAN, CharacterRace.GNOME,new QualatativeStats(Alignment.CHAOTICGOOD,Size.SMALL, "Common,Infernal",','), new QuantativeStats(40, 11, 25, 12, 14, 10, 7, 10, 11)));
        party.savePartyToJson("src/test/resources/test1.json");

    }
    @Test
    void readJsonFileToPMList() throws IOException{
        Party p  = new Party("src/test/resources/test1.json");
        for(int i=0;i<p.getPartySize();i++){
            System.out.println(p.getCharacter(i).getName());
            System.out.println(p.getCharacter(i).getCharacterRace().name());
            System.out.println(p.getCharacter(i).getCharacterClass().name());
            System.out.println(p.getCharacter(i).getLevel());
            System.out.println(p.getCharacter(i).getQualStats().getAlign().name());
            System.out.println(p.getCharacter(i).getQualStats().getSize().name());
            System.out.println(p.getCharacter(i).getQualStats().getLanguages().get(0));
            System.out.println(p.getCharacter(i).getQuanStats().getMoveSpeed());
            System.out.println(p.getCharacter(i).getQuanStats().getArmorClass());
            System.out.println(p.getCharacter(i).getQuanStats().getHp());
            System.out.println(p.getCharacter(i).getQuanStats().getCon());
            System.out.println(p.getCharacter(i).getQuanStats().getStr());
            System.out.println(p.getCharacter(i).getQuanStats().getWis());
            System.out.println(p.getCharacter(i).getQuanStats().getIntel());
            System.out.println(p.getCharacter(i).getQuanStats().getDex());
            System.out.println(p.getCharacter(i).getQuanStats().getCha());
            
        }
    }
    @Test
    void EnemyFromStringTest()throws FileNotFoundException{
        Scanner scan = new Scanner(new File("src/test/resources/EnemyDb.csv"));
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
        EnemyDataBaseList enemyDBList = new EnemyDataBaseList("src/test/resources/EnemyDb.csv");
        enemyDBList.enemyListHeadToJsonFile("src/test/resources/test2.json", 5);
    

    }
}
