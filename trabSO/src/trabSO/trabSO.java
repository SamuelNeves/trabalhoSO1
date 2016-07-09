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

public static void main(String [] args) throws IOException, InterruptedException{
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
		Semaphore semaphoreFullBuffer=new Semaphore(M);
		Semaphore semaphoreEmptyBuffer=new Semaphore(M);
		Client[] c= new Client[nOfClients];
		for(int i=0;i<nOfClients;i++){
			c[i]=new Client(i,PC,semaphoreFullBuffer,mutex,semaphoreEmptyBuffer);
			}
		Server server= new Server(PC,semaphoreFullBuffer,mutex,semaphoreEmptyBuffer,c);
		Thread clientThread[]= new Thread[nOfClients];
		
		Thread serverThread= new Thread(server);
		serverThread.start();
		for(int i=0;i<nOfClients;i++){
			clientThread[i]= new Thread(c[i]);
			clientThread[i].start();
		}
		serverThread.join();
		for(int i=0;i<nOfClients;i++){
		
			clientThread[i].join();
		}
		System.out.println("END KRL");
		
}

}

