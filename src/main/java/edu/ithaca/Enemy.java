package edu.ithaca;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;




import java.io.Serializable;
import java.util.*;

/**
 * Describes enemy information and stats. Properties have public getters so
 * other classes can access information. Setters are not required as the
 * information is taken from the database and will not change
 */
public class Enemy {
    private String name;
    private boolean isHumanoid;
    private boolean isMagicUser;
    private Terrain terrain;
    private ArrayList<Terrain> terrains;
    private MovementType movementType;
    private ArrayList<MovementType> movementTypes;
    private EnemyQuantStats quanStats;
    private QualatativeStats qualStats;
    private String savingThrows;
    private String skills;
    private String additional;

    /**
     * 
     * @param isHumanoid   - boolean for whether the enemy is humanoid, affects its
     *                     ability to communicate with party members if the DM
     *                     desires
     * @param isMagicUser  - boolean for whether the enemy is a magic user, this
     *                     provides more versatility in combat moves
     * @param terrain      - enum that indicates type of landscape the encounter will take place in
     * @param movementType - enemy's primary movement type - ground, fly, or swim
     * @param qualStats    - class that holds qualatative enemy stats
     * @param quanStats    - class that holds quantatative enemy stats
     */
    public Enemy(boolean isHumanoid, boolean isMagicUser, Terrain terrain, MovementType movementType,
            QualatativeStats qualStats, EnemyQuantStats quanStats) {
        this.isHumanoid = isHumanoid;
        this.isMagicUser = isMagicUser;
        this.terrain = terrain;
        this.movementType = movementType;
        this.qualStats = qualStats;
        this.quanStats = quanStats;
        this.movementTypes=null;
        this.savingThrows=null;
        this.skills=null;
        this.additional=null;
    }

    public Enemy(String name, boolean isHumanoid,
            QualatativeStats qualStats, EnemyQuantStats quanStats,String savingThrows,String skills, String additional) {
        this.name = name;
        this.isHumanoid = isHumanoid;
        this.isMagicUser = false;
        this.terrain = null;
        this.qualStats = qualStats;
        this.quanStats = quanStats;
        this.movementTypes = new ArrayList<>();
        this.movementType=null;
        if(quanStats.getGroundSpeed()>0){
            movementTypes.add(MovementType.GROUND);
        }
        if(quanStats.getFlySpeed()>0){
            movementTypes.add(MovementType.FLY);
        }
        if(quanStats.getSwimSpeed()>0){
            movementTypes.add(MovementType.SWIM);
        }
        this.terrains=new ArrayList<>();
        fillTerrains();
        this.savingThrows=savingThrows;
        this.skills=skills;
        this.additional=additional;
    }

    private void fillTerrains(){
        if(movementTypes.size()!=0){
            if(movementTypes.contains(MovementType.GROUND)){
                Terrain[] terrArr = Terrain.values();
                for(int i=0;i<terrArr.length;i++){
                    terrains.add(terrArr[i]);
                }
            }
            else{
                if(movementTypes.contains(MovementType.SWIM)&&movementTypes.contains(MovementType.FLY)){
                    terrains.add(Terrain.COAST);
                    terrains.add(Terrain.DESERT);
                    terrains.add(Terrain.GRASSLAND);
                    terrains.add(Terrain.MOUNTAIN);
                    terrains.add(Terrain.SWAMP);
                    terrains.add(Terrain.UNDERDARK);

                }
                else if(movementTypes.contains(MovementType.SWIM)){
                    terrains.add(Terrain.COAST);
                    terrains.add(Terrain.SWAMP);
                }
                else{
                    terrains.add(Terrain.DESERT);
                    terrains.add(Terrain.GRASSLAND);
                    terrains.add(Terrain.MOUNTAIN);
                    terrains.add(Terrain.UNDERDARK);
                }
            }
        }
    }

    public boolean getIsHumanoid() {
        return isHumanoid;
    }

