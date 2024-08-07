package io.lunio.massivo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.lunio.massivo.Model.Massivo;
import io.lunio.massivo.service.MassivoService;

@RestController
@RequestMapping("/massivo")
public class MassivoController {
 
    @Autowired
     private MassivoService massivoService;

    @PostMapping
    public Massivo createMassivo(@RequestBody Massivo massivo) {
        return massivoService.saveMassivo(massivo);
    }

    @GetMapping("/{id}")
    public Massivo getMassivoById(@PathVariable String id) {
        Optional<Massivo> massivo = massivoService.getMassivoById(id);
        return massivo.orElse(null); // Retorna null se não encontrar
    }

    @GetMapping
    public List<Massivo> getAllMassivos() {
        return massivoService.getAllMassivos();
    }

    @PutMapping("/{id}")
    public Massivo updateMassivo(@PathVariable String id, @RequestBody Massivo massivo) {
        return massivoService.updateMassivo(id, massivo);
    }

    @DeleteMapping("/{id}")
    public void deleteMassivoById(@PathVariable String id) {
        massivoService.deleteMassivoById(id);
    }
}
