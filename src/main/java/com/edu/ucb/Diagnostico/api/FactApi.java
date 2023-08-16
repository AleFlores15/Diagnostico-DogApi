package com.edu.ucb.Diagnostico.api;

import com.edu.ucb.Diagnostico.bl.FactBl;
import com.edu.ucb.Diagnostico.dto.FactDto;
import com.edu.ucb.Diagnostico.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")

@RestController
public class FactApi {
    @Autowired
    private FactBl factBl;
    @PostMapping("/api/v1/fact")
    public ResponseDto<String> saveFacts(/*@RequestBody FactDto factDto*/) {
        ResponseDto<String> response = new ResponseDto<>();

        try{
            this.factBl.saveFact();//factDto);

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
}
