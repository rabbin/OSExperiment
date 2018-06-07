package process_scheduling_management.scheduling_queue_imp;

import process_scheduling_management.Process;
import process_scheduling_management.SchedulingQueue;

import java.util.Collections;
import java.util.Comparator;

public class SjfSchedulingQueue extends SchedulingQueue {

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
                return (p1.serviceTime -p2.serviceTime);
            }
        });
    }

    @Override
    protected void run(int totalTime) {

        Process process = schedulingQueue.getFirst();

        for(Process pro:schedulingQueue){
            System.out.printf("\033[1;32mprocess %s : %d\033[0m | ", pro.processName,pro.serviceTime);
        }
        System.out.println();
        System.out.println(totalTime+": process "+process.processName);

        int size = schedulingQueue.size();
        for (int i = 1; i<size; i++){
            schedulingQueue.get(i).waitTime++;
        }

        process.leftServiceTime--;
        if (process.leftServiceTime ==0){
            process.finishTime = totalTime;
            process.turnAroundTime = process.finishTime - process.arriveTime + 1;
            process.weightedTurnAroundTime = (double)(process.turnAroundTime)/process.serviceTime;
            removeProcess(process);
        }
    }
}


