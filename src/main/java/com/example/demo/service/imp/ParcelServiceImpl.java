package com.example.demo.service.imp;

import com.example.demo.model.Parcel;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.ParcelService;
import org.springframework.stereotype.Service;

@Service
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository parcelRepository;

    public ParcelServiceImpl(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    @Override
    public Parcel addParcel(Parcel parcel) {

        if (parcelRepository.existsByTrackingNumber(parcel.getTrackingNumber())) {
            throw new RuntimeException("Parcel with this tracking number already exists");
        }

        return parcelRepository.save(parcel);
    }

    @Override
    public Parcel getByTrackingNumber(String trackingNumber) {

        return parcelRepository.findByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new RuntimeException("Parcel not found"));
    }
}
