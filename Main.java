import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // NEW COMMENT
        // NEW COMMENT
        // NEW COMMENT

        // Создаем три массива, в которых будем хранить:
        // - названия продуктов
        String[] product = {"Молоко", "Хлеб", "Гречневая крупа"};
        // цены продуктов
        int[] price = {50, 14, 80};
        // количество продуктов (изначально 0 шт)
        int[] amount = new int[product.length];

        // Вывод списка продуктов с ценами на экран
        for (int i = 0; i < product.length; i++) {
            System.out.println((i + 1) + ". " + product[i] + " " + price[i] + " руб/шт");
        }

        // общая сумма покупок
        int sumProducts = 0;

        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break; // выход из цикла при вводе слова "end"
            }

            // делим введенное данные на два числа (номер продукта и количество)
            String[] parts = input.split(" ");
            // сюда запишем введенный номер продукта
            int productNumber = Integer.parseInt(parts[0]) - 1;
            // сюда запишем введенное количество продукта
            int productCount = Integer.parseInt(parts[1]);
            // в массиве amount указали, что общее количество введенного продукта изменилось
            amount[productNumber] += productCount;
        }

        System.out.println("Ваша корзина:");
        for (int i = 0; i < product.length; i++) {
            // здесь мы берем только те продукты, которые выбирал пользователь
            // т.е. количество этих продуктов менялось (НЕ равно нулю)
            if (amount[i] != 0) {
                int currentSum = amount[i] * price[i];
                sumProducts += currentSum;
                System.out.println(product[i] + " в количестве " + amount[i] + " на сумму " + currentSum);
            }
        }
        System.out.println("Итого: " + sumProducts);
    }
}
