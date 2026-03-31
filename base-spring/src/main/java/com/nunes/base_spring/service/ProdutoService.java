package com.nunes.base_spring.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.nunes.base_spring.dto.ProdutoDTO;
import com.nunes.base_spring.exeption.NotFoundException;
import com.nunes.base_spring.model.ProdutoEntity;

@Service
public class ProdutoService {
    
    private static final List<ProdutoEntity> PRODUTOS = new ArrayList<>();

    static{
         PRODUTOS.add(ProdutoEntity.builder()
        .id(1)
        .nome("Notebook")
        .preco( new BigDecimal(4500))
        .qtd(10)
        .build());
        PRODUTOS.add(ProdutoEntity.builder()
            .id(2)
            .nome("Mouse")
            .preco( new BigDecimal(39.00))
            .qtd(11)
            .build());
        PRODUTOS.add(ProdutoEntity.builder()
            .id(3)
            .nome("iphone")
            .preco( new BigDecimal(7400))
            .qtd(10)
            .build());
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


    public ProdutoEntity atualizarProduto(ProdutoDTO produtoDTO, Integer id) throws NotFoundException{

        ProdutoEntity produto = PRODUTOS.stream()
                .filter(p -> p.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new NotFoundException("Produto nao encontrado"));

        produto.setNome(produtoDTO.getNome());
        produto.setPreco(produtoDTO.getPreco());
        produto.setQtd(produtoDTO.getQtd());
        return produto;
    }

    public void deleteProduct(Integer id){
        PRODUTOS.removeIf(p -> p.getId().equals(id));
    }

}
