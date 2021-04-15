package src;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class Enemy {

    private boolean isHumanoid;
    private boolean isMagicUser;
    private String terrain;
    private String movementType;


    /**
     * Default constructor
     */
    public Enemy(){
        isHumanoid = false;
        terrain = "Tundra";
        
    // }

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
}