
package Entidades;

public class Comida {
   private String nombre, detalle,tipoComida;
   private int cantidadCalorias, idComida;

    public Comida() {
    }

    public Comida(String nombre, String detalle , String tipoComida , int cantidadCalorias) {
        this.nombre = nombre;
        this.detalle = detalle;
         this.tipoComida= tipoComida;
        this.cantidadCalorias = cantidadCalorias;
       
    }

    public Comida(String nombre, String detalle, String tipoComida  , int cantidadCalorias, int idComida) {
        this.nombre = nombre;
        this.detalle = detalle;
         this.tipoComida= tipoComida;
        this.cantidadCalorias = cantidadCalorias;
        this.idComida = idComida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getCantidadCalorias() {
        return cantidadCalorias;
    }

    public void setCantidadCalorias(int cantidadCalorias) {
        this.cantidadCalorias = cantidadCalorias;
    }

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    @Override
    public String toString() {
        return "Comida{" + "nombre= " + nombre + ", detalle= " + detalle + ", tipoComida= " + tipoComida + ", cantidadCalorias= " + cantidadCalorias + ", idComida= " + idComida + '}';
    }

}
    
    
    
    
    
