package com.company;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Skriv inn linje 1 punkt 1 x og y koordinat: ");
        double p1[] = {scan.nextDouble(), scan.nextDouble()};
        System.out.print("Skriv inn linje 1 punkt 2 x og y koordinat: ");
        double q1[] = {scan.nextDouble(), scan.nextDouble()};

        System.out.print("Skriv inn linje 2 punkt 1 x og y koordinat: ");
        double p2[] = {scan.nextDouble(), scan.nextDouble()};
        System.out.print("Skriv inn linje 2 punkt 2 x og y koordinat: ");
        double q2[] = {scan.nextDouble(), scan.nextDouble()};

        System.out.println("linje a: [x"+ p1[0]+", y"+p1[1]+"] og [x"+q1[0]+", y"+q1[1]+"]");
        System.out.println("linje b: [x" +p2[0]+", y"+p2[1]+"] og [x"+q2[0]+", y"+q2[1]+"]");

        Point2D.Double punktP = new Point2D.Double(p1[0], p1[1]);
        Point2D.Double punktQ = new Point2D.Double(q1[0], q1[1]);
        Point2D.Double punktP2 = new Point2D.Double(p2[0], p2[1]);
        Point2D.Double punktQ2 = new Point2D.Double(q2[0], q2[1]);
        testen(punktP, punktQ, punktP2, punktQ2);

    }

// hvis (p1, q1, p2 og p1, q1, q2) og (p2, q2, p1 og p2, q2, q1) har forskjellig retning
    // eller (p1, q1 p2), (p1 q1 q2)(p2 q2 p1) p2 q2 q1) er på samme linje OG ((p1, q1)og(p2 q2) toucher x) eller y

    public static int retning(Point2D.Double p, Point2D.Double q, Point2D.Double r){
        // siden vi sjekker 3 punkter kan vi se om de heller fra hverandre og i hvilken vinkel. hvis det er en negativ vinkel er det anticlockwise og om det er en positiv vinkel er den clockwise. er den 0, er alle på linjke
        double verdi = (q.y-p.y)*(r.x-q.x)-(q.x-p.x)*(r.y-q.y);
        if(verdi ==0){
            return 0;
        } else if(verdi<0){
            System.out.println("anticlockwise");
            return 1;
        } else if(verdi>0){
            System.out.println("clockwise");
            return 2;
        }
        //hvis verdien er større enn 0 return 1 om ikke return 2. dvs 1 står for clockwise og 2 står for anticlockwise, dette er viktig etterpå da vi skal teste om kombinasjonene er like
       return -1;
    }
    public static boolean paLinje(Point2D.Double p, Point2D.Double q, Point2D.Double r){
        if(q.x<= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) && q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y)){
            return true;
        }
        return false;
    }

    public static boolean testen(Point2D.Double p1, Point2D.Double q1, Point2D.Double p2, Point2D.Double q2){
        int test1 = retning(p1, q1, p2);
        int test2 = retning(p1, q1, q2);
        int test3 = retning(p2, q2, p1);
        int test4 = retning(p2, q2, q1);

        if(test1 != test2 && test3 != test4){
            System.out.println("krysser");
            return true;
        }

        if(test1 == 0 && paLinje(p1, p2, q1)){
            System.out.println("ligger på linje test1");
            return true;
        }
        if (test2 ==0 && paLinje(p1, q2, q1)){
            System.out.println("ligger på linje test2");
            return true;
        }
        if (test3 == 0 && paLinje(p2, p1, q2)){
            System.out.println("ligger på linje test3");
            return true;
        }
        if(test4 == 0 && paLinje(p2, q1, q2)){
            System.out.println("ligger på linje test4");
            return true;
        }

        System.out.println("krysser ikke");
        return false;

    }

}
