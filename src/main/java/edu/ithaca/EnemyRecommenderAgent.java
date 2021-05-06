package edu.ithaca;

import java.util.*;

public class EnemyRecommenderAgent implements EnemyRecommender{
    List<Enemy> appropriateEnemyList = new ArrayList<>();
    List<Integer> enemyScoreList = new ArrayList<>();
    public final History history = new History();
    private final double repeatPenalty = 2;

    public static double calcAvPartyLevel(Party party) {
        int partySize = party.getPartySize();
        int levelTotal = 0;
        for (int i = 0; i < partySize; i++) {
            levelTotal += party.getCharacter(i).getLevel();
        }
        return levelTotal / (double) partySize;
    }

    public double calcCrToFind(Party party, Preferences preferences) {
        // Identify the ideal combat rating based on desired difficulty
        double crToFind = 0;
        double averagePartyLevel = calcAvPartyLevel(party);
        if (preferences.getDifficulty() == Difficulty.EASY) {
            if (averagePartyLevel >= 14 && averagePartyLevel <= 19) {
                crToFind = averagePartyLevel - 2;
            } else {
                crToFind = averagePartyLevel - 1;
            }
        }

        else if (preferences.getDifficulty() == Difficulty.MEDIUM) {
            if (averagePartyLevel >= 5 && averagePartyLevel <= 7) {
                crToFind = averagePartyLevel + 1;
            } else {
                crToFind = averagePartyLevel;
            }
        }

        else if (preferences.getDifficulty() == Difficulty.HARD) {
            if (averagePartyLevel < 2) {
                crToFind = averagePartyLevel;
            } else if (averagePartyLevel >= 2 && averagePartyLevel <= 4) {
                crToFind = averagePartyLevel + 1;
            } else {
                crToFind = averagePartyLevel + 2;
            }
        } else if (preferences.getDifficulty() == Difficulty.DEADLY) {
            if (averagePartyLevel < 2) {
                crToFind = averagePartyLevel + 1;
            } else if (averagePartyLevel >= 2 && averagePartyLevel <= 4) {
                crToFind = averagePartyLevel + 2;
            } else {
                crToFind = averagePartyLevel + 3;
            }
        }
        if (party.getPartySize() != 4) {
            if (party.getPartySize() > 4) { // Adds 2 Cr points to crToFind for every additional party member (after 4)
                crToFind += (party.getPartySize() - 4) * 2;
            } else {
                if (averagePartyLevel < 2) {
                    if (party.getPartySize() == 3) {
                        crToFind = 1.3;
                    } else {
                        crToFind = 0;
                    }
                }
                // Subtracts 2 Cr points to crToFind for every missing party member (less than
                // 4)
                else if (averagePartyLevel > 6) {
                    crToFind -= (4 - party.getPartySize()) * 2;
                }
            }
        }
        return crToFind;
    }

    /**
     * Calls method of EnemyDataBaseList class to search db for enemies with
     * matching combat ratings; adds Enemy to global appropriateEnemyList
     * 
     * @param crToFind - Cr value to search for in database (based on difficulty
     *                 preference and party level)
     * @sideEffect - appropriateEnemyList is populated with enemies with cr =
     *             crToFind
     */

    public void crSearch(double crToFind, EnemyDataBaseList edbl) {
        ArrayList<Enemy> enemies = edbl.crFind(crToFind);
        for (int i = 0; i < enemies.size(); i++) {
            appropriateEnemyList.add(enemies.get(i));
        }
    }

    /**
     * Calls method of ____ class to search db for enemies with matching
     * preferences; adds Enemy to global appropriateEnemyList
     * 
     * @param preferences
     * @sideEffect - appropriateEnemyList is populated with enemies that match
     *             preferences
     */
    public void prefSearch(Preferences preferences, EnemyDataBaseList edbl) {
        ArrayList<Enemy> enemies = edbl.prefFind(preferences);
        for (int i = 0; i < enemies.size(); i++) {
            appropriateEnemyList.add(enemies.get(i));
        }
    }

