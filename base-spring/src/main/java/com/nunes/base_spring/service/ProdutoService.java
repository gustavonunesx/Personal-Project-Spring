package com.nunes.base_spring.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nunes.base_spring.dto.ProdutoDTO;
import com.nunes.base_spring.model.ProdutoEntity;

@Service
public class ProdutoService {
    
    private List<ProdutoEntity> PRODUTOS = new ArrayList<>();

    static{
         ProdutoEntity.builder()
        .id(1)
        .nome("Notebook")
        .preco( new BigDecimal(4.500))
        .qtd(10)
        .build();
        ProdutoEntity.builder()
            .id(2)
            .nome("Mouse")
            .preco( new BigDecimal(39.90))
            .qtd(11)
            .build();
        ProdutoEntity.builder()
            .id(3)
            .nome("iphone")
            .preco( new BigDecimal(7.400))
            .qtd(10)
            .build();
    }

    public List<ProdutoEntity> getAll(){
        return new ArrayList<>(PRODUTOS);
    }



    public ProdutoEntity create(ProdutoDTO produtoDTO){

        Integer identificador = PRODUTOS.stream()
        .mapToInt(ProdutoEntity::getId)
        .max()
        .orElse(0) + 1;

        ProdutoEntity novoProduto = ProdutoEntity.builder()
            .id(identificador)
            .nome(produtoDTO.getNome())
            .preco(produtoDTO.getPreco())
            .qtd(produtoDTO.getQtd())
        .build();

        PRODUTOS.add(novoProduto);
        return novoProduto;
    }

}
