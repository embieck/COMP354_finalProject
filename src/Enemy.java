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


<<<<<<< HEAD:enemy.java
    // /**
    //  * Default constructor
    //  */
    // public enemy(){
    //     isHumanoid = false;
    //     terrain = "Tundra";
=======
    /**
     * Default constructor
     */
    public Enemy(){
        isHumanoid = false;
        terrain = "Tundra";
>>>>>>> d9e2c802cf42c5559e494caf624764e1dcff7c75:src/Enemy.java
        
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