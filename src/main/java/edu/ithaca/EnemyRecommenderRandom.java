package edu.ithaca;
import java.util.*;


public class EnemyRecommenderRandom {

    public static Enemy recommendRandomEnemy(){

        //Small Enemy Database

        ArrayList<Enemy> possibleEnemies = new ArrayList<>();
        ArrayList<QualitativeStats> possibleEnemiesQuals = new ArrayList<>();
        Enemy yeti = new Enemy(false, false, Terrain.ARCTIC, MovementType.GROUND, null, null);
        QualitativeStats qualYeti = new QualitativeStats(Alignment.LAWFULEVIL, Size.LARGE, "Yeti, Undercommon", ',');
        possibleEnemies.add(yeti);
        possibleEnemiesQuals.add(qualYeti);

        Enemy aarakocra = new Enemy(false, false, Terrain.MOUNTAIN, MovementType.FLY, null, null);
        QualitativeStats qualAarakocra = new QualitativeStats(Alignment.LAWFULEVIL, Size.LARGE, "Auran, Common", ',');
        possibleEnemies.add(aarakocra);
        possibleEnemiesQuals.add(qualAarakocra);

        Enemy dragon = new Enemy(false, true, Terrain.MOUNTAIN, MovementType.FLY, null, null);
        QualitativeStats qualDragon = new QualitativeStats(Alignment.NEUTRALEVIL, Size.HUGE, "Draconic", ',');
        possibleEnemies.add(dragon);
        possibleEnemiesQuals.add(qualDragon);

        Enemy owlbear = new Enemy(false, false, Terrain.FOREST, MovementType.GROUND, null, null);
        QualitativeStats qualOwlbear = new QualitativeStats(Alignment.LAWFULEVIL, Size.MEDIUM, "None", ',');
        possibleEnemies.add(owlbear);
        possibleEnemiesQuals.add(qualOwlbear);

        Enemy gelatinousCube = new Enemy(false, false, Terrain.GRASSLAND, MovementType.GROUND, null, null);
        QualitativeStats qualgelatinousCube = new QualitativeStats(Alignment.TRUENEUTRAL, Size.MEDIUM, "None", ',');
        possibleEnemies.add(gelatinousCube);
        possibleEnemiesQuals.add(qualgelatinousCube);

        Enemy beholder = new Enemy(false, true, Terrain.UNDERDARK, MovementType.FLY, null, null);
        QualitativeStats qualBeholder = new QualitativeStats(Alignment.LAWFULEVIL, Size.LARGE, "Beholder, Undercommon", ',');
        possibleEnemies.add(beholder);
        possibleEnemiesQuals.add(qualBeholder);

        Enemy aboleth = new Enemy(false, false, Terrain.COAST, MovementType.SWIM, null, null);
        QualitativeStats qualAboleth = new QualitativeStats(Alignment.LAWFULEVIL, Size.GARGANTUAN, "Aboleth, Aquan, Deep speech", ',');
        possibleEnemies.add(aboleth);
        possibleEnemiesQuals.add(qualAboleth);

        Enemy banshee = new Enemy(false, false, Terrain.UNDERDARK, MovementType.FLY, null, null);
        QualitativeStats qualBanshee = new QualitativeStats(Alignment.LAWFULEVIL, Size.MEDIUM, "Common, Elvish", ',');
        possibleEnemies.add(banshee);
        possibleEnemiesQuals.add(qualBanshee);

        Enemy bandit = new Enemy(true, false, Terrain.FOREST, MovementType.GROUND, null, null);
        QualitativeStats qualBandit = new QualitativeStats(Alignment.CHAOTICEVIL, Size.MEDIUM, "Common", ',');
        possibleEnemies.add(bandit);
        possibleEnemiesQuals.add(qualBandit);

        Enemy goblin = new Enemy(false, false, Terrain.FOREST, MovementType.GROUND, null, null);
        QualitativeStats qualGoblin = new QualitativeStats(Alignment.LAWFULEVIL, Size.SMALL, "Ghukliak", ',');
        possibleEnemies.add(goblin);
        possibleEnemiesQuals.add(qualGoblin);

        Enemy orc = new Enemy(false, false, Terrain.FOREST, MovementType.GROUND, null, null);
        QualitativeStats qualOrc = new QualitativeStats(Alignment.LAWFULEVIL, Size.LARGE, "Orcish, Common", ',');
        possibleEnemies.add(orc);
        possibleEnemiesQuals.add(qualOrc);

        Enemy zombie = new Enemy(false, false, Terrain.UNDERDARK, MovementType.GROUND, null, null);
        QualitativeStats qualZombie= new QualitativeStats(Alignment.NEUTRALEVIL, Size.MEDIUM, "None", ',');
        possibleEnemies.add(zombie);
        possibleEnemiesQuals.add(qualZombie);

        Enemy werewolf = new Enemy(false, false, Terrain.MOUNTAIN, MovementType.GROUND, null, null);
        QualitativeStats qualWerewolf = new QualitativeStats(Alignment.NEUTRALEVIL, Size.MEDIUM, "Common", ',');
        possibleEnemies.add(werewolf);
        possibleEnemiesQuals.add(qualWerewolf);

        Enemy giantRat = new Enemy(false, false, Terrain.FOREST, MovementType.GROUND, null, null);
        QualitativeStats qualGiantRat = new QualitativeStats(Alignment.NEUTRALEVIL, Size.SMALL, "None", ',');
        possibleEnemies.add(giantRat);
        possibleEnemiesQuals.add(qualGiantRat);

        Enemy arachnid = new Enemy(false, false, Terrain.FOREST, MovementType.GROUND, null, null);
        QualitativeStats qualArachnid = new QualitativeStats(Alignment.NEUTRALEVIL, Size.SMALL, "None", ',');
        possibleEnemies.add(arachnid);
        possibleEnemiesQuals.add(qualArachnid);

        Enemy rustMonster = new Enemy(false, false, Terrain.SWAMP, MovementType.GROUND, null, null);
        QualitativeStats qualRustMonster = new QualitativeStats(Alignment.LAWFULEVIL, Size.MEDIUM, "Undercommon", ',');
        possibleEnemies.add(rustMonster);
        possibleEnemiesQuals.add(qualRustMonster);

        Enemy cultist = new Enemy(true, true, Terrain.FOREST, MovementType.GROUND, null, null);
        QualitativeStats qualCultist = new QualitativeStats(Alignment.LAWFULEVIL, Size.MEDIUM, "Common", ',');
        possibleEnemies.add(cultist);
        possibleEnemiesQuals.add(qualCultist);

        //Randomly choose from the enemy database
        int rnd = new Random().nextInt(possibleEnemies.size());
        Enemy chosenEnemy = possibleEnemies.get(rnd);
        QualitativeStats chosenQuals = possibleEnemiesQuals.get(rnd);



        //Randomly assign quant stats
        int crRND = new Random().nextInt(30);
        int expRND = new Random().nextInt(1000);
        int msRND = new Random().nextInt(50);
        int acRND = new Random().nextInt(50);
        int hpRND = new Random().nextInt(50);
        int conRND = new Random().nextInt(20);
        int strRND = new Random().nextInt(20);
        int wisRND = new Random().nextInt(20);
        int intelRND = new Random().nextInt(20);
        int dexRND = new Random().nextInt(20);
        int chaRND = new Random().nextInt(20);

        EnemyQuantStats randomEnemyQuant = new EnemyQuantStats(crRND, expRND, msRND, acRND, hpRND, conRND, strRND, wisRND, intelRND, dexRND, chaRND);
        Enemy randonmRecommendedEnemy = new Enemy(chosenEnemy.getIsHumanoid(), chosenEnemy.getIsMagicUser(), chosenEnemy.getTerrain(), chosenEnemy.getMovementType(), chosenQuals, randomEnemyQuant);

        return randonmRecommendedEnemy;

    }
    
}
