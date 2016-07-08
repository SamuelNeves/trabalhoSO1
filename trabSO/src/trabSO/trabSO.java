package trabSO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;




public class trabSO {

public static void main(String [] args) throws IOException{
		int M=6;
		int nOfClients=3;
		PandC PC = new PandC(M);
//		buffer= new Process[M];
//		Scanner s = new Scanner(System.in);
//		System.out.println("Insira o numero de clientes:");
//		nOfClients=s.nextInt();
//		System.out.println("Insira o tamanho do buffer: ");
//		M=s.nextInt();
//		
		Client[] c= new Client[nOfClients];
		Server server= new Server(PC);
		Thread thread1[]= new Thread[nOfClients];
		
		Thread thread2= new Thread(server);
		thread2.start();
		for(int i=0;i<nOfClients;i++){
			c[i]=new Client(i,PC);
			thread1[i]= new Thread(c[i]);
			thread1[i].start();
		}
		
		
}

}

