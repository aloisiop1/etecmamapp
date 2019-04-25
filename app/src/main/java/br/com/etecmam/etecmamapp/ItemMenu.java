package br.com.etecmam.etecmamapp;

public class ItemMenu {

    private int desenho;
    private String titulo;

    public ItemMenu() {
    }

    public ItemMenu(int desenho, String titulo) {
        this.desenho = desenho;
        this.titulo = titulo;
    }

    public int getDesenho() {
        return desenho;
    }

    public void setDesenho(int desenho) {
        this.desenho = desenho;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
