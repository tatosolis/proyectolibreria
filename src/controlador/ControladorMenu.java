
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Frm_Autores;
import vista.Frm_Libros;
import vista.Frm_Menu;


public class ControladorMenu implements ActionListener {
    Frm_Menu vMe = new Frm_Menu();
    Frm_Autores vAu = new Frm_Autores();
    Frm_Libros vLi = new Frm_Libros();
    
    public ControladorMenu(Frm_Menu vMe, Frm_Autores vAu,Frm_Libros vLi ){
        this.vAu = vAu;
        this.vLi = vLi;
        this.vMe = vMe;
        
        vMe.Op_Autores.addActionListener(this);
        vMe.Op_Libros.addActionListener(this);
        vMe.Op_Salir.addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== vMe.Op_Autores){
            
            vAu.setVisible(true);
            vAu.setLocationRelativeTo(null);
        }
        if(ae.getSource()== vMe.Op_Libros){
            vLi.setVisible(true);
            vLi.setLocationRelativeTo(null);
        }
        
         if(ae.getSource()== vMe.Op_Salir){
            vLi.dispose();
            
        }
    }
    
    
    
    
}
