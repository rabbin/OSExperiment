package process_scheduling_management.scheduling_queue_imp;

import process_scheduling_management.Process;
import process_scheduling_management.SchedulingQueue;

import java.util.Collections;
import java.util.Comparator;


public class HrnSchedulingQueue extends SchedulingQueue {

    @Override
    protected void addProcess(Process process) {
        schedulingQueue.add(process);
        sort();
    }

    @Override
    protected void removeProcess(Process process) {
        schedulingQueue.remove(process);
        sort();
    }

    @Override
    protected void sort() {
        Collections.sort(schedulingQueue, new Comparator<Process>() {
            @Override
            public int compare(Process p1, Process p2) {
                double prority1 = (p1.arriveTime+p1.waitTime)/(double)p1.serviceTime;
                double prority2 = (p2.arriveTime+p2.waitTime)/(double)p2.serviceTime;

                return (int)(prority2 - prority1);
            }
        });
    }
    @Override
    protected void run(int totalTime) {


        Process process = schedulingQueue.getFirst();
        int size = schedulingQueue.size();
        for (int i = 1; i<size; i++){
            schedulingQueue.get(i).waitTime++;
        }

        process.leftServiceTime--;
        if (process.leftServiceTime ==0){
            process.finishTime = totalTime;
            process.turnAroundTime = process.finishTime - process.arriveTime + 1;
            process.weightedTurnAroundTime = (double)(process.turnAroundTime)/process.serviceTime;
            System.out.println(process);
            schedulingQueue.removeFirst();
        }
        sort();

    }
}
