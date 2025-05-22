/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package infrastructure;

import java.util.List;
/**
 *
 * @author 2023122760093
 */
public interface IGenericRepository {
    void inserir(Object obj);
    void alterar(Object obj);
    List listar(Class classe);
    Object get(Class classe, int id);
    void excluir(Object obj);
}
