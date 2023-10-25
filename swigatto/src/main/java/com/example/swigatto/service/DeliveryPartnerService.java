package com.example.swigatto.service;

import com.example.swigatto.dto.request.DeliveryPartnerRequest;
import com.example.swigatto.model.DeliveryPartner;
import com.example.swigatto.repository.DeliveryPartnerRepository;
import com.example.swigatto.transformer.PartnerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryPartnerService {

    final DeliveryPartnerRepository deliveryPartnerRepository;

    @Autowired
    public DeliveryPartnerService(DeliveryPartnerRepository deliveryPartnerRepository) {
        this.deliveryPartnerRepository = deliveryPartnerRepository;
    }


    public String addPartner(DeliveryPartnerRequest deliveryPartnerRequest) {

        // dto -> entity
        DeliveryPartner deliveryPartner = PartnerTransformer.PartnerRequestToDeliveryPartner(deliveryPartnerRequest);

        //save
        DeliveryPartner savedPartner = deliveryPartnerRepository.save(deliveryPartner);

        return "You have been Successfully registered!!!";

    }
}
