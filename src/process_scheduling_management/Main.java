package process_scheduling_management;

import process_scheduling_management.scheduling_queue_imp.FcfsSchedulingQueue;
import process_scheduling_management.scheduling_queue_imp.HrnSchedulingQueue;
import process_scheduling_management.scheduling_queue_imp.RrSchedulingQueue;
import process_scheduling_management.scheduling_queue_imp.SjfSchedulingQueue;

import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args){


        //        processPool.addProcess(new Process("A", 0, 3));
//        processPool.addProcess(new Process("B", 2, 6));
//        processPool.addProcess(new Process("C" , 4, 4));
//        processPool.addProcess(new Process("D", 6, 5));
//        processPool.addProcess(new Process("E" , 8, 2));
//        processPool.printProcesses();


        final int num = 5;
        Random rd = new Random(System.currentTimeMillis());

        LinkedList<Process> processes = new LinkedList<>();

        for(int i =0 ;i< num;i++){
            processes.add(new Process(String.valueOf(i), rd.nextInt(10), rd.nextInt(10)+1));
        }

        ProcessPool fcfs = new ProcessPool(new FcfsSchedulingQueue());
        ProcessPool hrn = new ProcessPool(new HrnSchedulingQueue());
        ProcessPool rr = new ProcessPool(new RrSchedulingQueue());
        ProcessPool sjf = new ProcessPool(new SjfSchedulingQueue());


        System.out.println("--fcfs------");
        fcfs.addProcesses(processes);
        fcfs.start();
        fcfs.printInfo();

        System.out.println("--sjf------");
        sjf.addProcesses(processes);
        sjf.start();
        sjf.printInfo();

        System.out.println("--rr------");
        rr.addProcesses(processes);
        rr.start();
        rr.printInfo();

        System.out.println("--hrn------");
        hrn.addProcesses(processes);
        hrn.start();
        hrn.printInfo();







    }
}
