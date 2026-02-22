import java.util.*;

public class Planner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Task> tasks = new ArrayList<>();

        System.out.println("=== Adaptive Planner AI ===");

        System.out.print("Quantas tarefas deseja adicionar? ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Nome da tarefa: ");
            String name = scanner.nextLine();

            System.out.print("Prioridade (1-Alta, 2-Media, 3-Baixa): ");
            int priority = scanner.nextInt();

            System.out.print("Horas necessarias: ");
            int hours = scanner.nextInt();
            scanner.nextLine();

            tasks.add(new Task(name, priority, hours));
        }

        System.out.print("Quantas horas voce tem hoje? ");
        int availableHours = scanner.nextInt();

        System.out.print("Nivel de energia (1-5): ");
        int energy = scanner.nextInt();

        suggestTasks(tasks, availableHours, energy);
    }

    public static void suggestTasks(List<Task> tasks, int availableHours, int energy) {

        tasks.sort(Comparator.comparingInt(Task::getPriority));

        System.out.println("\n=== Sugestao de Planejamento ===");

        for (Task task : tasks) {

            if (task.getHours() <= availableHours) {

                if (energy >= 3 || task.getPriority() != 1) {
                    System.out.println("Fazer: " + task.getName());
                    availableHours -= task.getHours();
                } else {
                    System.out.println("Adiar tarefa pesada: " + task.getName());
                }
            }
        }
    }
}
