package br.inatel.sistema.BD;

import br.inatel.sistema.Database;
import br.inatel.sistema.usuarios.Coordenador;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoordenadorBD extends Database {
    //------------------------------------INSERINDO NOVO REGISTRO---------------------------------------------//
    private boolean check = false;
    public boolean insertCoordenador(Coordenador coordenador) {
        connect();
        String sql = "INSERT INTO Coordenador (idCoordenador,nomeCoordenador,cpfCoordenador,rgCoordenador, dataNascC, " +
                 "naturalidadeCoordenador,enderecoCoordenador,contatoCoordenador) VALUES (?,?,?,?,?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, coordenador.getId());                    //concatena nome na 1 ? do comando
            pst.setString(2, coordenador.getNome());               //concatena nome na 2 ? do comando
            pst.setString(3, coordenador.getCpf());                //concatena nome na 3 ? do comando
            pst.setString(4, coordenador.getRg());                 //concatena nome na 4 ? do comando
            pst.setString(5, coordenador.getDataNasc());           //concatena nome na 5 ? do comando
            pst.setString(6, coordenador.getNaturalidade());       //concatena nome na 6 ? do comando
            pst.setString(7, coordenador.getEndereco());           //concatena nome na 7 ? do comando
            pst.setString(8, coordenador.getContato());            //concatena nome na 8 ? do comando
            pst.execute();                                                      //executa o comando
            check = true;
            System.out.println("Coordenador cadastrado com sucesso!");
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
    public ArrayList<Coordenador> researchCoordenador(){
        connect();
        ArrayList<Coordenador> coordenadores = new ArrayList<>();
        String sql = "SELECT * FROM Coordenador";

        try{
            statement =connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()){
                Coordenador coordenadorTemp = new Coordenador(result.getString("nomeCoordenador"),
                        result.getString("cpfCoordenador"), result.getString("rgCoordenador"),
                        result.getString("dataNascC"), result.getString("naturalidadeCoordenador"),
                        result.getString("enderecoCoordenador"), result.getString("contatoCoordenador"));

                coordenadorTemp.setId(result.getInt("idCoordenador"));

                System.out.println("Número de id: " + coordenadorTemp.getId());
                System.out.println("Nome do Coordenador: " + coordenadorTemp.getNome());
                System.out.println("Cpf do Coordenador: " + coordenadorTemp.getCpf());
                System.out.println("Rg do Coordenador: " + coordenadorTemp.getRg());
                System.out.println("Data de Nascimento: " + coordenadorTemp.getDataNasc());
                System.out.println("Naturalidade: " + coordenadorTemp.getNaturalidade());
                System.out.println("Endereço: " + coordenadorTemp.getEndereco());
                System.out.println("Contato: " + coordenadorTemp.getContato());
                System.out.println("-------------------------------------------------------------------------");
                coordenadores.add(coordenadorTemp);
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
        return coordenadores;
    }
    //-----------------------------ATUALIZANDO ENDERECO E CONTATO NO REGISTRO----------------------------------//
    public boolean updateCoordenadorEnd(int  id, String endereco){
        connect();
        String sqlend = "UPDATE Coordenador SET enderecoCoordenador=? WHERE idCoordenador=?";
        try {
            pst = connection.prepareStatement(sqlend);
            pst.setString(1, endereco);
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
    public boolean updateCoordenadorCont(int  id, String contato){
        connect();
        String sqlcot = "UPDATE Coordenador SET contatoCoordenador=?  WHERE idCoordenador=?";
        try {
            pst = connection.prepareStatement(sqlcot);
            pst.setString(  1,contato);
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
    public boolean deleteCoordenador(int id){
        connect();
        String sql = "DELETE FROM Coordenador WHERE idCoordenador=?";

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

