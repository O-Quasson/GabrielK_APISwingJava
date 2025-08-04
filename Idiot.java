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
        JFrame frame = new JFrame("Cadastro de Usuário");
        frame.setSize(1300,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        JPanel painelNome = new JPanel();
        JPanel painelEmail = new JPanel();
        JPanel painelIdade = new JPanel();
        painel.setLayout(new GridBagLayout());

        frame.add(painel);

        JLabel textoNome = new JLabel("Texto 1 LMAO XDXDXD");
        JTextField campoNome = new JTextField("Isso é um placeholder?");
        // ImageIcon imagem1 = new ImageIcon("C:\\Users\\20240474\\Downloads\\gui\\imagens\\idiot.png");
        painelNome.add(textoNome);
        painelNome.add(campoNome);
        // painel.add(new JLabel(imagem1));
        painel.add(painelNome);

        JLabel textoEmail = new JLabel("Texto 2 is so sigma lol");
        JTextField campoEmail = new JTextField("Já descobri que essa porra não é placeholder");
        painelEmail.add(textoEmail);
        painelEmail.add(campoEmail);
        painel.add(painelEmail);

        JLabel textoIdade = new JLabel("Texto 3 chipamzini bananini");
        JTextField campoIdade = new JTextField("COMO DIMINUI A FONTE?");
        painelIdade.add(textoIdade);
        painelIdade.add(campoIdade);
        painel.add(painelIdade);

        JButton butao = new JButton("Não, não é o país Butão");
        painel.add(butao);

        frame.setVisible(true);
    }
}