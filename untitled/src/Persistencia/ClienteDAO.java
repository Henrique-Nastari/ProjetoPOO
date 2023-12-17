package Persistencia;
import Dominio.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO {
    private Conexao conec = new Conexao();
    private final String INSERT = "insert into cliente (cpf, nome, datanascimento, rua, bairro, cep, cidade, " +
            "telefone) values (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String UPDATE = "update cliente set nome = ?, datanascimento=?, rua = ?, bairro = ?, cep=?, cidade" +
            " = ?, telefone = ? where cpf = ?";
    private final String DELETE = "delete from cliente where cpf = ?";
    private final String BUSCAR = "select * from public.cliente where cpf = ?";
    private final String RELATORIO_GERAL =	"select * from cliente";

    public ArrayList<Cliente> relatorioGeral(){
        ArrayList<Cliente> list = new ArrayList<>();

        try {
            conec.conectar();
            Statement instrucao = conec.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(RELATORIO_GERAL);

            while (rs.next()){
                Cliente c = new Cliente(rs.getString("cpf"), rs.getString("nome"), rs.getString("dataNascimento"),
                        rs.getString("rua"), rs.getString("bairro"), rs.getString("cep"), rs.getString("cidade"), rs.getString("telefone"));
                list.add(c);
            }
            conec.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro no relatorio" + e.getMessage());
        }
        return list;
    }

    public Cliente buscar(String cpf){
        Cliente c = null;
        try {
            conec.conectar();
            PreparedStatement instrucao = conec.getConexao().prepareStatement(BUSCAR);
            instrucao.setString(1, cpf);
            ResultSet rs = instrucao.executeQuery();
            if (rs.next()){
                c = new Cliente(rs.getString("cpf"), rs.getString("nome"), rs.getString("dataNascimento"),
                        rs.getString("rua"), rs.getString("bairro"), rs.getString("cep"), rs.getString("cidade"),
                        rs.getString("telefone"));
            }
            conec.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro na busca " + e.getMessage());
        }
        return c;
    }

    public void inserir(Cliente c){
        try {
            conec.conectar();
            PreparedStatement instrucao = conec.getConexao().prepareStatement(INSERT);
            instrucao.setString(1, c.getCpf());
            instrucao.setString(2,c.getNome());
            instrucao.setString(3,c.getDataNascimento());
            instrucao.setString(4,c.getRua());
            instrucao.setString(5,c.getBairro());
            instrucao.setString(6,c.getCep());
            instrucao.setString(7,c.getCidade());
            instrucao.setString(8,c.getTelefone());
            instrucao.execute();
            conec.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir" + e.getMessage());
        }
    }

    public void delete(int cpf) {
        try {
            conec.conectar();
            PreparedStatement instrucao = conec.getConexao().prepareStatement(DELETE);
            instrucao.setInt(1, cpf);
            instrucao.execute();
            conec.desconectar();
        }catch(SQLException e) {
            System.out.println("erro na exclusao "+e.getMessage());
        }

    }

    public void alterar(Cliente c, String cpf){
        try {
            conec.conectar();
            PreparedStatement instrucao = conec.getConexao().prepareStatement(UPDATE);
            instrucao.setString(1, c.getCpf());
            instrucao.setString(2,c.getNome());
            instrucao.setString(3, c.getDataNascimento());
            instrucao.setString(4, c.getRua());
            instrucao.setString(5,c.getBairro());
            instrucao.setString(6, c.getCep());
            instrucao.setString(7, c.getCidade());
            instrucao.setString(8, c.getTelefone());
            instrucao.execute();
            conec.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro ao alterar " + e.getMessage());
        }
    }
}
