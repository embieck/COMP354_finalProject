package edu.ithaca;
import java.util.*;
import edu.ithaca.QualatativeStats.*;
import edu.ithaca.QualatativeStats.alignment;

public class EnemyRecommenderReflex implements EnemyRecommender{


    public Enemy recommendEnemy(Party party){

        //QUANT STAT: moveSpeed, AC, hp, con, str, wis, intel, dex, cha

        int partySize = party.getPartySize();

        int combinedMS = 0;
        int combinedAC = 0;
        int combinedHP = 0;
        int combinedCON = 0;
        int combinedSTR = 0;
        int combinedWIS = 0;
        int combinedINTEL = 0;
        int combinedDEX = 0;
        int combinedCHA = 0;

        for (int i = 0; i <= party.getPartySize()-1; i++){
            PartyMember curMember = party.getCharacter(i);
            combinedMS += curMember.getMoveSpeed();
            combinedAC += curMember.getArmorClass(); 
            combinedHP += curMember.getHP();
            combinedCON += curMember.getCon();
            combinedSTR += curMember.getStr();
            combinedWIS += curMember.getWis();
            combinedINTEL += curMember.getIntel();
            combinedDEX += curMember.getDex();
            combinedCHA += curMember.getDex();

        } 

        combinedMS = combinedMS/partySize;
        combinedAC = combinedAC/partySize;
        combinedHP = combinedHP/partySize;
        combinedCON = combinedCON/partySize;
        combinedSTR = combinedSTR/partySize;
        combinedWIS = combinedWIS/partySize;
        combinedINTEL = combinedINTEL/partySize;
        combinedDEX = combinedDEX/partySize;
        combinedCHA = combinedCHA/partySize;

        //Small Enemy Database

        ArrayList<Enemy> possibleEnemies = new ArrayList<>();
        ArrayList<QualatativeStats> possibleEnemiesQuals = new ArrayList<>();
        Enemy yeti = new Enemy(false, false, Terrain.ARCTIC, MovementType.GROUND, null, null);
        QualatativeStats qualYeti = new QualatativeStats(alignment.lawfulEvil, size.large, "Yeti, Undercommon", ',');
        possibleEnemies.add(yeti);
        possibleEnemiesQuals.add(qualYeti);

        Enemy aarakocra = new Enemy(false, false, Terrain.MOUNTAIN, MovementType.FLY, null, null);
        QualatativeStats qualAarakocra = new QualatativeStats(alignment.lawfulEvil, size.large, "Auran, Common", ',');
        possibleEnemies.add(aarakocra);
        possibleEnemiesQuals.add(qualAarakocra);

        Enemy dragon = new Enemy(false, true, Terrain.MOUNTAIN, MovementType.FLY, null, null);
        QualatativeStats qualDragon = new QualatativeStats(alignment.neutralEvil, size.huge, "Draconic", ',');
        possibleEnemies.add(dragon);
        possibleEnemiesQuals.add(qualDragon);

        Enemy owlbear = new Enemy(false, false, Terrain.FOREST, MovementType.GROUND, null, null);
        QualatativeStats qualOwlbear = new QualatativeStats(alignment.lawfulEvil, size.medium, "None", ',');
        possibleEnemies.add(owlbear);
        possibleEnemiesQuals.add(qualOwlbear);

        Enemy gelatinousCube = new Enemy(false, false, Terrain.GRASSLAND, MovementType.GROUND, null, null);
        QualatativeStats qualgelatinousCube = new QualatativeStats(alignment.trueNeutral, size.medium, "None", ',');
        possibleEnemies.add(gelatinousCube);
        possibleEnemiesQuals.add(qualgelatinousCube);

        Enemy beholder = new Enemy(false, true, Terrain.UNDERDARK, MovementType.FLY, null, null);
        QualatativeStats qualBeholder = new QualatativeStats(alignment.lawfulEvil, size.large, "Beholder, Undercommon", ',');
        possibleEnemies.add(beholder);
        possibleEnemiesQuals.add(qualBeholder);

        Enemy aboleth = new Enemy(false, false, Terrain.COAST, MovementType.SWIM, null, null);
        QualatativeStats qualAboleth = new QualatativeStats(alignment.lawfulEvil, size.gargantuan, "Aboleth, Aquan, Deep speech", ',');
        possibleEnemies.add(aboleth);
        possibleEnemiesQuals.add(qualAboleth);

        Enemy banshee = new Enemy(false, false, Terrain.UNDERDARK, MovementType.FLY, null, null);
        QualatativeStats qualBanshee = new QualatativeStats(alignment.lawfulEvil, size.medium, "Common, Elvish", ',');
        possibleEnemies.add(banshee);
        possibleEnemiesQuals.add(qualBanshee);

        Enemy bandit = new Enemy(true, false, Terrain.FOREST, MovementType.GROUND, null, null);
        QualatativeStats qualBandit = new QualatativeStats(alignment.chaoticEvil, size.medium, "Common", ',');
        possibleEnemies.add(bandit);
        possibleEnemiesQuals.add(qualBandit);

        Enemy goblin = new Enemy(false, false, Terrain.FOREST, MovementType.GROUND, null, null);
        QualatativeStats qualGoblin = new QualatativeStats(alignment.lawfulEvil, size.small, "Ghukliak", ',');
        possibleEnemies.add(goblin);
        possibleEnemiesQuals.add(qualGoblin);

        Enemy orc = new Enemy(false, false, Terrain.FOREST, MovementType.GROUND, null, null);
        QualatativeStats qualOrc = new QualatativeStats(alignment.lawfulEvil, size.large, "Orcish, Common", ',');
        possibleEnemies.add(orc);
        possibleEnemiesQuals.add(qualOrc);

        Enemy zombie = new Enemy(false, false, Terrain.UNDERDARK, MovementType.GROUND, null, null);
        QualatativeStats qualZombie= new QualatativeStats(alignment.neutralEvil, size.medium, "None", ',');
        possibleEnemies.add(zombie);
        possibleEnemiesQuals.add(qualZombie);

        Enemy werewolf = new Enemy(false, false, Terrain.MOUNTAIN, MovementType.GROUND, null, null);
        QualatativeStats qualWerewolf = new QualatativeStats(alignment.neutralEvil, size.medium, "Common", ',');
        possibleEnemies.add(werewolf);
        possibleEnemiesQuals.add(qualWerewolf);

        Enemy giantRat = new Enemy(false, false, Terrain.FOREST, MovementType.GROUND, null, null);
        QualatativeStats qualGiantRat = new QualatativeStats(alignment.neutralEvil, size.small, "None", ',');
        possibleEnemies.add(giantRat);
        possibleEnemiesQuals.add(qualGiantRat);

        Enemy arachnid = new Enemy(false, false, Terrain.FOREST, MovementType.GROUND, null, null);
        QualatativeStats qualArachnid = new QualatativeStats(alignment.neutralEvil, size.small, "None", ',');
        possibleEnemies.add(arachnid);
        possibleEnemiesQuals.add(qualArachnid);

        Enemy rustMonster = new Enemy(false, false, Terrain.SWAMP, MovementType.GROUND, null, null);
        QualatativeStats qualRustMonster = new QualatativeStats(alignment.lawfulEvil, size.medium, "Undercommon", ',');
        possibleEnemies.add(rustMonster);
        possibleEnemiesQuals.add(qualRustMonster);

        Enemy cultist = new Enemy(true, true, Terrain.FOREST, MovementType.GROUND, null, null);
        QualatativeStats qualCultist = new QualatativeStats(alignment.lawfulEvil, size.medium, "Common", ',');
        possibleEnemies.add(cultist);
        possibleEnemiesQuals.add(qualCultist);

        //Randomly choose from the enemy database
        int rnd = new Random().nextInt(possibleEnemies.size());
        Enemy chosenEnemy = possibleEnemies.get(rnd);
        QualatativeStats chosenQuals = possibleEnemiesQuals.get(rnd);

        
        EnemyQuantStats enemyQuant = new EnemyQuantStats(6, 30, combinedMS, combinedAC, combinedHP, combinedCON, combinedSTR, combinedWIS, combinedINTEL, combinedDEX, combinedCHA);
        Enemy recommendedEnemy = new Enemy(chosenEnemy.getIsHumanoid(), chosenEnemy.getIsMagicUser(), chosenEnemy.getTerrain(), chosenEnemy.getMovementType(), chosenQuals, enemyQuant);

        return recommendedEnemy;

    }

