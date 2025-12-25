package com.example.demo.service.impl;

import com.example.demo.model.Parcel;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.ParcelService;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository parcelRepository;

    public ParcelServiceImpl(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    @Override
    public Parcel addParcel(Parcel parcel) {
        if (parcel.getWeightKg() <= 0) {
            throw new BadRequestException("weight");
        }

        if (parcelRepository.existsByTrackingNumber(parcel.getTrackingNumber())) {
            throw new BadRequestException("tracking");
        }

        return parcelRepository.save(parcel);
    }

    @Override
    public Parcel getByTrackingNumber(String trackingNumber) {
        return parcelRepository.findByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Parcel not found"));
    }
}
