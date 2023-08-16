package com.edu.ucb.Diagnostico.bl;

import com.edu.ucb.Diagnostico.dao.FactRepository;
import com.edu.ucb.Diagnostico.dto.FactDto;
import com.edu.ucb.Diagnostico.dto.ResponseDto;
import com.edu.ucb.Diagnostico.entity.FactEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.sql.PreparedStatement;
@Service
public class FactBl {
    // Inyectar el repositorio
    @Autowired
    private FactRepository factRepository;

    public void saveFact() {
        String apiUrl = "https://dog-api.kinduff.com/api/facts";
        RestTemplate restTemplate = new RestTemplate();
        FactDto response = restTemplate.getForObject(apiUrl, FactDto.class);
        System.out.println(response.getFacts());
        System.out.println(response);
        FactEntity factEntity = new FactEntity();
        factEntity.setFact(response.getFacts().get(0));
        factEntity.setAnimalId(1L);
        factRepository.save(factEntity);



    }






}
