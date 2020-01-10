package com.example.airbnb.model;

import javax.persistence.*;


@Entity
public class Room {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "house")
    private  House house;

    @ManyToOne
    @JoinColumn(name = "category_room")
    private CategoryRoom categoryRoom;

    private String description;
    private String img;

    public Room() {
    }

    public Room(String name, House house, CategoryRoom categoryRoom, String description, String img) {
        this.name = name;
        this.categoryRoom = categoryRoom;
        this.description = description;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryRoom getCategoryRoom() {
        return categoryRoom;
    }

    public void setCategoryRoom(CategoryRoom categoryRoom) {
        this.categoryRoom = categoryRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
