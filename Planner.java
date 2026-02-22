import java.util.*;

public class Planner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Task> tasks = new ArrayList<>();

        System.out.println("=== Adaptive Planner AI ===");

        System.out.print("Quantas tarefas deseja adicionar? ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nTarefa " + (i + 1));

            System.out.print("Nome da tarefa: ");
            String name = scanner.nextLine();

            System.out.print("Prioridade (1-Alta, 2-Média, 3-Baixa): ");
            int priority = Integer.parseInt(scanner.nextLine());

            System.out.print("Horas necessárias: ");
            int hours = Integer.parseInt(scanner.nextLine());

            tasks.add(new Task(name, priority, hours));
        }

        System.out.print("\nQuantas horas você tem hoje? ");
        int availableHours = Integer.parseInt(scanner.nextLine());

        System.out.print("Nível de energia (1-5): ");
        int energy = Integer.parseInt(scanner.nextLine());

        suggestTasks(tasks, availableHours, energy);
    }

    public static void suggestTasks(List<Task> tasks, int availableHours, int energy) {
        // Ordena por prioridade (1 primeiro)
        tasks.sort(Comparator.comparingInt(Task::getPriority));

        System.out.println("\n=== Sugestão de Planejamento ===");

        for (Task task : tasks) {
            if (task.getHours() > availableHours) {
                System.out.println("Sem tempo hoje: " + task.getName());
                continue;
            }

            // Regra simples: energia baixa evita tarefa “pesada” (prioridade alta)
            if (energy <= 2 && task.getPriority() == 1) {
                System.out.println("Energia baixa → adiar tarefa pesada: " + task.getName());
                continue;
            }

            System.out.println("Fazer: " + task.getName() + " (" + task.getHours() + "h)");
            availableHours -= task.getHours();
        }

        System.out.println("\nHoras restantes: " + availableHours);
    }
}
