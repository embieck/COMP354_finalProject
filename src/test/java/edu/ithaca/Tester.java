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

    private static void characterInheritanceTest() {
        // Create partyMembers and check if they are connected to qualatative and quantitative classes

        //QUANT STAT: moveSpeed, AC, hp, con, str, wis, intel, dex, cha
        //QUAL STAT: alignment, size, languages, delimiter
        
        QuantativeStats quantKemi = new QuantativeStats(30, 17, 32, 15, 17, 11, 12, 10, 15);
        QualatativeStats qualKemi = new QualatativeStats(alignment.lawfulGood, size.medium, "common", ',');
        
        QuantativeStats quantSJ = new QuantativeStats(1, 2, 3, 4, 5, 6, 7, 8, 9);
        QualatativeStats qualSJ = new QualatativeStats(alignment.chaoticGood, size.tiny, "dragon", ',');
        
        QuantativeStats quantJuliet = new QuantativeStats(25, 14, 13, 14, 13, 11, 13, 14, 9);
        QualatativeStats qualJuliet = new QualatativeStats(alignment.chaoticNeutral, size.large, "celestial, common", ',');
        
        QuantativeStats quantJomi = new QuantativeStats(20, 12, 11, 8, 10, 13, 12, 13, 16);
        QualatativeStats qualJomi = new QualatativeStats(alignment.chaoticEvil, size.small, "common, dragon", ',');
        
        QuantativeStats quantSoromi = new QuantativeStats(30, 15, 65, 14, 15, 11, 14, 16, 14);
        QualatativeStats qualSoromi = new QualatativeStats(alignment.neutralGood, size.huge, "common", ',');


        PartyMember kemi = new PartyMember("kemi", CharacterClass.BARD, CharacterRace.ELF, qualKemi, quantKemi);
        PartyMember sj = new PartyMember("SJ", CharacterClass.ROGUE, CharacterRace.DRAGONBORNE, qualSJ, quantSJ);
        PartyMember juliet = new PartyMember("juliet", CharacterClass.CLERIC, CharacterRace.GNOME, qualJuliet, quantJuliet);
        PartyMember jomi = new PartyMember("jomi", CharacterClass.DRUID, CharacterRace.HUMAN, qualJomi, quantJomi);
        PartyMember soromi = new PartyMember("soromi", CharacterClass.WARLOCK, CharacterRace.HALFELF, qualSoromi, quantSoromi);

        System.out.println("------Testing PartyMember: Qualitative Getters-------");
        System.out.println(soromi.getAlignment() + ": should be neutralGood");
        System.out.println(jomi.getSize() + ": should be small");
        System.out.println(juliet.getLanguages() + ": should be celestial and common");
        System.out.println(sj.getLanguages() + ": should be dragon");

        System.out.println("------Testing PartyMember: Quantitative Getters-------");
        System.out.println(kemi.getMoveSpeed() + ": should be 30");
        System.out.println(sj.getArmorClass() + ": should be 2");
        System.out.println(juliet.getHP() + ": should be 13");
        System.out.println(jomi.getCon() + ": should be 8");
        System.out.println(soromi.getStr() + ": should be 15");
        System.out.println(kemi.getWis() + ": should be 11");
        System.out.println(sj.getIntel() + ": should be 7");
        System.out.println(juliet.getDex() + ": should be 14");
        System.out.println(jomi.getCha() + ": should be 16");

    }

    private static void enemyInheritanceTest() {
        // Create enemies and make sure that enemyquant stats inherets correctly
        //ENEMY: isHumanoid, isMagicUser, terrain, movementType, qualStats, quanStats
        //QUAL: alignment, size, languages, delimiter
        //ENEMYQUAN: cr, exp, moveSpeed, AC, hp, con, str, wis, intel, dex, cha

        QualatativeStats qualYeti = new QualatativeStats(alignment.chaoticEvil, size.large, "Yeti", ',');
        EnemyQuantStats quanYeti = new EnemyQuantStats(cr, exp, moveSpeed, armorClass, hp, con, str, wis, intel, dex, cha)

        QualatativeStats qualDragon = new QualatativeStats(alignment.neutralEvil, size.huge, "Dragon", ',');

        QualatativeStats qualGelatinousCube = new QualatativeStats(alignment.unaligned, size.medium, "None", ',');

        QualatativeStats qualBandit = new QualatativeStats(alignment.neutralEvil, size.medium, "Common", ',');

        QualatativeStats qualAboleth = new QualatativeStats(alignment.lawfulEvil, size.gargantuan, "Aboleth, Aquan, Undercommon", ',');

        QualatativeStats qualBeholder = new QualatativeStats(alignment.lawfulEvil, size.large, "Beholder, Undercommon", ',');

        Enemy yeti = new Enemy(false, false, Terrain.ARCTIC, MovementType.GROUND, null, null);
        Enemy dragon = new Enemy(false, true, Terrain.MOUNTAIN, MovementType.FLY, null, null);
        Enemy gelatinousCube = new Enemy(false, false, Terrain.FOREST, MovementType.GROUND, null, null);
        Enemy bandit = new Enemy(true, false, Terrain.GRASSLAND, MovementType.GROUND, null, null);
        Enemy aboleth = new Enemy(false, false, Terrain.COAST, MovementType.SWIM, null, null);
        Enemy beholder = new Enemy(false, true, Terrain.UNDERDARK, MovementType.FLY, null, null);

        System.out.println("------Testing Enemy: Basic Getters-------");
        System.out.println(yeti.getTerrain() + ": should be Arctic");
        System.out.println(dragon.getTerrain() + ": should be Mountain");

        System.out.println("------Testing Enemy: Qualitative Getters-------");

        System.out.println("------Testing Enemy: Quantitative Getters-------");

    }

    public static void main(String args[]) {
        //partyTest();
        //statsTest();
        //uiTest();
        //characterInheritanceTest();
        enemyInheritanceTest();
    }
}
