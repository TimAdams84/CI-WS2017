package main07;

import java.util.concurrent.ThreadLocalRandom;

public class Aufgabe01 {

	public static void main(String[] args) {
		
		double sum = 0;
		long maxit = 100000000;
		
		for (int j = 0; j < maxit; j++) {
			for (int i = 0; i <3; i++) {
				double rnd = ThreadLocalRandom.current().nextInt(0, 32);
				double sign = ThreadLocalRandom.current().nextInt(0, 1);
				if(sign==0){
					sum += Math.pow(2, rnd);
				}
				else{
					sum -= Math.pow(2, rnd);
				}
				
					
			}	
			if(j%(maxit/100)==0){
				System.out.print("|");
			}
		}
		System.out.println("Berechnung fertig!");
		sum = sum/maxit;

		System.out.println("Die durchschnittliche Änderung beträgt "+sum+"!");
		
		
		
	}
}
