package src;
public class DungeonMaster{
    private String username;

    public DungeonMaster(String username) throws IllegalArgumentException{
        if(username.length()==0){
            throw new IllegalArgumentException("invalid username");
        }
        this.username=username;
    }
}