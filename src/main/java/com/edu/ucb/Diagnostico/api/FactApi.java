package com.edu.ucb.Diagnostico.api;

import com.edu.ucb.Diagnostico.bl.FactBl;
import com.edu.ucb.Diagnostico.dao.FactRepository;
import com.edu.ucb.Diagnostico.dto.FactDto;
import com.edu.ucb.Diagnostico.dto.ResponseDto;
import com.edu.ucb.Diagnostico.entity.FactEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")

@RestController
public class FactApi {
    @Autowired
    private FactBl factBl;

    @Autowired
    FactRepository factRepository;
    @PostMapping("/api/v1/pet/{petId}/fact")
    public ResponseDto<String> saveFacts(@PathVariable Long petId) {
        ResponseDto<String> response = new ResponseDto<>();
        try{
            this.factBl.saveFact(petId);
            response.setCode("0000");
            response.setResponse("Fact saved");
            return response;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            response.setCode("9999");
            response.setErrorMessage("Internal error");
            return response;
        }
    }


    @GetMapping("/api/v1/pet/{petId}/fact")
    public ResponseDto<Page<FactDto>> getFacts(
        @PathVariable Long petId,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ){
        ResponseDto<Page<FactDto>> response = new ResponseDto<>();
        Pageable pageable = PageRequest.of(page, size);
        try{
            Page<FactDto> factDtoPage = this.factBl.findFacts(petId, pageable); 
            response.setCode("0000");
            response.setResponse(factDtoPage);
            return response;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            response.setCode("9999");
            response.setErrorMessage("Internal error");
            return response;
        }
    }


    @PutMapping("/api/v1/user/{userid}/fact/{id}")
    public ResponseDto<String> updateFact(@PathVariable Long id, @PathVariable Long userid, @RequestBody FactDto factDto) {
        ResponseDto<String> response = new ResponseDto<>();
        try{
            this.factBl.updateFact(id, userid, factDto);
            response.setCode("0000");
            response.setResponse("Fact updated");
            return response;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            response.setCode("9999");
            response.setErrorMessage("Internal error");
            return response;
        }
    }

    @DeleteMapping("/api/v1/user/{userid}/fact/{id}")
    public ResponseDto<String> deleteFact(@PathVariable Long id, @PathVariable Long userid) {
        ResponseDto<String> response = new ResponseDto<>();
        try{
            this.factBl.deleteFact(id, userid);
            response.setCode("0000");
            response.setResponse("Fact deleted");
            return response;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            response.setCode("9999");
            response.setErrorMessage("Internal error");
            return response;
        }
    }


}
