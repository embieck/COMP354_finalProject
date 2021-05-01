package edu.ithaca;


public class Preferences {
    private Alignment alignment;
    private boolean isHumanoid;
    private Difficulty difficulty;
    private MovementType movementType;

    public Preferences(Alignment alignment, boolean isHumanoid, Difficulty difficulty, MovementType movementType){
        this.alignment = alignment;
        this.isHumanoid = isHumanoid;
        this.difficulty = difficulty;
        this.movementType = movementType;

    }

    public Preferences(){
        this.alignment = Alignment.NEUTRALEVIL;
        this.isHumanoid = false;
        this.difficulty = Difficulty.MEDIUM;
        this.movementType = MovementType.GROUND;
    }

    public Alignment getAlignment() {
        return this.alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public boolean isIsHumanoid() {
        return this.isHumanoid;
    }

    public boolean getIsHumanoid() {
        return this.isHumanoid;
    }

    public void setIsHumanoid(boolean isHumanoid) {
        this.isHumanoid = isHumanoid;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
    public MovementType getMovementType() {
        return this.movementType;
    }

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }


}
