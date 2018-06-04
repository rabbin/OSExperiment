package process_scheduling_management;

import java.util.LinkedList;

public class ProcessPool {
    SchedulingQueue schedulingQueue;
    LinkedList<Process> jobList = new LinkedList<>();
    int totalTime = -1;

    ProcessPool(SchedulingQueue schedulingQueue){
        this.schedulingQueue = schedulingQueue;
    }

    void addProcess(Process process){

        jobList.add(process);

    }

    void start(){



        while(true){

            totalTime++;

            int size = jobList.size();

            for (int i = 0; i<size; i++){
                Process process = jobList.get(i);
                if (process.arriveTime == totalTime){
                    schedulingQueue.addProcess(process);
                }
            }
            if(schedulingQueue.schedulingQueue.size() == 0){
                break;
            }
            schedulingQueue.run(totalTime);

        }
    }



}
