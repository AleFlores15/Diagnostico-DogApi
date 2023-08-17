package com.edu.ucb.Diagnostico.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.ucb.Diagnostico.bl.PetBl;
import com.edu.ucb.Diagnostico.dao.PetRepository;
import com.edu.ucb.Diagnostico.dto.PetDto;
import com.edu.ucb.Diagnostico.dto.ResponseDto;

@CrossOrigin(origins="*")

@RestController
public class PetApi {
    @Autowired
    private PetBl petBl;

    @Autowired
    PetRepository petRepository;

    @PostMapping("/api/v1/pet")
    public ResponseDto<String> savePet(@RequestBody PetDto pet) {
        ResponseDto<String> response = new ResponseDto<>();
        try{
            this.petBl.savePet(pet);
            response.setCode("0000");
            response.setResponse("Pet saved");
            return response;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            response.setCode("9999");
            response.setErrorMessage("Internal error");
            return response;
        }
    }

    @GetMapping("/api/v1/pet")
    public ResponseDto<List<PetDto>> getPet() {
        ResponseDto<List<PetDto>> response = new ResponseDto<>();
        try{
            List<PetDto> petDto = this.petBl.getPet();
            response.setCode("0000");
            response.setResponse(petDto);
            return response;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            response.setCode("9999");
            response.setErrorMessage("Internal error");
            return response;
        }
    }


    
}
