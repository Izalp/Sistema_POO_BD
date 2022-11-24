package br.inatel.sistema.usuarios;

import br.inatel.sistema.BD.EscolaBD;

public class Escola {
    private static EscolaBD escolaBD = new EscolaBD();
    private String nome;
    private String cnpj;
    private String localizacao;
    private String contato;
    private int id;

    private static int contador = escolaBD.getLastId();

    public Escola(String nome, String cnpj, String localizacao, String contato){
        this.nome = nome;
        this.cnpj = cnpj;
        this.localizacao = localizacao;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getContato() {
        return contato;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public void setId(int id) {
        this.id = id;
    }
}
