import java.util.*;

class Process {
    int id;
    int priority;
    int units;

    public Process(int id, int priority, int units) {
        this.id = id;
        this.priority = priority;
        this.units = units;
    }
}

public class CPU{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Process> processes = getProcesses(scanner);

        System.out.println("Select a CPU scheduling algorithm:");
        System.out.println("1. First-Come, First-Served (FCFS)");
        System.out.println("2. Shortest Job Next (SJN)");
        System.out.println("3. Priority Scheduling");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                runFCFS(processes);
                break;
            case 2:
                runSJN(processes);
                break;
            case 3:
                runPriority(processes);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void runFCFS(ArrayList<Process> processes) {
        Collections.sort(processes, Comparator.comparingInt(p -> p.id));

        int totalTime = 0;
        System.out.println("FCFS Scheduling:");
        for (Process process : processes) {
            int processTime = process.units;
            totalTime += processTime;
            System.out.println("Process " + process.id + " can run for " + processTime + " seconds "+ " and "+ process.units+" units");
        }
        System.out.println("Total time for all processes: " + totalTime + " seconds.");
    }

    private static void runSJN(ArrayList<Process> processes) {
        Collections.sort(processes, Comparator.comparingInt(p -> p.units));

        int totalTime = 0;
        System.out.println("SJN Scheduling:");
        for (Process process : processes) {
            int processTime = process.units;
            totalTime += processTime;
            System.out.println("Process " + process.id + " can run for " + processTime + " seconds"+" and "+ process.units+" units");
        }
        System.out.println("Total time for all processes: " + totalTime + " seconds.");
    }

    private static void runPriority(ArrayList<Process> processes) {
        Collections.sort(processes, Comparator.comparingInt(p -> p.priority));

        int totalTime = 0;
        System.out.println("Priority Scheduling:");
        for (Process process : processes) {
            int processTime = process.units;
            totalTime += processTime;
            System.out.println("Process " + process.id + " can run for " + processTime + " seconds with priority " + process.priority + " and "+ process.units+" units");
        }
        System.out.println("Total time for all processes: " + totalTime + " seconds.");
    }

    private static ArrayList<Process> getProcesses(Scanner scanner) {
        ArrayList<Process> processes = new ArrayList<>();

        System.out.print("Enter the number of processes: ");
        int numProcesses = scanner.nextInt();

        for (int i = 1; i <= numProcesses; i++) {
            System.out.print("Enter the number of units for process " + i + ": ");
            int units = scanner.nextInt();
            System.out.print("Enter the priority for process " + i + ": ");
            int priority = scanner.nextInt();

            processes.add(new Process(i, priority, units));
        }

        return processes;
    }
}
