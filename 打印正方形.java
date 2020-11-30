package com.pratiace;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        ang = ((n-2)*180)/n;
        while(count < n){
            pen.fd(key);
            pen.rt(ang);
        }
        Scanner s = new Scanner(System.in);
        System.out.println("input key:");
        int key = s.nextInt();

        for (int i = 0; i < key; i++) {
            if (i == 0 | i == key-1) {
                for (int j = 0; j < key; j++) {

                    if(j == key-1){
                        System.out.println("-");
                    }else{
                        System.out.print("-");
                    }
                }
            } else {
                for (int k = 0; k < key; k++) {
                    if ( k == 0) {
                        System.out.print("-");
                    } else {
                        if(k == key-1){
                            System.out.println("-");
                        }else{
                            System.out.print(" ");
                        }

                    }
                }

            }

        }

        return;
    }

}



p