package io.lunio.massivo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.lunio.massivo.Model.Massivo;
import io.lunio.massivo.repository.MassivoRepository;


@Service
public class MassivoService {
    
    
    @Autowired
    private MassivoRepository massivoRepository;

    public Massivo saveMassivo(Massivo massivo) {
        if (massivo.getTk() != null) {
            massivo.setTk(massivo.getTk() * 100);
        }
        return massivoRepository.save(massivo);
    }

    public Optional<Massivo> getMassivoById(String id) {
        return massivoRepository.findById(id);
    }

    public List<Massivo> getAllMassivos() {
        return massivoRepository.findAll();
    }

    public void deleteMassivoById(String id) {
        massivoRepository.deleteById(id);
    }

    public Massivo updateMassivo(String id, Massivo massivo) {
        if (massivo.getTk() != null) {
            massivo.setTk(massivo.getTk() * 100);
        }
        massivo.setId(id);
        return massivoRepository.save(massivo);
    }

    public void saveEvent() {
    Massivo evento = Massivo.builder()
                            .horario(LocalDateTime.now())
                            .desk("Desk Example")
                            .tk(123)
                            .build();
    massivoRepository.save(evento);  // O MongoDB gera o ID automaticamente
}
}
