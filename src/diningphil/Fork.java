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

/*
 * This function creates the forks and sets the
 * forks as available
 * @param isAvailable		This sets the forks to
 * 					available when they
 *					become available.
 */

public class Fork {
    private boolean isAvailable = true;
    private int id;

    public Fork(int id) {
            super();
            this.id = id;
    }

    public synchronized boolean isAvailable() {
            return isAvailable;
    }

    public synchronized void setAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
    }

    public String toString(){
            return id + "";
    }
}