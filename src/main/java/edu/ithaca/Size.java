package edu.ithaca;

public enum Size {
    TINY, SMALL, MEDIUM, LARGE, HUGE, GARGANTUAN,VARIES;
    public String getSize(){
        return this.name();
    }
}
