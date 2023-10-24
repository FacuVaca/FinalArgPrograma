package AccesoADatos;

import Entidades.Dieta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Entidades.Paciente;

public class PacienteData {

    private Connection con = null;

    public PacienteData() {
        con = Conexion.getconexion();
    }

    public void guardarPaciente(Paciente paciente) {
        try {
            String sql = "INSERT INTO paciente (nombre, dni, domicilio, telefono) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getNombre());
            ps.setInt(2, paciente.getDni());
            ps.setString(3, paciente.getDomicilio());
            ps.setString(4, paciente.getTelefono());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                paciente.setIdPaciente(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se agrego exitosamente un paciente");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Conectar con la tabla paciente" + ex.getMessage());
        }
    }

    public void modificarPaciente(Paciente paciente) {
        String sql = "UPDATE paciente SET  nombre=?,dni=?, domicilio=?,telefono=?  WHERE idPaciente=?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, paciente.getNombre());
            ps.setInt(2, paciente.getDni());
            ps.setString(3, paciente.getDomicilio());
            ps.setString(4, paciente.getTelefono());
            ps.setInt(5, paciente.getIdPaciente());
            ps.executeUpdate();
            int exito = ps.executeUpdate();
            if (exito > 0) {
                JOptionPane.showMessageDialog(null, "Paciente Modificado");
            } else {
                JOptionPane.showMessageDialog(null, "El Paciente no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Conectar con la tabla paciente" + ex.getMessage());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "el dni debe ser numerico" + e.getMessage());
        }
    }

    public void eliminarPaciente(int idPaciente) {
        try {
            String sql = "DELETE FROM paciente WHERE idPaciente=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Paciente dado de baja");
            } else {
                JOptionPane.showMessageDialog(null, "El Paciente no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Conectar con la tabla paciente" + ex.getMessage());
        }
    }

    public Paciente buscarPacientePorID(int idPaciente) {

        Paciente paciente = null;

        try {
            String sql = "SELECT nombre, dni, domicilio, telefono FROM paciente WHERE idPaciente = ? ";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idPaciente);

            ResultSet resultado = ps.executeQuery();

            if (resultado.next()) {

                paciente = new Paciente();
                paciente.setIdPaciente(idPaciente);
                paciente.setNombre(resultado.getString("nombre"));
                paciente.setDni(resultado.getInt("dni"));
                paciente.setDomicilio(resultado.getString("domicilio"));
                paciente.setTelefono(resultado.getString("telefono"));

            } else {
                JOptionPane.showMessageDialog(null, "No existe ese paciente");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error en la conexion" + ex);
        }

        return paciente;

    }

    public Paciente buscarPacientePorDni(int dni) {

        Paciente paciente = null;

        try {
            String sql = "SELECT nombre, dni, domicilio, telefono, idPaciente FROM paciente WHERE dni = ? ";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, dni);

            ResultSet resultado = ps.executeQuery();

            if (resultado.next()) {

                paciente = new Paciente();

                paciente.setIdPaciente(resultado.getInt("idPaciente"));
                paciente.setNombre(resultado.getString("nombre"));
                paciente.setDni(resultado.getInt("dni"));
                paciente.setDomicilio(resultado.getString("domicilio"));
                paciente.setTelefono(resultado.getString("telefono"));

            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error en la conexion" + ex);
        }

        return paciente;

    }

    public List<Paciente> ListarPacientes() {

        Paciente paciente = null;

        String sql = "SELECT nombre, dni, domicilio, telefono, idPaciente FROM paciente ";

        ArrayList<Paciente> pacientes = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {

                paciente = new Paciente();

                paciente.setIdPaciente(resultado.getInt("idPaciente"));
                paciente.setNombre(resultado.getString("nombre"));
                paciente.setDni(resultado.getInt("dni"));
                paciente.setDomicilio(resultado.getString("domicilio"));
                paciente.setTelefono(resultado.getString("telefono"));

                pacientes.add(paciente);

            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error en la conexion" + ex);
        }

        return pacientes;

    }

    public Paciente obtenerPacientePorId(int idPaciente) {

        for (Paciente paciente : ListarPacientes()) {
            if (paciente.getIdPaciente() == idPaciente) {
                return paciente;
            }
        }
        return null;
    }

    public List<Dieta> ListarDietas(int idPaciente, Paciente paciente) {
        String sql = "SELECT idDieta,nombre,idPaciente,fechaInicial,pesoInicial,pesoFinal,fechaFinal,altura FROM dieta WHERE idPaciente=?";
        Dieta dieta = null;

        ArrayList<Dieta> dietas = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dieta = new Dieta();

                dieta.setIdDieta(rs.getInt("idDieta"));
                dieta.setNombre(rs.getString("nombre"));
                dieta.setPaciente(paciente);
                dieta.setFechaInicial(rs.getDate("fechaInicial").toLocalDate());
                dieta.setPesoInicial(rs.getInt("pesoInicial"));
                dieta.setPesoFinal(rs.getInt("pesoFinal"));
                dieta.setFechaFinal(rs.getDate("fechaFinal").toLocalDate());
                dieta.setAltura(rs.getInt("altura"));
                dietas.add(dieta);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return dietas;
    }
}
