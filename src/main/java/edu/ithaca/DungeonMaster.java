package edu.ithaca;

/**
 * Dungeon Master class holds a single property of username so different
 * DM's/users can access the interface and save their party info
 */
public class DungeonMaster {
    private String username;

    /**
     * This class could have a static final reference to a Party for each username.
     * Otherwise, I don't think it is needed at all.
     * 
     * @param username - the username for a DM/user
     * @throws IllegalArgumentException
     */
    public DungeonMaster(String username) throws IllegalArgumentException {
        if (username.length() == 0) {
            throw new IllegalArgumentException("invalid username");
        }
        this.username = username;
    }
}