package br.inatel.sistema.usuarios;

public class Turmas {

    private int serie;
    private int numTurma;
    private int id;
    private static int contador = 0;

    public Turmas(int serie, int turma){
        this.serie = serie;
        this.numTurma = numTurma;

        this.contador++;
        this.id = contador;
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
