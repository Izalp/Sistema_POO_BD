package br.inatel.sistema.BD;

import br.inatel.sistema.Database;
import br.inatel.sistema.usuarios.Turmas;
import java.sql.SQLException;

public class TurmaBD extends Database {
    //------------------------------------INSERINDO NOVO REGISTRO---------------------------------------------//
    private boolean check = false;
    public boolean insertTurma(Turmas turmas) {
        int quant = turmas.getNumTurma();

        while(quant != 0) {

            connect();
            String sql = "INSERT INTO Turma (serie,numTurma) VALUES (?,?)";

            try {
                pst = connection.prepareStatement(sql);                  //concatena nome na 1 ? do comando
                pst.setInt(1, turmas.getSerie());                //concatena nome na 2 ? do comando
                pst.setInt(2, quant);                            //concatena nome na 3 ? do comando
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
}
