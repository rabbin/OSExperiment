package memory_management;

import memory_management.PageTableImp.FifoPageTable;
import memory_management.PageTableImp.LruPageTable;

import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args){

        final int len = 20;
        final int size = 3;

        Random rd = new Random(System.currentTimeMillis());
        LinkedList<Integer> pageSequence = new LinkedList<>();
        for(int i =0; i<len;i++){
            pageSequence.add(rd.nextInt(15));
        }

        System.out.println("LRU:");
        MemoryService lru=  new MemoryService(new LruPageTable(size), pageSequence);
        lru.start();
        lru.printInfo();

        System.out.println("-------------------------------");
        System.out.println("FIFO:");
        MemoryService fifo=  new MemoryService(new FifoPageTable(size), pageSequence);
        fifo.start();
        fifo.printInfo();

    }
}
