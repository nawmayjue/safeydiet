package com.projects.safeydiet.feature.location.service.impl;

import com.projects.safeydiet.feature.location.dto.CreateLocationRequest;
import com.projects.safeydiet.feature.location.dto.LocationResponse;
import com.projects.safeydiet.feature.location.dto.UpdateLocationRequest;
import com.projects.safeydiet.feature.location.service.LocationService;
import com.projects.safeydiet.shared.data.model.Location;
import com.projects.safeydiet.shared.data.repository.jpa.LocationJpaRepository;
import com.projects.safeydiet.shared.exception.BadRequestException;
import com.projects.safeydiet.shared.exception.NotFoundException;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationJpaRepository locationJpaRepository;

    @Override
    public LocationResponse createLocation(CreateLocationRequest request){
        String city = request.city().trim().toLowerCase();
        String region = request.region().trim().toLowerCase();
        String country = request.country().trim().toLowerCase();

        if(locationJpaRepository.existsByCityAndRegionAndCountry(city, region, country)){
            throw new BadRequestException("Location Already Exists.");
        }

        Location createdLocation = Location.builder()
                .city(city)
                .region(region)
                .country(country)
                .build();

        Location savedLocation = locationJpaRepository.save(createdLocation);

        return LocationResponse.builder()
                .id(savedLocation.getId())
                .city(savedLocation.getCity())
                .region(savedLocation.getRegion())
                .country(savedLocation.getCountry())
                .createdAt(savedLocation.getCreatedAt())
                .updatedAt(savedLocation.getUpdatedAt())
                .build();
    }

    @Override
    public List<LocationResponse> retrieveAll() {
        List<Location> locations = locationJpaRepository.findAll();
        return locations.stream()
                .map(location -> {
                    LocationResponse response = LocationResponse.builder()
                            .id(location.getId())
                            .city(location.getCity())
                            .region(location.getRegion())
                            .country(location.getCountry())
                            .createdAt(location.getCreatedAt())
                            .updatedAt(location.getUpdatedAt())
                            .build();
                    return response;
                })
                .toList();
    }

    @Override
    public LocationResponse retrieveOne(Long id) {
        Location location = locationJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Location not found"));

        return LocationResponse.builder()
                .id(location.getId())
                .city(location.getCity())
                .region(location.getRegion())
                .country(location.getCountry())
                .createdAt(location.getCreatedAt())
                .updatedAt(location.getUpdatedAt())
                .build();
    }

    @Override
    public LocationResponse updateLocation(Long id, UpdateLocationRequest request) {
        Location location = locationJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Location not found"));

        String city = request.city().trim().toLowerCase();
        String region = request.region().trim().toLowerCase();
        String country = request.country().trim().toLowerCase();

        if(locationJpaRepository.existsByCityAndRegionAndCountry(city, region, country)){
            throw new BadRequestException("Location Already Exists.");
        }

        location.setCity(city);
        location.setRegion(region);
        location.setCountry(country);

        Location updatedLocation = locationJpaRepository.save(location);

        return LocationResponse.builder()
                .id(updatedLocation.getId())
                .city(updatedLocation.getCity())
                .region(updatedLocation.getRegion())
                .country(updatedLocation.getCountry())
                .createdAt(updatedLocation.getCreatedAt())
                .updatedAt(updatedLocation.getUpdatedAt())
                .build();
    }

    @Override
    public void deleteLocation(Long id) {
        Location location = locationJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Location not found."));
        locationJpaRepository.deleteById(id);
    }

}
