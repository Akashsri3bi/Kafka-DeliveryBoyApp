package com.delhiveryboy.deliveryboyapp.controller;


import com.delhiveryboy.deliveryboyapp.model.LocationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.delhiveryboy.deliveryboyapp.service.KafkaService;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    //Working on currently building the delivery boy application like zomato
    // Using apache kafka still stuck on getting location through post mapping
    // lets see if we figure it out correctly or not


    //Taking too long to connect to local server somethings not working

    //I figured out the issue I forget to run the zookeper and starter files my bad :>
    @Autowired
    private KafkaService kafkaService ;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(@RequestBody LocationModel locationModel){

        this.kafkaService.updateLocation(locationModel) ;
        return new ResponseEntity<>(Map.of("message" , "Location Updated") , HttpStatus.OK) ;
    }
}
