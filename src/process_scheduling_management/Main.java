package process_scheduling_management;

import process_scheduling_management.scheduling_queue_imp.HrnSchedulingQueue;

public class Main {
    public static void main(String[] args){

        ProcessPool processPool = new ProcessPool(new HrnSchedulingQueue());
        processPool.addProcess(new Process("write", 0, 10));
        processPool.addProcess(new Process("print", 1, 5));
        processPool.addProcess(new Process("read" , 4, 7));
//        processPool.printProcesses();
        processPool.start();

    }
}
