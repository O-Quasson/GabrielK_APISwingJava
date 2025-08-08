import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.ButtonGroup;

public class CadastroUsuario {
    public static void main (String[] args){
        //explicação do por quê eu fiz como um array na linha 78
        int[] id = new int[2];
        id[0] = 0;
        
        //JFrame com nome CadastrodeUsuario, como pedido/mandado
        JFrame CadastrodeUsuario = new JFrame("Cadastro de Usuário");
        CadastrodeUsuario.setSize(1200,1000);
        CadastrodeUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //JPanel que agrupa todos os elementos/componentes pra eu não precisar ficar settando cada elemento específico como visível
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());

        //adicionando o painel dentro do JFrame
        CadastrodeUsuario.add(painel);
        painel.setLayout(null);

        //Legenda/título do campo de digitar nome e o próprio campo
        JLabel textoNome = new JLabel("Digite seu nome:      ");
        JTextField campoNome = new JTextField();
        painel.add(textoNome);
        painel.add(campoNome);
        //posição deles na tela e tamanho deles
        textoNome.setBounds(333,50,500,100);
        campoNome.setBounds(333, 120,500,50);

        //Título do campo de digitar email e o próprio campo
        JLabel textoEmail = new JLabel("Digite seu email:        ");
        JTextField campoEmail = new JTextField();
        painel.add(textoEmail);
        painel.add(campoEmail);
        //posição deles na tela e tamanho deles
        textoEmail.setBounds(333,150,500,100);
        campoEmail.setBounds(333,220,500,50);

        //Título do campo de digitar idade e o próprio campo
        JLabel textoIdade = new JLabel("Digite sua idade:        ");
        JFormattedTextField campoIdade = new JFormattedTextField();
        //máscara para permitir ser digitado apenas números
        MaskFormatter mascaraIdade = null;
        try {
            //VSCode mandou eu colocar essa linha dentro de um try/catch, então eu só obedeci
            //o # permite apenas números, não letras ou caracteres especiais
            mascaraIdade = new MaskFormatter("###");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mascaraIdade.install(campoIdade);
        campoIdade.setText("");
        painel.add(textoIdade);
        painel.add(campoIdade);
        //posição deles na tela e tamanho deles
        textoIdade.setBounds(333,250,500,100);
        campoIdade.setBounds(333,320,500,50);

        //seleção de gênero
        JLabel textoGenero = new JLabel("Insira o seu gênero:     ");
        JRadioButton opcaoMasculino = new JRadioButton("Masculino");
        JRadioButton opcaoFeminino = new JRadioButton("Feminino");
        ButtonGroup opcoesGenero = new ButtonGroup();
        opcoesGenero.add(opcaoMasculino);
        opcoesGenero.add(opcaoFeminino);
        textoGenero.setBounds(333,350,150,100);
        opcaoMasculino.setBounds(463,375, 100, 50);
        opcaoFeminino.setBounds(573,375, 100, 50);
        painel.add(textoGenero);
        painel.add(opcaoMasculino);
        painel.add(opcaoFeminino);

        //array onde vai ser armazenado o usuários cadastrados
        Usuario[] usuario = new Usuario[10];
        usuario[0] = new Usuario(id[0], "null", "null", "null", 0);

        //botão de cadastrar usuário
        JButton botaoCadastrar = new JButton("Cadastrar usuário");
        botaoCadastrar.setBounds(333,450, 225, 70);
        //Eu não tava conseguindo colocar para chamar a função de dentro da classe usuario, então transformei em arrow function
        //verifica se tem espaço o suficiente para cadastrar usuários (fiz isso com a possibilidade dos professores mandarem adicionar uma tela de login depois em mente),
        //verifica se os campos não estão vazios, e se não estiverem vazios, cadastra o usuário e exibe uma mensagem
        botaoCadastrar.addActionListener(cadastrarUsuario -> {
            if(id[0]<10){
                // int intidade = Integer.parseInt(campoIdade.getText().trim());
                String generoEscolhido;

                if((campoNome.getText().trim().equals(""))||((!opcaoFeminino.isSelected())&&(!opcaoMasculino.isSelected()))||(campoEmail.getText().trim().equals(""))||(campoIdade.getText().trim().equals(""))){
                    JOptionPane.showMessageDialog(null, "Algo deu errado! Aparentemente, um dos campos de informação está incompleto!", "Erro!", JOptionPane.ERROR_MESSAGE);
                }else{
                    //por quê isso tá funcionando? Não sei, mas eu tô aceitando
                    //provavelmente deve ser variável local, tipo 'let' em javascript
                    if(opcaoFeminino.isSelected()){
                        generoEscolhido = "Feminino";
                    }else{
                        generoEscolhido = "Masculino";
                    };
                    usuario[id[0]] = new Usuario(id[0], campoNome.getText().trim(), generoEscolhido, campoEmail.getText().trim(), Integer.parseInt(campoIdade.getText().trim()));
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado! \nNome: " + usuario[id[0]].getnome() + "\nGênero: " + usuario[id[0]].getgenero() + "\nEmail: " + usuario[id[0]].getemail() + "\nIdade: " + usuario[id[0]].getidade());
                    //usar um int normal não tava funcionando, enquanto o array de usuários tava funcionando, então eu criei um array simples de 2 posições, sendo que eu vou usar só uma, então vai ser a mesma coisa que usar um int normal
                    id[0] = id[0] + 1;
                };
            }else{
                JOptionPane.showMessageDialog(null, "Tem um limite máximo de 10 contas nesse projeto, respeite ele", "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        });
        painel.add(botaoCadastrar);

        //botão para limpar os campos
        JButton botaoApagar = new JButton("Limpar dados inseridos");
        botaoApagar.setBounds(608,450, 225, 70);
        botaoApagar.addActionListener(limparCampos -> {
            campoNome.setText("");
            campoEmail.setText("");
            campoIdade.setText("");
            opcoesGenero.clearSelection();
        });
        painel.add(botaoApagar);

        CadastrodeUsuario.setVisible(true);
    }
}