    public boolean getIsMagicUser() {
        return isMagicUser;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    // qualitative stats
    
    public QualatativeStats getQualStats(){
        return qualStats;
    }
    public void setQualStats(QualatativeStats qls){
        qualStats=qls;
    }
    @JsonIgnore
    public Alignment getAlignment() {
        return qualStats.getAlign();
    }
    @JsonIgnore
    public Size getSize() {
        return qualStats.getSize();
    }
    @JsonIgnore
    public ArrayList<String> getLanguages() {
        return qualStats.getLanguages();
    }

    // quantitative stats
    public EnemyQuantStats getQuanStats(){
        return quanStats;
    }
    public void setQuanStats(EnemyQuantStats qns){
        quanStats=qns;
    }
    @JsonIgnore
    public int getMoveSpeed() {
        return quanStats.getMoveSpeed();
    }
    @JsonIgnore
    public int getArmorClass() {
        return quanStats.getArmorClass();
    }
    @JsonIgnore
    public int getHP() {
        return quanStats.getHp();
    }
    @JsonIgnore
    public int getCon() {
        return quanStats.getCon();
    }
    @JsonIgnore
    public int getStr() {
        return quanStats.getStr();
    }
    @JsonIgnore
    public int getWis() {
        return quanStats.getWis();
    }
    @JsonIgnore
    public int getIntel() {
        return quanStats.getIntel();
    }
    @JsonIgnore
    public int getDex() {
        return quanStats.getDex();
    }
    @JsonIgnore
    public int getCha() {
        return quanStats.getCha();
    }
    @JsonIgnore
    public double getCr(){
        return quanStats.getCr();
    }
    @JsonIgnore
    public double getExp(){
        return quanStats.getexp();
    }

    // public String enemyToString(){
    //     return this.toString();
    // }
    @JsonIgnore
    public String toString(){

        ArrayList<String> randEnemyNameList = new ArrayList<>();
        randEnemyNameList.add("Yeti");
        randEnemyNameList.add("Aarakocra");
        randEnemyNameList.add("Dragon");
        randEnemyNameList.add("Owl Bear");
        randEnemyNameList.add("Gelatinous cube");
        randEnemyNameList.add("Beholder");
        randEnemyNameList.add("Aboleth");
        randEnemyNameList.add("Bandit");
        randEnemyNameList.add("Banshee");
        randEnemyNameList.add("Goblin");
        randEnemyNameList.add("Orc");
        randEnemyNameList.add("Zombie");
        randEnemyNameList.add("Werewolf");
        randEnemyNameList.add("Giant Rat");
        randEnemyNameList.add("Arachnid Queen");
        randEnemyNameList.add("Rust Monster");
        randEnemyNameList.add("Cultist"); 

        int rnd = new Random().nextInt(randEnemyNameList.size());
        String chosenEnemy = randEnemyNameList.get(rnd);

        //hp, con, str, wis, intel, dex, cha, cr, exp
        
        return ("Enemy: " + chosenEnemy + "\n" + "Is Humanoid: " + isHumanoid + "\n" + "Is Magic User: " + isMagicUser + "\n"
        + "Movespeed: " + this.getMoveSpeed() + "\n" + "Armor Class: " + this.getArmorClass() + "\n"
        + "HP: " + this.getHP() + "\n" + "Constitution: " + this.getCon() + "\n" + "Strength: "
        + this.getStr() + "\n" + "Wisdom: " + this.getWis() + "\n" + "Intelligence: " + this.getIntel() + "\n"
        + "Dexterity: " + this.getDex() + "\n" + "Charisma: " + this.getCha() + "\n" + "EXP: " 
        + this.getExp() + "\n" + "Combat rating: " + this.getCr() + "\n");

    }

    // /**
    //  * Constructor
    //  * @param isHumanoid - gives a clue to the default behavior of the creatures
    //  * @param isMagicUser - size of creature, how much space it occupies
    //  * @param terrain - list of languages the character can speak
    //  * @param movementType - the char used to seperate in the languages parameter
    //  */
    // public Enemy(boolean isHumanoid, boolean isMagicUser, String terrain, String movementType,
    // QualatativeStats qualStats, EnemyQuantStats quanStats){
    //     this.isHumanoid = isHumanoid;
    //     this.isMagicUser = isMagicUser;
    //     this.terrain = terrain;
    //     this.movementType = movementType;        
    //     this.qualStats = qualStats;
    //     this.quanStats = quanStats;
    //     }
    }
