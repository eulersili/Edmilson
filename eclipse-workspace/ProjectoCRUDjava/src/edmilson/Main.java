package edmilson;

import dao.FuncionarioDAO;
import model.Funcionario;

public class Main {
    public static void main(String[] args) {

        FuncionarioDAO dao = new FuncionarioDAO();

//        // 1. Adicionar funcionário
//        Funcionario novo = new Funcionario(
//                "João", "A.", "Silva",
//                "joao.silva@empresa.com",
//                "987654321",
//                3500.00
//        );
//
//        dao.adicionarFuncionario(novo);

        // 2. Listar funcionários
        System.out.println("\n--- LISTA DE FUNCIONÁRIOS ---\n");
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

        // 3. Atualizar funcionário
        Funcionario atualizado = new Funcionario(
                1,                         // número do funcionário
                "João", "Almeida", "Silva",
                "joao.almeida@empresa.com",
                "999999999",
                4100.00
        );

        dao.atualizarFuncionario(atualizado);

        // 4. Excluir funcionário
        dao.excluirFuncionario(1);
    }
}