    public void main(String args[]){

        QuantativeStats quantKemi = new QuantativeStats(30, 17, 32, 15, 17, 11, 12, 10, 15);
        QualatativeStats qualKemi = new QualatativeStats(alignment.lawfulGood, size.medium, "common, elvish, sylvan", ',');
        
        QuantativeStats quantEmma = new QuantativeStats(1, 2, 3, 4, 5, 6, 7, 8, 9);
        QualatativeStats qualEmma = new QualatativeStats(alignment.chaoticGood, size.tiny, "common, elvish", ',');
        
        QuantativeStats quantKelsey = new QuantativeStats(25, 14, 13, 14, 13, 11, 13, 14, 9);
        QualatativeStats qualKelsey = new QualatativeStats(alignment.chaoticNeutral, size.large, "celestial, common", ',');
        
        QuantativeStats quantToby = new QuantativeStats(20, 12, 11, 8, 10, 13, 12, 13, 16);
        QualatativeStats qualToby = new QualatativeStats(alignment.chaoticEvil, size.small, "common, draconic", ',');
        

        ArrayList<PartyMember> characters = new ArrayList<>();
        PartyMember kemi = new PartyMember("kemi", CharacterClass.BARD, CharacterRace.ELF, qualKemi, quantKemi);
        PartyMember emma = new PartyMember("emma", CharacterClass.PALADIN, CharacterRace.HALFELF, qualEmma, quantEmma);
        PartyMember kelsey = new PartyMember("kelsey", CharacterClass.DRUID, CharacterRace.HALFORC, qualKelsey, quantKelsey);
        PartyMember toby = new PartyMember("toby", CharacterClass.WIZARD, CharacterRace.DRAGONBORNE, qualToby, quantToby);
        characters.add(kemi);
        characters.add(emma);
        characters.add(kelsey);
        characters.add(toby);

        Party newParty = new Party(characters, characters.size());

        Enemy recommendedEnemy1 = recommendEnemy(newParty);
        Enemy recommendedEnemy2 = recommendEnemy(newParty);
        Enemy recommendedEnemy3 = recommendEnemy(newParty);

        System.out.println("Here are three recommended enemies: " + "\n" );
        System.out.println(recommendedEnemy1 + "\n");
        System.out.println(recommendedEnemy2 + "\n");
        System.out.println(recommendedEnemy3 + "\n");

    }
    
}
