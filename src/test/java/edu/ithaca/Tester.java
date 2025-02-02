package edu.ithaca;

import java.io.FileNotFoundException;
import java.util.*;

import edu.ithaca.QualitativeStats.*;

class Tester {
    private static void statsTest() {
        // Testing Default Contructor & Getters
        System.out.println("------Testing QualStats: Default Contructor-------");
        QualitativeStats qualStats1 = new QualitativeStats();
        System.out.println(qualStats1.getAlign() + ": Should be unaligned");
        System.out.println(qualStats1.getSize() + ": Should be medium");
        System.out.println(qualStats1.getLanguages() + ": Should be [common]");

        // Testing Contructor
        System.out.println("------Testing QualStats: Contructor-------");
        String delimeter = ",";
        QualitativeStats qualStats2 = new QualitativeStats(Alignment.CHAOTICGOOD, Size.TINY, "common,dragon",
                delimeter.charAt(0));
        System.out.println(qualStats2.getLanguages() + ": Should be [common, dragon]");

        String delimeter2 = " ";
        QualitativeStats qualStats3 = new QualitativeStats(Alignment.CHAOTICNEUTRAL, Size.HUGE, "dragon common spanish",
                delimeter2.charAt(0));
        System.out.println(qualStats3.getLanguages() + ": Should be [dragon, common, spanish]");

        QualitativeStats qualStats4 = new QualitativeStats(Alignment.CHAOTICNEUTRAL, Size.HUGE, "",
                delimeter2.charAt(0));
        System.out.println(qualStats4.getLanguages() + ": Should be [common]");
    }

    // private static void uiTest() {
    // UserInterfaceMain.getProperUsernameLogin();
    // Party testParty;
    // // UserInterfaceMain.writePartyFile("test.csv", testParty);
    // // UserInterfaceMain.readPartyFile("test.csv");
    // }

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
        System.out.println((testParty.findCharacterByName("wanda") == null) + ": Should be true");

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
        // Create partyMembers and check if they are connected to qualatative and
        // quantitative classes

        // QUANT STAT: moveSpeed, AC, hp, con, str, wis, intel, dex, cha
        // QUAL STAT: alignment, size, languages, delimiter

        QuantativeStats quantKemi = new QuantativeStats(30, 17, 32, 15, 17, 11, 12, 10, 15);
        QualitativeStats qualKemi = new QualitativeStats(Alignment.LAWFULGOOD, Size.MEDIUM, "common", ',');

        QuantativeStats quantSJ = new QuantativeStats(1, 2, 3, 4, 5, 6, 7, 8, 9);
        QualitativeStats qualSJ = new QualitativeStats(Alignment.CHAOTICGOOD, Size.TINY, "dragon", ',');

        QuantativeStats quantJuliet = new QuantativeStats(25, 14, 13, 14, 13, 11, 13, 14, 9);
        QualitativeStats qualJuliet = new QualitativeStats(Alignment.CHAOTICNEUTRAL, Size.LARGE , "celestial, common", ',');

        QuantativeStats quantJomi = new QuantativeStats(20, 12, 11, 8, 10, 13, 12, 13, 16);
        QualitativeStats qualJomi = new QualitativeStats(Alignment.CHAOTICEVIL, Size.SMALL, "common, dragon", ',');

        QuantativeStats quantSoromi = new QuantativeStats(30, 15, 65, 14, 15, 11, 14, 16, 14);
        QualitativeStats qualSoromi = new QualitativeStats(Alignment.NEUTRALGOOD, Size.HUGE, "common", ',');

        PartyMember kemi = new PartyMember("kemi", CharacterClass.BARD, CharacterRace.ELF, qualKemi, quantKemi);
        PartyMember sj = new PartyMember("SJ", CharacterClass.ROGUE, CharacterRace.DRAGONBORNE, qualSJ, quantSJ);
        PartyMember juliet = new PartyMember("juliet", CharacterClass.CLERIC, CharacterRace.GNOME, qualJuliet,
                quantJuliet);
        PartyMember jomi = new PartyMember("jomi", CharacterClass.DRUID, CharacterRace.HUMAN, qualJomi, quantJomi);
        PartyMember soromi = new PartyMember("soromi", CharacterClass.WARLOCK, CharacterRace.HALFELF, qualSoromi,
                quantSoromi);

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
        // ENEMY: isHumanoid, isMagicUser, terrain, movementType, qualStats, quanStats
        // QUAL: alignment, size, languages, delimiter
        // ENEMYQUAN: cr, exp, moveSpeed, AC, hp, con, str, wis, intel, dex, cha

