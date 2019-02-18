package ru.zakharov.entities;

public class Product {
    private Long id;
    private String title;
    private Double coast;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getCoast() {
        return coast;
    }

    public void setCoast(Double coast) {
        this.coast = coast;
    }
}
