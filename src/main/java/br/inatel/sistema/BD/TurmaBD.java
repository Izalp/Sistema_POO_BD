package br.inatel.sistema.BD;

import br.inatel.sistema.Database;
import br.inatel.sistema.usuarios.Aluno;
import br.inatel.sistema.usuarios.Turmas;

import java.sql.SQLException;
import java.util.ArrayList;

public class TurmaBD extends Database {
    //------------------------------------INSERINDO NOVO REGISTRO---------------------------------------------//
    private boolean check = false;
    public boolean insertTurma(Turmas turmas) {
        int quant = turmas.getNumTurma();

        while(quant != 0) {

            connect();
            String sql = "INSERT INTO Turma (idTurma,serie,NumTurmas) VALUES (?,?,?)";

            try {
                pst = connection.prepareStatement(sql);
                pst.setInt(1, turmas.getId());                   //concatena nome na 1 ? do comando
                pst.setInt(2, turmas.getSerie());                //concatena nome na 2 ? do comando
                pst.setInt(3, quant);                            //concatena nome na 3 ? do comando
                pst.execute();                                               //executa o comando
                check = true;
                System.out.println("Turma cadastrada com sucesso!");
            }
            catch (SQLException e) {
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
            quant--;
        }
        return check;
    }

}
