package entities;

public class Colaborador {
    private String nome;
    private String email;
    private Double salary;

    public Colaborador(String nome, String email, Double salary) {
        this.nome = nome;
        this.email = email;
        this.salary = salary;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


}
