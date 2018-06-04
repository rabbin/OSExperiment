package process_scheduling_management;

public class Process {
    public String processName;
    public  int arriveTime;
    public  int serviceTime;
    public  int waitTime;
    public  int leftServiceTime;
    public int finishTime;
    public int turnAroundTime;
    public double weightedTurnAroundTime;

    Process(String processName,int arriveTime,int serviceTime){
        this.processName = processName;
        this.arriveTime = arriveTime;
        this.serviceTime = serviceTime;
        this.leftServiceTime = serviceTime;
    }

    @Override
    public String toString() {
        return "process name: "+ processName+
                ", arrive time: "+ arriveTime+
                ", service time: "+ serviceTime+
                ", wait time: "+ waitTime+
                ", finish time: "+ finishTime+
                ", turn arround time: "+ turnAroundTime+
                ", weighted turn arround time:"+ String.format("%.2f", weightedTurnAroundTime);
    }

}
