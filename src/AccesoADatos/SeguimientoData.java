package AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Entidades.Paciente;
import java.sql.Date;
import Entidades.Comida;
import Entidades.Dieta;
import Entidades.Seguimiento;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SeguimientoData {

    private Connection con = null;

    public SeguimientoData() {
        con = Conexion.getconexion();

    }

    public void AgregarSeguimiento(Seguimiento seguimiento) {
        try {
            if (seguimiento == null || seguimiento.getPaciente() == null) {
                JOptionPane.showMessageDialog(null, "Datos de seguimiento incorrectos.");
                return;
            }

            LocalDate fechaSeguimiento = seguimiento.getFecha();
            int idPaciente = seguimiento.getPaciente().getIdPaciente();

            String sqlVerificarDieta = "SELECT COUNT(*) FROM Dieta WHERE idPaciente = ? AND (? BETWEEN fechaInicial AND fechaFinal OR ? BETWEEN fechaInicial AND fechaFinal)";
            try (PreparedStatement psVerificarDieta = con.prepareStatement(sqlVerificarDieta)) {
                psVerificarDieta.setInt(1, idPaciente);
                psVerificarDieta.setDate(2, Date.valueOf(fechaSeguimiento));
                psVerificarDieta.setDate(3, Date.valueOf(fechaSeguimiento));

                ResultSet rs = psVerificarDieta.executeQuery();
                if (rs.next()) {
                    int dietasExisten = rs.getInt(1);

                    if (dietasExisten > 1) {
                        JOptionPane.showMessageDialog(null, "No se pueden agregar seguimientos en una fecha que coincide con una dieta existente.");
                    } else {

                        String sqlInsertar = "INSERT INTO Seguimiento (idPaciente, fecha, medidaPecho, medidaCintura, medidaCadera, peso,idDieta) VALUES (?,?,?,?,?,?,?)";
                        try (PreparedStatement psInsertar = con.prepareStatement(sqlInsertar)) {
                            psInsertar.setInt(1, idPaciente);
                            psInsertar.setDate(2, Date.valueOf(seguimiento.getFecha()));
                            psInsertar.setDouble(3, seguimiento.getMedidaPecho());
                            psInsertar.setDouble(4, seguimiento.getMedidaCintura());
                            psInsertar.setDouble(5, seguimiento.getMedidaCadera());
                            psInsertar.setDouble(6, seguimiento.getPeso());
                            psInsertar.setInt(7, seguimiento.getIdDieta());
                            int filasModificadas = psInsertar.executeUpdate();
                            if (filasModificadas == 1) {
                                JOptionPane.showMessageDialog(null, "El seguimiento ha sido añadido con éxito");
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al agregar el seguimiento");
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al establecer la conexión o ejecutar la consulta: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + ex.getMessage());
        }
    }

    public boolean verificarSeguimientoExistente(Paciente paciente, LocalDate fecha) {
        try {
            String sqlVerificarSeguimiento = "SELECT COUNT(*) FROM Seguimiento WHERE idPaciente = ? AND fecha = ?";
            try (PreparedStatement psVerificarSeguimiento = con.prepareStatement(sqlVerificarSeguimiento)) {
                psVerificarSeguimiento.setInt(1, paciente.getIdPaciente());
                psVerificarSeguimiento.setDate(2, Date.valueOf(fecha));

                ResultSet rs = psVerificarSeguimiento.executeQuery();
                if (rs.next()) {
                    int seguimientosExisten = rs.getInt(1);
                    return seguimientosExisten > 0;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia del seguimiento: " + ex.getMessage());
        }
        return false;
    }

    public Seguimiento ObtenerSeguimientoPorID(int idSeguimiento) {

        Seguimiento seguimiento = null;

        try {
            String sql = "SELECT idSeguimiento, idPaciente ,	fecha	, medidaPecho ,	medidaCintura ,	medidaCadera FROM seguimiento WHERE idSeguimiento = ? ";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idSeguimiento);

            ResultSet resultado = ps.executeQuery();

            if (resultado.next()) {

                seguimiento = new Seguimiento();
                PacienteData pacientedata = new PacienteData();

                seguimiento.setIdSeguimiento(idSeguimiento);
                int idPaciente = resultado.getInt("idPaciente");
                seguimiento.setPaciente(pacientedata.obtenerPacientePorId(idPaciente));
                seguimiento.setFecha(resultado.getDate("fecha").toLocalDate());
                seguimiento.setMedidaPecho(resultado.getDouble("medidaPecho"));
                seguimiento.setMedidaCintura(resultado.getDouble("medidaCintura"));
                seguimiento.setMedidaCadera(resultado.getDouble("medidaCadera"));

            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error en la conexion" + ex);

        }

        return seguimiento;

    }

    public void eliminarSeguimientoPorId(int idSeguimiento) {

        try {
            String sql = "DELETE FROM seguimiento WHERE idSeguimiento=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idSeguimiento);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Seguimiento dado de baja");
            } else {
                JOptionPane.showMessageDialog(null, "El Segumiento no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Conectar con la tabla Segumiento" + ex.getMessage());
        }
    }

    public void eliminarSeguimiento(int idPaciente, int idSeguimiento) {

        try {
            String sql = "DELETE FROM seguimiento WHERE idPaciente=? And idSeguimiento=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            ps.setInt(2, idSeguimiento);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Seguimiento dado de baja");
            } else {
                JOptionPane.showMessageDialog(null, "El Segumiento no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Conectar con la tabla Segumiento" + ex.getMessage());
        }
    }

    public List<Seguimiento> obtenerSeguimientoPorPersona(int idPaciente) {

        List<Seguimiento> pacientes = new ArrayList<>();

        PacienteData pacientedata = null;

        try {
            String sql = "SELECT idSeguimiento,idPaciente,fecha, medidaPecho ,medidaCintura ,medidaCadera FROM seguimiento WHERE idPaciente=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            ResultSet resultado = ps.executeQuery();
            Seguimiento seguimiento;

            while (resultado.next()) {
                seguimiento = new Seguimiento();
                pacientedata = new PacienteData();

                seguimiento.setIdSeguimiento(resultado.getInt("idSeguimiento"));
                seguimiento.setIdSeguimiento(idPaciente);
                int idPaciente1 = resultado.getInt("idPaciente");
                seguimiento.setPaciente(pacientedata.obtenerPacientePorId(idPaciente1));
                seguimiento.setFecha(resultado.getDate("fecha").toLocalDate());
                seguimiento.setMedidaPecho(resultado.getDouble("medidaPecho"));
                seguimiento.setMedidaCintura(resultado.getDouble("medidaCintura"));
                seguimiento.setMedidaCadera(resultado.getDouble("medidaCadera"));

                pacientes.add(seguimiento);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudieron obtener los datos de la tabla Seguimiento" + ex);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "No se pudieron obtener los datos" + ex.getMessage());
        }
        return pacientes;
    }

    public LocalDate encontrarFechaMasReciente(int idPaciente) {
        String sql = "SELECT fecha FROM SEGUIMIENTO WHERE idPaciente=? ORDER BY fecha DESC";
        LocalDate fecha = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            ResultSet resultado = ps.executeQuery();

            if (resultado.next()) {
                fecha = resultado.getDate("fecha").toLocalDate();
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la fecha más reciente de seguimiento: " + e.getMessage());
        }

        return fecha;
    }

    public double CalcularIMCFinal(int idPaciente) {

        double IMCFinal = 0;

        String sql = "Select altura , pesoFinal FROM DIETA  WHERE idPaciente = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idPaciente);

            ResultSet resultado = ps.executeQuery();

            resultado.next();

            double alturaFinal = resultado.getDouble("altura");
            double pesoFinal = resultado.getDouble("pesoFinal");

            IMCFinal = pesoFinal / (alturaFinal * alturaFinal);

        } catch (SQLException ex) {
            Logger.getLogger(SeguimientoData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return IMCFinal;

    }
    
     public double CalcularIMCFinalObtenido(int idPaciente) {

        double IMCFinal = 0;

        String sql = "Select altura FROM DIETA  WHERE idPaciente = ? ";
double pesoObtenido= obtenerPesoPorFecha(idPaciente);
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idPaciente);

            ResultSet resultado = ps.executeQuery();

            resultado.next();

            double alturaFinal = resultado.getDouble("altura");
           

            IMCFinal = pesoObtenido/ (alturaFinal * alturaFinal);

        } catch (SQLException ex) {
            Logger.getLogger(SeguimientoData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return IMCFinal;

    }

    public double CalcularIMCInicial(int idPaciente) {

        double IMCInicial = 0;

        String sql = "Select altura , pesoInicial FROM DIETA  WHERE idPaciente = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idPaciente);

            ResultSet resultado = ps.executeQuery();

            resultado.next();

            double altura = resultado.getDouble("altura");
            double peso = resultado.getDouble("pesoInicial");

            IMCInicial = peso / (altura * altura);

        } catch (SQLException ex) {
            Logger.getLogger(SeguimientoData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return IMCInicial;

    }

    public List<Paciente> ObjetivoNoCumplido(Dieta dieta) {
        PacienteData pacienteData = new PacienteData();
        List<Paciente> ListaPacientes = pacienteData.ListarPacientes();
        List<Paciente> pacientesNoCumplidos = new ArrayList<>();

        for (Paciente pac : ListaPacientes) {
            if (!objetivoCumplidoParaPaciente(dieta, pac)) {
                pacientesNoCumplidos.add(pac);
            }
        }

        return pacientesNoCumplidos;
    }

    public List<Paciente> ObjetivoCumplido(Dieta dieta) {

        PacienteData pacienteData = new PacienteData();

        List<Paciente> ListaPacientes = pacienteData.ListarPacientes();

        List<Paciente> pacientesCumplidos = new ArrayList<>();

        for (Paciente pac : ListaPacientes) {

            if (objetivoCumplido(dieta) == true) {

                pacientesCumplidos.add(pac);

            }
        }
        return pacientesCumplidos;
    }

    public double obtenerPesoPorFecha(int idPaciente) {
        double peso = 0;

        LocalDate fecha = encontrarFechaMasReciente(idPaciente);

        try {
            String sql = "SELECT peso FROM seguimiento WHERE idPaciente =? AND fecha=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            ps.setDate(2, Date.valueOf(fecha));
            ResultSet resultado = ps.executeQuery();

            if (resultado.next()) {
                peso = resultado.getDouble("peso");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el peso por fecha: " + ex.getMessage());
        }

        return peso;
    }

    public boolean objetivoCumplido(Dieta dieta) {
        boolean VoF = false;

        LocalDate fechaMasReciente = encontrarFechaMasReciente(dieta.getPaciente().getIdPaciente());

        System.out.println("Fecha más reciente de seguimiento: " + fechaMasReciente);

        if (fechaMasReciente != null && dieta.getFechaFinal() != null) {
            System.out.println("Fecha final de la dieta: " + dieta.getFechaFinal());
            System.out.println("Peso final de la dieta: " + dieta.getPesoFinal());

            LocalDate fechaInicialDieta = dieta.getFechaInicial();
            if (fechaMasReciente.compareTo(fechaInicialDieta) >= 0 && fechaMasReciente.compareTo(dieta.getFechaFinal()) <= 0
                    && dieta.getPesoFinal() == obtenerPesoPorFecha(dieta.getPaciente().getIdPaciente())) {
                VoF = true;
            }
        }

        return VoF;
    }

    public List<Comida> ComidasMenosDeCalo(int calorias) {
        /* el nombre del metodo es horrible no sabia q ponerle*/
        String sql = "SELECT nombre,tipoComida,cantidadCalorias FROM comida WHERE cantidadCalorias <= ?";
        Comida comida = null;
        List<Comida> comidas = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, calorias);
            ResultSet listaModificada = ps.executeQuery();
            while (listaModificada.next()) {
                comida = new Comida();
                comida.setNombre(listaModificada.getString("nombre"));
                comida.setTipoComida(listaModificada.getString("tipoComida"));
                comida.setCantidadCalorias(listaModificada.getInt("cantidadCalorias"));
                comidas.add(comida);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return comidas;
    }

    public Seguimiento ObtenerSeguimientoPorIDPaciente(int idPaciente) {

        Seguimiento seguimiento = null;

        try {
            String sql = "SELECT idSeguimiento, idPaciente ,	fecha	, medidaPecho ,	medidaCintura ,	medidaCadera FROM seguimiento WHERE idPaciente = ? ";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idPaciente);

            ResultSet resultado = ps.executeQuery();

            if (resultado.next()) {

                seguimiento = new Seguimiento();
                PacienteData pacientedata = new PacienteData();

                seguimiento.setIdSeguimiento(idPaciente);
                int idPaciente1 = resultado.getInt("idPaciente");
                seguimiento.setPaciente(pacientedata.obtenerPacientePorId(idPaciente1));
                seguimiento.setFecha(resultado.getDate("fecha").toLocalDate());
                seguimiento.setMedidaPecho(resultado.getDouble("medidaPecho"));
                seguimiento.setMedidaCintura(resultado.getDouble("medidaCintura"));
                seguimiento.setMedidaCadera(resultado.getDouble("medidaCadera"));

            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error en la conexion" + ex);

        }

        return seguimiento;

    }

 public boolean modificarSeguimiento(int idPaciente, Seguimiento seguimiento) {

        boolean actual = false;

        int idSeguimiento= seguimiento.getIdSeguimiento();
        
        try {
            String sql = "UPDATE Seguimiento SET fecha=?, medidaPecho=?, medidaCintura=?, medidaCadera=? WHERE idPaciente=? AND idSeguimiento=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(seguimiento.getFecha()));
            ps.setDouble(2, seguimiento.getMedidaPecho());
            ps.setDouble(3, seguimiento.getMedidaCintura());
            ps.setDouble(4, seguimiento.getMedidaCadera());
            ps.setInt(5, idPaciente);
            ps.setInt(6, idSeguimiento);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                actual = true;
            } else {
                actual = false;
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la tabla inscripcion " + ex.getMessage());
        }
        return actual;
    }


public int obtenerIdSeguimientoPorFechaYPaciente(int idPaciente, LocalDate fechaInicial, LocalDate fechaFinal) {
    int idSeguimiento = -1;

    try {
        String sql = "SELECT idSeguimiento FROM Seguimiento WHERE idPaciente = ? AND fecha >= ? AND fecha <= ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPaciente);
        ps.setDate(2, Date.valueOf(fechaInicial));
        ps.setDate(3, Date.valueOf(fechaFinal));

        ResultSet resultado = ps.executeQuery();

        if (resultado.next()) {
            idSeguimiento = resultado.getInt("idSeguimiento");
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener el ID de seguimiento: " + ex.getMessage());
    }

    return idSeguimiento;
}
    public boolean objetivoCumplidoParaPaciente(Dieta dieta, Paciente paciente) {
        LocalDate fechaMasReciente = encontrarFechaMasReciente(paciente.getIdPaciente());

        if (fechaMasReciente != null && dieta.getFechaFinal() != null) {
            LocalDate fechaInicialDieta = dieta.getFechaInicial();

            if (fechaMasReciente.compareTo(fechaInicialDieta) >= 0 && fechaMasReciente.compareTo(dieta.getFechaFinal()) <= 0
                    && dieta.getPesoFinal() == obtenerPesoPorFecha(paciente.getIdPaciente())) {
                return true;
            }
        }

        return false;
    }
    public int ultimoDieta(){
                String sql="SELECT MAX(idDieta) AS idDieta from dieta ";
            int idDieta=0;
           try {
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet resultado = ps.executeQuery();
                while (resultado.next()){
                    idDieta=resultado.getInt("idDieta");
                }
                return idDieta;
           } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
           }
           return idDieta;
    }
}