        QualitativeStats qualYeti = new QualitativeStats(Alignment.CHAOTICEVIL, Size.LARGE, "Yeti", ',');
        EnemyQuantStats quanYeti = new EnemyQuantStats(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

        QualitativeStats qualDragon = new QualitativeStats(Alignment.NEUTRALEVIL, Size.HUGE, "Dragon", ',');
        EnemyQuantStats quanDragon = new EnemyQuantStats(11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1);

        QualitativeStats qualGelatinousCube = new QualitativeStats(Alignment.UNALIGNED, Size.MEDIUM, "None", ',');
        EnemyQuantStats quanGelationusCube = new EnemyQuantStats(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22);

        QualitativeStats qualBandit = new QualitativeStats(Alignment.NEUTRALEVIL, Size.MEDIUM, "Common", ',');
        EnemyQuantStats quanBandit = new EnemyQuantStats(1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21);

        QualitativeStats qualAboleth = new QualitativeStats(Alignment.LAWFULEVIL, Size.GARGANTUAN,
                "Aboleth, Aquan, Undercommon", ',');
        EnemyQuantStats quanAboleth = new EnemyQuantStats(5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55);

        QualitativeStats qualBeholder = new QualitativeStats(Alignment.LAWFULEVIL, Size.LARGE, "Beholder, Undercommon",
                ',');
        EnemyQuantStats quanBeholder = new EnemyQuantStats(3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33);

        Enemy yeti = new Enemy(false, false, Terrain.ARCTIC, MovementType.GROUND, qualYeti, quanYeti);
        Enemy dragon = new Enemy(false, true, Terrain.MOUNTAIN, MovementType.FLY, qualDragon, quanDragon);
        Enemy gelatinousCube = new Enemy(false, false, Terrain.FOREST, MovementType.GROUND, qualGelatinousCube,
                quanGelationusCube);
        Enemy bandit = new Enemy(true, false, Terrain.GRASSLAND, MovementType.GROUND, qualBandit, quanBandit);
        Enemy aboleth = new Enemy(false, false, Terrain.COAST, MovementType.SWIM, qualAboleth, quanAboleth);
        Enemy beholder = new Enemy(false, true, Terrain.UNDERDARK, MovementType.FLY, qualBeholder, quanBeholder);

        System.out.println("------Testing Enemy: Basic Getters-------");
        System.out.println(dragon.getIsHumanoid() + ": should be False");
        System.out.println(bandit.getIsHumanoid() + ": should be True");
        System.out.println(beholder.getIsMagicUser() + ": should be True");
        System.out.println(aboleth.getIsMagicUser() + ": should be False");
        System.out.println(yeti.getTerrain() + ": should be Arctic");
        System.out.println(dragon.getTerrain() + ": should be Mountain");
        System.out.println(gelatinousCube.getMovementType() + ": should be Ground");
        System.out.println(aboleth.getMovementType() + ": should be Swim");

        System.out.println("------Testing Enemy: Qualitative Getters-------");
        System.out.println(gelatinousCube.getAlignment() + ": should be Unaligned");
        System.out.println(bandit.getAlignment() + ": should be Neutral Evil");
        System.out.println(aboleth.getSize() + ": should be Gargantuan");
        System.out.println(beholder.getSize() + ": should be Large");
        System.out.println(yeti.getLanguages() + ": should be Yeti");
        System.out.println(aboleth.getLanguages() + ": should be Aboleth, Aquan, and Undercommon");

        System.out.println("------Testing Enemy: Quantitative Getters-------");
        System.out.println(yeti.getCr() + ": should be 1.0");
        System.out.println(dragon.getExp() + ": should be 10.0");
        System.out.println(gelatinousCube.getMoveSpeed() + ": should be 6");
        System.out.println(bandit.getArmorClass() + ": should be 7");
        System.out.println(aboleth.getHP() + ": should be 25");
        System.out.println(beholder.getCon() + ": should be 18");
        System.out.println(yeti.getStr() + ": should be 7");
        System.out.println(dragon.getWis() + ": should be 4");
        System.out.println(gelatinousCube.getIntel() + ": should be 18");
        System.out.println(bandit.getDex() + ": should be 19");
        System.out.println(aboleth.getCha() + ": should be 55");

    }

