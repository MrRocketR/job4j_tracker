package ru.job4j.pojo;

public class Shop {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            /* проверяем, что объект не равен null. Т.к. у нас массив не заполнен целиком. */
            if (product != null) {
                System.out.println(product.getName());
            }
        }
    }
        public static int indexOfNull (Product[]products){
            int out = -1;
            for (int index = 0; index < products.length; index++) {
                Product nullFinder = products[index];
                if (nullFinder == null) {
                    out = index;
                    break;
                }
            }
            return out;
        }
}