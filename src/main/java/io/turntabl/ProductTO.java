package io.turntabl;

public class ProductTO {
    private String product_name;
    private String unit_price;

    public ProductTO(String product_name, String unit_price) {
        this.product_name = product_name;
        this.unit_price = unit_price;
    }


    public String getProduct_name() {
        return product_name;
    }

    public String getUnit_price() {
        return unit_price;
    }

    @Override
    public String toString() {
        return "product_name: " + product_name + "\n" +
               "unit_price: " + unit_price;
    }
}
