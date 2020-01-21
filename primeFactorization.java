package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tallet = scan.nextInt();

            for(int i=2; i<tallet;i++){
                if(tallet%i==0){
                    System.out.print(i+"*");
                    tallet=tallet/i;
                }
                if(tallet%i==0){
                    System.out.print(i+"*");
                    tallet=tallet/i;
                }
                if(tallet%i==0){
                    System.out.print(i+"*");
                    tallet=tallet/i;
                }
                if(tallet%i==0){
                    System.out.print(i+"*");
                    tallet=tallet/i;
                }

            }

        if(tallet>1)
        System.out.print(tallet);

    }
}
