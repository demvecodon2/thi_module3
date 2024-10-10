package model;

public class Product {
    private  int id;
    private String name;
    private int price;
    private String discount;
    private String inventory;
    public Product() {}
    public Product(int id, String name, int price, String discount, String inventory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.inventory = inventory;
    }

    public Product(String name, int price, String discount, String inventory) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }


}



