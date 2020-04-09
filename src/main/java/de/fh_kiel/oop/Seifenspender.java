/*
 * Author: Oliver Gorczyca
 * Aufgabe 3
 * */
package de.fh_kiel.oop;

public class Seifenspender {
    private double seife = 1000.0;

    public double getSeife() {
        return seife;
    }

    public void setSeife(double seife) {
        this.seife = seife;
    }

    public boolean seifendosisEntnehmen() {
        if (seife > 0) {
            seife -= 10;
            return true;
        } else {
            return false;
        }
    }

    public void seifeNachfuellen() {
        setSeife(1000);
    }

}
