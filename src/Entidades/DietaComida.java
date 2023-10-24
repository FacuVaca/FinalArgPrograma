package Entidades;

public class DietaComida {

    private int idDietaComida;
    private Comida comida;
    private Dieta dieta;

    public DietaComida() {
    }

    public DietaComida(int idDietaComida, Comida comida) {
        this.idDietaComida = idDietaComida;
        this.comida = comida;
    }

    public DietaComida(int idDietaComida, Comida comida, Dieta dieta) {
        this.idDietaComida = idDietaComida;
        this.comida = comida;
        this.dieta = dieta;
    }

    public int getIdDietaComida() {
        return idDietaComida;
    }

    public void setIdDietaComida(int idDietaComida) {
        this.idDietaComida = idDietaComida;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

}
