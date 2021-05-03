package edu.ithaca;
import java.util.*;


public class EnemyRecommenderRandom {

    public static Enemy recommendRandomEnemy(){

        //Small Enemy Database

        ArrayList<Enemy> possibleEnemies = new ArrayList<>();
        ArrayList<QualatativeStats> possibleEnemiesQuals = new ArrayList<>();
        Enemy yeti = new Enemy(false, false, Terrain.ARCTIC, MovementType.GROUND, null, null);
        QualatativeStats qualYeti = new QualatativeStats(Alignment.LAWFULEVIL, Size.LARGE, "Yeti, Undercommon", ',');
        possibleEnemies.add(yeti);
        possibleEnemiesQuals.add(qualYeti);

        Enemy aarakocra = new Enemy(false, false, Terrain.MOUNTAIN, MovementType.FLY, null, null);
        QualatativeStats qualAarakocra = new QualatativeStats(Alignment.LAWFULEVIL, Size.LARGE, "Auran, Common", ',');
        possibleEnemies.add(aarakocra);
        possibleEnemiesQuals.add(qualAarakocra);

        Enemy dragon = new Enemy(false, true, Terrain.MOUNTAIN, MovementType.FLY, null, null);
        QualatativeStats qualDragon = new QualatativeStats(Alignment.NEUTRALEVIL, Size.HUGE, "Draconic", ',');
        possibleEnemies.add(dragon);
        possibleEnemiesQuals.add(qualDragon);

        Enemy owlbear = new Enemy(false, false, Terrain.FOREST, MovementType.GROUND, null, null);
        QualatativeStats qualOwlbear = new QualatativeStats(Alignment.LAWFULEVIL, Size.MEDIUM, "None", ',');
        possibleEnemies.add(owlbear);
        possibleEnemiesQuals.add(qualOwlbear);

        Enemy gelatinousCube = new Enemy(false, false, Terrain.GRASSLAND, MovementType.GROUND, null, null);
        QualatativeStats qualgelatinousCube = new QualatativeStats(Alignment.TRUENEUTRAL, Size.MEDIUM, "None", ',');
        possibleEnemies.add(gelatinousCube);
        possibleEnemiesQuals.add(qualgelatinousCube);

        Enemy beholder = new Enemy(false, true, Terrain.UNDERDARK, MovementType.FLY, null, null);
        QualatativeStats qualBeholder = new QualatativeStats(Alignment.LAWFULEVIL, Size.LARGE, "Beholder, Undercommon", ',');
        possibleEnemies.add(beholder);
        possibleEnemiesQuals.add(qualBeholder);

        Enemy aboleth = new Enemy(false, false, Terrain.COAST, MovementType.SWIM, null, null);
        QualatativeStats qualAboleth = new QualatativeStats(Alignment.LAWFULEVIL, Size.GARGANTUAN, "Aboleth, Aquan, Deep speech", ',');
        possibleEnemies.add(aboleth);
        possibleEnemiesQuals.add(qualAboleth);

        Enemy banshee = new Enemy(false, false, Terrain.UNDERDARK, MovementType.FLY, null, null);
        QualatativeStats qualBanshee = new QualatativeStats(Alignment.LAWFULEVIL, Size.MEDIUM, "Common, Elvish", ',');
        possibleEnemies.add(banshee);
        possibleEnemiesQuals.add(qualBanshee);

        Enemy bandit = new Enemy(true, false, Terrain.FOREST, MovementType.GROUND, null, null);
        QualatativeStats qualBandit = new QualatativeStats(Alignment.CHAOTICEVIL, Size.MEDIUM, "Common", ',');
        possibleEnemies.add(bandit);
        possibleEnemiesQuals.add(qualBandit);

        Enemy goblin = new Enemy(false, false, Terrain.FOREST, MovementType.GROUND, null, null);
        QualatativeStats qualGoblin = new QualatativeStats(Alignment.LAWFULEVIL, Size.SMALL, "Ghukliak", ',');
        possibleEnemies.add(goblin);
        possibleEnemiesQuals.add(qualGoblin);

        Enemy orc = new Enemy(false, false, Terrain.FOREST, MovementType.GROUND, null, null);
        QualatativeStats qualOrc = new QualatativeStats(Alignment.LAWFULEVIL, Size.LARGE, "Orcish, Common", ',');
        possibleEnemies.add(orc);
        possibleEnemiesQuals.add(qualOrc);

        Enemy zombie = new Enemy(false, false, Terrain.UNDERDARK, MovementType.GROUND, null, null);
        QualatativeStats qualZombie= new QualatativeStats(Alignment.NEUTRALEVIL, Size.MEDIUM, "None", ',');
        possibleEnemies.add(zombie);
        possibleEnemiesQuals.add(qualZombie);

        Enemy werewolf = new Enemy(false, false, Terrain.MOUNTAIN, MovementType.GROUND, null, null);
        QualatativeStats qualWerewolf = new QualatativeStats(Alignment.NEUTRALEVIL, Size.MEDIUM, "Common", ',');
        possibleEnemies.add(werewolf);
        possibleEnemiesQuals.add(qualWerewolf);

        Enemy giantRat = new Enemy(false, false, Terrain.FOREST, MovementType.GROUND, null, null);
        QualatativeStats qualGiantRat = new QualatativeStats(Alignment.NEUTRALEVIL, Size.SMALL, "None", ',');
        possibleEnemies.add(giantRat);
        possibleEnemiesQuals.add(qualGiantRat);

        Enemy arachnid = new Enemy(false, false, Terrain.FOREST, MovementType.GROUND, null, null);
        QualatativeStats qualArachnid = new QualatativeStats(Alignment.NEUTRALEVIL, Size.SMALL, "None", ',');
        possibleEnemies.add(arachnid);
        possibleEnemiesQuals.add(qualArachnid);

        Enemy rustMonster = new Enemy(false, false, Terrain.SWAMP, MovementType.GROUND, null, null);
        QualatativeStats qualRustMonster = new QualatativeStats(Alignment.LAWFULEVIL, Size.MEDIUM, "Undercommon", ',');
        possibleEnemies.add(rustMonster);
        possibleEnemiesQuals.add(qualRustMonster);

        Enemy cultist = new Enemy(true, true, Terrain.FOREST, MovementType.GROUND, null, null);
        QualatativeStats qualCultist = new QualatativeStats(Alignment.LAWFULEVIL, Size.MEDIUM, "Common", ',');
        possibleEnemies.add(cultist);
        possibleEnemiesQuals.add(qualCultist);

        //Randomly choose from the enemy database
        int rnd = new Random().nextInt(possibleEnemies.size());
        Enemy chosenEnemy = possibleEnemies.get(rnd);
        QualatativeStats chosenQuals = possibleEnemiesQuals.get(rnd);



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
