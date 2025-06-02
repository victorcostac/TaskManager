/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import domain.Board;
import domain.Endereco;
import domain.Tarefa;
import domain.Usuario;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;

import viewer.BoardRegisterDlg;
import viewer.ClientRegisterDlg;
import viewer.MainFrame;
import viewer.TaskRegisterDlg;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Usuário
 */
public class GerenciadorInterGrafica { // Gerenciador de interface gráfica
    private BoardRegisterDlg boardRegisterDlg = null;
    private ClientRegisterDlg userRegisterDlg = null;
    private MainFrame mainFrame = null;
    private TaskRegisterDlg taskRegisterDlg = null;
    
    private GerenciadorDominio gerenciadorDominio; // Gerenciador de Dompinio
    
    // ########  SINGLETON  #########
    private static final GerenciadorInterGrafica myInstance = new GerenciadorInterGrafica();
    
    private GerenciadorInterGrafica(){
        try {
            this.gerenciadorDominio = new GerenciadorDominio();
        } catch (java.lang.ExceptionInInitializerError | HibernateException ex) {
            System.err.println("Initial SessionFactory creation failed." + ex.getCause());
            JOptionPane.showMessageDialog(null, ex, "Erro ao inicializar.", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public static GerenciadorInterGrafica getMyInstance(){
        return myInstance;
    }
    
    // ######### SINGLETON ###########
    
    // ABRIR JDIALOG
    private JDialog openWindow(java.awt.Frame parent, JDialog dlg, Class classe){
        if (dlg == null){     
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class).newInstance(parent,true);    
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName() + ". " + ex.getMessage() );
            } 
        }    
        dlg.setLocation(parent.getLocation());
        dlg.setVisible(true); 
        return dlg;
    }   
    
    public void openMainFrame(){ //ABRIR JANELA PRINCIPAL
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
    
    public void openBoardRegisterDlg(){
        boardRegisterDlg = (BoardRegisterDlg) openWindow(mainFrame, boardRegisterDlg, BoardRegisterDlg.class);
    }
    
    public void openClientRegisterDlg() {
        userRegisterDlg = (ClientRegisterDlg) openWindow(mainFrame, userRegisterDlg, ClientRegisterDlg.class);
    }
    
    public void openTaskRegisterDlg() {
        taskRegisterDlg = (TaskRegisterDlg) openWindow(mainFrame, taskRegisterDlg, TaskRegisterDlg.class);
    }
    
    /*public void loadComboUsers(JComboBox combo){
        try {
            List list = getUsuarios();
            combo.setModel(new DefaultComboBoxModel(list.toArray()));
        } catch (Exception ex) {// adiconar  as exceptions depois 
            JOptionPane.showMessageDialog(boardRegisterDlg, ex, "board registration", JOptionPane.ERROR_MESSAGE);
        }
    }*/
    
    public void loadCombo(JComboBox combo, Class classe){
        try {
            List list = this.gerenciadorDominio.listar(classe);
            combo.setModel(new DefaultComboBoxModel(list.toArray()));
        } catch (Exception ex) {// adiconar  as exceptions depois 
            JOptionPane.showMessageDialog(taskRegisterDlg, ex, "Task registration", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void exit() {
        System.exit(0);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        Usuario usuario = new Usuario();
        usuario.setNome("VICTOR");
        System.out.println("Nome do Usuario:  ==== "+usuario.getNome());  
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        // TRADUÇÃO
        /*
        javax.swing.UIManager.put("OptionPane.yesButtonText", "Sim");
        javax.swing.UIManager.put("OptionPane.noButtonText", "Não");
        javax.swing.UIManager.put("OptionPane.cancelButtonText", "Cancelar");
*/
        
                /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciadorInterGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        GerenciadorInterGrafica GIManager = GerenciadorInterGrafica.getMyInstance();
        GIManager.openMainFrame();

    }

    public GerenciadorDominio getGerenciadorDominio() {
        return gerenciadorDominio;
    }
}
