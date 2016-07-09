package trabSO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;




public class trabSO {

public static void main(String [] args) throws IOException{
		int M=10;
		int nOfClients=4;
		PandC PC = new PandC(M);
//		buffer= new Process[M];
//		Scanner s = new Scanner(System.in);
//		System.out.println("Insira o numero de clientes:");
//		nOfClients=s.nextInt();
//		System.out.println("Insira o tamanho do buffer: ");
//		M=s.nextInt();
//		
		final Lock mutex= new ReentrantLock(true);
		Semaphore s=new Semaphore(M);
		Semaphore s2=new Semaphore(M);
		Client[] c= new Client[nOfClients];
		Server server= new Server(PC,s,mutex,s2);
		Thread clientThread[]= new Thread[nOfClients];
		
		Thread serverThread= new Thread(server);
		serverThread.start();
		for(int i=0;i<nOfClients;i++){
			c[i]=new Client(i,PC,s,mutex,s2);
			clientThread[i]= new Thread(c[i]);
			clientThread[i].start();
		}
		
		
}

}

