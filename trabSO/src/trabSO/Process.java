package trabSO;

public class Process{
	Process(String name,int timeOfExecution){
		this.name = name;
		this.timeOfExecution = timeOfExecution;
	}
	String name;
	int timeOfExecution;
	public String getName() {
		return name;
	}
	public int getTimeOfExecution() {
		return timeOfExecution;
	}
	@Override
	public String toString() {
		return "Process [name=" + name + ", timeOfExecution=" + timeOfExecution + "]";
	}
	
	
	
}