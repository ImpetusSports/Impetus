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

/**
 *
 * @author Michael Orner
 */
// reps contain repStats(weight, distanceData, maxVelocity, power, acceleration, jerk, snap, crackle, pop, distanceTraveled)  
@Entity
public class Repetition implements Serializable {

    @Id
    private double repetitionNumber;
    private double maxVelocity;
    private double averageVelocity;
    private double jerk;
    private double crackle;
    private double snap;
    private double pop;
    private double power;
    private double repetitionDistanceTraveled;
 //   private List<Double> repetitionDistanceData;
    
    @ManyToOne
    @JoinColumn(name="workset_id")
    private WorkSet workset;
}
