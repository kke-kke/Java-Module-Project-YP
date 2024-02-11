import java.util.ArrayList;
import java.util.List;

public class CostCalculator {
    public static List<Product> products = new ArrayList<>();
    public static double resultingCost;

    public static void addProduct(String name, double cost) {
        if (cost != 0) {
            products.add(new Product(name, cost));
            resultingCost = resultingCost + cost;
            System.out.println(String.format("Товар %s стоимостью %.2f успешно добавлен в список", name, cost));
        } else {
            System.out.println("Не введена цена товара, товар не был добавлен в список");
        }
    }

    public static void showAddedProducts(int people) {
        System.out.println("Добавленные товары:");
        for (Product product : products) {
            System.out.println("Товар: " + product.productName + ", цена: " + outputFormat(product.productCost));
        }
        showDividedResultingCost(people);
    }

    public static void showDividedResultingCost(int people) {
        double costPerPerson = resultingCost / people;
        System.out.println("Счет одного человека: " + outputFormat(costPerPerson));
    }

    protected static String outputFormat(double cost) {
        String format = "";
        int num = (int) Math.floor(cost) % 10;
        int extra = (int) Math.floor(cost) % 100;
        if (extra >= 11 && extra <= 19) {
            format = String.format("%.2f рублей", cost);
        } else {
            switch (num) {
                case 1:
                    format = String.format("%.2f рубль", cost);
                    break;
                case 2:
                case 3:
                case 4:
                    format = String.format("%.2f рубля", cost);
                    break;
                default:
                    format = String.format("%.2f рублей", cost);
                    break;
            }
        }
        return format;
    }
}
