//Include history of # of death saving throws, HP % used by enemy, party deaths 
//After recommending an enemy, it should be added to history list with corresponding party & preferences
//Enemy history should also include its evaluation score
//Map vs corresponding array list
package edu.ithaca;

public interface EnemyRecommender {
    public Enemy recommendEnemy(Party party);

}
