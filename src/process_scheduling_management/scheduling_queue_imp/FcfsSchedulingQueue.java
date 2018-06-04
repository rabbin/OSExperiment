package process_scheduling_management.scheduling_queue_imp;

import process_scheduling_management.Process;
import process_scheduling_management.SchedulingQueue;


public class FcfsSchedulingQueue extends SchedulingQueue {

    @Override
    protected void addProcess(Process process){
        schedulingQueue.addFirst(process);
    }

    @Override
    protected void removeProcess(Process process){
        schedulingQueue.remove(process);
    }
    @Override
    protected void sort(){

    }
    @Override
    protected void run(int totalTime) {

        Process process = schedulingQueue.getLast();

        int size = schedulingQueue.size();
        for (int i = 0; i<size-1; i++){
            schedulingQueue.get(i).waitTime++;
        }

        process.leftServiceTime--;
        if (process.leftServiceTime ==0){
            process.finishTime = totalTime;
            process.turnAroundTime = process.finishTime - process.arriveTime+1;
            process.weightedTurnAroundTime = (process.turnAroundTime)/(double)process.serviceTime;
            System.out.println(process);
            removeProcess(process);
        }

    }
}
