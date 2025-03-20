package exercicios.TestesExercicios;

public class User {
    String nome;
    int idade;

    

    public User(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }


    @Override
    public String toString() {
        return "User - nome: " + nome + ", idade: " + idade;
    }

    

    

}
