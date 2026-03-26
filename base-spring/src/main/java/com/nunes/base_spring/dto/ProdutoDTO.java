package com.nunes.base_spring.dto;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Builder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class ProdutoDTO {

    private String nome;
    private BigDecimal preco;
    private int qtd;
    
}
