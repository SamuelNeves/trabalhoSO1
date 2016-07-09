package trabSO;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class Server implements Runnable{
	
	PandC buffer;	
	Semaphore semaphore;
	Semaphore semaphore2;
	Lock mutex;
	int totalProcessed;
	public Server(PandC buffer,Semaphore s, Lock m,Semaphore s2){
		semaphore=s;
		semaphore2=s2;
		mutex=m;
		this.buffer=buffer;
		this.totalProcessed=0;
		
	}
	public Process remove() throws InterruptedException{
		System.out.println(buffer.getCont());
		System.out.println(buffer.getCont());
		Process item=buffer.getBuffer()[buffer.getOut()];
		buffer.setCont(buffer.getCont()-1);
		buffer.setOut((buffer.getOut()+1)%buffer.getSizeOfBuffer());
		totalProcessed=totalProcessed+1;		
		return item;
	}
	public void run(){
		Process retorno;
		while(true){
			
		try {
			semaphore2.acquire();
			System.out.println("saiu laço");
			mutex.lock();
				if(buffer.getCont()!=0)	{
					retorno=remove();
					System.out.println("Processo: "+ retorno.getName()+ " Tempo de Execução: "+ retorno.getTimeOfExecution());
				
					System.out.println("TOtal processado:"+(totalProcessed));
				}
			mutex.unlock();
			semaphore.release();
			
			
//			try {
//				this.wait(10*retorno.getTimeOfExecution());
//			} catch (InterruptedException e) {
//				 TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		}
	}
	
	
	
	
}