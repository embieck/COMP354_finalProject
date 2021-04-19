package edu.ithaca;

public class EnemyQuantStats {
    public double cr;
    public int exp;

    public EnemyQuantStats() {
        this.cr = 0;
        this.exp = 0;
    }

    /**
     * 
     * @param cr  - Combat rating, can range from 0-30
     * @param exp - Experience points
     */
    public EnemyQuantStats(double cr, int exp) {
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