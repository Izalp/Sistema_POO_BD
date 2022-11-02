package br.inatel.sistema.usuarios;

public class Turmas {

    private String serie;
    private int turma;
    private int id;
    private static int contador = 0;

    public Turmas(String serie, int turma, int id){
        this.serie = serie;
        this.turma = turma;

        this.contador++;
        this.id = contador;
    }

    public String getSerie() {
        return serie;
    }

    public int getTurma() {
        return turma;
    }

    public int getId() {
        return id;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }

    public void setId(int id) {
        this.id = id;
    }
}
