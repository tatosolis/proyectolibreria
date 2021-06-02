
package ejerciciolibreria;

import controlador.ControladorAutor;
import controlador.ControladorLibro;
import controlador.ControladorMenu;
import modelo.AutorVO;
import modelo.LibreriaDAO;
import modelo.LibroVO;
import vista.Frm_Autores;
import vista.Frm_Libros;
import vista.Frm_Menu;


public class EjercicioLibreria {


    public static void main(String[] args) {
        
        //Implemenacion de vistas
    Frm_Menu me = new Frm_Menu();
    
    Frm_Autores au = new Frm_Autores();
    Frm_Libros li = new Frm_Libros();
    
        //Implementacion de datos
        
         AutorVO avo= new AutorVO();
         LibroVO lvo= new LibroVO();
         LibreriaDAO ldao = new LibreriaDAO();
         
        
        //Controladores
        ControladorMenu cm = new ControladorMenu(me, au, li);
        ControladorAutor ca = new ControladorAutor(au,avo,ldao);
        ControladorLibro cl = new ControladorLibro(li,lvo,ldao);
        
        //Activa menu
        me.setVisible(true);
     //   au.setVisible(true);
        me.setLocationRelativeTo(me);
       // au.setLocationRelativeTo(au);
    }
    
}
