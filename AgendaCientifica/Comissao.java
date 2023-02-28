import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class Comissao{
	
	private String nomeComissao;
	private String cnpj;
	private int qtdIntegrantes;
	private String Senha;
	
	public void setComissao() {
	
		Conexao connection = new Conexao();
			
		Connection con =  connection.Conexao();
			
		try {
				PreparedStatement stmt  =  con.prepareStatement("INSERT INTO comissao(nome_comissao, cnpj, qtd_integrantes, senha) VALUES (?,?,?,?)");
				stmt.setString(1, nomeComissao);
				stmt.setString(2, cnpj);
				stmt.setInt(3, qtdIntegrantes);
				stmt.setString(4,Senha);
				stmt.executeUpdate();
				
				
		}catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
		}	
			
	}
	
	public Comissao() {
		
		JFrame janelaComissao = new JFrame();
		janelaComissao.setSize(500,500);
		janelaComissao.setTitle("Agenda Cientifica");
		janelaComissao.setVisible(true);
		
		JPanel setComissaoPanel = new JPanel(new FlowLayout());
		
		Font LoginTitle = new Font("Serif", Font.PLAIN,20);
		
		JLabel Wellcome = new JLabel("Cadastro de Comissão Organizadora"); 
		Wellcome.setFont(LoginTitle);
		Wellcome.setBounds(100 , 80 , 300, 50);
		
		JLabel nameLabel = new JLabel("Nome : "); 
		nameLabel.setBounds(100 , 150 , 200, 50);
		
		JLabel cnpjLabel = new JLabel("CNPJ"); 
		cnpjLabel.setBounds(100 , 220 , 200, 50);
		
		JLabel qtdIntegrantesLabel = new JLabel("Quantidade de integrantes : "); 
		qtdIntegrantesLabel.setBounds(100 , 280 , 200, 50);
		
		JLabel senha = new JLabel("senha : "); 
		senha.setBounds(100 , 340 , 200, 50);
		
		JTextField nameInput = new JTextField();
		nameInput.setBounds(100, 200, 300 , 20);
		
		JTextField cnpjInput = new JTextField();
		cnpjInput.setBounds(100, 260, 300 , 20);
		
		JTextField qtdIntegrantesInput = new JTextField();
		qtdIntegrantesInput.setBounds(100, 320, 300 , 20);
		
		JTextField passwordInput = new JTextField();
		passwordInput.setBounds(100 , 380 , 300 , 20 );
		
		JButton avancar = new JButton("Avançar");
		avancar.setBounds(200,420, 100, 20);
		
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(50, 20 , 100, 20);
		
		voltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
				janelaComissao.setVisible(false);
			}
		});
		
		avancar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nomeComissao = nameInput.getText();
				cnpj = cnpjInput.getText();
				String a = qtdIntegrantesInput.getText();
				Senha = passwordInput.getText();
				int b = Integer.parseInt(a);
				qtdIntegrantes = b;
				setComissao();
				EnderecoComissao endereco = new EnderecoComissao(cnpj);
				janelaComissao.setVisible(false);
			}
		});
		
		setComissaoPanel.setLayout(null);
		setComissaoPanel.setSize(500,500);
		setComissaoPanel.setLocation(0, 0);
		setComissaoPanel.add(Wellcome);
		setComissaoPanel.add(nameLabel);
		setComissaoPanel.add(cnpjLabel);
		setComissaoPanel.add(qtdIntegrantesLabel);
		setComissaoPanel.add(senha);
		setComissaoPanel.add(nameInput);
		setComissaoPanel.add(cnpjInput);
		setComissaoPanel.add(qtdIntegrantesInput);
		setComissaoPanel.add(passwordInput);
		setComissaoPanel.add(avancar);
		setComissaoPanel.add(voltar);
		janelaComissao.setLayout(null);
		janelaComissao.add(setComissaoPanel);
		
	}
}