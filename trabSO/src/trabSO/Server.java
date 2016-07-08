package trabSO;

public class Server implements Runnable{
	
	PandC buffer;	
	
	
	public Server(PandC buffer){
		
		this.buffer=buffer;
		
		
	}
	public Process remove(){
		
		while(buffer.getCont()==0);
		Process item=buffer.getBuffer()[buffer.getOut()];
		buffer.setCont(buffer.getCont()-1);
		buffer.setOut((buffer.getOut()+1)%buffer.getSizeOfBuffer());
		
		return item;
	}
	public void run(){
		Process retorno;
		while(true){
			System.out.println("Server");
		retorno=remove();
		System.out.println("Processo: "+ retorno.getName()+ " Tempo de Execução: "+ retorno.getTimeOfExecution());
		System.out.println("EXECUTOU");
//		try {
//			this.wait(10*retorno.getTimeOfExecution());
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		}
	}
	
	
	
	
}