    private static Enemy enemyRecommenderReflexTest() {

        QuantativeStats quantKemi = new QuantativeStats(30, 17, 32, 15, 17, 11, 12, 10, 15);
        QualitativeStats qualKemi = new QualitativeStats(Alignment.LAWFULGOOD, Size.MEDIUM, "common, elvish, sylvan",
                ',');

        QuantativeStats quantEmma = new QuantativeStats(30, 13, 11, 12, 15, 14, 14, 11, 12);
        QualitativeStats qualEmma = new QualitativeStats(Alignment.CHAOTICGOOD, Size.TINY, "common, elvish", ',');

        QuantativeStats quantKelsey = new QuantativeStats(30, 14, 13, 14, 13, 11, 13, 14, 9);
        QualitativeStats qualKelsey = new QualitativeStats(Alignment.CHAOTICNEUTRAL, Size.LARGE, "celestial, common",
                ',');

        QuantativeStats quantToby = new QuantativeStats(30, 12, 11, 8, 10, 13, 12, 13, 16);
        QualitativeStats qualToby = new QualitativeStats(Alignment.CHAOTICEVIL, Size.GARGANTUAN, "common, draconic",
                ',');

        ArrayList<PartyMember> characters = new ArrayList<>();
        PartyMember kemi = new PartyMember("kemi", CharacterClass.BARD, CharacterRace.ELF, qualKemi, quantKemi);
        PartyMember emma = new PartyMember("emma", CharacterClass.PALADIN, CharacterRace.HALFELF, qualEmma, quantEmma);
        PartyMember kelsey = new PartyMember("kelsey", CharacterClass.DRUID, CharacterRace.HALFORC, qualKelsey,
                quantKelsey);
        PartyMember toby = new PartyMember("toby", CharacterClass.WIZARD, CharacterRace.DRAGONBORNE, qualToby,
                quantToby);
        characters.add(kemi);
        characters.add(emma);
        characters.add(kelsey);
        characters.add(toby);

        Party newParty = new Party(characters, characters.size());
        EnemyRecommenderReflex newRecommender = new EnemyRecommenderReflex();

        Enemy recommendedEnemy = newRecommender.recommendEnemy(newParty);
        return recommendedEnemy;

        // String recommendedEnemyString =
        // recommendedEnemy.enemyToString(recommendedEnemy);

        // return recommendedEnemyString;

    }

    private static Enemy enemyRecommenderRandomTest() {

        Enemy randomRecommendedEnemy = EnemyRecommenderRandom.recommendRandomEnemy();
        return randomRecommendedEnemy;

    }

