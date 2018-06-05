package memory_management.PageTableImp;

import memory_management.PageTable;

import java.util.LinkedList;


public class LruPageTable extends PageTable {

    public LruPageTable(int size){
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
            pageTable.remove(index);
            pageTable.addFirst(pageNum);
            return null;
        }
        else if(index < size){
            pageTable.addFirst(pageNum);

        }
        else{
            pageTable.removeLast();
            pageTable.addFirst(pageNum);
        }

        return pageNum;
    }


}
