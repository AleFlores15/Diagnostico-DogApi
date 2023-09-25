package com.edu.ucb.Diagnostico.command;

import com.edu.ucb.Diagnostico.bl.FactBl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveFactCommand implements Command {

    @Autowired
    private FactBl factBl;

    @Override
    public void execute(Long petId) {
        factBl.saveFact(petId);
    }
}