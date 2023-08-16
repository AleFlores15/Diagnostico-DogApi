package com.edu.ucb.Diagnostico.bl;

import com.edu.ucb.Diagnostico.dao.FactRepository;
import com.edu.ucb.Diagnostico.dto.FactDto;
import com.edu.ucb.Diagnostico.dto.ResponseDto;
import com.edu.ucb.Diagnostico.entity.FactEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class FactBl {
    // Inyectar el repositorio
    @Autowired
    private FactRepository factRepository;



    public void saveFact(Long petId) {
        Date fechaActual = new Date();
        String apiUrl = "https://dog-api.kinduff.com/api/facts";
        RestTemplate restTemplate = new RestTemplate();
        FactDto response = restTemplate.getForObject(apiUrl, FactDto.class);
        final Logger log = LoggerFactory.getLogger(FactBl.class);
        log.info("oasiosaoinfi;ans");
        System.out.println(response.getFacts());
        System.out.println(response);
        FactEntity factEntity = new FactEntity();
        factEntity.setFact(response.getFacts().get(0));
        factEntity.setStart_date(fechaActual);
        factEntity.setStatus(true);
        factEntity.setpetId(petId);
        
        factRepository.save(factEntity);
    }


    public Page<FactDto> findFacts(Long petId, Pageable pageable) {
        Page<FactEntity> factEntityPage = factRepository.findAllbyPetId(petId, pageable);
        return factEntityPage.map(this::convertToFactDto);
        
    }

    private FactDto convertToFactDto(FactEntity factEntity) {
        FactDto factDto = new FactDto();
        List<String> facts = new ArrayList<>();
        facts.add(factEntity.getFact());
        factDto.setFacts(facts);
        return factDto;
    }
   


    public void updateFact(Long id, Long userid, FactDto factDto) {
        FactEntity factEntity = factRepository.findById(id).get();
        factEntity.setFact(factDto.getFacts().get(0));
        factRepository.save(factEntity);
    }

    public void deleteFact(Long id, Long userid) {
        factRepository.deleteById(id);
    }






}
