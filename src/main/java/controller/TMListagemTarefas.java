/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Tarefa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 2023122760093
 */
public class TMListagemTarefas extends AbstractTableModel{
    private List lista  = new ArrayList();  

    @Override
    public int getColumnCount() {
        return 6;   // Quantidade de colunas da TABELA
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Tarefa tarefa = (Tarefa) lista.get(rowIndex);
        switch ( columnIndex ) {
            case 0: return tarefa.getId();
            case 1: return tarefa.getNome();
            case 2: return tarefa.getResponsavel();
            case 3: return tarefa.getPrioridade();
            case 4: return tarefa.getFase();
            case 5: return tarefa.getDataVencimento();

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String nomes[] = {"Id", "Nome", "Responsável", "Prioridade", "Fase", "Vencimento"};
        return nomes[column];
    }
    
    
    public Object getItem (int rowIndex) {
        return lista.get(rowIndex);        
    }
    
    public void adicionar (Object obj) {
        lista.add(obj);
        fireTableRowsInserted( lista.size() - 1, lista.size() - 1 );
        
    }
    
    public void remover (int indice) {
        lista.remove(indice);
        fireTableRowsDeleted( indice, indice );
        
    }
    
    public void setLista(List novaLista) {
        if ( novaLista == null || novaLista.isEmpty()) {
            if ( !lista.isEmpty() ) {
                lista.clear();
                fireTableRowsDeleted(0,0);
            }
        } else {
            lista = novaLista;
            fireTableRowsInserted( 0, lista.size() - 1);
        }
        
    }
    
    public List getLista() {
        return lista;
    }
        
}
