/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impetussports.impetus;

/**
 *
 * @author Michael Orner
 */
public enum ExerciseType {
    SQUAT("Squat"),
    BENCH("Bench"),
    CLEAN("Clean"),
    DEADLIFT("Dead Lift"),
    PRESS("Press"),
    HANGCLEAN("Hang Clean"),
    ROW("Row");
    ;

    private final String text;

    /**
     * @param text
     */
    ExerciseType(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
    
}
