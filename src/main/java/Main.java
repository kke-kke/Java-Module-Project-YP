import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people;
        String name;
        double cost = 0;

        while (true) {
            System.out.println("На скольких человек необходимо разделить счет?");

            if (scanner.hasNextInt()) {
                people = scanner.nextInt();

                if (people > 1) {
                    while (true) {
                        System.out.println("Добавить товар к счету? Для окончания введите команду \"Завершить\"");
                        String answer = scanner.next();
                        if (answer.equalsIgnoreCase("Завершить")) {
                            CostCalculator.showAddedProducts(people);
                            return;
                        } else {
                            System.out.println("Введите название товара");
                            name = scanner.next();
                            System.out.println("Введите стоимость товара");
                            if (scanner.hasNextDouble()) {
                                cost = scanner.nextDouble();
                            } else {
                                scanner.nextLine();
                                System.out.println("Введены некорректные данные. Пожалуйста, введите положительное число");
                            }

                            CostCalculator.addProduct(name, cost);
                            cost = 0;

                        }
                    }
                } else {
                    System.out.println("Количество людей некорректно для разделения счета. Пожалуйста, введите целое число от 2");
                }

            } else {
                scanner.nextLine();
                System.out.println("Введены некорректные данные. Пожалуйста, введите число");
            }
        }

    }
}