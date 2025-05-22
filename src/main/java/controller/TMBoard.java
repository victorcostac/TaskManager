/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import domain.Board;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class TMBoard extends AbstractTableModel{    private List lista  = new ArrayList();  

    @Override
    public int getColumnCount() {
        return 5;   // Quantidade de colunas da TABELA
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Board board = (Board) lista.get(rowIndex);
        switch ( columnIndex ) {
            case 0: return board.getId();
            case 1: return board.getNome();
            case 2: return board.getDescricao();
            case 3: return board.getProprietario();
            case 4: return board.getStatus();

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String nomes[] = {"Id", "Nome", "Descrição", "Proprietário", "status"};
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
