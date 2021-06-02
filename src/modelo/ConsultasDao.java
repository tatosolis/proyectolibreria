
package modelo;

import java.util.ArrayList;


public interface ConsultasDao {
    public void insertar(AutorVO p);
    public void actualizar(AutorVO p);
    public void eliminar(AutorVO p);
    public ArrayList<AutorVO> consultarTablaAutor();
    public void insertarLibro(LibroVO p);
    public void actualizarLibro(LibroVO p);
    public void eliminarLibro(LibroVO p);
    public ArrayList<LibroVO> consultarTablaLibro();
    
    
}
