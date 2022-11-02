package br.inatel.sistema.usuarios;

public class Aluno{
    private String escolaOrigem;
    private String nome;
    private String cpf;
    private String rg;
    private String dataNasc;
    private String naturalidade;
    private String sexo;
    private String nomeFiliacao1;
    private String nomeFiliacao2;
    private String endereco;
    private String contato;
    private int matricula;
    private static int contador = 0;

    public Aluno (String escolaOrigem, String nome, String cpf, String rg, String dataNasc, String naturalidade,
                  String sexo, String nomeFiliacao1, String nomeFiliacao2, String endereco, String contato){
        this.escolaOrigem = escolaOrigem;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNasc = dataNasc;
        this.naturalidade = naturalidade;
        this.sexo = sexo;
        this.nomeFiliacao1 = nomeFiliacao1;
        this.nomeFiliacao2 = nomeFiliacao2;
        this.endereco = endereco;
        this.contato = contato;

        this.contador++;
        this.matricula = contador;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getEscolaOrigem() {
        return escolaOrigem;
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

    public String getSexo() {
        return sexo;
    }

    public String getNomeFiliacao1() {
        return nomeFiliacao1;
    }

    public String getNomeFiliacao2() {
        return nomeFiliacao2;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setEscolaOrigem(String escolaOrigem) {
        this.escolaOrigem = escolaOrigem;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setNomeFiliacao1(String nomeFiliacao1) {
        this.nomeFiliacao1 = nomeFiliacao1;
    }

    public void setNomeFiliacao2(String nomeFiliacao2) {
        this.nomeFiliacao2 = nomeFiliacao2;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

}

