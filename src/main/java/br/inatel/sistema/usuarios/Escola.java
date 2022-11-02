package br.inatel.sistema.usuarios;

public class Escola {

    private String nome;
    private String cnpj;
    private String localizacao;
    private String contato;
    private int id;
    private static int contador = 0;

    public Escola(String nome, String cnpj, String localizacao, String contato, String id){
        this.nome = nome;
        this.cnpj = cnpj;
        this.localizacao = localizacao;
        this.contato = contato;

        this.contador++;
        this.id = contador;
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
