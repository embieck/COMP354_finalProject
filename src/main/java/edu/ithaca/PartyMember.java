package edu.ithaca;

import java.io.Serializable;
import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.ithaca.QualatativeStats.alignment;
import edu.ithaca.QualatativeStats.size;


public class PartyMember implements Serializable{

    private String name;
    private CharacterClass characterClass;
    private CharacterRace characterRace;
    private QualatativeStats qualStats;
    private QuantativeStats quanStats;
    private int level;

    /**
     * Complete constructor (assigns stats information)
     * 
     * @param name           - String that contains name of the character
     * @param CharacterClass - enum that indicates class of the character
     * @param CharacterRace  - enum that indicates race of the character
     * @param qualStats      - object containing qualatative stats of party member
     * @param quanStats      - object containing quantative stats of party member
     * @param level          - level of the party member
     */
    public PartyMember(String name, CharacterClass characterClass, CharacterRace characterRace,
            QualatativeStats qualStats, QuantativeStats quanStats, int level) {
        this.name = name;
        this.characterClass = characterClass;
        this.characterRace = characterRace;
        this.qualStats = qualStats;
        this.quanStats = quanStats;
        this.level = level;

    }
    /**
     * Constructor with default level 1
     * @param name
     * @param characterClass
     * @param characterRace
     * @param qualStats
     * @param quanStats
     */
    public PartyMember(String name, CharacterClass characterClass, CharacterRace characterRace,
            QualatativeStats qualStats, QuantativeStats quanStats) {
        this.name = name;
        this.characterClass = characterClass;
        this.characterRace = characterRace;
        this.qualStats = qualStats;
        this.quanStats = quanStats;
        this.level = 1;

    }

    /**
     * Constructor that doesn't assign stats information
     * 
     * @param name           - String that contains name of the character
     * @param CharacterClass - enum that indicates class of the character
     * @param CharacterRace  - enum that indicates race of the character
     */
    public PartyMember(String name, CharacterClass characterClass, CharacterRace characterRace, int level) {
        this.name = name;
        this.characterClass = characterClass;
        this.characterRace = characterRace;
        this.qualStats = new QualatativeStats();
        this.quanStats = new QuantativeStats(30, 12, 10, 10, 10, 10, 10, 10, 10);
        this.level = level;
    }

    public PartyMember(){
        this.name= "Frank N. Furter";
        this.characterClass=CharacterClass.ROGUE;
        this.characterRace=CharacterRace.HALFELF;
        this.qualStats=new QualatativeStats();
        this.quanStats = new QuantativeStats(30, 12, 10, 10, 10, 10, 10, 10, 10);
        this.level=1;
    }

    public String getName() {
        return name;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public CharacterRace getCharacterRace() {
        return characterRace;
    }

    // qualitative stats
    public QualatativeStats getQualStats(){
        return qualStats;
    }
    public void setQualStats(QualatativeStats qls){
        qualStats=qls;
    }
    @JsonIgnore
    public alignment getAlignment() {
        return qualStats.getAlign();
    }
    @JsonIgnore
    public size getSize() {
        return qualStats.getSize();
    }
    @JsonIgnore   
    public ArrayList<String> getLanguages() {
        return qualStats.getLanguages();
    }

    // quantitative stats
    public QuantativeStats getQuanStats(){
        return quanStats;
    }
    public void setQuanStats(QuantativeStats qns){
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
    
    //Getter for Level
    public int getLevel(){
        return this.level;
    }

    //Setter for Level
    public void setLevel(int level){
        this.level = level;
    }
}
