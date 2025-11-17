package dao;

import model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por executar comandos SQL no banco de dados.
 * Aqui ficam os métodos CRUD (Create, Read, Update, Delete).
 */
public class UsuarioDAO {

    // Dados da conexão com o banco MySQL
    private final String URL = "jdbc:mysql://localhost:3306/crud_java_simples";
    private final String USER = "root";
    private final String PASSWORD = "";

    /**
     * Abre conexão com o banco de dados.
     */
    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // --------------------- CREATE ---------------------
    /**
     * Adiciona um novo usuário ao banco.
     */
    public void adicionarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";

        try (Connection conn = conectar(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Passa valores para a query SQL
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());

            stmt.executeUpdate(); // Executa o comando SQL
            System.out.println("Usuário adicionado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // --------------------- READ ---------------------
    /**
     * Retorna uma lista com todos os usuários cadastrados.
     */
    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = conectar(); 
             PreparedStatement stmt = conn.prepareStatement(sql); 
             ResultSet rs = stmt.executeQuery()) {

            // Percorre resultados do SELECT
            while (rs.next()) {
                Usuario u = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email")
                );
                lista.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // --------------------- UPDATE ---------------------
    /**
     * Atualiza um usuário já existente no banco.
     */
    public void atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome = ?, email = ? WHERE id = ?";

        try (Connection conn = conectar(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setInt(3, usuario.getId());

            stmt.executeUpdate();
            System.out.println("Usuário atualizado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // --------------------- DELETE ---------------------
    /**
     * Exclui um usuário pelo ID.
     */
    public void excluirUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (Connection conn = conectar(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Usuário excluído!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
