package com.example.airbnb.model;

import javax.persistence.*;


@Entity
public class Room {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String nameHouse;
    private String nameHost;
    @ManyToOne
    @JoinColumn(name = "category_room")
    private CategoryRoom categoryRoom;

    private String description;

    @Column(columnDefinition = "TEXT")
    private String img;

    public Room() {
    }

    public Room(String nameHouse, String nameHost, CategoryRoom categoryRoom, String description, String img) {
        this.nameHouse = nameHouse;
        this.nameHost = nameHost;
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

    public String getNameHouse() {
        return nameHouse;
    }

    public void setNameHouse(String nameHouse) {
        this.nameHouse = nameHouse;
    }

    public String getNameHost() {
        return nameHost;
    }

    public void setNameHost(String nameHost) {
        this.nameHost = nameHost;
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
}
