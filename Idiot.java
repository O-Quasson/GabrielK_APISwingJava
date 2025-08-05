import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;

public class Idiot {
    public static void main (String[] args){
        int id = 0;

        JFrame frame = new JFrame("Cadastro de Usuário");
        frame.setSize(1200,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        JPanel painelNome = new JPanel();
        JPanel painelEmail = new JPanel();
        JPanel painelIdade = new JPanel();
        painel.setLayout(new GridBagLayout());

        frame.add(painel);
        painel.setLayout(null);

        JLabel textoNome = new JLabel("Texto 1 LMAO XDXDXD");
        JTextField campoNome = new JTextField("Isso é um placeholder?");
        // ImageIcon imagem1 = new ImageIcon("C:\\Users\\20240474\\Downloads\\gui\\imagens\\idiot.png");
        painelNome.add(textoNome);
        painelNome.add(campoNome);
        // painel.add(new JLabel(imagem1));
        painelNome.setBounds(333,150,500,100);
        painel.add(painelNome);

        JLabel textoEmail = new JLabel("Texto 2 is so sigma lol");
        JTextField campoEmail = new JTextField("Já descobri que essa porra não é placeholder");
        painelEmail.add(textoEmail);
        painelEmail.add(campoEmail);
        painelEmail.setBounds(333,300,500,100);
        painel.add(painelEmail);

        JLabel textoIdade = new JLabel("Texto 3 chipamzini bananini");
        JTextField campoIdade = new JTextField("COMO DIMINUI A FONTE?");
        painelIdade.add(textoIdade);
        painelIdade.add(campoIdade);
        painelIdade.setBounds(333,450,500,100);
        painel.add(painelIdade);

        Usuario[] usuario = new Usuario[id, "um", "um", 1];

        JButton butao = new JButton("Não, não é o país Butão");
        butao.setBounds(333,600, 500, 100);
        butao.addActionListener(usuario.cadastrarUsuario(painelNome.get));
        painel.add(butao);

        frame.setVisible(true);
    }
}