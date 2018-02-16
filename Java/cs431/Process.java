import java.util.Comparator;

public class Process implements Comparator<Process> {
    int burstTime;
    int workTime;
    int completeTime;
    String name;
    boolean complete = false;
    public Process() {

    }

    public int compare(Process a, Process b) {
        return a.burstTime - b.burstTime;
    }
}
