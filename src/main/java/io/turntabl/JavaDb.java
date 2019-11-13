package io.turntabl;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class JavaDb {
//    public static String input(){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter name you want to search for: ");
//        return scanner.nextLine();
//
//    }
    private static Scanner scanner = new Scanner(System.in);
    private static  String url = "jdbc:postgresql:northwind";

    public static void searchFunctionCustomers(){

        try(Connection database = DriverManager.getConnection(url, "doreen-dodoo",  "turntabl")) {
            PreparedStatement query2 = database.prepareStatement("select * from customers where contact_name like ? ");
            System.out.println("Please enter the category name you want to search for: ");
            String searchName = scanner.nextLine();
            //ResultSet searchResults = query2.executeQuery("select * from customers where contact_name like '"+searchName+"%';");
            query2.clearParameters();
            query2.setString(1, searchName + '%');
            ResultSet resultsFromSearch = query2.executeQuery();
            if (!resultsFromSearch.next()) {
                System.out.println("No user with such name exists in the database");
            } else {
                System.out.println("--------------------------------------------------------------------------------------------------------------------");
                System.out.printf("%-10s %-30s %-30s %-15s %-30s", "Customer_id  ", "Company_name", "Contact_name ", "Country", "Telephone");
                System.out.println("--------------------------------------------------------------------------------------------------------------------");
                while (resultsFromSearch.next()) {
                    System.out.format("%-10s %-30s %-30s %-15s %-30s", resultsFromSearch.getString("customer_id"), resultsFromSearch.getString("company_name"),
                            resultsFromSearch.getString("contact_name"), resultsFromSearch.getString("country"), resultsFromSearch.getString("phone"));
                    System.out.println();
                }
            }
        }catch(SQLException sqlE){
            System.err.println("Connection error: " + sqlE);
        }


    }
    public static void searchFunctionCategories(){
        try(Connection database = DriverManager.getConnection(url, "doreen-dodoo",  "turntabl")) {
            PreparedStatement query2 = database.prepareStatement("select * from categories where category_name like ? ");
            String searchName = scanner.nextLine();
            //ResultSet searchResults = query2.executeQuery("select * from categories where category_name like '"+searchName+"%';");
            query2.clearParameters();
            query2.setString(1, searchName + '%');
            ResultSet resultsFromSearch = query2.executeQuery();
            if (!resultsFromSearch.next()) {
                System.out.println("No category with such name exists in the database");
            } else {
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.printf("%-10s %-30s %-45s", "Category_id  ", "Category_name", "Category_description");
                System.out.println("----------------------------------------------------------------------------------------");
                while (resultsFromSearch.next()) {
                    System.out.format("%-10s %-30s %-30s %-15s %-30s", resultsFromSearch.getString("customer_id"), resultsFromSearch.getString("company_name"),
                            resultsFromSearch.getString("contact_name"), resultsFromSearch.getString("country"), resultsFromSearch.getString("phone"));
                    System.out.println();
                }
            }
        }catch(SQLException sqlE){
            System.err.println("Connection error: " + sqlE);
        }


    }

    public static void main(String[] args){
        String url = "jdbc:postgresql:northwind";
        try(Connection database = DriverManager.getConnection(url, "doreen-dodoo",  "turntabl")){

//            Statement query = database.createStatement();
//            ResultSet results = query.executeQuery("select * from customers;");
//
//            System.out.println("--------------------------------------------------------------------------------------------------------------------");
//            System.out.printf("%-10s %-30s %-30s %-15s %-30s", "Customer_id  ", "Company_name",  "Contact_name ", "Country", "Telephone");
//            System.out.println("--------------------------------------------------------------------------------------------------------------------");
//            while(results.next()){
//                System.out.format("%-10s %-30s %-30s %-15s %-30s", results.getString("customer_id"), results.getString("company_name"),
//                        results.getString("contact_name"), results.getString("country"), results.getString("phone"));
//                System.out.println();
//            }




        }catch(SQLException sqlE){
            System.err.println("Connection error: " + sqlE);
        }


    }
}
