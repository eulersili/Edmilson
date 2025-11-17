package model;

/**
 * Classe que representa um usuário na aplicação.
 * Funciona como espelho da tabela "usuarios" no banco de dados.
 */
public class Usuario {
    private int id;          // Identificador único do usuário
    private String nome;     // Nome do usuário
    private String email;    // Email do usuário

    public Usuario() {}

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Usuario(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    // Getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
