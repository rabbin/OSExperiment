package memory_management;

import java.util.LinkedList;

public abstract class PageTable {
    public LinkedList<Integer> pageTable ;
    public int size;
    public abstract Integer  lookup(Integer pageNum);

}
