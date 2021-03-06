package process_scheduling_management.scheduling_queue_imp;

import process_scheduling_management.Process;
import process_scheduling_management.SchedulingQueue;



public class RrSchedulingQueue extends SchedulingQueue {

    private int flag = -1;
    @Override
    protected void addProcess(Process process){
        schedulingQueue.add(process);
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

        int size = schedulingQueue.size();
        flag++;
        flag %= size;
        Process process = schedulingQueue.get(flag);
        for(Process pro:schedulingQueue){
            System.out.printf("\033[1;32mprocess %s\033[0m | ", pro.processName);
        }
        System.out.println();
        System.out.println(totalTime+": process "+process.processName);

        for(int i = 0; i< size ;i++){
            if(i != flag ){
                schedulingQueue.get(i).waitTime++;
            }
        }
        process.leftServiceTime--;
        if (process.leftServiceTime ==0){
            process.finishTime = totalTime;
            process.turnAroundTime =1+ process.finishTime - process.arriveTime;
            process.weightedTurnAroundTime = (process.turnAroundTime)/(double)process.serviceTime;
            removeProcess(process);
        }


    }
}
