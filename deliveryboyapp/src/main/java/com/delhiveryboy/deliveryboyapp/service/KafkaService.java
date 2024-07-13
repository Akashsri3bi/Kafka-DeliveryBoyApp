package com.delhiveryboy.deliveryboyapp.service;

import com.delhiveryboy.deliveryboyapp.kafka.AppConstants;
import com.delhiveryboy.deliveryboyapp.model.LocationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<Object, LocationModel> kafkaTemplate ;
    public void updateLocation(LocationModel locationModel){
        this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME , locationModel/*String.valueOf( locationModel.getLatitude()) + " , "  + String.valueOf(locationModel.getLongitude())*/) ;
    }
}
