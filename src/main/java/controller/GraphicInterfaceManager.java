/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
//controller.GraphicInterfaceManager
import Domain.Board;
import Domain.User;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import viewer.BoardRegisterDlg;
import viewer.ClientRegisterDlg;
import viewer.MainFrame;
import viewer.TaskRegisterDlg;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Usuário
 */
public class GraphicInterfaceManager { // Gerenciador de interface gráfica
    private BoardRegisterDlg boardRegisterDlg = null;
    private ClientRegisterDlg userRegisterDlg = null;
    private MainFrame mainFrame = null;
    private TaskRegisterDlg taskRegisterDlg = null;
    
    private DomainManager domainManager; // Gerenciador de Dompinio
    
    // ########  SINGLETON  #########
    private static final GraphicInterfaceManager myInstance = new GraphicInterfaceManager();
    
    private GraphicInterfaceManager(){
        try {
            this.domainManager = new DomainManager();
        }catch(Exception e){ //trocar pelo Exception certo depois
            JOptionPane.showMessageDialog(null, e, "ERROR AT INITIALIZATION",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public static GraphicInterfaceManager getMyInstance(){
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
    
    public void loadComboUsers(JComboBox combo){
        try {
            List list = domainManager.getUsers();
            combo.setModel(new DefaultComboBoxModel(list.toArray()));
        } catch (Exception ex) {// adiconar  as exceptions depois 
            JOptionPane.showMessageDialog(boardRegisterDlg, ex, "board registration", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void loadComboBoards(JComboBox combo){
        try {
            List list = domainManager.getBoards();
            combo.setModel(new DefaultComboBoxModel(list.toArray()));
        } catch (Exception ex) {// adiconar  as exceptions depois 
            JOptionPane.showMessageDialog(taskRegisterDlg, ex, "Task registration", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public List<Board> loadBoards(){
        return domainManager.getBoards();
    }
    
    public List<User> getUsers(){
        return domainManager.getUsers();
    }
    
    public void registerUserCreated(User user){
        domainManager.createUser(user);
    }
    
    public void registerBoardCreated(Board board) {
        domainManager.createBoard(board);
    }
    
    public void deleteBoardById(Long boardId){
        domainManager.deleteBoardById(boardId);
    }
    
    
    public void exit() {
        System.exit(0);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
        /* Create and display the form */
        GraphicInterfaceManager GIManager = GraphicInterfaceManager.getMyInstance();
        GIManager.openMainFrame();

    }
    
    
}
