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
        cpu.readFile("testdata2.txt");
        cpu.FCFS();
        cpu.readFile("testdata2.txt");
        cpu.SJF();
        cpu.readFile("testdata2.txt");
        cpu.rr2();
        cpu.readFile("testdata2.txt");
        cpu.rr5();
        cpu.readFile("testdata3.txt");
        cpu.FCFS();
        cpu.readFile("testdata3.txt");
        cpu.SJF();
        cpu.readFile("testdata3.txt");
        cpu.rr2();
        cpu.readFile("testdata3.txt");
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
        System.out.println("-----------Firt Come First Serve-----------");
        int time = 0;
        for (Process p : list) {
            while (p.workTime < p.burstTime) {
                System.out.print("\nTime: " + time);
                System.out.print(" \tWorking on: " + p.name);
                if (p.startTime == -1) {
                    p.startTime = time;
                    System.out.print(" \tstarted at time: " + p.startTime);
                }
                time++;
                p.workTime++;
                if (p.workTime == p.burstTime) {
                    p.completeTime = time;
                    System.out
                            .print("\tcompleted at time: " + time);
                }
                System.out.println();
            }
        }
        output();
    }

    private void SJF() {
        System.out.println("-----------Shortest Job First-----------");
        list.sort(new Process());
        int time = 0;
        for (Process p : list) {
            while (p.workTime < p.burstTime) {
                System.out.print("\nTime: " + time);
                System.out.print(" \tWorking on: " + p.name);
                if (p.startTime == -1) {
                    p.startTime = time;
                    System.out.print(" \tstarted at time: " + p.startTime);
                }
                time++;
                p.workTime++;
                if (p.workTime == p.burstTime) {
                    p.completeTime = time;
                    System.out.print("\tcompleted at time: " + time);
                }
                System.out.println();
            }
        }
        output();
    }

    private void rr(int timeSlice) {
        int time = 0;
        int counter = 0;
        int complete = 0;
        Process p = new Process();
        while (complete < numberOfProcesses) {
            p = list.get(counter);
            if (!p.complete) {
                for (int i = 0; i < timeSlice; i++) {
                    p.workTime++;
                    System.out.print("\nTime: " + time);
                    System.out.print(" \tWorking on: " + p.name);
                    if (p.startTime == -1) {
                        p.startTime = time;
                        System.out.print(" \tstarted at time: " + p.startTime);
                    }
                    time++;
                    if (p.workTime == p.burstTime) {
                        p.completeTime = time;
                        p.complete = true;
                        ;
                        complete++;
                        System.out.println(" \tstarted at time: " + p.startTime + "\tcompleted at time: " + time);
                        break;
                    }
                    System.out.println();
                }
            }
            counter++;
            if (counter == numberOfProcesses) {
                counter = 0;
            }
        }
        output();
    }

    private void rr2() {
        System.out.println("-----------Round Robin Time Slice 2-----------");

        rr(2);

    }

    private void rr5() {
        System.out.println("-----------Round Robin Time Slice 5-----------");

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
        System.out.println();
        System.out.println("Average waiting time: " + avgWaitingTime);
        System.out.println("Average Complete Time: " + avgCompleteTime);

    }

}
