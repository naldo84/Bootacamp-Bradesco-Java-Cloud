package exercicios.HerancaEPolimorfismoEmJava.Exercicio2;

public class Usuario {

    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String realizarLogin(String email, String senha){
        if(this.email.equals(email) && this.senha.equals(senha)){
            return "Login realizado com sucesso!";
        }else{
            return "Email ou senha inválidos!";
        }
    }

    public String realizarLogoff(){
        return "Logoff realizado com sucesso!";
    }

    public void alterarSenha(String novaSenha){
        this.senha = novaSenha;
    }

    public void alterarDados(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

}
