
package AccesoADatos;

import Entidades.Comida;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class ComidaData {

    private Connection con = null;

    public ComidaData() {

        con = Conexion.getconexion();

    }

    public void guardarComida(Comida comida) {
        String repeticionCheck="Select * from comida where nombre=?";
        try {
            PreparedStatement psCheck=con.prepareStatement(repeticionCheck);
            psCheck.setString(1,comida.getNombre());
            ResultSet result=psCheck.executeQuery();
            if (!result.isBeforeFirst() ) {    
                String sql = "INSERT INTO comida (nombre, detalle,tipoComida,cantidadCalorias) VALUES (?,?,?,?) ";
                try {
                    PreparedStatement psInsert = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    psInsert.setString(1, comida.getNombre());
                    psInsert.setString(2, comida.getDetalle());
                    psInsert.setString(3, comida.getTipoComida());
                    psInsert.setInt(4, comida.getCantidadCalorias());
         
                    int listaModificada = psInsert.executeUpdate();
            
                    ResultSet rs = psInsert.getGeneratedKeys();
                    if(rs.next()){
                        comida.setIdComida(rs.getInt(1));
                    }
                    if (listaModificada > 0) {
                        JOptionPane.showMessageDialog(null, " La Comida ha sido añadida con exito");
                    }

                    psInsert.close();
                    psCheck.close();
                } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion");
                }
            } else {
            JOptionPane.showMessageDialog(null, "Comida Repetida");
            }
            
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion");
        }
      
                
        

    }

    public Comida buscarComida(int id) {
        Comida comida = null;

        try {
            String sql = "SELECT nombre,detalle, tipoComida ,cantidadCalorias FROM comida WHERE idComida = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet resultado = ps.executeQuery();

            if (resultado.next()) {

                comida = new Comida();

                comida.setIdComida(id);
                comida.setNombre(resultado.getString("nombre"));
                comida.setDetalle(resultado.getString("detalle"));
                comida.setTipoComida(resultado.getString("tipoComida"));
                comida.setCantidadCalorias(resultado.getInt("cantidadCalorias"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe esa Comida");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error en la conexion" + ex);
        }

        return comida;
    }

public boolean modificarComida(Comida comida) {
    try {
        String sql = "UPDATE comida SET nombre=?, detalle=?, tipoComida=?, cantidadCalorias=? WHERE idComida=?";

        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, comida.getNombre());
        ps.setString(2, comida.getDetalle());
        ps.setString(3, comida.getTipoComida());
        ps.setInt(4, comida.getCantidadCalorias());
        ps.setInt(5, comida.getIdComida()); 
        
        int exito = ps.executeUpdate();
        
        return exito == 1;
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al Conectar con la tabla comida: " + ex.getMessage());
        return false;
    }
}

     public void eliminarComida(String nombreComida) {
        try {
            String sql = "DELETE FROM comida WHERE comida.nombre=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreComida);
            int exito = ps.executeUpdate();
            if (exito > 0) {
                JOptionPane.showMessageDialog(null, "Comida eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "La comida no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Conectar con la tabla" + ex.getMessage());
        }
    }

    public List<Comida> listarComidas() {
        Comida comida = null;

        String sql = "SELECT nombre,detalle,tipoComida,cantidadCalorias,idComida FROM comida";

        ArrayList<Comida> comidas = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {

                comida = new Comida();
                comida.setNombre(resultado.getString("nombre"));
                comida.setDetalle(resultado.getString("detalle"));
                comida.setTipoComida(resultado.getString("tipoComida"));
                comida.setCantidadCalorias(resultado.getInt("cantidadCalorias"));
                comida.setIdComida(resultado.getInt("idComida"));
                comidas.add(comida);

            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error en la conexion" + ex);
        }

        return comidas;
    }
    public Comida obtenerComidaPorId(int idComida) {
    
    for (Comida comida : listarComidas()) {
        if (comida.getIdComida()== idComida) {
            return comida;
        }
    }
    return null; 
}
    public List <Comida> obtenerComidaPorNombre(String nombreComida) {
        ArrayList<Comida> listasComidas= new ArrayList<>();
         Comida comida = null;

        try {
            String sql = "SELECT nombre,detalle,tipoComida,cantidadCalorias,idComida FROM comida WHERE nombre = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombreComida);

            ResultSet resultado = ps.executeQuery();

            if (resultado.next()) {

                comida = new Comida();

                
                comida.setNombre(nombreComida);
                comida.setDetalle(resultado.getString("detalle"));
                comida.setTipoComida(resultado.getString("tipoComida"));
                comida.setCantidadCalorias(resultado.getInt("cantidadCalorias"));
                comida.setIdComida(resultado.getInt("idComida"));
                listasComidas.add(comida);
            } else {
                JOptionPane.showMessageDialog(null, "No existe esa Comida");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error en la conexion" + ex);
        }

        return listasComidas;
    }
}
