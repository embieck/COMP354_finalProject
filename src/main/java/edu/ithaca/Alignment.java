package edu.ithaca;

public enum Alignment {
    UNALIGNED, CHAOTICEVIL, LAWFULEVIL, NEUTRALEVIL, CHAOTICGOOD, LAWFULGOOD, NEUTRALGOOD, CHAOTICNEUTRAL,
    LAWFULNEUTRAL, TRUENEUTRAL;

    public String getAlignment(){
        return this.name();
    }
}
