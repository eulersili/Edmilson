package main;

import dao.UsuarioDAO;
import model.Usuario;

/**
 * Classe principal que testa os métodos CRUD da aplicação.
 */
public class Main {
    public static void main(String[] args) {

        UsuarioDAO dao = new UsuarioDAO();

        // CREATE (criar usuário)
        dao.adicionarUsuario(new Usuario("Maria", "maria@email.com"));

        // READ (listar usuários)
        dao.listarUsuarios().forEach(u ->
            System.out.println(u.getId() + " | " + u.getNome() + " | " + u.getEmail())
        );

        // UPDATE (atualizar usuário)
        dao.atualizarUsuario(new Usuario(1, "Maria Silva", "maria.silva@email.com"));

        // DELETE (deletar usuário)
        dao.excluirUsuario(1);
    }
}
