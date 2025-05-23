/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.Board;
import infrastructure.GenericRepository;
import java.util.List;

/**
 *
 * @author 2023122760093
 */
public class GenericService {
    
    private final GenericRepository repository;
    
    public GenericService(GenericRepository repository) {
        this.repository = repository;
    }

    public void criar(Object obj) {
        repository.inserir(obj);
    }

    public List<Object> listar(Class classe) {
        return repository.listar(classe);
    }

    public void deletar(Object obj) {
        repository.excluir(obj);
    }
    
    public void alterar(Object obj) {
        repository.alterar(obj);
    }
}
