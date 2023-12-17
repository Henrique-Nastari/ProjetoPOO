package Persistencia;

import Dominio.Animais;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AnimaisDAO {
    private Conexao conec = new Conexao();
    private final String INSERT = "insert into animais (animalid, nome, idade, especie, raca) values (?, ?, ?, ?, ?)";
    private final String UPDATE = "update animais set nome = ?, idade = ?, especie = ?, raca = ? where animalId = ?";
    private final String DELETE = "delete from animais where animalId = ?";
    private final String BUSCAR = "select * from public.animais where animalId = ?";
    private final String RELATORIO_GERAL =	"select * from animais";

    public ArrayList<Animais> relatorioGeral(){
        ArrayList<Animais> list = new ArrayList<>();

        try {
            conec.conectar();
            Statement instrucao = conec.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(RELATORIO_GERAL);

            while (rs.next()) {
                Animais a = new Animais (rs.getInt("animaisId"), rs.getString("nome"), rs.getInt("idade"),
                        rs.getString("especie"), rs.getString("raca"));
                list.add(a);
            }
            conec.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro no relatorio" + e.getMessage());
        }
        return list;
    }

    public Animais buscar(int animalId){
        Animais a = null;
        try {
            conec.conectar();
            PreparedStatement instrucao = conec.getConexao().prepareStatement(BUSCAR);
            instrucao.setInt(1, animalId);
            ResultSet rs = instrucao.executeQuery();
            if (rs.next()) {
                a = new Animais(rs.getInt("animalId"), rs.getString("nome"), rs.getInt("idade"), rs.getString(
                        "especie"), rs.getString("raca"));
            }
            conec.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        }
        return a;
    }

    public void inserir (Animais a) {
        try {
            conec.conectar();
            PreparedStatement instrucao = conec.getConexao().prepareStatement(INSERT);
            instrucao.setInt(1, a.getAnimalId());
            instrucao.setString(2, a.getNome());
            instrucao.setInt(3, a.getIdade());
            instrucao.setString(4, a.getEspecie());
            instrucao.setString(5, a.getRaca());
            instrucao.execute();
            conec.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    public void delete(int animaisId) {
        try {
            conec.conectar();
            PreparedStatement instrucao = conec.getConexao().prepareStatement(DELETE);
            instrucao.setInt(1, animaisId);
            instrucao.execute();
            conec.desconectar();
        }catch(SQLException e) {
            System.out.println("erro na exclusao "+e.getMessage());
        }


    }

    public void alterar (Animais a, int animalId) {
        try{
            conec.conectar();
            PreparedStatement instrucao = conec.getConexao().prepareStatement(UPDATE);
            instrucao.setString(1, a.getNome());
            instrucao.setInt(2, a.getIdade());
            instrucao.setString(3, a.getEspecie());
            instrucao.setString(4, a.getRaca());
            instrucao.execute();
            conec.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro ao alterar " + e.getMessage());
        }
    }
}
