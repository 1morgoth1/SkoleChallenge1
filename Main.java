package com.company;

public class Main {

    public static void main(String[] args) {
    int teaParty1[] = {6, 8};
    int teaParty2[] = {3, 8};
    int teaParty3[] = {20, 6};

        // print                                            kaller på funksjon med array som input
        System.out.println("Teselskap 1 har en score på: "+kalkulasjon(teaParty1[0], teaParty1[1]));
        System.out.println("Teselskap 2 har en score på: "+kalkulasjon(teaParty2[0], teaParty2[1]));
        System.out.println("Teselskap 3 har en score på: "+kalkulasjon(teaParty3[0], teaParty3[1]));
    }
    public static int kalkulasjon(int te, int kaker){
        //kalkulasjonen for å bedømme teaparty score
        if(te<5 || kaker<5){
            return 0;
        } else if(te>(kaker*2) || kaker>(te*2)) {
            return 2;
        } else if(te >=5 && kaker>=5){
            return 1;
        }
        return -1;
    }
}