    public static void crToFindTest() {
        System.out.println("-----CR To Find Test-----");

        ArrayList<PartyMember> characters = new ArrayList<>();
        PartyMember kemi = new PartyMember("kemi", CharacterClass.BARD, CharacterRace.ELF, null, null, 1);
        PartyMember sj = new PartyMember("SJ", CharacterClass.ROGUE, CharacterRace.DRAGONBORNE, null, null, 1);
        PartyMember juliet = new PartyMember("juliet", CharacterClass.CLERIC, CharacterRace.GNOME, null, null, 3);
        PartyMember jomi = new PartyMember("jomi", CharacterClass.DRUID, CharacterRace.HUMAN, null, null, 4);
        PartyMember soromi = new PartyMember("soromi", CharacterClass.WARLOCK, CharacterRace.HALFELF, null, null, 5);
        characters.add(juliet);
        characters.add(jomi);
        Party partySm = new Party(characters);
        characters.add(kemi);
        characters.add(sj);
        Party party = new Party(characters);
        characters.add(soromi);
        Party partyLg = new Party(characters);

        EnemyRecommenderAgent agent = new EnemyRecommenderAgent();
        Preferences prefEasy = new Preferences(Alignment.CHAOTICEVIL, false, Difficulty.EASY, MovementType.GROUND);
        Preferences prefMed = new Preferences();
        Preferences prefHard = new Preferences(Alignment.CHAOTICEVIL, false, Difficulty.HARD, MovementType.GROUND);
        Preferences prefDeadly = new Preferences(Alignment.CHAOTICEVIL, false, Difficulty.DEADLY, MovementType.GROUND);

        // Testing crToFind with varying Difficulty
        // Party < 4
        System.out.println("Should be 3.5: " + EnemyRecommenderAgent.calcAvPartyLevel(partySm));
        System.out.println("Should be 2: " + partySm.getPartySize());

        System.out.println("Should be 2.5: " + agent.calcCrToFind(partySm, prefEasy));
        System.out.println("Should be 3.5: " + agent.calcCrToFind(partySm, prefMed));

        System.out.println("Should be 4.5: " + agent.calcCrToFind(partySm, prefHard));
        System.out.println("Should be 5.5: " + agent.calcCrToFind(partySm, prefDeadly));

        // Party > 4
        System.out.println("Should be 2.8: " + EnemyRecommenderAgent.calcAvPartyLevel(partyLg));
        System.out.println("Should be 5: " + partyLg.getPartySize());

        System.out.println("Should be 3.8: " + agent.calcCrToFind(partyLg, prefEasy));
        System.out.println("Should be 4.8: " + agent.calcCrToFind(partyLg, prefMed));
        System.out.println("Should be 5.8: " + agent.calcCrToFind(partyLg, prefHard));
        System.out.println("Should be 6.8: " + agent.calcCrToFind(partyLg, prefDeadly));

        // Party = 4
        System.out.println("Should be 2.25: " + EnemyRecommenderAgent.calcAvPartyLevel(party));
        System.out.println("Should be 4: " + party.getPartySize());

        System.out.println("Should be 1.25: " + agent.calcCrToFind(party, prefEasy));
        System.out.println("Should be 2.25: " + agent.calcCrToFind(party, prefMed));
        System.out.println("Should be 3.25: " + agent.calcCrToFind(party, prefHard));
        System.out.println("Should be 4.25: " + agent.calcCrToFind(party, prefDeadly));

    }

    public static void calcScoreTest() {
        System.out.println("-----Calc Score Test-----");

        EnemyRecommenderAgent agent = new EnemyRecommenderAgent();
        Preferences pref1 = new Preferences(Alignment.CHAOTICEVIL, false, Difficulty.EASY, MovementType.FLY);
        Preferences pref2 = new Preferences(Alignment.UNALIGNED, true, Difficulty.HARD, MovementType.GROUND);
        QualitativeStats qualStats = new QualitativeStats();
        EnemyQuantStats quanStats = new EnemyQuantStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Enemy enemy1 = new Enemy(true, false, Terrain.GRASSLAND, MovementType.GROUND, qualStats, quanStats);
        double crToFind;

        crToFind = 0.0;
        System.out.println("Should be 4: " + agent.calcScore(enemy1, pref1, crToFind));
        System.out.println("Should be 10: " + agent.calcScore(enemy1, pref2, crToFind));
        crToFind = 1.0;
        System.out.println("Should be 3: " + agent.calcScore(enemy1, pref1, crToFind));
        System.out.println("Should be 9: " + agent.calcScore(enemy1, pref2, crToFind));

    }

    private static void agentTest() throws FileNotFoundException {
        crToFindTest();
        calcScoreTest();
        crSearchTest();
        prefSearchTest();
    }

    //Test for UI
    public static void crSearchTest() throws FileNotFoundException {
        System.out.println("-----CR Find Test-----");

        EnemyDataBaseList agent = new EnemyDataBaseList("src/test/resources/EnemyDb.csv");
        List<Enemy> list = new ArrayList<>();

        list = agent.crFind(1.0);
        System.out.println("Should all be 1: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getCr());
        }
        list.clear();
        System.out.println("Should true: " + list.isEmpty());
        list = agent.crFind(.13);
        System.out.println("Should all be .13: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getCr());
        }
        list.clear();
        System.out.println("Should true: " + list.isEmpty());
        list = agent.crFind(10);
        System.out.println("Should all be 10: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getCr());
        }

    }
    //Test for UI
    public static void prefSearchTest() {
        System.out.println("-----Pref Find Test-----");

        EnemyDataBaseList agent = new EnemyDataBaseList();
        List<Enemy> list = new ArrayList<>();
        Preferences pref1 = new Preferences(Alignment.CHAOTICEVIL, false, Difficulty.EASY, MovementType.FLY);
        Preferences pref2 = new Preferences(Alignment.UNALIGNED, true, Difficulty.HARD, MovementType.GROUND);
        Preferences pref3 = new Preferences(Alignment.CHAOTICNEUTRAL, false, Difficulty.DEADLY, MovementType.SWIM);

        list = agent.prefFind(pref1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Should be false, chaoticEvil, Fly : " + list.get(i).getIsHumanoid()
                    + list.get(i).getAlignment() + list.get(i).getMovementType());
        }
        list.clear();
        System.out.println("Should true: " + list.isEmpty());

