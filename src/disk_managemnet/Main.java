package disk_managemnet;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args){

        System.out.println("SSTF: ");
        LinkedList<Integer> requestQueueSSTF = new LinkedList<>();
        requestQueueSSTF.add(98);
        requestQueueSSTF.add(183);
        requestQueueSSTF.add(37);
        requestQueueSSTF.add(122);
        requestQueueSSTF.add(14);
        requestQueueSSTF.add(124);
        requestQueueSSTF.add(65);
        requestQueueSSTF.add(67);
        DiskManageService sstf = new DiskManageService(DiskManageService.Type.SSTF, requestQueueSSTF);

        sstf.start(53);

        System.out.println("SCAN: ");
        LinkedList<Integer> requestQueueSCAN = new LinkedList<>();
        requestQueueSCAN.add(98);
        requestQueueSCAN.add(183);
        requestQueueSCAN.add(37);
        requestQueueSCAN.add(122);
        requestQueueSCAN.add(14);
        requestQueueSCAN.add(124);
        requestQueueSCAN.add(65);
        requestQueueSCAN.add(67);

        DiskManageService scan = new DiskManageService(DiskManageService.Type.SCAN, requestQueueSCAN);

        scan.start(53);





    }
}
