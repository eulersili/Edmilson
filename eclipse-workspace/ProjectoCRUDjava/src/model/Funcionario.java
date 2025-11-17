package model;

public class Funcionario {

    private int numeroFuncionario;
    private String primeiroNome;
    private String nomeMeio;
    private String ultimoNome;
    private String email;
    private String contacto;
    private double salario;

    public Funcionario() {}

    public Funcionario(String primeiroNome, String nomeMeio, String ultimoNome, String email, String contacto, double salario) {
        this.primeiroNome = primeiroNome;
        this.nomeMeio = nomeMeio;
        this.ultimoNome = ultimoNome;
        this.email = email;
        this.contacto = contacto;
        this.salario = salario;
    }

    public Funcionario(int numeroFuncionario, String primeiroNome, String nomeMeio, String ultimoNome, String email, String contacto, double salario) {
        this.numeroFuncionario = numeroFuncionario;
        this.primeiroNome = primeiroNome;
        this.nomeMeio = nomeMeio;
        this.ultimoNome = ultimoNome;
        this.email = email;
        this.contacto = contacto;
        this.salario = salario;
    }

    // Getters e Setters
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
