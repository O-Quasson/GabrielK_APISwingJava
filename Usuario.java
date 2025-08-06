import javax.swing.JOptionPane;

public class Usuario {
    private String nome;
    private String email;
    private int idade;
    private int id;

    public Usuario(int id, String nome, String email, int idade){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    };

    public int getid() {
        return id;
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

    public void setid(int id) {
        this.id = id;
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

    public void cadastrarUsuario(String nome, String email, String strIdade, int id, Usuario... usuario){
        int intidade = Integer.parseInt(strIdade);
        if((nome!="")&&(email!="")&&(intidade>=1)){
            usuario[id] = new Usuario(id, nome, email, idade);
            JOptionPane.showMessageDialog(null, "Usuário cadastrado:\nNome: " + usuario[id].getnome() + "\nEmail: " + usuario[id].getemail() + "\nIdade: " + usuario[id].getidade());
            id = id+1;
        }else{
            JOptionPane.showMessageDialog(null, "Erro!", "Algo deu errado! Aparentemente, um dos campos de informação está incompleto!", JOptionPane.ERROR_MESSAGE);
        }
    };
}
