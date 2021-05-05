package edu.ithaca;


import java.io.Serializable;
import java.util.*;

/**
 * extended by Character class Includes a constructor to set inital stats
 * Includes public getters and setters for all stats to allow edits to stats
 **/

public class QualatativeStats implements Serializable{

    public ArrayList<String> languages = new ArrayList<>();
    public Alignment align;
    public Size size;

    /**
     * Default constructor
     */
    public QualatativeStats() {
        this.align = Alignment.UNALIGNED;
        this.languages.add("common");
        this.size = Size.MEDIUM;
    }

    /**
     * Constructor
     * 
     * @param align     - gives a clue to the default behavior of the creatures
     * @param size      - size of creature, how much space it occupies
     * @param languages - list of languages the character can speak
     * @param delimiter - the char used to seperate in the languages parameter
     */
    public QualatativeStats(Alignment align, Size size, String languageStr, char delimiter){
        this.align = align;
        this.size = size;
        if (!languageStr.isEmpty()) {
            String curLang = "";
            for (int i = 0; i < languageStr.length(); i++) {
                if (languageStr.charAt(i) != delimiter && languageStr.charAt(i) !=' ')
                    curLang += languageStr.charAt(i);
                else {
                    this.languages.add(curLang);
                    curLang = "";
                }
            }
            languages.add(curLang);
        }
    }

    public ArrayList<String> getLanguages() {
        return this.languages;
    }

    public String getLanguage(int index) throws RuntimeException{
        if(languages!=null&&!languages.isEmpty()){
            return languages.get(index);
        }
        else{
            throw new RuntimeException("enemy has no languages recorded");
        }
    }

    public Alignment getAlign() {
        return this.align;
    }

    public void setAlign(Alignment align) {
        this.align = align;
    }

    public Size getSize() {
        return this.size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void addLanguage(String language) {
        this.languages.add(language);
    }
}
