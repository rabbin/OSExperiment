package process_scheduling_management;

import java.util.LinkedList;

public abstract class SchedulingQueue {
    protected LinkedList<Process> schedulingQueue = new LinkedList<>();

    protected abstract void addProcess(Process process);

    protected abstract void removeProcess(Process process);

    protected abstract void sort();

    protected abstract void run(int totalTime);
}
