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

    public Process(String processName,int arriveTime,int serviceTime){
        this.processName = processName;
        this.arriveTime = arriveTime;
        this.serviceTime = serviceTime;
        this.leftServiceTime = serviceTime;
    }
    public Process(Process process){
        this.processName = process.processName;
        this.arriveTime = process.arriveTime;
        this.serviceTime = process.serviceTime;
        this.leftServiceTime = process.leftServiceTime;
    }

    @Override
    public String toString() {
        return ""+
                String.format("%-15s%-15d%-15d%-15d%-15d%-15d%-15.2f",
                        processName,arriveTime, serviceTime,waitTime, finishTime,turnAroundTime, weightedTurnAroundTime);
    }

}
