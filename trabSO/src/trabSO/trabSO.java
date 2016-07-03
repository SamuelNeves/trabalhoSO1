package trabSO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;




public class trabSO {
	public static 	Process[] buffer=null;
public static void main(String [] args) throws IOException{
		int M=3;
		buffer= new Process[M];
		int numberOfClients=5;
		
//		System.out.println("Insira o tamanho do buffer: ");
//		Scanner s = new Scanner(System.in);
//		M=s.nextInt();
		M=3;
//		Process buffer[]= new Process[M];
		
		Client[] c= new Client[numberOfClients];
		for(int i=0;i<numberOfClients;i++){
			c[i]=new Client(i);
		}
	
}

}

