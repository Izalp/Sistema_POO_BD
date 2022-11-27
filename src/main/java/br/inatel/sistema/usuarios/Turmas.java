package br.inatel.sistema.usuarios;

import br.inatel.sistema.BD.TurmaBD;

public class Turmas {
    private static TurmaBD turmaBD = new TurmaBD();
    private int serie;
    private int numTurma;
    private int id;

    private static int contador = turmaBD.getLastId();

    public Turmas(int serie, int numTurma, int id){
        this.serie = serie;
        this.numTurma = numTurma;
        this.id = id;
    }

    public int getSerie() {
        return serie;
    }

    public int getNumTurma() {
        return numTurma;
    }

    public int getId() {
        return id;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public void setNumTurma(int numTurma) {
        this.numTurma = numTurma;
    }

    public void setId(int id) {
        this.id = id;
    }
}
