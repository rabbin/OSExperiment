package process_scheduling_management;

import process_scheduling_management.scheduling_queue_imp.FcfsSchedulingQueue;
import process_scheduling_management.scheduling_queue_imp.HrnSchedulingQueue;
import process_scheduling_management.scheduling_queue_imp.RrSchedulingQueue;
import process_scheduling_management.scheduling_queue_imp.SjfSchedulingQueue;

public class Main {
    public static void main(String[] args){


        ProcessPool processPool = new ProcessPool(new RrSchedulingQueue());
        processPool.addProcess(new Process("A", 0, 3));
        processPool.addProcess(new Process("B", 2, 6));
        processPool.addProcess(new Process("C" , 4, 4));
        processPool.addProcess(new Process("D", 6, 5));
        processPool.addProcess(new Process("E" , 8, 2));
//        processPool.printProcesses();
        processPool.start();

    }
}
