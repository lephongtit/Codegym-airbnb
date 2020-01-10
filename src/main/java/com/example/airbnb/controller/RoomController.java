package com.example.airbnb.controller;

import com.example.airbnb.model.CategoryHouse;
import com.example.airbnb.model.House;
import com.example.airbnb.model.Room;
import com.example.airbnb.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")

@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping
    public ResponseEntity<Iterable<Room>> listRoom() {
        Iterable<Room> rooms = roomService.findAll();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Room> create(@RequestBody Room room) {
        roomService.save(room);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> editRoom(@PathVariable("id") Long id, @RequestBody Room room) {
        Optional<Room> room1 = roomService.findById(id);
        if (room1.isPresent()) {
            room1.get().setName(room.getName());
            room1.get().setHouse(room.getHouse());
            room1.get().setCategoryRoom(room.getCategoryRoom());
            room1.get().setDescription(room.getDescription());
            room1.get().setImg(room.getImg());
            roomService.save(room1.get());
            return new ResponseEntity("thanh cong", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        Optional<Room> room = roomService.findById(id);
        if (room == null){
            return new ResponseEntity( HttpStatus.NOT_FOUND);
        }
        roomService.delete(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
