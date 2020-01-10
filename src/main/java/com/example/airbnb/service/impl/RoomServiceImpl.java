package com.example.airbnb.service.impl;

import com.example.airbnb.model.Room;
import com.example.airbnb.repository.RoomRepository;
import com.example.airbnb.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;


    @Override
    public Iterable<Room> findAll() {

        return roomRepository.findAll();
    }

    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void delete(Long id) {
        Optional<Room> room = roomRepository.findById(id);
        if (room.isPresent()){
            roomRepository.delete(room.get());
        }

    }

    @Override
    public Optional<Room> findById(Long id) {
        return roomRepository.findById(id);
    }
}
