package com.nunes.base_spring.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.nunes.base_spring.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.http.HttpStatus;
import com.nunes.base_spring.model.ProdutoEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.nunes.base_spring.dto.ProdutoDTO;
import com.nunes.base_spring.exeption.NotFoundException;

@RestController
@RequestMapping("/v1/produtos")
//gera o construtor com os atributos final, ou seja, o produtoService, e injeta a dependencia sem precisar do autowired
@RequiredArgsConstructor 
public class ProdutoController {

    //chamar o service para pegar os produtos sem autowired, melhor para testes unitarios
    private final ProdutoService produtoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoEntity> getAll(){
        return produtoService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity create(@RequestBody ProdutoDTO produtoDTO){
        return produtoService.create(produtoDTO);
    }

    @PutMapping("/{id}")
    public ProdutoEntity updateProduct(@PathVariable Integer id, @RequestBody ProdutoDTO produtoDTO) throws NotFoundException{
        return produtoService.atualizarProduto(produtoDTO,id);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct (@PathVariable Integer id){
        produtoService.deleteProduct(id);
    }
}
