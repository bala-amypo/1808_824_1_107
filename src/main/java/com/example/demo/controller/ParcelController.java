// package com.example.demo.controller;

// import com.example.demo.model.Parcel;
// import com.example.demo.service.ParcelService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/parcels")
// public class ParcelController {

//     private final ParcelService parcelService;

//     public ParcelController(ParcelService parcelService) {
//         this.parcelService = parcelService;
//     }

//     // POST /parcels
//     @PostMapping
//     public Parcel addParcel(@RequestBody Parcel parcel) {
//         return parcelService.addParcel(parcel);
//     }

//     // GET /parcels/tracking/{trackingNumber}
//     @GetMapping("/tracking/{trackingNumber}")
//     public Parcel getParcel(@PathVariable String trackingNumber) {
//         return parcelService.getByTrackingNumber(trackingNumber);
//     }
// }
@RestController
@RequestMapping("/api/parcels")
public class ParcelController {

    private final ParcelRepository repo;

    public ParcelController(ParcelRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Parcel add(@RequestBody Parcel p) {
        return repo.save(p);
    }

    @GetMapping("/tracking/{trackingNumber}")
    public Parcel get(@PathVariable String trackingNumber) {
        return repo.findByTrackingNumber(trackingNumber).orElseThrow();
    }
}
