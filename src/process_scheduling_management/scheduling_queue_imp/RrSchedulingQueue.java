package process_scheduling_management.scheduling_queue_imp;

import process_scheduling_management.Process;
import process_scheduling_management.SchedulingQueue;



public class RrSchedulingQueue extends SchedulingQueue {

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



    }
}
