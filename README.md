# COMP354_finalProject
D&D Enemy Recommender 
Agent Template: https://docs.google.com/document/d/1L0s0yYY_bOWPeGJpdq8vRsQ7hgFN_o_FCMS8XExaE3A/edit?usp=sharing

The Agent:
The simple reflex agent, EnemyRecommenderReflex, uses its sensor to recieve Party information. These includes the class, race, and ability scores of each party member. It then averages the ability scores of the party to randomly select an ememy monster and assign its ability score with the average of the party's to create a well-matched opponent. This information is returned as an Ememy object, which holds many of the same stats as party members. 

Other percepts our agents will consider in the future are terrain, whether the enemy is humanoid (and the langauges they speak), and movement type (should be appropriate to the terrain). We will also be adding a history of previously chosen enemies and an evaluation function to increase our agent's intelligence and improve future recommendations.

A human (DungeonMaster) doing this task would need to evaluate all of the same metrics of the party and compare it against enemy base stats, adjusting them for their party's needs. This agent allows for more variety of monsters and automates the process of fitting the stats to the party.

Testing:
The Tester.java class contains tests for the classes that make up the enviornment. Many of these classes are inherited by others, so much of the testing is grouped together and results will print to the console. Class tests can be commented out in the main method.
