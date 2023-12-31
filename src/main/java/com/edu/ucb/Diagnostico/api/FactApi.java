package com.edu.ucb.Diagnostico.api;

import com.edu.ucb.Diagnostico.bl.FactBl;
import com.edu.ucb.Diagnostico.dao.FactRepository;
import com.edu.ucb.Diagnostico.dto.FactDto;
import com.edu.ucb.Diagnostico.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import com.edu.ucb.Diagnostico.command.Invoker;
import com.edu.ucb.Diagnostico.command.SaveFactCommand;
import com.edu.ucb.Diagnostico.command.Command;
@CrossOrigin(origins="*")

@RestController
public class FactApi {
    @Autowired
    private FactBl factBl;
    @Autowired
    FactRepository factRepository;

    @Autowired
    private Invoker invoker;

    @Autowired
    private Command saveFactCommand;


    @PostMapping("/api/v1/pet/{petId}/fact")
    public ResponseDto<String> saveFacts(@PathVariable Long petId) {
        ResponseDto<String> response = new ResponseDto<>();
        try {
            invoker.addCommand(saveFactCommand); // Añade el comando al Invoker
            invoker.executeCommands(petId); // Ejecuta los comandos
            response.setCode("0000");
            response.setResponse("Fact saved");
            return response;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            response.setCode("9999");
            response.setErrorMessage("Internal error");
            return response;
        }
    }

    @PostMapping("/api/v1/pet/{petId}/savefact")
    public ResponseDto<String> saveFact(@PathVariable Long petId, @RequestBody FactDto factDto) {
        ResponseDto<String> response = new ResponseDto<>();
        try{
            this.factBl.saveManualFact(petId, factDto);
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
        Pageable pageable = PageRequest.of(page, size, Sort.by("fact.fact_id").descending() );
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


    @PutMapping("/api/v1/fact/{id}")
    public ResponseDto<String> updateFact(@PathVariable Long id, @RequestBody FactDto factDto) {
        ResponseDto<String> response = new ResponseDto<>();
        try{
            this.factBl.updateFact(id, factDto);
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

    @PutMapping("/api/v1/delete/fact/{id}")
    public ResponseDto<String> deleteFact2(@PathVariable Long id) {
        ResponseDto<String> response = new ResponseDto<>();
        try{
            this.factBl.deleteByStatus(id);
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

    
    @DeleteMapping("/api/v1/fact/{id}")
    public ResponseDto<String> deleteFact(@PathVariable Long id) {
        ResponseDto<String> response = new ResponseDto<>();
        try{
            this.factBl.deleteFact(id);
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
