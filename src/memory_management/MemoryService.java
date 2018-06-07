package memory_management;
import java.util.LinkedList;

public class MemoryService {
    LinkedList<Integer> pageSequence ;
    PageTable pageTable;
    LinkedList<Integer> eliminatedPage = new LinkedList<>();
    int sequenceLength;

    MemoryService(PageTable pageTable, LinkedList<Integer> pageSequence){

        this.pageSequence = pageSequence;
        this.pageTable = pageTable;

        sequenceLength = pageSequence.size();
    }

    void start(){
        for(int i = 0; i<sequenceLength;i++){

            Integer res = pageTable.lookup(pageSequence.get(i));
            System.out.printf("访问页面：%d ",pageSequence.get(i));
            if (res ==null){
                System.out.printf("命中\n");
            }else {
                System.out.printf("未命中\n");
            }
            eliminatedPage.add(res);

            System.out.print("\033[1;32m");
            for(Integer item: pageTable.pageTable){
                System.out.print(item+"\t");
            }
            System.out.println("\033[0m");
        }
    }

    void printInfo(){
        System.out.println("缺页情况：");
        for(int i = 0 ; i< sequenceLength; i++){
            System.out.print(pageSequence.get(i)+"\t");
        }
        System.out.println();
        int count= 0;
        for (int i = 0 ; i< sequenceLength; i++){
            if (eliminatedPage.get(i) ==null){
                System.out.print("y"+"\t");
            }else {
                System.out.print("n"+"\t");
                count++;
            }
        }
        System.out.println();


        System.out.println("缺页率："+String.format("%.2f", (double)(count*100)/sequenceLength) +"%");

    }

}
