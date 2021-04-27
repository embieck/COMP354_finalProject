package edu.ithaca;

import java.io.Serializable;
import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;


import edu.ithaca.QualatativeStats.alignment;
import edu.ithaca.QualatativeStats.size;


public class PartyMember implements Serializable{

    private String name;
    private CharacterClass characterClass;
    private CharacterRace characterRace;
    private QualatativeStats qualStats;
    private QuantativeStats quanStats;
    /**
     * Constructor for JSON file read in to create partymember
     * @param name
     * @param characterClass
     * @param characterRace
     * @param align
     * @param size
     * @param languageStr
     * @param moveSpeed
     * @param armorClass
     * @param hp
     * @param con
     * @param str
     * @param wis
     * @param intel
     * @param dex
     * @param cha
     */
    public PartyMember(String name, CharacterClass characterClass, CharacterRace characterRace,
    alignment align, size size, String languageStr,
    int moveSpeed, int armorClass, int hp, int con, int str, int wis, int intel, int dex, int cha) {
        this.name = name;
        this.characterClass = characterClass;
        this.characterRace = characterRace;
        this.qualStats = new QualatativeStats(align,size,languageStr,',');
        this.quanStats = new QuantativeStats(moveSpeed, armorClass, hp, con, str, wis, intel, dex, cha);
    }

    /**
     * Complete constructor (assigns stats information)
     * @param name           - String that contains name of the character
     * @param CharacterClass - enum that indicates class of the character
     * @param CharacterRace  - enum that indicates race of the character
     * @param qualStats      - object containing qualatative stats of party member
     * @param quanStats      - object containing quantative stats of party member
     */
    public PartyMember(String name, CharacterClass characterClass, CharacterRace characterRace,
            QualatativeStats qualStats, QuantativeStats quanStats) {
        this.name = name;
        this.characterClass = characterClass;
        this.characterRace = characterRace;
        this.qualStats = qualStats;
        this.quanStats = quanStats;
    }

    /**
     * Constructor that doesn't assign stats information
     * @param name           - String that contains name of the character
     * @param CharacterClass - enum that indicates class of the character
     * @param CharacterRace  - enum that indicates race of the character
     */
    public PartyMember(String name, CharacterClass characterClass, CharacterRace characterRace) {
        this.name = name;
        this.characterClass = characterClass;
        this.characterRace = characterRace;
        this.qualStats = new QualatativeStats();
        this.quanStats = new QuantativeStats(30, 12, 10, 10, 10, 10, 10, 10, 10);
    }

    public PartyMember(){
        this.name= "Frank N. Furter";
        this.characterClass=CharacterClass.ROGUE;
        this.characterRace=CharacterRace.HALFELF;
        this.qualStats=new QualatativeStats();
        this.quanStats = new QuantativeStats(30, 12, 10, 10, 10, 10, 10, 10, 10);
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
    // public alignment getAlignment() {
    //     return qualStats.getAlign();
    // }

    // public size getSize() {
    //     return qualStats.getSize();
    // }

    // public ArrayList<String> getLanguages() {
    //     return qualStats.getLanguages();
    // }

    // quantitative stats
    public QuantativeStats getQuanStats(){
        return quanStats;
    }
    public void setQuanStats(QuantativeStats qns){
        quanStats=qns;
    }
    // public int getMoveSpeed() {
    //     return quanStats.getMoveSpeed();
    // }

    // public int getArmorClass() {
    //     return quanStats.getArmorClass();
    // }

    // public int getHP() {
    //     return quanStats.getHp();
    // }

    // public int getCon() {
    //     return quanStats.getCon();
    // }

    // public int getStr() {
    //     return quanStats.getStr();
    // }

    // public int getWis() {
    //     return quanStats.getWis();
    // }

    // public int getIntel() {
    //     return quanStats.getIntel();
    // }

    // public int getDex() {
    //     return quanStats.getDex();
    // }

    // public int getCha() {
    //     return quanStats.getCha();
    // }

}
