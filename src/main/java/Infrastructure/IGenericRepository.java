/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package infrastructure;

import java.util.List;
import java.util.UUID;
/**
 *
 * @author 2023122760093
 */
public interface IGenericRepository {
    void inserir(Object obj);
    void alterar(Object obj);
    List listar(Class classe);
    public <T> T get(Class<T> clazz, UUID id);
    void excluir(Object obj);
}
