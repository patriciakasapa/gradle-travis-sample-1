package io.turntabl;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class JavaDb {
    public static String input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter name you want to search for: ");
        return scanner.nextLine();

    }

    public static void main(String[] args){
        String url = "jdbc:postgresql:northwind";
        try(Connection database = DriverManager.getConnection(url, "doreen-dodoo",  "turntabl")){

            Statement query = database.createStatement();
            ResultSet results = query.executeQuery("select * from customers;");

            System.out.println("--------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-10s %-30s %-30s %-15s %-30s", "Customer_id  ", "Company_name",  "Contact_name ", "Country", "Telephone");
            System.out.println("--------------------------------------------------------------------------------------------------------------------");
            while(results.next()){
                System.out.format("%-10s %-30s %-30s %-15s %-30s", results.getString("customer_id"), results.getString("company_name"),
                        results.getString("contact_name"), results.getString("country"), results.getString("phone"));
                System.out.println();
            }



        }catch(SQLException sqlE){
            System.err.println("Connection error: " + sqlE);
        }


    }
}
