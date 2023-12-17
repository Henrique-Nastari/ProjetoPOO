package Persistencia;
import Dominio.Consultas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConsultasDAO {
    private Conexao conec = new Conexao();
    private final String INSERT = "insert into Consultas (consultaId, dataConsulta, procedimento) values (?, ?, ?)";
    private final String UPDATE = "update Consultas set consultaId = ?, dataConsulta=?, procedimento = ? where consultaid = ?";
    private final String DELETE = "delete from Consultas where consultaId = ?";
    private final String BUSCAR = "select * from Consultas where consultaId = ?";
    private final String RELATORIO_GERAL =	"select * from Consultas";

    public ArrayList<Consultas> relatorioGeral(){
        ArrayList <Consultas> list = new ArrayList<>();
        try {
            conec.conectar();
            Statement instrucao = conec.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(RELATORIO_GERAL);

            while (rs.next()) {
                Consultas ct = new Consultas(rs.getInt("consultaId"), rs.getString("dataConsultas"),
                        rs.getString("procedimento"));
                list.add(ct);
            }
            conec.desconectar();
        } catch(SQLException e) {
            System.out.println("Erro no relatorio" + e.getMessage());
        }
        return list;
    }
    public Consultas buscar (int consultaId){
        Consultas ct = null;
        try {
            conec.conectar();
            PreparedStatement instrucao = conec.getConexao().prepareStatement(BUSCAR);
            instrucao.setInt(1, consultaId);
            ResultSet rs = instrucao.executeQuery();
            if(rs.next()) {
                ct = new Consultas(rs.getInt("consultaId"), rs.getString("dataConsultas"), rs.getString(
                        "procedimentos"));
            }
            conec.desconectar();
        } catch (SQLException e) {
            System.out.println("Error na busca " + e.getMessage());
        }
        return ct;
    }

    public void inserir (Consultas ct){
        try {
            conec.conectar();
            PreparedStatement instrucao = conec.getConexao().prepareStatement(INSERT);
            instrucao.setInt(1, ct.getConsultaId());
            instrucao.setString(2, ct.getDataConsulta());
            instrucao.setString(3, ct.getProcedimento());
            instrucao.execute();
            conec.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir " + e.getMessage());
        }
    }

    public void delete (int consultaId){
        try {
            conec.conectar();
            PreparedStatement instrucao = conec.getConexao().prepareStatement(DELETE);
            instrucao.setInt(1, consultaId);
            instrucao.execute();
            conec.desconectar();
        } catch (SQLException e){
            System.out.println("Erro na exclusao " + e.getMessage());
        }
    }

    public void alterar (Consultas ct, int consultaId){
        try{
            conec.conectar();
            PreparedStatement instrucao = conec.getConexao().prepareStatement(UPDATE);
            instrucao.setInt(1, ct.getConsultaId());
            instrucao.setString(2, ct.getDataConsulta());
            instrucao.setString(3, ct.getProcedimento());
            instrucao.execute();
            conec.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro ao alterar" + e.getMessage());
        }
    }

}
