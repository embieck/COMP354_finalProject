package edu.ithaca;

import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;

import edu.ithaca.QualatativeStats;
import edu.ithaca.QuantativeStats;
import edu.ithaca.QualatativeStats.alignment;
import edu.ithaca.QualatativeStats.size;

/**
 * 
 */
public class PartyMember {

    private String name;
    private CharacterClass characterClass;
    private CharacterRace characterRace;
    private QualatativeStats qualStats;
    private QuantativeStats quanStats;

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
        this.name = "";
        this.characterClass = characterClass;
        this.characterRace = characterRace;

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
    public alignment getAlignment() {
        return qualStats.getAlign();
    }

    public size getSize() {
        return qualStats.getSize();
    }

    public ArrayList<String> getLanguages() {
        return qualStats.getLanguages();
    }

    // quantitative stats
    public int getMoveSpeed() {
        return quanStats.getMoveSpeed();
    }

    public int getArmorClass() {
        return quanStats.getArmorClass();
    }

    public int getHP() {
        return quanStats.getHp();
    }

    public int getCon() {
        return quanStats.getCon();
    }

    public int getStr() {
        return quanStats.getStr();
    }

    public int getWis() {
        return quanStats.getWis();
    }

    public int getIntel() {
        return quanStats.getIntel();
    }

    public int getDex() {
        return quanStats.getDex();
    }

    public int getCha() {
        return quanStats.getCha();
    }

}
