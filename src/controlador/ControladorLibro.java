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
import modelo.LibroVO;
import vista.Frm_Libros;

public class ControladorLibro implements ActionListener, MouseListener, WindowListener {

    Frm_Libros vista = new Frm_Libros();
    LibroVO lvo = new LibroVO();
    LibreriaDAO ldao = new LibreriaDAO();

    public ControladorLibro(Frm_Libros vista, LibroVO lvo, LibreriaDAO ldao) {
        this.vista = vista;
        this.lvo = lvo;
        this.ldao = ldao;
        vista.addWindowListener(this);
        vista.Btn_Agregar.addActionListener(this);
        vista.Btn_Modificar.addActionListener(this);
        vista.Btn_Eliminar.addActionListener(this);
        vista.Btn_Salir.addActionListener(this);
        vista.Tbl_Libros.addMouseListener(this);
        // vista.Box_Autor.addActionListener(this);

    }

    //Llena tabla
    private void mostrar() {
        DefaultTableModel m = new DefaultTableModel();
        m.setColumnCount(0);
        m.addColumn("Id Libro");
        m.addColumn("Nombre de Libro");
        m.addColumn("Genero");
        m.addColumn("Resumen");
        m.addColumn("Precio");
        m.addColumn("Id Autor");
        m.addColumn("Nombre");
        m.addColumn("Apellido");
        for (LibroVO lvo : ldao.consultarTablaLibro()) {
            m.addRow(new Object[]{lvo.getId_libro(), lvo.getNombre_libro(), lvo.getGenero(),
                lvo.getResumen(), lvo.getPrecio(), lvo.getId_autor(), lvo.getNombre_autor(), lvo.getApellido_autor()});
        }
        vista.Tbl_Libros.setModel(m);
    }

    private void insertaLibro() {

        lvo.setNombre_libro(vista.Txt_NombreLibro.getText());
        lvo.setGenero(vista.Txt_Genero.getText());
        lvo.setResumen(vista.Txt_Resumen.getText());
        lvo.setPrecio(Float.parseFloat(vista.Txt_Precio.getText()));
        lvo.setId_autor(Integer.parseInt(vista.txt_autor.getText()));
        ldao.insertarLibro(lvo);
    }

    private void modificarLibro() {
        lvo.setNombre_libro(vista.Txt_NombreLibro.getText());
        lvo.setGenero(vista.Txt_Genero.getText());
        lvo.setResumen(vista.Txt_Resumen.getText());
        lvo.setPrecio(Float.parseFloat(vista.Txt_Precio.getText()));
        lvo.setId_autor(Integer.parseInt(vista.txt_autor.getText()));
        lvo.setId_libro(Integer.parseInt(vista.Txt_IdLibro.getText()));
        ldao.actualizarLibro(lvo);

    }

    private void eliminarLibro() {
        lvo.setId_libro(Integer.parseInt(vista.Txt_IdLibro.getText()));
        ldao.eliminarLibro(lvo);
    }

    private void llenaCampos() {
        int seleccion = vista.Tbl_Libros.getSelectedRow();
        vista.Txt_IdLibro.setText(String.valueOf(vista.Tbl_Libros.getValueAt(seleccion, 0)));
        vista.Txt_NombreLibro.setText(String.valueOf(vista.Tbl_Libros.getValueAt(seleccion, 1)));
        vista.Txt_Genero.setText(String.valueOf(vista.Tbl_Libros.getValueAt(seleccion, 2)));
        vista.Txt_Resumen.setText(String.valueOf(vista.Tbl_Libros.getValueAt(seleccion, 3)));
        vista.Txt_Precio.setText(String.valueOf(vista.Tbl_Libros.getValueAt(seleccion, 4)));
        vista.txt_autor.setText(String.valueOf(vista.Tbl_Libros.getValueAt(seleccion, 5)));

    }

    private void limpiaCampos() {
        vista.Txt_Genero.setText("");
        vista.Txt_IdLibro.setText("");
        vista.Txt_NombreLibro.setText("");
        vista.Txt_Precio.setText("");
        vista.Txt_Resumen.setText("");
        vista.txt_autor.setText("");
    }
    // }
//    private void llenaComboAutor(){
//        vista.Box_Autor.removeAllItems();
//       // vista.Box_Autor.addItem("opciones");
//       // DefaultTableModel m = new DefaultTableModel();
//        for (AutorVO avo : ldao.consultarTablaAutor()) {
//            vista.Box_Autor.addItem(avo.getId_autor()+"-"+avo.getApellido()+","+avo.getNombre());
//        }
//       // vista.txt_autor.setText(vista.Box_Autor.getSelectedItem().toString());

//    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista.Btn_Agregar) {
            this.insertaLibro();
            this.limpiaCampos();
            this.mostrar();
        }

        if (ae.getSource() == vista.Btn_Modificar) {
            this.modificarLibro();
            this.limpiaCampos();
            this.mostrar();
        }

        if (ae.getSource() == vista.Btn_Eliminar) {
            this.eliminarLibro();
            this.limpiaCampos();
            this.mostrar();
        }

        if (ae.getSource() == vista.Btn_Salir) {
            vista.dispose();
        }

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        this.llenaCampos();

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
    }

    @Override
    public void windowClosed(WindowEvent we) {
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
