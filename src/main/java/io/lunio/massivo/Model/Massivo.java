package io.lunio.massivo.Model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa um evento massivo armazenado no banco de dados.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "massive-event")  
public class Massivo {

    @Id
    private String id;     
                 
    private LocalDateTime horario;      
    private String desk;               
    private Integer tk;                

}
