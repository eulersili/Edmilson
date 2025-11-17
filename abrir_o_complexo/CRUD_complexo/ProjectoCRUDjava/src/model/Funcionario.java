package model;

// Classe que representa um funcionário (entidade de negócio)
public class Funcionario {

    // Atributos do funcionário
    private int numeroFuncionario;   // ID do funcionário (PRIMARY KEY)
    private String primeiroNome;     // Primeiro nome
    private String nomeMeio;         // Nome do meio
    private String ultimoNome;       // Último nome
    private String email;            // Email corporativo ou pessoal
    private String contacto;         // Telefone ou contacto
    private double salario;          // Salário mensal

    // Construtor vazio (necessário para alguns usos, como frameworks)
    public Funcionario() {}

    // Construtor para inserir novo funcionário (sem ID)
    public Funcionario(String primeiroNome, String nomeMeio, String ultimoNome, String email, String contacto, double salario) {
        this.primeiroNome = primeiroNome;
        this.nomeMeio = nomeMeio;
        this.ultimoNome = ultimoNome;
        this.email = email;
        this.contacto = contacto;
        this.salario = salario;
    }

    // Construtor completo (inclui o número do funcionário)
    public Funcionario(int numeroFuncionario, String primeiroNome, String nomeMeio, String ultimoNome, String email, String contacto, double salario) {
        this.numeroFuncionario = numeroFuncionario;
        this.primeiroNome = primeiroNome;
        this.nomeMeio = nomeMeio;
        this.ultimoNome = ultimoNome;
        this.email = email;
        this.contacto = contacto;
        this.salario = salario;
    }

    // Getters e setters para acessar os atributos
    public int getNumeroFuncionario() {
    	return numeroFuncionario;
    }
    public void setNumeroFuncionario(int numeroFuncionario) {
    	this.numeroFuncionario = numeroFuncionario;
    }

    public String getPrimeiroNome() {
    	return primeiroNome;
    }
    public void setPrimeiroNome(String primeiroNome) {
    	this.primeiroNome = primeiroNome;
    }

    public String getNomeMeio() {
    	return nomeMeio;
    }
    public void setNomeMeio(String nomeMeio) {
    	this.nomeMeio = nomeMeio;
    }

    public String getUltimoNome() {
    	return ultimoNome;
    }
    public void setUltimoNome(String ultimoNome) {
    	this.ultimoNome = ultimoNome;
    }

    public String getEmail() {
    	return email;
    }
    public void setEmail(String email) {
    	this.email = email;
    }

    public String getContacto() {
    	return contacto;
    }
    public void setContacto(String contacto) {
    	this.contacto = contacto;
	}

    public double getSalario() {
    	return salario;
    }
    public void setSalario(double salario) {
    	this.salario = salario;
	}
}
