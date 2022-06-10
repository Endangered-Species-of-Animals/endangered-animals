package com.esoa.demo.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.esoa.demo.entity.Park;
import com.esoa.demo.repository.ParkRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParkService {

    private final ParkRepository parkRepository;
    private final ImageParkService imageParkService;

    @Transactional
    public void create(Park dto, MultipartFile photo){
        if (parkRepository.existsByNameAndDescription(dto.getName(), dto.getDescription()))
            throw new IllegalArgumentException("Error!");
        
        Park park = new Park();
        park.setName(dto.getName());
        park.setLocation(dto.getLocation());
        park.setPosition(dto.getPosition());
        park.setDescription(dto.getDescription());
        park.setLink(dto.getLink());
        park.setDeleted(false);
        if (!photo.isEmpty()) park.setImage(imageParkService.copy(photo));
        parkRepository.save(park);

        
    }

    @Transactional
    public void update(Park dto){

        Park park = parkRepository.findById(dto.getId()).get();
        park.setName(dto.getName());
        park.setLocation(dto.getLocation());
        park.setPosition(dto.getPosition());
        park.setDescription(dto.getDescription());
        park.setLink(dto.getLink());

        parkRepository.save(park);

    }

    @Transactional(readOnly = true)
    public Park getById(Integer id){
        return parkRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Park> getAll(Integer id){
        return parkRepository.findAll();
    }

   
    @Transactional(readOnly = true)
    public void enableById(Integer id){
        parkRepository.enableById(id);   
    }

    @Transactional
    public void deleteById(Integer id) {
        parkRepository.deleteById(id);
    }

}
