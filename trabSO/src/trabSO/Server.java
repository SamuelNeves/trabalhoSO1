package trabSO;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class Server implements Runnable{
	Client[] client;
	PandC buffer;	
	Semaphore semaphoreFullBuffer;
	Semaphore semaphoreEmptyBuffer;
	Lock mutex;
	int totalProcessed;
	int totalOfProcess;
	public Server(PandC buffer,Semaphore s, Lock m,Semaphore s2,Client[] c){
		client=c;
		semaphoreFullBuffer=s;
		semaphoreEmptyBuffer=s2;
		mutex=m;
		this.buffer=buffer;
		this.totalProcessed=0;
		totalProcessed=0;
		for(Client i: c){
			totalOfProcess+=i.getNumberOfProcess();
		}
		
	}
	
//	private  boolean checkClients(){
//		for(Client i: client){
////			System.out.println("ID"+i.id);
//			if(i.P.size()!=0 ){	
//				return true;
//			}
//		}
//		return false;
//	}
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
		Process retorno = null;
		while(totalProcessed<totalOfProcess){
			
		try {
			semaphoreEmptyBuffer.acquire();
//			System.out.println("saiu laço");
			mutex.lock();
				if(buffer.getCont()!=0)	{
					retorno=remove();
					
					System.out.println("Processo: "+ retorno.getName()+ " Tempo de Execução: "+ retorno.getTimeOfExecution());
					System.out.println("TOtal processado:"+(totalProcessed));
					Thread.sleep(100*retorno.getTimeOfExecution());
				}
	
			mutex.unlock();
			semaphoreFullBuffer.release();	
//			try {
//				this.wait(10*retorno.getTimeOfExecution());
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		}
	}
	
	
	
	
}