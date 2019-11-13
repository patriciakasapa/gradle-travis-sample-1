package io.turntabl;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductDAOImpl implements ProductDAO {

    List<ProductTO> popularProducts = new ArrayList<>();
    @Override
    public void viewProducts() {

        String url = "jdbc:postgresql:northwind";
        try(Connection database = DriverManager.getConnection(url, "doreen-dodoo",  "turntabl")){
            PreparedStatement query2 = database.prepareStatement("select count(order_details.product_id) as count, products.product_name from products inner join order_details on products.product_id = order_details.product_id group by products.product_name order by count desc limit 5");
            query2.clearParameters();
            ResultSet resultsFromSearch = query2.executeQuery();
            while (resultsFromSearch.next()) {
                System.out.print(resultsFromSearch.getString("product_name"));
                System.out.println();

            }



        }catch(SQLException sqlE){
            System.err.println("Connection error: " + sqlE);
        }

    }
}
