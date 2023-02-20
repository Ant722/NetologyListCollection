import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> purchases = new ArrayList<>();

        while (true) {
            System.out.println("Выберите операцию или end для завершения\n" +
                    "1.Добавить\n" + "2.Показать\n" + "3.Удалить\n" + "4.Найти");
            String input = scanner.nextLine();

            if ("end".equals(input)) {
                break;
            } else if ("Добавить".equals(input) || Integer.parseInt(input) == 1) {
                add(scanner, purchases);

            } else if ("Показать".equals(input) || Integer.parseInt(input) == 2) {
                System.out.println("Список покупок:");
                for (int i = 0; i < purchases.size(); i++) {
                    System.out.println((i + 1) + ". " + purchases.get(i));
                }

            } else if ("Удалить".equals(input) || Integer.parseInt(input) == 3) {
                remove(scanner, purchases);

            } else if ("Найти".equals(input) || Integer.parseInt(input) == 4) {
                search(scanner, purchases);
            } else {
                System.out.println("Введеное значение не корректно!");
            }
        }
    }
    private static void search(Scanner scanner, List<String> purchases) {
        System.out.println("Введите текст для поиска:");
        String input2 = scanner.nextLine();
        System.out.println("Найдено:");

        for (int i = 0; i < purchases.size(); i++) {
            if (purchases.get(i).toLowerCase().contains(input2.toLowerCase())) {
                System.out.println(purchases.get(i));
            }
        }
    }
    private static void remove(Scanner scanner, List<String> purchases) {
        System.out.println("Список покупок:");
        for (int i = 0; i < purchases.size(); i++) {
            System.out.println((i + 1) + ". " + purchases.get(i));
        }
        System.out.println("Какую хотите удалить? Введите номер или название");
        String input2 = scanner.nextLine();
        if (purchases.contains(input2) || (Integer.parseInt(input2) <= purchases.size() && Integer.parseInt(input2) > 0)) {

            if (purchases.contains(input2)) {
                Iterator<String> iterator = purchases.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().equals(input2)) {
                        iterator.remove();
                    }
                }
                System.out.println("Покупка " + input2 + " удалена, список покупок: ");

                for (int i = 0; i < purchases.size(); i++) {
                    System.out.println((i + 1) + ". " + purchases.get(i));
                }
            } else {
                int j = Integer.parseInt(input2) - 1;
                System.out.println("Покупка " + purchases.get(j) + " удалена, список покупок: ");
                purchases.remove(j);
                for (int i = 0; i < purchases.size(); i++) {
                    System.out.println((i + 1) + ". " + purchases.get(i));
                }
            }

        } else {
            System.out.println("Введеное значение не корректно!");
        }
    }
    private static void add(Scanner scanner, List<String> purchases) {
        System.out.println("Какую покупку хотите добавить?");
        String input2 = scanner.nextLine();
        purchases.add(input2);
        System.out.println(purchases.size());
    }
}