package com.edu.ucb.Diagnostico.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.ucb.Diagnostico.dao.PetRepository;
import com.edu.ucb.Diagnostico.dto.PetDto;
import com.edu.ucb.Diagnostico.entity.PetEntity;

@Service
public class PetBl {
    @Autowired
    private PetRepository petRepository;
    public void savePet(PetDto petDto) {
        PetEntity petEntity = new PetEntity();
        petEntity.setName(petDto.getName());
        petEntity.setBirthdate(petDto.getBirthdate());
        petEntity.setBreed(petDto.getBreed());
        petEntity.setStatus(petDto.isStatus());
        petRepository.saveAndFlush(petEntity);
    }

    public List<PetDto> getPet() {
        List<PetEntity> petEntityList = petRepository.findAll();
        return petEntityList.stream().map(petEntity -> {
            PetDto petDto = new PetDto();
            petDto.setPetId(petEntity.getPetId());
            petDto.setName(petEntity.getName());
            petDto.setBirthdate(petEntity.getBirthdate());
            petDto.setBreed(petEntity.getBreed());
            petDto.setStatus(petEntity.isStatus());
            return petDto;
        }).collect(java.util.stream.Collectors.toList());
        
    }

 }

    
    

