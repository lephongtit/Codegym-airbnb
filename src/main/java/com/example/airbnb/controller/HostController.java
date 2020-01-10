package com.example.airbnb.controller;

import com.example.airbnb.model.CategoryHouse;
import com.example.airbnb.model.CategoryRoom;
import com.example.airbnb.model.House;
import com.example.airbnb.model.Price;
import com.example.airbnb.service.CategoryHouseService;
import com.example.airbnb.service.CategoryRoomService;
import com.example.airbnb.service.HouseService;
import com.example.airbnb.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/host")
public class HostController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private CategoryHouseService categoryHouseService;
    @Autowired
    private CategoryRoomService categoryRoomService;
    @Autowired
    private PriceService priceService;

    @GetMapping
    public ResponseEntity<Iterable<House>>listHouse(){
        Iterable<House>homeStays= houseService.findAll();
        return new ResponseEntity<>(homeStays, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> edit(@PathVariable("id") Long id,@RequestBody House house){
        Optional<House>homeStay1= houseService.findById(id);

        if(homeStay1.isPresent()){
            homeStay1.get().setNameHouse(house.getNameHouse());
            homeStay1.get().setCategoryHouse(house.getCategoryHouse());
            homeStay1.get().setAddress(house.getAddress());
            homeStay1.get().setAmountBathRoom(house.getAmountBathRoom());
            homeStay1.get().setAmountBedRoom(house.getAmountBedRoom());
            homeStay1.get().setDescription(house.getDescription());
            homeStay1.get().setImageUrls(house.getImageUrls());
            homeStay1.get().setPrice(house.getPrice());

            houseService.save(homeStay1.get());
            return new ResponseEntity("thanh cong",HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<House>createHouse(@RequestBody House house){
        if (house.getCategoryHouse() != null){
            String nameHouse= house.getCategoryHouse().getName();
            CategoryHouse categoryHouse=categoryHouseService.findByName(nameHouse);
            house.setCategoryHouse(categoryHouse);
        }
        if (house.getPrice()!=null){
            Price price= house.getPrice();
            priceService.save(price);
        }
        houseService.save(house);



        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        Optional<House> homeStay1 = houseService.findById(id);
        if (homeStay1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        houseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{id}")

    public ResponseEntity<House> findById(@PathVariable Long id){
        Optional<House> homeStay = houseService.findById(id);
        if (homeStay == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(homeStay, HttpStatus.OK);
    }

}