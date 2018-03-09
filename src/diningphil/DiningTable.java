package diningphil;

/*
 * CS409 Team Project
 * March 21, 2018
 * Tannenbaum's Solution to the Dining Philosophers Solution
 * Team 2
 * Matthew Annerton, Dina Brown, Tristan Cone, Quang Tran
 *
 * @author drums
 */

import java.util.ArrayList;

/*
 * This function sets the arrays for the philosophers
 * and the forks at the dining table.
 * @param diners 	This sets the diners
 * @param forks 	This sets the forks
 */

public class DiningTable {
    private ArrayList<Philosopher> diners = new ArrayList<>();
    private ArrayList<Fork> forks = new ArrayList<>();

    public ArrayList<Philosopher> getDiners() {

        return diners;
    }
    public void setDiners(ArrayList<Philosopher> diners) {

        this.diners = diners;
    }
    public ArrayList<Fork> getForks() {
            return forks;
    }
    public void setForks(ArrayList<Fork> forks) {

        this.forks = forks;
    }

}
