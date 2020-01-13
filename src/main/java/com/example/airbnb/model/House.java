package com.example.airbnb.model;



import javax.persistence.*;

import java.util.Set;


@Entity
public class  House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameHouse;

    @ManyToOne
    @JoinColumn(name = "category_home")
    private CategoryHouse categoryHouse;

    @OneToMany(targetEntity = Room.class)
    Set<Room> rooms;

    private Long amountBathRoom;
    private Long amountBedRoom;
    private String address;
    private String description;
    @OneToOne
    @JoinColumn(name = "price")
    private Price price;
    @Column(columnDefinition = "TEXT")
    private String imageUrls;

    public House() {
    }

    public House(String nameHouse, Long amountBathRoom, Long amountBedRoom, String address, String description, Price price, String imageUrls) {
        this.nameHouse = nameHouse;
        this.categoryHouse = categoryHouse;
        this.rooms = rooms;
        this.amountBathRoom = amountBathRoom;
        this.amountBedRoom = amountBedRoom;
        this.address = address;
        this.description = description;
        this.price = price;
        this.imageUrls = imageUrls;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameHouse() {
        return nameHouse;
    }

    public void setNameHouse(String nameHouse) {
        this.nameHouse = nameHouse;
    }

    public CategoryHouse getCategoryHouse() {
        return categoryHouse;
    }

    public void setCategoryHouse(CategoryHouse categoryHouse) {
        this.categoryHouse = categoryHouse;
    }

    public Long getAmountBathRoom() {
        return amountBathRoom;
    }

    public void setAmountBathRoom(Long amountBathRoom) {
        this.amountBathRoom = amountBathRoom;
    }

    public Long getAmountBedRoom() {
        return amountBedRoom;
    }

    public void setAmountBedRoom(Long amountBedRoom) {
        this.amountBedRoom = amountBedRoom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }



    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
}
