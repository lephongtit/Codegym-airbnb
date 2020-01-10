package com.example.airbnb.service;

import com.example.airbnb.model.Room;
import com.example.airbnb.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

public interface RoomService  {
    Iterable<Room> findAll();
    void save(Room room);
    void delete (Long id);
    Optional<Room> findById ( Long id);

}
