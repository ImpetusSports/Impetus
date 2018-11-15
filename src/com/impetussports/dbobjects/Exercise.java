/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impetussports.dbobjects;

import com.impetussports.impetus.ExerciseType;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 *
 * @author Michael Orner
 */
// exercises contain sets, exerciseGoals, excerciseStats(max)

@Entity
public class Exercise implements Serializable {
    
    @Id
    private ExerciseType exerciseType;
    private double numberOfSets;
    private double targetNumberOfSets;
    private double targetMax;
    private double calculatedMax;
    private double score;
    
    @ManyToOne
    @JoinColumn(name="workout_id")
    private Workout workout;
   
    @OneToMany(mappedBy = "exercise")
    private List<WorkSet> sets;
  
    
}
