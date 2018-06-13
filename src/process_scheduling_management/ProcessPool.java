package process_scheduling_management;

import process_scheduling_management.scheduling_queue_imp.SjfSchedulingQueue;

import java.util.LinkedList;

public class ProcessPool{
    private SchedulingQueue schedulingQueue;
    private LinkedList<Process> jobList = new LinkedList<>();
    private int totalTime = -1;

    public ProcessPool(SchedulingQueue schedulingQueue){
        this.schedulingQueue = schedulingQueue;
    }

    void addProcess(Process process){

        jobList.add(new Process(process));

    }

    public void addProcesses(LinkedList<Process> processes){

        for(Process process: processes){
            jobList.add(new Process(process));
        }
    }

    public void start(){

        int jobCount = jobList.size();
        while(true){

            totalTime++;

            int size = jobList.size();

            for (int i = 0; i<size; i++){
                Process process = jobList.get(i);
                if (process.arriveTime == totalTime){
                    schedulingQueue.addProcess(process);
                    jobCount--;
                }
            }
            if(schedulingQueue.schedulingQueue.size() == 0 && jobCount ==0){
                break;
            }else if(schedulingQueue.schedulingQueue.size() == 0){
                continue;
            }else{
                schedulingQueue.run(totalTime);
            }


        }


    }

    public void printInfo(){
        System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s%-15s%-15s","processName","arriveTime","serviceTime","waitTime","finishTime","turnAroundTime","weightedTurnAroundTime"));
        for(Process process: jobList){
            System.out.println(process);
        }
    }



}
