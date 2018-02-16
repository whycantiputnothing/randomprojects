import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CPUScheduling {
    List<Process> list;
    int numberOfProcesses;

    public CPUScheduling() {
        list = new ArrayList<Process>();
    }

    public static void main(String[] args) throws FileNotFoundException {
        CPUScheduling cpu = new CPUScheduling();
        cpu.readFile();
        for (Process a : cpu.list) {
            System.out.println(a.name);
            System.out.println(a.burstTime);
        }
        cpu.FCFS();
    }

    public void readFile() throws FileNotFoundException {
        File file = new File("testdata1.txt");
        Scanner input = new Scanner(file);
        int counter = 0;
        Process process = new Process();
        int num = 0;
        while (input.hasNextLine()) {
            num++;
            if (counter == 0) {
                process.name = input.nextLine();
                counter++;
            } else {
                process.burstTime = Integer.parseInt(input.nextLine());
                list.add(process);
                process = new Process();
                counter = 0;
            }
        }
        numberOfProcesses = num/2;
        input.close();
    }
    
    public void FCFS(){
        int time = 1;
        int counter = 0;
        int complete = 0;
        Process p = new Process();
        while(complete < numberOfProcesses) {
                p = list.get(counter);
                System.out.println("Time: " + time);
                System.out.println("\tJob Name: " + p.name);
                if(!p.complete) {
                    p.workTime++;
                    if (p.workTime == p.burstTime) {
                        p.completeTime = time;
                        p.complete = true;
                        complete++;
                        System.out.println("\t\t" + p.name + " completed");
                    }              
                }
                time++;
                counter++;
                if(counter > numberOfProcesses - 1) {
                    counter = 0;
                }                
        }
        output();
    }
    
    public void output(){
        
        double avgWaitingTime = 0;
        double avgCompleteTime = 0;
        for (Process p : list) {
            avgCompleteTime += p.completeTime;
            avgWaitingTime += p.completeTime - p.burstTime;
        }
        avgCompleteTime = avgCompleteTime/numberOfProcesses;
        avgWaitingTime = avgWaitingTime/numberOfProcesses;
        System.out.println("Average waiting time: " + avgWaitingTime);
        System.out.println("Average Complete Time: " + avgCompleteTime);
        
    }

}
