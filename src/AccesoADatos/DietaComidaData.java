package AccesoADatos;

import Entidades.Comida;
import Entidades.Dieta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DietaComidaData {

    private Connection con = null;
    private PacienteData pacienteData;
    private ComidaData comidaData;

    public DietaComidaData() {
        con = Conexion.getconexion();
    }
    public void AgregarComidaDieta(int idComida, int idDieta)  {
        String insertPs="Insert into dietacomida (idComida,idDieta) Values (?,?)";
        try{
            PreparedStatement psInsert=con.prepareStatement(insertPs,Statement.RETURN_GENERATED_KEYS);
            psInsert.setInt(1,idComida);
            psInsert.setInt(2,idDieta);
            int listaModificada = psInsert.executeUpdate();
            ResultSet rs = psInsert.getGeneratedKeys();
            if (listaModificada > 0) {
                JOptionPane.showMessageDialog(null, " La Comida ha sido añadida con exito a la dieta");
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        }

    }
    public void BorrarComidaDieta(int idDieta,int idComida){
        try{
            String sql = "DELETE FROM dietacomida WHERE idDieta=? AND idComida=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ps.setInt(2, idComida);
            int exito = ps.executeUpdate();
            System.out.println(idComida);
             System.out.println(idDieta);
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Comida eliminada de la dieta");
            } else {
                JOptionPane.showMessageDialog(null, "La comida no existe en la dieta seleccionada");
            }
            ps.close();
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }
    public void BuscarComidasDieta(int idDieta){
        //Error da las comidas de la dieta pero las da repetidas WIP*)

        String sql = "Select idComida FROM dietacomida WHERE idDieta=?";
        try {
            PreparedStatement psCheck=con.prepareStatement(sql);
            psCheck.setInt(1,idDieta);
            ResultSet result=psCheck.executeQuery();
            
            while (result.next()) {
                String sid = result.getString(1);
                String sqlComida = "Select idComida FROM dietacomida WHERE idDieta=?";
                PreparedStatement psComida=con.prepareStatement(sql);
                psComida.setInt(1,idDieta);
                ResultSet resultcomida=psComida.executeQuery();
                try {


                while (resultcomida.next()) {
                    int blabla=resultcomida.getInt(1);
                    ComidaData cd=new ComidaData();
                    System.out.println(cd.buscarComida(blabla));
                    result.next();
                }

                } catch(SQLException ex) {
                    System.out.println(ex);
                }
                
            }
            psCheck.close();
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }
    public List<Comida> ListarComidas(int idDieta){
        Comida comida=null;
        String sql = "SELECT idComida FROM dietacomida WHERE idDieta=?";
        ArrayList<Comida> comidas = new ArrayList<>();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                
                String sqlcomida="SELECT nombre,detalle,tipoComida,cantidadCalorias,idComida FROM comida WHERE idComida=?";
                

                try {
                    
                    PreparedStatement pscomida=con.prepareStatement(sqlcomida);
                    int asd=resultado.getInt("idComida");
                    
                    pscomida.setInt(1,asd);
                    ResultSet rescom = pscomida.executeQuery();

                while (rescom.next()) {

                    comida = new Comida();
                    comida.setNombre(rescom.getString("nombre"));
                    comida.setDetalle(rescom.getString("detalle"));
                    comida.setTipoComida(rescom.getString("tipoComida"));
                    comida.setCantidadCalorias(rescom.getInt("cantidadCalorias"));
                    comida.setIdComida(rescom.getInt("idComida"));
                    comidas.add(comida);

                }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, " Error en la conexion" + ex);
                }

            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error en la conexion" + ex);
        }
        return comidas;
    }

}
