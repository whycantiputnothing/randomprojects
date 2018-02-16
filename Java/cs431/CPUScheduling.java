import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CPUScheduling {
    List<Process> list;
    int numberOfProcesses;

    public CPUScheduling() {

    }

    public static void main(String[] args) {
        CPUScheduling cpu = new CPUScheduling();
        cpu.readFile("testdata1.txt");
        cpu.FCFS();
        cpu.readFile("testdata1.txt");
        cpu.SJF();
        cpu.readFile("testdata1.txt");
        cpu.rr2();
        cpu.readFile("testdata1.txt");
        cpu.rr5();
        
    }

    public void readFile(String name) {
        list = new ArrayList<Process>();
        Scanner input = null;
        try {
            File inputFile = new File(name);
            input = new Scanner(inputFile);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("file not found");
        }
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
        numberOfProcesses = num / 2;
        input.close();
    }

    private void FCFS() {
        int time = 1;
        for (Process p : list) {
            while (p.workTime < p.burstTime) {
                System.out.println("Time: " + time);
                System.out.println("\tJob Name: " + p.name);
                p.workTime++;
                if (p.workTime == p.burstTime) {
                    p.completeTime = time;
                    System.out.println("\t\t" + p.name + " completed");
                }
                time++;

            }
        }
        output();
    }

    private void SJF() {
        list.sort(new Process());
        FCFS();
    }
    
    private void rr(int timeSlice) {
        int time = 0;
        int counter = 0;
        int complete = 0;
        Process p = new Process();
        while(complete < numberOfProcesses) {
            p = list.get(counter);
            if(!p.complete) {
                for(int i = 0; i < timeSlice; i++) {
                    time++;
                    System.out.println("Time: " + time);
                    System.out.println("\tJob Name: " + p.name);
                    p.workTime++;
                    if(p.workTime == p.burstTime) {
                        p.completeTime = time;
                        p.complete = true;;
                        complete++;
                        System.out.println("\t\t" + p.name + " completed");
                        break;
                    }
                }                
            }
            counter++;
            if(counter == numberOfProcesses) {
                counter = 0;
            }
        }
        output();
    }
    

    private void rr2() {
        rr(2);
        
    }

    private void rr5() {
        rr(5);
    }
    

    private void output() {
        double avgWaitingTime = 0;
        double avgCompleteTime = 0;
        for (Process p : list) {
            avgCompleteTime += p.completeTime;
            avgWaitingTime += (p.completeTime - p.burstTime);
        }
        avgCompleteTime = avgCompleteTime / numberOfProcesses;
        avgWaitingTime = avgWaitingTime / numberOfProcesses;
        System.out.println("Average waiting time: " + avgWaitingTime);
        System.out.println("Average Complete Time: " + avgCompleteTime);

    }

}
