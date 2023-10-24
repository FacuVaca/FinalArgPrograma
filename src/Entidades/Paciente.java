package Entidades;

public class Paciente {

    private String nombre, domicilio, telefono;
    private int dni, idPaciente;

    public Paciente() {
    }

    public Paciente(String nombre, int dni, String domicilio, String telefono) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.dni = dni;

    }

    public Paciente(String nombre, int dni, String domicilio, String telefono, int idPaciente) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.dni = dni;
        this.idPaciente = idPaciente;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public String toString() {
        return nombre + ", " + idPaciente;
    }

}
