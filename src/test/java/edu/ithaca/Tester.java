package edu.ithaca;

import java.util.*;

import edu.ithaca.QualatativeStats.*;


class Tester {
    private static void statsTest() {
        //Testing Default Contructor & Getters
        System.out.println("------Testing QualStats: Default Contructor-------");
        QualatativeStats qualStats1 = new QualatativeStats();
        System.out.println(qualStats1.getAlign() + ": Should be unaligned");
        System.out.println(qualStats1.getSize() + ": Should be medium");
        System.out.println(qualStats1.getLanguages() + ": Should be [common]");

        //Testing  Contructor
        System.out.println("------Testing QualStats: Contructor-------");
        String delimeter = ",";
        QualatativeStats qualStats2 = new QualatativeStats(alignment.chaoticGood, size.tiny, "common,dragon", delimeter.charAt(0));
        System.out.println(qualStats2.getLanguages() + ": Should be [common, dragon]");

        String delimeter2 = " ";
        QualatativeStats qualStats3 = new QualatativeStats(alignment.chaoticNeutral, size.huge, "dragon common spanish", delimeter2.charAt(0));
        System.out.println(qualStats3.getLanguages() + ": Should be [dragon, common, spanish]");

        QualatativeStats qualStats4 = new QualatativeStats(alignment.chaoticNeutral, size.huge, "", delimeter2.charAt(0));
        System.out.println(qualStats4.getLanguages() + ": Should be [common]");
    }

    private static void uiTest() {
        UserInterfaceMain.properUsernameLogin();
        Party testParty;
        // UserInterfaceMain.writePartyFile("test.csv", testParty);
        // UserInterfaceMain.readPartyFile("test.csv");
    }

    private static void partyTest() {
        // Create characters in PartyMemberClass & add them to arrayList
        ArrayList<PartyMember> characters = new ArrayList<>();
        PartyMember kemi = new PartyMember("kemi", CharacterClass.BARD, CharacterRace.ELF, null, null);
        PartyMember sj = new PartyMember("SJ", CharacterClass.ROGUE, CharacterRace.DRAGONBORNE, null, null);
        PartyMember juliet = new PartyMember("juliet", CharacterClass.CLERIC, CharacterRace.GNOME, null, null);
        PartyMember jomi = new PartyMember("jomi", CharacterClass.DRUID, CharacterRace.HUMAN, null, null);
        PartyMember soromi = new PartyMember("soromi", CharacterClass.WARLOCK, CharacterRace.HALFELF, null, null);
        characters.add(soromi);
        characters.add(juliet);
        characters.add(jomi);
        characters.add(sj);
        characters.add(kemi);

        // Testing Party: FindCharacterByClass
        System.out.println("------Testing Party: FindCharacterByClass-------");
        Party testParty = new Party(characters, 5);
        System.out.println(testParty.findCharacterByClass(CharacterClass.BARD).getName() + ": Should be kemi");
        System.out.println(testParty.findCharacterByClass(CharacterClass.ROGUE).getName() + ": Should be SJ");
        System.out.println((testParty.findCharacterByClass(CharacterClass.WIZARD) == null) + ": Should be true");
        

        // Testing Party: FindCharacterByName
        System.out.println("------Testing Party: FindCharacterByName-------");
        System.out.println(testParty.findCharacterByName("soromi").getCharacterClass() + ": Should be Warlock");
        System.out.println(testParty.findCharacterByName("jomi").getCharacterClass() + ": Should be Druid");
        System.out.println((testParty.findCharacterByName("wanda") == null )+ ": Should be true");
        


        // Testing Party: Getters
        System.out.println("------Testing Party: Getters-------");
        System.out.println(testParty.getCharacter(0).getName() + ": Should be soromi");
        System.out.println(testParty.getCharacter(4).getName() + ": Should be kemi");
        System.out.println(testParty.getCharacter(5) + ": Should be null");
        
        // Note: If this getter will be included in the UI, we might want to offset the
        // indexes by 1

        System.out.println(testParty.getPartySize() + ": Should be 5");
        // Add a remove function (that updates party size) so parties can be changed
        // dynamically

        // Testing PartyMember: Getters
        System.out.println("------Testing PartyMember: Getters-------");
        System.out.println(kemi.getName() + ": Should be kemi");
        System.out.println(jomi.getCharacterClass() + ": Should be Druid");
        System.out.println(juliet.getCharacterRace() + ": Should be Gnome");
    }

    public static void main(String args[]) {
        partyTest();
        //statsTest();
        //uiTest();
    }
}
