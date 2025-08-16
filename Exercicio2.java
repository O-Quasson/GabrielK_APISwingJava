import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

public class Exercicio2 {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Exercício 2");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        JTabbedPane abas = new JTabbedPane();

        JPanel painel1 = new JPanel();
        JLabel textoConfig = new JLabel("Bem vindo às Configurações!");
        ImageIcon icon1 = new ImageIcon("./images/config.png");
        icon1.getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        painel1.add(textoConfig);
        abas.add(painel1, 0);
        abas.setTitleAt(0,"Configurações");
        abas.setIconAt(0, icon1);

        JPanel painel2 = new JPanel();
        painel2.setBackground(Color.BLUE);
        painel2.setSize(500,500);
        JTextField campoNome = new JTextField("Insira seu nome: ");
        ImageIcon icon2 = new ImageIcon("./images/me.png");
        icon2.getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        painel2.setLayout(null);

        //ótimo, agr ficou um bagulho gigante no meio do código, que merda
        //isso que dá querer fazer uma coisinha legal
        //pelo menos isso funciona, né
        MouseListener eventoCliqueCampoNome = new MouseListener() {
            //eu odeio ter que dar override em todos os métodos de interfaces 😭😭
            //ainda bme que o vscode tem esse negócio de quickfix
            //não, professor, eu não usei chatgpt
            //https://www.devmedia.com.br/swing-em-java-capturando-coordenadas-do-mouse/28863 -> minha fonte

            @Override
            public void mouseClicked(MouseEvent e) {
                campoNome.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            }
        };
            
        painel2.add(campoNome);
        campoNome.setBounds(125, 75, 250, 50);
        campoNome.addMouseListener(eventoCliqueCampoNome);
        campoNome.addActionListener(mensagemBoasVindas -> {
            if(campoNome.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null, "Insira seu nome primeiro!");
            }else{
                JOptionPane.showMessageDialog(null, "Olá, " + campoNome.getText().trim() + "!");
            }
        });
        abas.add(painel2, 1);
        abas.setTitleAt(1, "Perfil");
        abas.setIconAt(1, icon2);

        JPanel painel3 = new JPanel();
        painel3.setSize(500,500);
        painel3.setLayout(null);
        JTextArea campoAjuda = new JTextArea("Digite suas dúvidas aqui!");
        ImageIcon icon3 = new ImageIcon("./images/penso.png");
        icon3.getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        campoAjuda.setBounds(125,75,150,100);

        MouseListener eventoCliqueCampoAjuda = new MouseListener() {
            //eu adoro o quickfix do vscode

            @Override
            public void mouseClicked(MouseEvent e) {
                campoAjuda.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            }
        };
        
        campoAjuda.addMouseListener(eventoCliqueCampoAjuda); 
        campoAjuda.setLineWrap(true);
        JButton botaoEnviar = new JButton("Enviar dúvida");
        botaoEnviar.setBounds(125,200,150,25);
        botaoEnviar.addActionListener(enviarDuvida -> {
            if(campoAjuda.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Você não escreveu nada!");
            }else{
                JOptionPane.showMessageDialog(null, "Sua dúvida foi enviada. Eu com certeza lerei ela e tentarei te contatar o mais rápido o possível para sanar sua dúvida!");
                campoAjuda.setText("");
            }
        });
        painel3.add(botaoEnviar);
        painel3.add(campoAjuda);
        abas.add(painel3, 2);
        abas.setTitleAt(2,"Ajuda");
        abas.setIconAt(2, icon3);

        frame.add(abas);
        frame.setVisible(true);
    }
}