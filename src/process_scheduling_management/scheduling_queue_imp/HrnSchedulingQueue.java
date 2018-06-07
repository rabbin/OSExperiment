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
                double res =prority2 - prority1;
                if(res >0){
                    return 1;
                }else if(res < 0){
                    return -1;
                }else{
                    return 0;
                }

            }
        });
    }
    @Override
    protected void run(int totalTime) {

        sort();

        Process process = schedulingQueue.getFirst();

        for(Process pro:schedulingQueue){
            System.out.printf("\033[1;32mprocess %s: %.2f\033[0m | ",pro.processName ,(pro.arriveTime+pro.waitTime)/(double)pro.serviceTime);
        }
        System.out.println();
        System.out.println(totalTime+ ": process "+process.processName);

        int size = schedulingQueue.size();
        for (int i = 1; i<size; i++){
            schedulingQueue.get(i).waitTime++;
        }

        process.leftServiceTime--;
        if (process.leftServiceTime ==0){
            process.finishTime = totalTime;
            process.turnAroundTime = process.finishTime - process.arriveTime + 1;
            process.weightedTurnAroundTime = (double)(process.turnAroundTime)/process.serviceTime;
            schedulingQueue.removeFirst();
        }

    }
}