        list = agent.prefFind(pref2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Should be true, unaligned, Ground : " + list.get(i).getIsHumanoid()
                    + list.get(i).getAlignment() + list.get(i).getMovementType());
        }
        list.clear();
        System.out.println("Should true: " + list.isEmpty());

        list = agent.prefFind(pref3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Should be false, chaoticNeutral, Swim : " + list.get(i).getIsHumanoid()
                    + list.get(i).getAlignment() + list.get(i).getMovementType());
        }
    }


    private static void historyTest(){
        new History();
        
        ArrayList<PartyMember> characters = new ArrayList<>();
        PartyMember kemi = new PartyMember("kemi", CharacterClass.BARD, CharacterRace.ELF, 1);
        PartyMember sj = new PartyMember("SJ", CharacterClass.ROGUE, CharacterRace.DRAGONBORNE, 2);
        PartyMember juliet = new PartyMember("juliet", CharacterClass.CLERIC, CharacterRace.GNOME, 3);
        PartyMember jomi = new PartyMember("jomi", CharacterClass.DRUID, CharacterRace.HUMAN, 4);
        PartyMember soromi = new PartyMember("soromi", CharacterClass.WARLOCK, CharacterRace.HALFELF, 5);
        characters.add(juliet);
        characters.add(jomi);
        Party partySm = new Party(characters);
        characters.add(kemi);
        characters.add(sj);
        Party party = new Party(characters);
        characters.add(soromi);
        Party partyLg = new Party(characters);
        
        Enemy enemy = EnemyRecommenderRandom.recommendRandomEnemy();
        enemy.setName("dragon");
        Preferences pref = new Preferences();
        EnemyEval eval = new EnemyEval("dragon",0);
        
        //Testing addToHistory (full)
        History.addToHistory(enemy, eval, partySm, pref);
        History.printHistory(0);
        //Testing addToHistory (partial)
        History.addToHistory(enemy, party, pref);
        History.printHistory(1);
        //Testing append eval
        History.appendEval(eval);
        History.printHistory(1);
        //Testing insert eval w/ index
        History.addToHistory(enemy, partyLg, pref);
        History.addToHistory(enemy, party, pref);
        History.printHistory(3);
        History.insertEval(3, eval);
        History.printHistory(3);
        //Testing insert eval w/o index
        Enemy enemy2 = EnemyRecommenderRandom.recommendRandomEnemy();
        enemy2.setName("test");
        eval.setName("test");
        History.addToHistory(enemy2, partySm, pref);
        History.addToHistory(enemy, partyLg, pref);
        History.printHistory(4);
        System.out.println("Should be true: " + History.insertEval(eval));
        History.printHistory(4);
        //Testing printAllHistory
        System.out.println("-----Full History-----");
        History.printHistory();
        System.out.println("-----End Full History-----");
        //Testing clearAll function
        System.out.println("-----Clear History-----");
        History.clearAll();
        History.printHistory();
        System.out.println("-----End of Clear History-----");

        
    
    }

    public static void main(String args[]) throws FileNotFoundException {
        // partyTest();
        // statsTest();
        // characterInheritanceTest();
        // enemyInheritanceTest();
        agentTest();
        // historyTest();
        // System.out.println("REFLEX AGENT TESTS" + "\n");
        // System.out.println("REFLEX ENEMY 1");
        // System.out.println(enemyRecommenderReflexTest().toString());
        // System.out.println("REFLEX ENEMY 2");
        // System.out.println(enemyRecommenderReflexTest());
        // System.out.println("REFLEX ENEMY 3");
        // System.out.println(enemyRecommenderReflexTest());

        // System.out.println("RANDOM AGENT TESTS" + "\n");
        // System.out.println("RANDOM ENEMY 1");
        // System.out.println(enemyRecommenderRandomTest().toString());
        // System.out.println("RANDOM ENEMY 2");
        // System.out.println(enemyRecommenderRandomTest());
        // System.out.println("RANDOM ENEMY 3");
        // System.out.println(enemyRecommenderRandomTest());

    }

}
