package edmilson;

import dao.FuncionarioDAO;
import model.Funcionario;

// Classe principal: executa testes do CRUD
public class Main {
    public static void main(String[] args) {

        // Cria o objeto DAO para acessar o banco
        FuncionarioDAO dao = new FuncionarioDAO();

        // -------------------- CREATE --------------------
//        // Criando um novo funcionário
//        Funcionario novo = new Funcionario(
//                "João", "A.", "Silva",
//                "joao.silva@empresa.com",
//                "987654321",
//                15000
//        );
//
//        dao.adicionarFuncionario(novo); // adiciona no banco

        // -------------------- READ --------------------
        System.out.println("\n--- LISTA DE FUNCIONÁRIOS ---\n");
        
        // Imprime todos os funcionários
        dao.listarFuncionarios().forEach(f ->
            System.out.println(
                f.getNumeroFuncionario() + " | " +
                f.getPrimeiroNome() + " " +
                f.getNomeMeio() + " " +
                f.getUltimoNome() + " | " +
                f.getEmail() + " | " +
                f.getContacto() + " | " +
                f.getSalario()
            )
        );

        // -------------------- UPDATE --------------------
        // Atualizando os dados do funcionário de número 1
        Funcionario atualizado = new Funcionario(
                1,
                "João", "Almeida", "Silva",
                "joao.almeida@empresa.com",
                "999999999",
                20500
        );

        dao.atualizarFuncionario(atualizado);

        // -------------------- DELETE --------------------
        // Excluindo o funcionário número 1
        dao.excluirFuncionario(5);
    }
}
