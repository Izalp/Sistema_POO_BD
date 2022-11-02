package br.inatel.sistema.usuarios;

public class Professor{
    private String nome;
    private String cpf;
    private String rg;
    private String dataNasc;
    private String naturalidade;
    private String sexo;
    private String cargo;
    private String disciplina;
    private String endereco;
    private String contato;

    private int id;

    private static int contador = 0;

    public Professor (String nome, String cpf,  String rg, String dataNasc, String naturalidade, String sexo,
                      String cargo, String disciplina, String endereco, String contato){
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNasc = dataNasc;
        this.naturalidade = naturalidade;
        this.sexo = sexo;
        this.cargo = cargo;
        this.disciplina = disciplina;
        this.endereco = endereco;
        this.contato = contato;

        this.contador++;
        this.id = contador;
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

    public String getCargo() {
        return cargo;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getContato() {
        return contato;
    }

    public int getId(){ return id; }

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

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

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

