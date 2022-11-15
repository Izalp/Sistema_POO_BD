package br.inatel.sistema.BD;

import br.inatel.sistema.Database;
import br.inatel.sistema.usuarios.Professor;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfessorBD extends Database {
    //------------------------------------INSERINDO NOVO REGISTRO---------------------------------------------//
    private boolean check = false;
    public boolean insertProfessor(Professor professor) {
        connect();
        String sql = "INSERT INTO professor(idProfessor,nomeProfessor,cpfProfessor,rgProfessor,dataNascP," +
                "naturalidadeProfessor,sexoProfessor,cargo,disciplina,endereco,contato) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,professor.getId());                    //concatena nome na 1 ? do comando
            pst.setString(2, professor.getNome());              //concatena nome na 2 ? do comando
            pst.setString(3, professor.getCpf());               //concatena nome na 3 ? do comando
            pst.setString(4, professor.getRg());                //concatena nome na 4 ? do comando
            pst.setString(5, professor.getDataNasc());          //concatena nome na 5 ? do comando
            pst.setString(6, professor.getNaturalidade());      //concatena nome na 6 ? do comando
            pst.setString(7, professor.getSexo());              //concatena nome na 7 ? do comando
            pst.setString(8, professor.getCargo());             //concatena nome na 8 ? do comando
            pst.setString(9, professor.getDisciplina());        //concatena nome na 9 ? do comando
            pst.setString(10, professor.getEndereco());         //concatena nome na 10 ? do comando
            pst.setString(11, professor.getContato());          //concatena nome na 11 ? do comando
            pst.execute();                                                   //executa o comando
            check = true;
            System.out.println("Professor cadastrado com sucesso!");
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

    //-----------------------------------BUSCANDO TODOS OS REGISTROS-------------------------------------------//

    public ArrayList<Professor> researchProfessor(){
        connect();
        ArrayList<Professor> professores = new ArrayList<>();
        String sql = "SELECT * FROM professor";

        try{
            statement =connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()){
                Professor professorTemp = new Professor(result.getString("nomeProfessor"),
                        result.getString("cpfProfessor"), result.getString("rgProfessor"),
                        result.getString("dataNascP"),  result.getString("naturalidadeProfessor"),
                        result.getString("sexoProfessor"), result.getString("cargo"),
                        result.getString("disciplina"), result.getString("endereco"),
                        result.getString("contato"));

                professorTemp.setId(result.getInt("idProfessor"));

                System.out.println("Número de Identificação: " + professorTemp.getId());
                System.out.println("Nome do professor: " + professorTemp.getNome());
                System.out.println("Cpf do professor: " + professorTemp.getCpf());
                System.out.println("Rg do professor: " + professorTemp.getRg());
                System.out.println("Data de Nascimento: " + professorTemp.getDataNasc());
                System.out.println("Naturalidade: " + professorTemp.getNaturalidade());
                System.out.println("Sexo: " + professorTemp.getSexo());
                System.out.println("Cargo: " + professorTemp.getCargo());
                System.out.println("Disciplina: " + professorTemp.getDisciplina());
                System.out.println("Endereço: " + professorTemp.getEndereco());
                System.out.println("Contato: " + professorTemp.getContato());
                System.out.println("-------------------------------------------------------------------------");
                professores.add(professorTemp);
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
        return professores;
    }
    //-----------------------------------ATUALIZANDO NOME NO REGISTRO----------------------------------------//
    public boolean updateProfessorEnd(int  id, String endereco){
        connect();
        String sql = "UPDATE professor SET endereco=? WHERE idProfessor=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,endereco);
            pst.setInt(2,id);
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
    public boolean updateProfessorCont(int  id, String contato){
        connect();
        String sql = "UPDATE professor SET contato=? WHERE idProfessor=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,contato);
            pst.setInt(2,id);
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
    public boolean deleteProfessor(int id){
        connect();
        String sql = "DELETE FROM professor WHERE idProfessor=?";

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
