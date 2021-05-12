# COMP354_finalProject
D&D Enemy Recommender Agent Template: https://docs.google.com/document/d/1L0s0yYY_bOWPeGJpdq8vRsQ7hgFN_o_FCMS8XExaE3A/edit?usp=sharing

Quick Start:
Run UserInterfaceMain to see a demonstration of the agent functionality


Sensors: 
EnemyDatabaseList interfaces with 800+ possible enemies and their stats
UserInterfaceMain gathers Party and user preferences
History class holds information on previous recommendations including the enemy recommended, the party and preference information, and a user's evaluation

Actuators:
The UserInterfaceMain class  makes all calls to the agent(s) to recommend an enemy.

Agents:
The simple reflex agent, EnemyRecommenderReflex, uses its sensor to recieve Party information. These includes the class, race, and ability scores of each party member. It then averages the ability scores of the party to randomly select an ememy monster and assign its ability score with the average of the party's to create a well-matched opponent. This information is returned as an Enemy object, which holds many of the same stats as party members.

In addition to party stats, the  model based agent (EnemyRecommenderAgent) also considers the user's preferences for the recommended enemy such as difficulty, whether the enemy is humanoid, its alignment, and its movement type. It also has access to a History of previously recommended enemies to avoid repeat recommendations and an evaluation made by the user.

EnemyRecommenderRandom assigns random stats with ability scores capped at 20. It does not have access to sensors.

A human (DungeonMaster) doing this task would need to evaluate all of the same metrics of the party and compare it against enemy base stats, adjusting them for their party's needs. This agent allows for more variety of monsters and automates the process of fitting the stats to the party.


Tests and Interfaces:
All tests for this agent can be found in the 'resources' folder within the 'test/java/edu/ithaca' folder. 
Note: The Tester.java class contains most tests for the classes that make up the enviornment. Many of these classes are inherited by others, so much of the testing is grouped together and results will print to the console. Class tests can be commented out in the main method.

The current interface contains the recommend enemy method, which uses the following sensors — Enemy Database List, DM Preferences, and Party Info —  to create an Enemy, or the actuator. It also has the calcCombinedScore methods that retroactively take in the enemy's combat data and adds it to the initial score to save it to the agent's history, depending on whether or not the enemy is chosen.


How To Guide for a New Agent:
A new agent should be implement the methods defined by EnemyRecommender class, with the most important being recommendEnemy. This is the main actuator in this environment, so the function return an Enemy object with the appropriate stats. An intelligent agent could utilize the provided sensors for Party, Preference, and DatabaseList to make the best recommendation. The new agent should be located in src/main/java/ithaca/edu. To test it, code can be added in the Tester class located in src/test/java/ithaca/edu. 


Recommender System Implementation:
As a software designed to recommend a monster to a D&D party based on stats and other preferences, implementing a recommender system based on the party's response to previous monsters would be an effective way to ensure our agent is as informed as possible. 

Overleaf Link for Advanced Agent: https://www.overleaf.com/read/hdbgshxgzqmb
