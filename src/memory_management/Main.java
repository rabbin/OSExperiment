package memory_management;

import memory_management.PageTableImp.FifoPageTable;
import memory_management.PageTableImp.LruPageTable;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args){

        LinkedList<Integer> pageSequence = new LinkedList<>();
        pageSequence.addFirst(7);
        pageSequence.addFirst(7);
        pageSequence.addFirst(6);
        pageSequence.addFirst(5);
        pageSequence.addFirst(4);
        pageSequence.addFirst(1);
        pageSequence.addFirst(3);
        pageSequence.addFirst(2);
        pageSequence.addFirst(1);
        pageSequence.addFirst(1);


        MemoryService memoryService=  new MemoryService(new LruPageTable(3), pageSequence);
        memoryService.start();
        memoryService.printInfo();
    }
}
