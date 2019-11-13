package io.turntabl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

//        CustomerDAOImpl productNames = new CustomerDAOImpl();
//        System.out.println("Enter customer name: ");
//        Scanner scanner = new Scanner(System.in);
//        String name = scanner.nextLine();
//        productNames.getProductNames(name);


        ProductDAOImpl products = new ProductDAOImpl();
        products.viewProducts();

    }
}
