package de.fh_kiel.oop;

import processing.core.PApplet;
import processing.core.PImage;

public class SeifenspenderProcessing extends PApplet {
    PImage bg;
    float TOP_EDGE = 270;
    float BOTTOM_EDGE = 480;
    double MILILITER;
    int COUNT;
    Seifenspender sfProcessing = new Seifenspender();

    public void settings() {
        bg = loadImage("seifenspender.png");
        size(bg.width, bg.height);
        MILILITER = 1000 / (BOTTOM_EDGE - TOP_EDGE);
    }

    public void draw() {
        background(bg);
        rect(75, TOP_EDGE, 240, BOTTOM_EDGE, 0, 0, 30, 30);
        fill(0, 255, 255);
    }

    public void mousePressed() {
        if (sfProcessing.getSeife() > 0) {
            // Seife entnehmen
            TOP_EDGE += MILILITER;
            BOTTOM_EDGE -= MILILITER;
            sfProcessing.seifendosisEntnehmen();
            COUNT++;
            System.out.println(COUNT + ". Restseife: " + sfProcessing.getSeife() + "ml");
        }
        else {
            // Seife nachfüllen
            System.out.println("Seife ist leer, bitte Rechtsklicken!");
            if (mouseButton == RIGHT) {
                sfProcessing.seifeNachfuellen();
                System.out.println("####################\nSeife aufgefüllt: " + sfProcessing.getSeife() + "ml");
                COUNT = 1;
                TOP_EDGE = 270;
                BOTTOM_EDGE = 480;
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("de.fh_kiel.oop.SeifenspenderProcessing");
    }

}
