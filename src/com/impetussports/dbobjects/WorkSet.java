/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impetussports.dbobjects;

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

 // sets contain reps, ditsanceData, averageVelocity, setGoals(based on percentage of max), setStats

@Entity
public class WorkSet implements Serializable {
    
    @Id
    private double setNumber;
//    private List<Double> setDistanceData;
    private double weight;
    private double averageMaxVelocity;
    private double averageVelocity;
    private double maxVelocity;
    private double targetWeight;
    private double targetMaxVelocity;
    private double targetAverageVelocity;
    private double setScore;
    private double setTotalDistanceTraveled;  
    private double targetPercentageOfMax;
    private double numberOfRepetitions;
    private double targetNumberOfRepetitions;
    
    @ManyToOne
    @JoinColumn(name="exercise_id")
    private Exercise exercise;
    
    
    @OneToMany(mappedBy = "workset")
    private List<Repetition> Repetitions;
    
}
