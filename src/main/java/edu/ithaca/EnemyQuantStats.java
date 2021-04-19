package edu.ithaca;

public class EnemyQuantStats extends QuantativeStats {
    public double cr;
    public int exp;

    /**
     * 
     * @param cr  - Combat rating, can range from 0-30
     * @param exp - Eexperience points
     */
    public EnemyQuantStats(double cr, int exp, int moveSpeed, int armorClass, int hp, int con, int str, int wis, int intel, int dex,
    int cha) {
        super(moveSpeed, armorClass, hp, con, str, wis, intel, dex, cha);
        this.cr = cr;
        this.exp = exp;
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

}