public class Usuario {
    private String nome;
    private String email;
    private int idade;

    public Usuario(String nome, String email, int idade){
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    };

    public String getnome() {
        return nome;
    };

    public String getemail() {
        return email;
    };

    public int getidade() {
        return idade;
    };

    public void setnome(String nome) {
        this.nome = nome;
    };

    public void setemail(String email){
        this.email = email;
    };

    public void setidade(int idade){
        this.idade = idade;
    };
}
