package trabSO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Client implements Runnable{
	
	int id;
	ArrayList <Process> P= new ArrayList<Process>();
	public Client(int id){
		this.id=id;
		try {
			readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
System.out.println(P.toString());

br.close();
}

public void run(){
	
	
	
	
	
	
	
	
}
	
}