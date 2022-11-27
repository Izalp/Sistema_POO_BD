package br.inatel.sistema.usuarios;

import br.inatel.sistema.BD.DiretorBD;

public class Diretor {
    private static DiretorBD diretorBD = new DiretorBD();
    private String nome;
    private String cpf;
    private String rg;
    private String dataNasc;
    private String naturalidade;
    private String endereco;
    private String contato;
    private int id;
    private int idEscola;

    private static int contador = diretorBD.getLastId();

    public Diretor (String nome, String cpf,  String rg, String dataNasc, String naturalidade,
                        String endereco, String contato, int idEscola){
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNasc = dataNasc;
        this.naturalidade = naturalidade;
        this.endereco = endereco;
        this.contato = contato;
        this.idEscola = idEscola;
   }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {return rg;}

    public String getDataNasc() {
        return dataNasc;
    }

    public String getNaturalidade() {return naturalidade;}

    public String getEndereco() {
        return endereco;
    }

    public String getContato() {
        return contato;
    }

    public int getId(){ return id; }

    public int getIdEscola() { return idEscola; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) { this.rg = rg; }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setNaturalidade(String naturalidade) { this.naturalidade = naturalidade; }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public void setId(int id) {
        this.id = id;
    }
}
