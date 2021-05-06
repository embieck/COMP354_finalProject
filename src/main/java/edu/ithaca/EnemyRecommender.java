
package edu.ithaca;

public interface EnemyRecommender {
    public Enemy recommendEnemy(Party party, Preferences preferences, EnemyDataBaseList edbl);
    // evaluation for unchosen enemies
    public EnemyEval calcCombinedScore(Enemy e);
    // evaluation for chosen enemies
    public EnemyEval calcCombinedScore(Enemy e,int deathSaves, int hpDepleted, int deaths);
    // evaluation determined based on initial info
    public int calcScore(Enemy enemy, Preferences preferences, double crToFind);
    // calculates score with feature hierarchy
    public int calcScoreWithFeatureHierarchy(int crGapPenalty, int crScore, int humanoidScore, int alignScore, int moveScore);

}
