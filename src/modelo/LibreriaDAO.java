package modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

public class LibreriaDAO implements ConsultasDao {

    @Override
    public void insertar(AutorVO p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "exec InsertaAutor '" + p.getNombre() + "','"
                    + p.getApellido() + "','" + p.getPais_origen() + "','" + p.getCasa_editorial() + "';";
            c.consultas_multiples(consulta);

        } catch (Exception e) {
            System.err.println("mensaje insertar: " + e.getMessage());
        }
        c.desconectar();
    }

    @Override
    public void actualizar(AutorVO p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "exec ModificaAutor " +p.getId_autor()+",'" + p.getNombre() + "','"
                    + p.getApellido() + "','" + p.getPais_origen() + "','" + p.getCasa_editorial() + "';";
            c.consultas_multiples(consulta);

        } catch (Exception e) {
            System.err.println("mensaje modificar: " + e.getMessage());
        }
        c.desconectar();

    }

    @Override
    public void eliminar(AutorVO p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "exec EliminaAutor " + p.getId_autor();
            c.consultas_multiples(consulta);

        } catch (Exception e) {
            System.err.println("mensaje eliminar: " + e.getMessage());
        }
        c.desconectar();
    }

    @Override
    public ArrayList<AutorVO> consultarTablaAutor() {
        Conector c = new Conector();
        ArrayList<AutorVO> info = new ArrayList<>();
        try {
            c.conectar();
            String consulta = "SELECT * FROM Tblautor;";
            ResultSet rs = c.consulta_datos(consulta);
            while (rs.next()) {
                AutorVO avo = new AutorVO();
                avo.setId_autor(rs.getInt(1));
                avo.setNombre(rs.getString(2));
                avo.setApellido(rs.getString(3));
                avo.setPais_origen(rs.getString(4));
                avo.setCasa_editorial(rs.getString(5));

                info.add(avo);

            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error al mostar datos " + e.getMessage());
        }

        return info;
    }

    @Override
    public ArrayList<LibroVO> consultarTablaLibro() {
        Conector c = new Conector();
        ArrayList<LibroVO> info = new ArrayList<>();
        try {
            c.conectar();
            String consulta = "select l.id_libro,l.nombre_libro, l.genero,l.resumen, l.precio, l.id_autor, a.nombre, a.apellido "
                    + "from tbllibro l left join  tblautor a on a.id_autor = l.id_autor";
            ResultSet rs = c.consulta_datos(consulta);
            while (rs.next()) {
//                AutorVO avo = new AutorVO();
                LibroVO lvo = new LibroVO();
                lvo.setId_libro(rs.getInt(1));
                lvo.setNombre_libro(rs.getString(2));
                lvo.setGenero(rs.getString(3));
                lvo.setResumen(rs.getString(4));
                lvo.setPrecio(rs.getLong(5));
                lvo.setId_autor(rs.getInt(6));
                lvo.setNombre_autor(rs.getString(7));
                lvo.setApellido_autor(rs.getString(8));
                info.add(lvo);

            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error al mostrar datos " + e.getMessage());
        }

        return info;
    }

    @Override
    public void insertarLibro(LibroVO p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "exec InsertaLibro '" + p.getNombre_libro() + "','"
                    + p.getGenero() + "','" + p.getResumen() + "'," + p.getPrecio()
                    + "," + p.getId_autor() + ";";
            c.consultas_multiples(consulta);

        } catch (Exception e) {
            System.err.println("mensaje insertar: " + e.getMessage());
        }
        c.desconectar();
    }

    @Override
    public void actualizarLibro(LibroVO p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "exec ModificaLibro "+p.getId_libro()+ ",'" + p.getNombre_libro() + "','"
                    + p.getGenero() + "','" + p.getResumen() + "'," + p.getPrecio()
                    + "," + p.getId_autor() + ";";
            c.consultas_multiples(consulta);

        } catch (Exception e) {
            System.err.println("mensaje insertar: " + e.getMessage());
        }
        c.desconectar();

    }

    @Override
    public void eliminarLibro(LibroVO p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "exec EliminaLibro " + p.getId_libro();
            c.consultas_multiples(consulta);

        } catch (Exception e) {
            System.err.println("mensaje eliminar: " + e.getMessage());
        }
        c.desconectar();
    }

}
