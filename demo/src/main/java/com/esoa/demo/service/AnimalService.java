package com.esoa.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.esoa.demo.entity.Animal;
import com.esoa.demo.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final ImageAnimalService imageAnimalService;


    @Transactional
    public void create(Animal dto, MultipartFile photo){
        if (animalRepository.existsByNameAndDescription(dto.getName(), dto.getDescription()))
            throw new IllegalArgumentException("Error!");
        
        Animal animal = new Animal();
        animal.setName(dto.getName());
        animal.setDescription(dto.getDescription());
        animal.setDischargeDate(dto.getDischargeDate());
        animal.setCategory(dto.getCategory());
        animal.setScientific_name(dto.getScientific_name());
        animal.setSpecie(dto.getSpecie());
        animal.setDeleted(false);
        if (!photo.isEmpty()) animal.setImage(imageAnimalService.copy(photo));

        animalRepository.save(animal);

    }

    @Transactional
    public void update(Animal dto){
        
        Animal animal = animalRepository.findById(dto.getId()).get();
    
        animal.setDescription(dto.getDescription());
        animal.setDischargeDate(dto.getDischargeDate());
        animal.setCategory(dto.getCategory());
        animal.setScientific_name(dto.getScientific_name());
        animal.setSpecie(dto.getSpecie());
        animal.setDeleted(false);

        animalRepository.save(animal);

    }

    @Transactional(readOnly = true)
    public Animal getById(Integer id){
        return animalRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Animal> getAll(Integer id){
        return animalRepository.findAll();
    }

   
    @Transactional(readOnly = true)
    public void enableById(Integer id){
        animalRepository.enableById(id);  
    }

    @Transactional
    public void deleteById(Integer id) {
        animalRepository.deleteById(id);
    }

}
