package io.turntabl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAOImpl implements CustomerDAO {
    List<ProductTO> productsFound = new ArrayList<>();

    @Override
    public void getProductNames(String name) {
        String url = "jdbc:postgresql:northwind";
        try(Connection database = DriverManager.getConnection(url, "doreen-dodoo",  "turntabl")){
            PreparedStatement query2 = database.prepareStatement("select products.product_name, products.unit_price from products inner join order_details on products.product_id = order_details.product_id inner join orders on order_details.order_id = orders.order_id inner join customers on orders.customer_id = customers.customer_id where customers.contact_name like ? ");
            query2.clearParameters();
            query2.setString(1, name + '%');
            ResultSet resultsFromSearch = query2.executeQuery();
            while (resultsFromSearch.next()) {
                ProductTO products = new ProductTO(resultsFromSearch.getString("product_name"), resultsFromSearch.getString("unit_price"));
                productsFound.add(products);
            }
            for(ProductTO products:productsFound){
                System.out.println(products);
            }

        }catch(SQLException sqlE){
            System.err.println("Connection error: " + sqlE);
        }
    }


}
