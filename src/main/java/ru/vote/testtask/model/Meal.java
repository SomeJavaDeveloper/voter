package ru.vote.testtask.model;

public class Meal extends AbstractEntity{

    private Integer price;

    public Meal() {
    }

    public Meal(String name, Integer price) {
        this(null, name, price);
    }

    public Meal(Integer id, String name, Integer price) {
        super(id, name);
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "price=" + price +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
