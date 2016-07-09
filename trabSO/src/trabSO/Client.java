package trabSO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;



public class Client  implements Runnable{
	
	int id;
	PandC buffer;
	ArrayList <Process> P= new ArrayList<Process>();
	
	private Lock mutex;
	private Semaphore semaphore;
	private Semaphore semaphore2;
	public Client(int id, PandC buffer, Semaphore semaphore, Lock m,Semaphore semaphore2){
		this.id=id;
		this.mutex=m;
		this.semaphore=semaphore;
		this.semaphore2=semaphore2;
		try {
			readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.buffer=buffer;
	}
	

public void readFile() throws IOException
{		
//Reading File
FileReader f=null;
BufferedReader br =null;
try {// tenta ler o arquivo
    f = new FileReader("src/trabSO/processlist"+Integer.toString(this.id) +".dat"); // associa var a arquivo
    br= new BufferedReader(f);// abre arquivo p/ler
    String linha;
    while((linha=br.readLine())!=null){
	String[] P1 = linha.split(" ");
	String nome = "Cliente "+this.id+" Processo: " +P1[0];   
	int tempo = Integer.parseInt(P1[1]);
	P.add(new Process(nome,tempo));
	
	}
 } catch (IOException e) {
    e.printStackTrace();
} finally {
    if(f !=null){f.close();}
}
//System.out.println(P.toString());

br.close();
}
public void run(){
//	int aux=0;
	while(P.size()!=0){
//		aux++;
//		System.out.println("cliente"+ this.id);
		if(P.size()!=0)
			try {
				semaphore.acquire();
				mutex.lock();
					insert(P.remove(0));	
				mutex.unlock();
//				semaphore.release();
				semaphore2.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			break;
	}
	}

public void insert( Process item ) throws InterruptedException{
	
//	while(buffer.getCont()==buffer.getSizeOfBuffer()){
//		System.out.println("Esperando para inserir");
//	}

	buffer.setCont(buffer.getCont()+1);
	buffer.insert(buffer.getIn(),item);
	buffer.setIn((buffer.getIn()+1)%buffer.getSizeOfBuffer());
	System.out.println("Inseriu");
	System.out.println(buffer.getCont());
//	semaphore2.release();

}



	
}