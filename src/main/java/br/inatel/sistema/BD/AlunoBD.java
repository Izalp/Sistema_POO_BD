package br.inatel.sistema.BD;

import br.inatel.sistema.Database;
import br.inatel.sistema.usuarios.Aluno;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoBD extends Database {
    //------------------------------------INSERINDO NOVO REGISTRO---------------------------------------------//
    private boolean check = false;
    public boolean insertAluno(Aluno aluno) {
        connect();
        String sql = "INSERT INTO aluno (matriculaAluno,escolaOrigem,nomeAluno,cpfAluno,rgAluno,dataNasc, naturalidadeAluno," +
                "sexoAluno,nomeFiliacao1,nomeFiliacao2,enderecoAluno,contatoAluno) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, aluno.getMatricula());             //concatena nome na 1 ? do comando
            pst.setString(2, aluno.getEscolaOrigem());       //concatena nome na 2 ? do comando
            pst.setString(3, aluno.getNome());               //concatena nome na 3 ? do comando
            pst.setString(4, aluno.getCpf());                //concatena nome na 4 ? do comando
            pst.setString(5, aluno.getRg());                 //concatena nome na 5 ? do comando
            pst.setString(6, aluno.getDataNasc());           //concatena nome na 6 ? do comando
            pst.setString(7, aluno.getNaturalidade());       //concatena nome na 7 ? do comando
            pst.setString(8, aluno.getSexo());               //concatena nome na 8 ? do comando
            pst.setString(9, aluno.getNomeFiliacao1());      //concatena nome na 9 ? do comando
            pst.setString(10, aluno.getNomeFiliacao2());     //concatena nome na 10 ? do comando
            pst.setString(11, aluno.getEndereco());          //concatena nome na 11 ? do comando
            pst.setString(12, aluno.getContato());           //concatena nome na 12 ? do comando
            pst.execute();                                                //executa o comando
            check = true;
            System.out.println("Aluno cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro na operação: " + e.getMessage());
            check = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
    public int getLastId() {
        int id = 0;
        try {
            String sql = "SELECT idTurma FROM Turma ORDER BY idTurma DESC LIMIT 1";
            connect();
            pst = connection.prepareStatement(sql);
            result = pst.executeQuery();
            while (result.next()) {
                id = result.getInt("idTurma");
            }

        } catch (SQLException e) {
            System.out.println("Erro na operação: " + e.getMessage());
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return id;
    }
    //-----------------------------------BUSCANDO TODOS OS REGISTROS-------------------------------------------//
    public ArrayList<Aluno> researchAluno(){
        connect();
        ArrayList<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM aluno";

        try{
            statement =connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()){
                Aluno alunoTemp = new Aluno(result.getString("escolaOrigem"),
                        result.getString("nomeAluno"), result.getString("cpfAluno"),
                        result.getString("rgAluno"), result.getString("dataNasc"),
                        result.getString("naturalidadeAluno"), result.getString("sexoAluno"),
                        result.getString("nomeFiliacao1"), result.getString("nomeFiliacao2"),
                        result.getString("enderecoAluno"), result.getString("contatoAluno"));

                alunoTemp.setMatricula(result.getInt("matriculaAluno"));

                System.out.println("Número de matrícula: " + alunoTemp.getMatricula());
                System.out.println("Escola de Origem: " + alunoTemp.getEscolaOrigem());
                System.out.println("Nome do aluno: " + alunoTemp.getNome());
                System.out.println("Cpf do aluno: " + alunoTemp.getCpf());
                System.out.println("Rg do aluno: " + alunoTemp.getRg());
                System.out.println("Data de Nascimento: " + alunoTemp.getDataNasc());
                System.out.println("Naturalidade: " + alunoTemp.getNaturalidade());
                System.out.println("Sexo: " + alunoTemp.getSexo());
                System.out.println("Nome da filiação 1 (mãe): " + alunoTemp.getNomeFiliacao1());
                System.out.println("Nome da filiação 2 (pai): " + alunoTemp.getNomeFiliacao2());
                System.out.println("Endereço: " + alunoTemp.getEndereco());
                System.out.println("Contato: " + alunoTemp.getContato());
                System.out.println("-------------------------------------------------------------------------");
                alunos.add(alunoTemp);
            }
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }finally {
            try {
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return alunos;
    }
    //-----------------------------ATUALIZANDO ENDERECO E CONTATO NO REGISTRO----------------------------------//
    public boolean updateAlunoEnd(int  matricula, String endereco){
        connect();
        String sqlend = "UPDATE aluno SET enderecoAluno=? WHERE matriculaAluno=?";
        try {
            pst = connection.prepareStatement(sqlend);
            pst.setString(1, endereco);
            pst.setInt(2,matricula);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
    public boolean updateAlunoCont(int  matricula, String contato){
        connect();
        String sqlcot = "UPDATE aluno SET contatoAluno=?  WHERE id=?";
        try {
            pst = connection.prepareStatement(sqlcot);
            pst.setString(  1,contato);
            pst.setInt(2,matricula);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
    //-----------------------------------------EXCLUINDO REGISTRO----------------------------------------------//
    public boolean deleteAluno(int id){
        connect();
        String sql = "DELETE FROM aluno WHERE matriculaAluno=?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
}
