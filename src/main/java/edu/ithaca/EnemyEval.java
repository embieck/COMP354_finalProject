package edu.ithaca;

public class EnemyEval {
    boolean isChosen;
    String name;
    int deathSaves;
    int hpDepleted;
    int deaths;

    public EnemyEval(String name) {
        this.name = name;
        this.deathSaves = 0;
        this.hpDepleted = 0;
        this.deaths = 0;
        isChosen = false;
    }

    /**
     * Constructor: Sets evaluation info for enemy to be saved in History Note:
     * Evaluation should only be completed after the recommended enemy has been in
     * an encounter with a party
     * 
     * @param enemyName  - Name of recommended enemy being evaluated (should be same
     *                   as db)
     * @param deathSaves - Number of death saving throws the party had to make
     *                   during encounter with recommended enemy
     * @param hpDepleted - The number of hp points lost by the party during the
     *                   encounter
     * @param deaths     - Number of party members that died during encounter
     */
    public EnemyEval(String enemyName, int deathSaves, int hpDepleted, int deaths) {
        this.name = enemyName;
        this.deathSaves = deathSaves;
        this.hpDepleted = hpDepleted;
        this.deaths = deaths;
        isChosen = true;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeathSaves() {
        return this.deathSaves;
    }

    public void setDeathSaves(int deathSaves) {
        this.deathSaves = deathSaves;
    }

    public int getHpDepleted() {
        return this.hpDepleted;
    }

    public void setHpDepleted(int hpDepleted) {
        this.hpDepleted = hpDepleted;
    }

    public int getDeaths() {
        return this.deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

}
