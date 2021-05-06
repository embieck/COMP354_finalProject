
package edu.ithaca;

public interface EnemyRecommender {
    public Enemy recommendEnemy(Party party, Preferences preferences, EnemyDataBaseList edbl);
    // evaluation for chosen enemies
    public EnemyEval calcCombinedScore(Enemy e);
    // evaluation for unchosen enemies
    public EnemyEval calcCombinedScore(Enemy e,int deathSaves, int hpDepleted, int deaths);

}
