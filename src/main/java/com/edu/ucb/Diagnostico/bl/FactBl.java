package com.edu.ucb.Diagnostico.bl;

import com.edu.ucb.Diagnostico.dao.FactRepository;
import com.edu.ucb.Diagnostico.dto.FactDto;
import com.edu.ucb.Diagnostico.entity.FactEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    
    @Autowired
    private FactRepository factRepository;


    // Variable de configuracion del api
    @Value("${api.url}")
    private String apiUrl;

    private final Logger log = LoggerFactory.getLogger(FactBl.class);

    public void saveFact(Long petId) {
        Date fechaActual = new Date();
        
        //String apiUrl = "https://dog-api.kinduff.com/api/facts";
        RestTemplate restTemplate = new RestTemplate();
        FactDto response = restTemplate.getForObject(this.apiUrl, FactDto.class);
       
        log.info("Guardando la siguiente fact: " + response.getFacts().get(0) + " para la mascota con id: " + petId );

        FactEntity factEntity = new FactEntity();
        factEntity.setFact(response.getFacts().get(0));
        factEntity.setStart_date(fechaActual);
        factEntity.setStatus(true);
        factEntity.setpetId(petId);
        
        factRepository.save(factEntity);

        log.info("Fact guardada con exito");
    }


    public Page<FactDto> findFacts(Long petId, Pageable pageable) {
        log.info("Buscando facts de la mascota con id: " + petId);
        Page<FactEntity> factEntityPage = factRepository.findAllbyPetId(petId, pageable);
        return factEntityPage.map(this::convertToFactDto);        
    }

    private FactDto convertToFactDto(FactEntity factEntity) {
        FactDto factDto = new FactDto();
        List<String> facts = new ArrayList<>();
        facts.add(factEntity.getFact());
        factDto.setFacts(facts);
        factDto.setStart_date(factEntity.getStart_date());
        factDto.setStatus(factEntity.getStatus());
        factDto.setPetId(factEntity.getpetId());
        
        return factDto;
    }
   


    public void updateFact(Long id, FactDto factDto) {
        log.warn("Actualizando fact con id: " + id);
        FactEntity factEntity = factRepository.findById(id).get();
        factEntity.setFact(factDto.getFacts().get(0));
        factRepository.save(factEntity);
    }

    public void deleteFact(Long id) {
        log.warn("Eliminando fact con id: " + id);
        factRepository.deleteById(id);
    }






}
