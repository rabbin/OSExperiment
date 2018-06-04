package memory_management.PageTableImp;

import memory_management.PageTable;

import java.util.LinkedList;

public class FifoPageTable extends PageTable{


    public FifoPageTable(int size){
        pageTable = new LinkedList<>();
        this.size =size;
    }
    @Override
    public Integer lookup(Integer pageNum) {
        int sizeT = pageTable.size();
        int index ;
        for(index =0; index<sizeT; index++){
            if(pageTable.get(index).equals(pageNum) ){
                break;
            }
        }

        if(index< sizeT){
            return null;
        }
        else if(index < size){
            pageTable.addFirst(pageNum);
            return pageNum;
        }
        else{
            pageTable.removeLast();
            pageTable.addFirst(pageNum);
            return pageNum;
        }

    }

}
