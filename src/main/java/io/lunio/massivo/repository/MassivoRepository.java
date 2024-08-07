package io.lunio.massivo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.lunio.massivo.Model.Massivo;

@Repository
public interface MassivoRepository extends MongoRepository<Massivo, String>{

    //Encontre um Massivo pelo campo 'desk'
    Massivo findByDesk(String desk);
    
    //Encontre todos os Massivos com um código 'TK'específico
    List<Massivo> findByTk(Integer tk);
}
