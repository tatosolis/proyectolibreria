package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.AutorVO;
import modelo.LibreriaDAO;
import vista.Frm_Autores;

public class ControladorAutor implements ActionListener, MouseListener, WindowListener {

    Frm_Autores vista = new Frm_Autores();
    AutorVO avo = new AutorVO();
    LibreriaDAO ldao = new LibreriaDAO();

    public ControladorAutor(Frm_Autores vista, AutorVO avo, LibreriaDAO ldao) {
        this.vista = vista;
        this.avo = avo;
        this.ldao = ldao;
        vista.addWindowListener(this);
        vista.Btn_Insertar.addActionListener(this);
        vista.Btn_Modificar.addActionListener(this);
        vista.Btn_Eliminar.addActionListener(this);
        vista.Btn_Salir.addActionListener(this);
        vista.Tbl_Autores.addMouseListener(this);
    }

    //Llena tabla
    private void mostrar() {
        DefaultTableModel m = new DefaultTableModel();
        m.setColumnCount(0);
        m.addColumn("Id");
        m.addColumn("Nombre");
        m.addColumn("Apellido");
        m.addColumn("Pais Origen");
        m.addColumn("Casa Editorial");
        for (AutorVO avo : ldao.consultarTablaAutor()) {
            m.addRow(new Object[]{avo.getId_autor(), avo.getNombre(), avo.getApellido(),
                avo.getPais_origen(), avo.getCasa_editorial()});
        }
        vista.Tbl_Autores.setModel(m);
    }
    //Inserta un autor
    private void insertarAutor(){
        avo.setNombre(vista.Txt_Nombre.getText());
        avo.setApellido(vista.Txt_Apellido.getText());
        avo.setPais_origen(vista.Txt_PaisOrigen.getText());
        avo.setCasa_editorial(vista.Txt_CasaEditorial.getText());
        ldao.insertar(avo);
    }
    
    //modifica un autor
        private void modificarAutor(){
        avo.setId_autor(Integer.parseInt(vista.Txt_IdAutor.getText()));
        avo.setNombre(vista.Txt_Nombre.getText());
        avo.setApellido(vista.Txt_Apellido.getText());
        avo.setPais_origen(vista.Txt_PaisOrigen.getText());
        avo.setCasa_editorial(vista.Txt_CasaEditorial.getText());
        ldao.actualizar(avo);
    }
    
        //Elimina un autor
        private void eliminarAutor(){
            avo.setId_autor(Integer.parseInt(vista.Txt_IdAutor.getText()));
            ldao.eliminar(avo);
        }
        private void limpiaCampos(){
            vista.Txt_IdAutor.setText("");
            vista.Txt_Nombre.setText("");
            vista.Txt_Apellido.setText("");
            vista.Txt_PaisOrigen.setText("");
            vista.Txt_CasaEditorial.setText("");
        }


    @Override
    public void actionPerformed(ActionEvent ae) {
         if(ae.getSource()==vista.Btn_Insertar){
            try {
                this.insertarAutor();
                
                vista.Jop.showMessageDialog(null, "Registro Insertado");
                this.limpiaCampos();
                this.mostrar();
                
            } catch (Exception e) {
                vista.Jop.showMessageDialog(null, "Registro no Insertado");
                this.limpiaCampos();
            }
       }
         
         if(ae.getSource()==vista.Btn_Modificar){
            try {
                this.modificarAutor();
                
                vista.Jop.showMessageDialog(null, "Registro Actualizado");
                this.limpiaCampos();
                this.mostrar();
                
            } catch (Exception e) {
                vista.Jop.showMessageDialog(null, "Registro no Actualizado");
                this.limpiaCampos();
            }
       }
         
         if(ae.getSource()==vista.Btn_Eliminar){
            try {
                this.eliminarAutor();
                
                vista.Jop.showMessageDialog(null, "Registro Eliminado");
                this.limpiaCampos();
                this.mostrar();
                
            } catch (Exception e) {
                vista.Jop.showMessageDialog(null, "Registro no Eliminado");
                this.limpiaCampos();
            }
       }
         
           if(ae.getSource()==vista.Btn_Salir){
            vista.dispose();
       }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
         int seleccion = vista.Tbl_Autores.getSelectedRow();
         vista.Txt_IdAutor.setText(String.valueOf(vista.Tbl_Autores.getValueAt(seleccion, 0)));
         vista.Txt_Nombre.setText(String.valueOf(vista.Tbl_Autores.getValueAt(seleccion, 1)));
         vista.Txt_Apellido.setText(String.valueOf(vista.Tbl_Autores.getValueAt(seleccion, 2)));
         vista.Txt_PaisOrigen.setText(String.valueOf(vista.Tbl_Autores.getValueAt(seleccion, 3)));
         vista.Txt_CasaEditorial.setText(String.valueOf(vista.Tbl_Autores.getValueAt(seleccion, 4)));
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void windowOpened(WindowEvent we) {
        this.mostrar();
    }

    @Override
    public void windowClosing(WindowEvent we) {
        vista.dispose();
    }

    @Override
    public void windowClosed(WindowEvent we) {
        vista.dispose();
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }

}
