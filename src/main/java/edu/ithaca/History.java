package edu.ithaca;

import java.util.*;

/**
 * Holds a history of reccomendations that include: 1) The enemies recoomended
 * by the agent 2) The party and 3) the preferences given to the agent to
 * provide the reccommendation and 4) an evaluation of the enemy's performance
 * in the encounter package edu.ithaca;
 */
public class History {
    public static ArrayList<Enemy> chosenEnemies = new ArrayList<>();
    public static ArrayList<EnemyEval> evaluations = new ArrayList<>();
    public static ArrayList<Party> parties = new ArrayList<>();
    public static ArrayList<Preferences> preferences = new ArrayList<>();

    /**
     * Adds encounter information to corresponding history lists (Used when enemy is
     * not chosen)
     * 
     * @param enemy    - Enemy object used for encounter
     * @param eval     - Completed evaluation for the enemy (after encounter)
     * @param curParty - Party facing enemy during encounter
     * @param pref     - Preferences given to the agent for encounter
     */
    public static void addToHistory(Enemy enemy, EnemyEval eval, Party curParty, Preferences pref) {
        chosenEnemies.add(enemy);
        int listSize = 0;
        while (listSize < chosenEnemies.size() && chosenEnemies.get(listSize) != null) {
            listSize++;
        }
        evaluations.add(listSize - 1, eval);
        parties.add(listSize - 1, curParty);
        preferences.add(listSize - 1, pref);
    }

    /**
     * Adds recommended enemy information to history (Used when enemy is chosen)
     * Note: Evaluation object will need to be added via another method Note:
     * Indexes are matched according to the index of the inserted enemy Note:
     * Parameters should be the same objects passed to/from the agent recommender
     * 
     * @param enemy    - Enemy object used for encounter
     * @param curParty - Party facing enemy during encounter
     * @param pref     - Preferences given to the agent for encounter
     */
    public static void addToHistory(Enemy enemy, Party curParty, Preferences pref) {
        chosenEnemies.add(enemy);
        int listSize = 0;
        while (listSize < chosenEnemies.size() && chosenEnemies.get(listSize) != null) {
            listSize++;
        }
        evaluations.add(listSize - 1, null);
        parties.add(listSize - 1, curParty);
        preferences.add(listSize - 1, pref);
    }

    /**
     * Appends eval to end of history of evaluations list
     * 
     * @param eval - Completed evaluation for the enemy (after encounter)
     */
    public static void appendEval(EnemyEval eval) {
        evaluations.add(eval);
    }

    /**
     * Inserts eval into given index in history of evaluations list Note: If index
     * is invalid, evaluation will be appended to list
     * 
     * @param index - Corresponding index of enemy to insert evaluation
     * @param eval  - Completed evaluation for the enemy (after encounter)
     */
    public static void insertEval(int index, EnemyEval eval) {
        if (index >= 0 && index < evaluations.size())
            evaluations.add(index, eval);
        else {
            evaluations.add(eval);
        }
    }

    /**
     * Inserts evaluation to corresponding index based on enemy name field
     * 
     * @param eval - Completed evaluation for the enemy (after encounter)
     * @return true - If a matching name was found and evaluation was inserted into
     *         corresponding index
     * @return false - If no name match was found, evaluation appended to end of
     *         list
     */
    public static boolean insertEval(EnemyEval eval) {
        for (int i = 0; i < chosenEnemies.size(); i++) {
            if (eval.name.equals(chosenEnemies.get(i).getName())) {
                evaluations.add(i, eval);
                return true;
            }
        }
        evaluations.add(eval);
        return false;
    }

    /**
     * Prints the enemy name, evaluation metrics, party members, and preferences for
     * a recommended enemy at a given index in the history
     * 
     * @param index - Location to print history information from
     */
    public static void printHistory(int index) {
        if (index >= 0) {
            if (index < chosenEnemies.size())
                System.out.println("Enemy: " + chosenEnemies.get(index).getName());
            if (evaluations.get(index) != null)
                System.out.println("Evaluation: Death saving throws = " + evaluations.get(index).getDeathSaves()
                        + "\t HP drained by enemy = " + calcHpPerc(parties.get(index), evaluations.get(index))
                        + "\t Deaths = " + evaluations.get(index).getDeaths());
            if (index < parties.size())
                System.out.println("Party: Party size = " + parties.get(index).getPartySize() + "\t Party members = "
                        + parties.get(index).toStringMembers());
            if (index < preferences.size())
                System.out.println("Preferences: Difficulty= " + preferences.get(index).getDifficulty()
                        + "\t Humanoid = " + preferences.get(index).getIsHumanoid() + "\t Alignment = "
                        + preferences.get(index).getAlignment() + "\t Movement Type = "
                        + preferences.get(index).getMovementType());
            System.out.print("---------------\n");
        }
    }

    /**
     * Prints all recorded history information to console
     */
    public static void printHistory() {
        for (int i = 0; i < chosenEnemies.size(); i++) {
            printHistory(i);
        }
    }

    /**
     * Calculates the percentage of hp dealt to a party by an enemy
     * 
     * @param party - Party object from encounter with enemy
     * @param eval  - Evaluation object on encounter with enemy
     * @return percentage of hp damage done to party by enemy
     */
    public static int calcHpPerc(Party party, EnemyEval eval) {
        int totHp = 0;
        for (int i = 0; i < party.getPartySize(); i++) {
            totHp += party.getCharacter(i).getHP();
        }
        return (eval.getHpDepleted() / totHp) * 100;
    }

    /**
     * Removes all stored information from all history lists
     */
    public static void clearAll() {
        chosenEnemies.clear();
        evaluations.clear();
        parties.clear();
        preferences.clear();
    }

}
