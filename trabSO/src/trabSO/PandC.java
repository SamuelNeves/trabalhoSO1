package trabSO;
public class PandC{
	private int sizeOfBuffer;
	private int cont;
	private int in;
	private int out;
	private Process[] buffer;
	
	public PandC(int sizeOfBuffer){
		this.cont=0;
		this.in= 0;
		this.out=0;
		this.sizeOfBuffer=sizeOfBuffer;	
		buffer=new Process[sizeOfBuffer];
			
		
	}

	public int getSizeOfBuffer() {
		return sizeOfBuffer;
	}

	public void setSizeOfBuffer(int sizeOfBuffer) {
		this.sizeOfBuffer = sizeOfBuffer;
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	public int getIn() {
		return in;
	}

	public void setIn(int in) {
		this.in = in;
	}

	public int getOut() {
		return out;
	}

	public void setOut(int out) {
		this.out = out;
	}

	public Process[] getBuffer() {
		return buffer;
	}

	public void setBuffer(Process[] buffer) {
		this.buffer = buffer;
	}
	
	public void insert(int index,Process item){
		
		buffer[index]=item; 
	}
}