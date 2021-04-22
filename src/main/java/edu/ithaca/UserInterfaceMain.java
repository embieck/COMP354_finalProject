package edu.ithaca;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class UserInterfaceMain {
    /**
     * Prompts user to input a valid (non-empty) username string
     * 
     * @return valid username string entered by user
     */
    public static String getProperUsernameLogin() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter username:\n");
        String username = scan.nextLine();
        while (username.length() == 0) {
            System.out.println("invalid username");
            System.out.println("Enter username:\n");
            username = scan.nextLine();
        }
        scan.close();
        return username;

    }

    /**
     * Reads party information from csv file and returns the information via a
     * reference to a Party object
     * 
     * @param filename - name of csv file to read party member information from
     * @return reference to a Party object populated with party members from csv fie
     * @throws FileNotFoundException
     * @throws RuntimeException
     */
    public static Party readPartyFile(String filename) throws FileNotFoundException, RuntimeException {
        File f = new File(filename);
        Scanner scan = new Scanner(f);
        scan.useDelimiter(",");
        ArrayList<PartyMember> partyMembers = new ArrayList<>();
        try{
            while (scan.hasNext()) {
                String charName = scan.next();
                if(charName.equalsIgnoreCase("Name")){
                    scan.nextLine();
                    charName=scan.next();
                }
                String raceOrClass = scan.next();
                if(isStringClass(raceOrClass)){
                    CharacterClass cc = stringToClass(raceOrClass);
                    CharacterRace cr = stringToRace(scan.next());
                    partyMembers.add(new PartyMember(charName, cc, cr));
                }
                else{
                    CharacterClass cc = stringToClass(scan.next());
                    CharacterRace cr = stringToRace(raceOrClass);
                    partyMembers.add(new PartyMember(charName, cc, cr));
                }
                
            }
        }catch(InputMismatchException e){
            System.out.println("type mismatch takes place. Party member list will be emptied");

        }

        scan.close();

        if (partyMembers.size() < 1) {
            throw new RuntimeException("empty file");
        }
        return new Party(partyMembers);
    }

    /**
     * Prints csv file information to the console
     * 
     * @param filename - csv file name
     * @throws FileNotFoundException
     */
    public static void printFileInfo(String filename) throws FileNotFoundException {
        File f = new File(filename);
        Scanner scan = new Scanner(f);
        scan.useDelimiter(",");
        while (scan.hasNext()) {
            System.out.println(scan.next());
        }
        scan.close();
    }

    /**
     * Creates an enum mapping of character classes to strings for the class
     * 
     * @return EnumMap with keys as the enum Character Classes and values as their
     *         string counterparts
     */
    private static EnumMap<CharacterClass, String> createStringToClassMapping() {
        EnumMap<CharacterClass, String> classesAndStrings = new EnumMap<>(CharacterClass.class);
        classesAndStrings.put(CharacterClass.BARBARIAN, "barbarian");
        classesAndStrings.put(CharacterClass.ROGUE, "rogue");
        classesAndStrings.put(CharacterClass.BARD, "bard");
        classesAndStrings.put(CharacterClass.PALADIN, "paladin");
        classesAndStrings.put(CharacterClass.SORCERER, "sorcerer");
        classesAndStrings.put(CharacterClass.WIZARD, "wizard");
        classesAndStrings.put(CharacterClass.FIGHTER, "fighter");
        classesAndStrings.put(CharacterClass.WARLOCK, "warlock");
        classesAndStrings.put(CharacterClass.CLERIC, "cleric");
        classesAndStrings.put(CharacterClass.MONK, "monk");
        classesAndStrings.put(CharacterClass.RANGER, "ranger");
        classesAndStrings.put(CharacterClass.DRUID, "druid");
        return classesAndStrings;

    }

    /**
     * Converts a string representing a character class to its proper enum
     * counterpart
     * 
     * @return enum Character Class
     */
    public static CharacterClass stringToClass(String className) throws IllegalArgumentException {
        EnumMap<CharacterClass, String> classesAndStrings = createStringToClassMapping();
        Set<Entry<CharacterClass, String>> entries = classesAndStrings.entrySet();
        Iterator<Entry<CharacterClass, String>> i = entries.iterator();
        className=className.trim();
        while (i.hasNext()) {
            Entry<CharacterClass, String> entry = i.next();
            if (entry.getValue().equalsIgnoreCase(className)) {
                return entry.getKey();
            }
        }
        
        throw new IllegalArgumentException("invalid class name");

    }

    /**
     * checks to see whether string entered matches one of the class enums
     * @param className
     * @return boolean of whether className matches one of the enums
     */

    public static boolean isStringClass(String className) {
        EnumMap<CharacterClass, String> classesAndStrings = createStringToClassMapping();
        Set<Entry<CharacterClass, String>> entries = classesAndStrings.entrySet();
        Iterator<Entry<CharacterClass, String>> i = entries.iterator();
        className=className.trim();
        while (i.hasNext()) {
            Entry<CharacterClass, String> entry = i.next();
            if (entry.getValue().equalsIgnoreCase(className)) {
                return true;
            }
        }
        return false;

    }

    /**
     * Creates an enum mapping of character races to strings for the class
     * 
     * @return EnumMap with keys as the enum Character races and values as their
     *         string counterparts
     */
    private static EnumMap<CharacterRace, String> createStringToRaceMapping() {
        EnumMap<CharacterRace, String> racesAndStrings = new EnumMap<>(CharacterRace.class);
        racesAndStrings.put(CharacterRace.DRAGONBORNE, "dragonborne");
        racesAndStrings.put(CharacterRace.DWARF, "dwarf");
        racesAndStrings.put(CharacterRace.ELF, "elf");
        racesAndStrings.put(CharacterRace.GNOME, "gnome");
        racesAndStrings.put(CharacterRace.HALFELF, "half-elf");
        racesAndStrings.put(CharacterRace.HALFLING, "halfling");
        racesAndStrings.put(CharacterRace.HALFORC, "half-orc");
        racesAndStrings.put(CharacterRace.HUMAN, "human");
        racesAndStrings.put(CharacterRace.TIEFLING, "tiefling");

        return racesAndStrings;

    }

    /**
     * Converts a string representing a character race to its proper enum
     * counterpart
     * 
     * @return enum Character Race
     */
    public static CharacterRace stringToRace(String race) throws IllegalArgumentException {
        EnumMap<CharacterRace, String> racesAndStrings = createStringToRaceMapping();
        Set<Entry<CharacterRace, String>> entries = racesAndStrings.entrySet();
        Iterator<Entry<CharacterRace, String>> i = entries.iterator();
        race = race.trim();
        while (i.hasNext()) {
            Entry<CharacterRace, String> entry = i.next();
            if (entry.getValue().equalsIgnoreCase(race)) {
                return entry.getKey();
            }
        }
        //System.out.println(race);
        throw new IllegalArgumentException("invalid race name");

    }
    /**
     * checks to see whether string entered matches one of the race enums
     * @param race
     * @return boolean of whether race matches one of the enums
     */

    public static boolean isStringRace(String race){
        EnumMap<CharacterRace, String> racesAndStrings = createStringToRaceMapping();
        Set<Entry<CharacterRace, String>> entries = racesAndStrings.entrySet();
        Iterator<Entry<CharacterRace, String>> i = entries.iterator();
        race = race.trim();
        while (i.hasNext()) {
            Entry<CharacterRace, String> entry = i.next();
            if (entry.getValue().equalsIgnoreCase(race)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Converts a string representing a terrain to its proper enum
     * counterpart
     * 
     * @return enum Terrain
     */
    private static EnumMap<Terrain, String> createStringToTerrainMapping() {
        EnumMap<Terrain, String> terrainsAndStrings = new EnumMap<>(Terrain.class);
        terrainsAndStrings.put(Terrain.ARCTIC, "arctic");
        terrainsAndStrings.put(Terrain.COAST, "coast");
        terrainsAndStrings.put(Terrain.DESERT, "desert");
        terrainsAndStrings.put(Terrain.FOREST, "forest");
        terrainsAndStrings.put(Terrain.GRASSLAND, "grassland");
        terrainsAndStrings.put(Terrain.MOUNTAIN, "mountain");
        terrainsAndStrings.put(Terrain.SWAMP, "swamp");
        terrainsAndStrings.put(Terrain.UNDERDARK, "underdark");
        return terrainsAndStrings;
    }

    /**
     * Converts a string representing a movement type to its proper enum
     * counterpart
     * 
     * @return enum MovementType
     */
    private static EnumMap<MovementType, String> createStringToMovementTypeMapping() {
        EnumMap<MovementType, String> movementsAndStrings = new EnumMap<>(MovementType.class);
        movementsAndStrings.put(MovementType.FLY, "fly");
        movementsAndStrings.put(MovementType.GROUND, "ground");
        movementsAndStrings.put(MovementType.SWIM, "swim");
        
        return movementsAndStrings;
    }

    /**
     * Writes party information to a csv file
     * 
     * @param filename - name of file to save Party information to
     * @param p        - Party object to save as csv file
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void writePartyFile(String filename, Party p) throws FileNotFoundException, IOException {
        File f = new File(filename);
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        //System.out.println(p.getPartySize());
        bw.write("Name, CharacterRace/CharacterClass, CharacterRace/CharacterClass,\n");
        for (int i = 0; i < p.getPartySize(); i++) {
            PartyMember c = p.getCharacter(i);
            String delim = ",";
            bw.write(c.getName() + delim);
            // write class
            if (c.getCharacterClass() == CharacterClass.BARD) {
                bw.write("bard" + delim);
            } else if (c.getCharacterClass() == CharacterClass.BARBARIAN) {
                bw.write("barbarian" + delim);
            } else if (c.getCharacterClass() == CharacterClass.FIGHTER) {
                bw.write("fighter" + delim);
            } else if (c.getCharacterClass() == CharacterClass.ROGUE) {
                bw.write("rogue" + delim);
            } else if (c.getCharacterClass() == CharacterClass.SORCERER) {
                bw.write("sorcerer" + delim);
            } else if (c.getCharacterClass() == CharacterClass.WARLOCK) {
                bw.write("warlock" + delim);
            } else if (c.getCharacterClass() == CharacterClass.WIZARD) {
                bw.write("wizard" + delim);
            } else if (c.getCharacterClass() == CharacterClass.CLERIC) {
                bw.write("cleric" + delim);
            } else if (c.getCharacterClass() == CharacterClass.MONK) {
                bw.write("monk" + delim);
            } else if (c.getCharacterClass() == CharacterClass.RANGER) {
                bw.write("ranger" + delim);
            } else if (c.getCharacterClass() == CharacterClass.PALADIN) {
                bw.write("paladin" + delim);
            } else {
                bw.write("druid" + delim);
            }
            // write race
            if (c.getCharacterRace() == CharacterRace.DRAGONBORNE) {
                bw.write("dragonborne" + delim);
            } else if (c.getCharacterRace() == CharacterRace.HALFELF) {
                bw.write("half-elf" + delim);
            } else if (c.getCharacterRace() == CharacterRace.HALFLING) {
                bw.write("halfling" + delim);
            } else if (c.getCharacterRace() == CharacterRace.HALFORC) {
                bw.write("half-orc" + delim);
            } else if (c.getCharacterRace() == CharacterRace.GNOME) {
                bw.write("gnome" + delim);
            } else if (c.getCharacterRace() == CharacterRace.DWARF) {
                bw.write("dwarf" + delim);
            } else if (c.getCharacterRace() == CharacterRace.ELF) {
                bw.write("elf" + delim);
            } else if (c.getCharacterRace() == CharacterRace.TIEFLING) {
                bw.write("tiefling" + delim);
            } else {
                bw.write("human" + delim);
            }
            
            if(i<p.getPartySize()-1){
                bw.write("\n");
            }
        }
        bw.close();

    }
    /**
     * creates a basic party member w/ name, class, race from user input
     * @return party member to be added to a party
     */
    public static PartyMember getPartyMemberEntered(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter party member's name:\n");
        String name = scan.nextLine();
        while (name.length() == 0) {
            System.out.println("invalid party member name");
            System.out.println("Enter party member's name:\n");
            name = scan.nextLine();
        }
        System.out.println("Enter party member's class:\n");
        String className = scan.nextLine();
        while(!isStringClass(className)){
            System.out.println("invalid class entered");
            System.out.println("Enter party member's class:\n");
            className = scan.nextLine();
        }
        CharacterClass cc = stringToClass(className);

        System.out.println("Enter party member's race:\n");
        String race = scan.nextLine();
        while(!isStringRace(race)){
            System.out.println("invalid race entered");
            System.out.println("Enter party member's race:\n");
            race = scan.nextLine();
        }
        CharacterRace cr = stringToRace(race);

        scan.close();
        return new PartyMember(name, cc, cr);
    }

    public static void main(String[] args) throws IOException {
        String username = getProperUsernameLogin();
        DungeonMaster dm = new DungeonMaster(username);
        Party p = new Party(new ArrayList<PartyMember>());
        Scanner scan = new Scanner(System.in);
        try{
            p = readPartyFile("/Users/erb/Comp354_AI/COMP354_finalProject/src/main/java/edu/ithaca/resources/party.csv");
        }
        catch(RuntimeException e){}
        if(p.getPartySize()==0){
            System.out.println("No pre existing party info. Enter 'done' to stop or any key to continue:\n");
            String doneOrElse = scan.nextLine();
            while(!doneOrElse.equalsIgnoreCase("done")){
                PartyMember pm = getPartyMemberEntered();
                p.addCharacter(pm);
                System.out.println("No pre existing party info. Enter 'done' to stop or any key to continue:\n");
                doneOrElse = scan.nextLine();
            }
            writePartyFile("/Users/erb/Comp354_AI/COMP354_finalProject/src/main/java/edu/ithaca/resources/party.csv", p);
        }
        
        //Interface code for making a recommendation

    }

}
