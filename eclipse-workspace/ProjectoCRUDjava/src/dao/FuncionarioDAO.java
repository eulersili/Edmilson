package dao;

import model.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    private final String URL = "jdbc:mysql://localhost:3306/crud_java";
    private final String USER = "root";
    private final String PASSWORD = "";

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // CREATE
    public void adicionarFuncionario(Funcionario f) {
        String sql = "INSERT INTO funcionarios (primeiro_nome, nome_meio, ultimo_nome, email, contacto, salario) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, f.getPrimeiroNome());
            stmt.setString(2, f.getNomeMeio());
            stmt.setString(3, f.getUltimoNome());
            stmt.setString(4, f.getEmail());
            stmt.setString(5, f.getContacto());
            stmt.setDouble(6, f.getSalario());

            stmt.executeUpdate();
            System.out.println("Funcionário adicionado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Funcionario> listarFuncionarios() {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Funcionario f = new Funcionario(
                    rs.getInt("numero_funcionario"),
                    rs.getString("primeiro_nome"),
                    rs.getString("nome_meio"),
                    rs.getString("ultimo_nome"),
                    rs.getString("email"),
                    rs.getString("contacto"),
                    rs.getDouble("salario")
                );
                lista.add(f);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // UPDATE
    public void atualizarFuncionario(Funcionario f) {
        String sql = "UPDATE funcionarios SET primeiro_nome = ?, nome_meio = ?, ultimo_nome = ?, "
                   + "email = ?, contacto = ?, salario = ? WHERE numero_funcionario = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, f.getPrimeiroNome());
            stmt.setString(2, f.getNomeMeio());
            stmt.setString(3, f.getUltimoNome());
            stmt.setString(4, f.getEmail());
            stmt.setString(5, f.getContacto());
            stmt.setDouble(6, f.getSalario());
            stmt.setInt(7, f.getNumeroFuncionario());

            stmt.executeUpdate();
            System.out.println("Funcionário atualizado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void excluirFuncionario(int numeroFuncionario) {
        String sql = "DELETE FROM funcionarios WHERE numero_funcionario = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, numeroFuncionario);
            stmt.executeUpdate();

            System.out.println("Funcionário excluído!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