    /**
     * Calculates the heuristic score of an Enemy for preferences in difficulty
     * (cr), isHumanoid, Alignment, and movementType. Max Score: 10 Penalizes score
     * 1 point for every 1 point difference in cr
     * 
     * @param enemy
     * @param preferences
     * @return score (out of 10)
     */
    public int calcScore(Enemy enemy, Preferences preferences, double crToFind) {
        int crScore = 0;
        int humanoidScore = 0;
        int alignScore = 0;
        int moveScore = 0;

        if (Math.abs(enemy.getCr() - crToFind) <= 4) {
            crScore = 1;
        }

        if (enemy.getIsHumanoid() == preferences.getIsHumanoid()) {
            humanoidScore = 1;
        }

        if (enemy.getAlignment() == preferences.getAlignment()) {
            alignScore = 1;
        }

        if (enemy.getMovementType() == preferences.getMovementType()) {
            moveScore = 1;
        }
        int finalScore = 0;
        for (int i = 0; i < History.chosenEnemies.size(); i++) {
            for (int k = 0; k < appropriateEnemyList.size(); k++)
                if (History.chosenEnemies.get(i) == appropriateEnemyList.get(k))
                    finalScore -= repeatPenalty;
        }
        //feature hierarchy
        finalScore += calcScoreWithFeatureHierarchy((int)Math.abs(crToFind - enemy.getCr()), crScore, humanoidScore, alignScore, moveScore);
        return finalScore;
    }

    public int calcScoreWithFeatureHierarchy(int crGapPenalty, int crScore, int humanoidScore, int alignScore, int moveScore){
        int finalScore = (4 * crScore) - crGapPenalty + (3 * humanoidScore) + (2 * alignScore)
                + moveScore;
        return (int) finalScore;
    }

    /**
     * Iterates through appropriateEnemyList and populates the corresponding
     * heuristic score list
     * 
     * @sideEffect - Adds the heuristic score of each appropriateEnemyList into a
     *             corresponding enemyScore arrayList
     */
    public void popScoreList(Preferences preferences, double crToFind) {
        for (int i = 0; i < appropriateEnemyList.size(); i++) {
            enemyScoreList.add(i, calcScore(appropriateEnemyList.get(i), preferences, crToFind));
        }
    }

    /**
     * Iterates through scoreList to locate the index of the highest score and
     * returns the enemy with that index in the corresponding list
     * 
     * @return Enemy with highest score
     */
    public Enemy bestEnemy() {
        int maxScore = -1;
        int maxIndex = -1;
        for (int i = 0; i < enemyScoreList.size(); i++) {
            if (enemyScoreList.get(i) > maxScore) {
                maxScore = enemyScoreList.get(i);
                maxIndex = i;
            }
        }
        return appropriateEnemyList.get(maxIndex);
    }

    public Enemy recommendEnemy(Party party, Preferences preferences, EnemyDataBaseList edbl) {
        double crToFind = calcCrToFind(party, preferences);
        crSearch(crToFind, edbl);
        if (appropriateEnemyList.size() < 1) { // If no suitable enemies are found, repeat crSearch with +/- 1
            crSearch(crToFind + 1, edbl);
            crSearch(crToFind - 1, edbl);
        }
        prefSearch(preferences, edbl);
        popScoreList(preferences, crToFind);
        return bestEnemy();
    }
    /**
     * Determines an additional evaluation of the enemy based on whether user chooses the final enemy produced
     * Pre: Recommendation must be made beforehand
     */
    public void recordEnemyResults(Enemy e, Party curParty, Preferences pref, EnemyEval eval){
        if(eval.getIsChosen()){
            history.addToHistory(e, eval, curParty, pref);
        }
        else{
            history.addToHistory(e,eval,curParty,pref);
        }
        
    }

    public EnemyEval calcCombinedScore(Enemy e){
        int enemyScore = enemyScoreList.get(findEnemy(e));
        return new EnemyEval(e.getName(), enemyScore);

    }

    public EnemyEval calcCombinedScore(Enemy e, int deathSaves, int hpDepleted, int deaths){
        int enemyScore = enemyScoreList.get(findEnemy(e));
        return new EnemyEval(e.getName(), deathSaves, hpDepleted, deaths, enemyScore);
    }

    private int findEnemy(Enemy e){
        for(int i=0;i<appropriateEnemyList.size();i++){
            if(appropriateEnemyList.get(i).equals(e)){
                return i;
            }
        }
        return -1;
    }

    private int getEnemyScore(Enemy e){
        return enemyScoreList.get(findEnemy(e));
    }

}
