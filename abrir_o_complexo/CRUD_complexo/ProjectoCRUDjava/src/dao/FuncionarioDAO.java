package dao;

import model.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Classe responsável por acessar o banco de dados (CRUD)
public class FuncionarioDAO {

    // Dados da conexão com o MySQL
    private final String URL = "jdbc:mysql://localhost:3306/crud_java";
    private final String USER = "root";
    private final String PASSWORD = "";

    // Método para conectar ao banco de dados
    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // ---------------------- CREATE ----------------------
    // Adiciona um novo funcionário ao banco
    public void adicionarFuncionario(Funcionario f) {

        String sql = "INSERT INTO funcionarios (primeiro_nome, nome_meio, ultimo_nome, email, contacto, salario) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        // Try-with-resources → fecha conexão automaticamente
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Preenchendo os parâmetros da query
            stmt.setString(1, f.getPrimeiroNome());
            stmt.setString(2, f.getNomeMeio());
            stmt.setString(3, f.getUltimoNome());
            stmt.setString(4, f.getEmail());
            stmt.setString(5, f.getContacto());
            stmt.setDouble(6, f.getSalario());

            stmt.executeUpdate(); // executa o INSERT
            System.out.println("Funcionário adicionado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ---------------------- READ ----------------------
    // Lista todos os funcionários do banco
    public List<Funcionario> listarFuncionarios() {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            // Enquanto houver registros no banco...
            while (rs.next()) {

                // Cria um objeto Funcionario com os dados do banco
                Funcionario f = new Funcionario(
                    rs.getInt("numero_funcionario"),
                    rs.getString("primeiro_nome"),
                    rs.getString("nome_meio"),
                    rs.getString("ultimo_nome"),
                    rs.getString("email"),
                    rs.getString("contacto"),
                    rs.getDouble("salario")
                );

                // Adiciona à lista
                lista.add(f);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // ---------------------- UPDATE ----------------------
    // Atualiza um funcionário existente
    public void atualizarFuncionario(Funcionario f) {

        String sql = "UPDATE funcionarios SET primeiro_nome = ?, nome_meio = ?, ultimo_nome = ?, "
                   + "email = ?, contacto = ?, salario = ? WHERE numero_funcionario = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Substitui os ? pelos valores do objeto
            stmt.setString(1, f.getPrimeiroNome());
            stmt.setString(2, f.getNomeMeio());
            stmt.setString(3, f.getUltimoNome());
            stmt.setString(4, f.getEmail());
            stmt.setString(5, f.getContacto());
            stmt.setDouble(6, f.getSalario());
            stmt.setInt(7, f.getNumeroFuncionario());

            stmt.executeUpdate(); // executa UPDATE
            System.out.println("Funcionário atualizado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ---------------------- DELETE ----------------------
    // Exclui um funcionário pelo número
    public void excluirFuncionario(int numeroFuncionario) {

        String sql = "DELETE FROM funcionarios WHERE numero_funcionario = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, numeroFuncionario);
            stmt.executeUpdate(); // executa DELETE

            System.out.println("Funcionário excluído!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
