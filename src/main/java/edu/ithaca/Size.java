package edu.ithaca;

public enum Size {
    TINY, SMALL, MEDIUM, LARGE, HUGE, GARGANTUAN;
    public String getSize(){
        return this.name();
    }
}
