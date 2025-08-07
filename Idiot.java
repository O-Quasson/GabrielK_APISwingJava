import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
// import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class Idiot {
    public static void main (String[] args){
        int id = 0;

        JFrame frame = new JFrame("Cadastro de Usuário");
        frame.setSize(1200,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());

        frame.add(painel);
        painel.setLayout(null);

        JLabel textoNome = new JLabel("Digite seu nome:      ");
        JTextField campoNome = new JTextField("placeholder");
        // ImageIcon imagem1 = new ImageIcon("C:\\Users\\20240474\\Downloads\\gui\\imagens\\idiot.png");
        painel.add(textoNome);
        painel.add(campoNome);
        // painel.add(new JLabel(imagem1));
        textoNome.setBounds(333,150,500,100);
        campoNome.setBounds(333,200,500,100);

        JLabel textoEmail = new JLabel("Digite seu email:        ");
        JTextField campoEmail = new JTextField("POR QUE CARALHOS ESSA PORRA NÃO AUMENTA DE TAMANHOOOOOOOOOOOOOOOOOOOO");
        painel.add(textoEmail);
        painel.add(campoEmail);
        textoEmail.setBounds(333,300,500,100);
        campoEmail.setBounds(333,350,500,100);

        JLabel textoIdade = new JLabel("Digite sua idade:        ");
        JFormattedTextField campoIdade = new JFormattedTextField();
        MaskFormatter mascaraIdade = null;
        try {
            // VSCode mandou eu colocar essa linha dentro de um try/catch, então eu só obedeci
            mascaraIdade = new MaskFormatter("###");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mascaraIdade.install(campoIdade);
        painel.add(textoIdade);
        painel.add(campoIdade);
        textoIdade.setBounds(333,450,500,100);
        campoIdade.setBounds(333,500,500,100);

        Usuario[] usuario = new Usuario[10];
        usuario[0] = new Usuario(id, "null", "null", 0);

        JButton butao = new JButton("Cadastrar usuário");
        butao.setBounds(333,600, 500, 100);
        //mexer nisso
        butao.addActionListener(cadastrarUsuario -> {
            // if(id>10){
                int intidade = Integer.parseInt(campoIdade.getText().toString());
                if((campoNome.getText().equals(""))&&(campoEmail.getText().equals(""))&&(intidade>=1)){
                    usuario[id] = new Usuario(id, campoNome.getText(), campoEmail.getText(), intidade);
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado:\nNome: " + usuario[id].getnome() + "\nEmail: " + usuario[id].getemail() + "\nIdade: " + usuario[id].getidade());
                    // id = id+1;
                }else{
                    JOptionPane.showMessageDialog(null, "Algo deu errado! Aparentemente, um dos campos de informação está incompleto!", "Erro!", JOptionPane.ERROR_MESSAGE);
                }
            // }else{
            //     JOptionPane.showMessageDialog(null, "Tem um limite máximo de 10 contas nesse projeto, respeite ele", "Erro!", JOptionPane.ERROR_MESSAGE);
            // }
        });

        painel.add(butao);

        frame.setVisible(true);
    }
}