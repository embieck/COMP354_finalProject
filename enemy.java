import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.graalvm.compiler.core.amd64.AMD64NodeLIRBuilder;

import java.util.*;

public class enemy {

    private boolean isHumanoid;
    private boolean isMagicUser;
    private String terrain;
    private String movementType;


    public boolean getIsHumanoid(){
        return isHumanoid;
    }

    public boolean getIsMagicUser(){
        return isMagicUser;
    }

    public String getTerrain(){
        return terrain;
    }

    public String getMovementType(){
        return movementType;
    }

    /**
     * Constructor
     * @param isHumanoid - gives a clue to the default behavior of the creatures
     * @param isMagicUser - size of creature, how much space it occupies
     * @param terrain - list of languages the character can speak
     * @param movementType - the char used to seperate in the languages parameter
     */
    // public enemy(boolean isHumanoid, boolean isMagicUser, String terrain, String movementType){
    //     isHumanoid = null;
    //     isMagicUser = null;
    //     String terrain = "";
    //     String movementType = "";
        
    //     }
    // }
