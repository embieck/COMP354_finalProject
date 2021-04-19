package edu.ithaca;

import java.util.*;

/**
 * extended by Character class Includes a constructor to set inital stats
 * Includes public getters and setters for all stats to allow edits to stats
 **/

public class QualatativeStats {

    public ArrayList<String> languages = new ArrayList<>();
    public alignment align;
    public size size;

    /**
     * Default constructor
     */
    public QualatativeStats() {
        this.align = alignment.unaligned;
        this.languages.add("common");
        this.size = size.medium;
    }

    /**
     * Constructor
     * 
     * @param align     - gives a clue to the default behavior of the creatures
     * @param size      - size of creature, how much space it occupies
     * @param languages - list of languages the character can speak
     * @param delimiter - the char used to seperate in the languages parameter
     */
    public QualatativeStats(alignment align, size size, String languageStr, char delimiter) {
        this.align = align;
        this.size = size;
        if (!languageStr.isEmpty()) {
            String curLang = "";
            for (int i = 0; i < languageStr.length(); i++) {
                if (languageStr.charAt(i) != delimiter)
                    curLang += languageStr.charAt(i);
                else {
                    this.languages.add(curLang);
                    curLang = "";
                }
            }
            languages.add(curLang);
        }
    }

    public enum alignment {
        unaligned, chaoticEvil, lawfulEvil, neutralEvil, chaoticGood, lawfulGood, neutralGood, chaoticNeutral,
        lawfulNeutral, trueNeutral;
    }

    public enum size {
        tiny, small, medium, large, huge, gargantuan;
    }

    public ArrayList<String> getLanguages() {
        return this.languages;
    }

    public alignment getAlign() {
        return this.align;
    }

    public void setAlign(alignment align) {
        this.align = align;
    }

    public size getSize() {
        return this.size;
    }

    public void setSize(size size) {
        this.size = size;
    }

    public void addLanguage(String language) {
        this.languages.add(language);
    }
}
