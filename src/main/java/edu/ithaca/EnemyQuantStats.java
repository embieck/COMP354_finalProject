package edu.ithaca;

public class EnemyQuantStats extends QuantativeStats {
    private double cr;
    private int exp;
    private int swimSpeed;
    private int groundSpeed;
    private int flySpeed;

    /**
     * Extends Quantatative Stats to include those only held by enemies and provide
     * getters and setters for the agent to utilize
     * 
     * @param cr  - Combat rating, can range from 0-30
     * @param exp - Experience points
     */
    public EnemyQuantStats(double cr, int exp, int moveSpeed, int armorClass, int hp, int con, int str, int wis,
            int intel, int dex, int cha) {
        super(moveSpeed, armorClass, hp, con, str, wis, intel, dex, cha);
        this.cr = cr;
        this.exp = exp;
    }

    public EnemyQuantStats(double cr, int exp, int swimSpeed, int groundSpeed, int flySpeed, int armorClass, int hp, int con, int str, int wis,
            int intel, int dex, int cha) {
        super(0, armorClass, hp, con, str, wis, intel, dex, cha);
        this.cr = cr;
        this.exp = exp;
        this.swimSpeed = swimSpeed;
        this.groundSpeed = groundSpeed;
        this.flySpeed = flySpeed;
    }

    public double getCr() {
        return this.cr;
    }

    public void setCr(double cr) {
        this.cr = cr;
    }

    public int getexp() {
        return this.exp;
    }

    public void setexp(int exp) {
        this.exp = exp;
    }

    public int getSwimSpeed(){
        return swimSpeed;
    }

    public int getGroundSpeed(){
        return groundSpeed;
    }
    public int getFlySpeed(){
        return flySpeed;
    }

}