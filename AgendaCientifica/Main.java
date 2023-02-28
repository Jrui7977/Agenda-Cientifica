import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class Main {
	
	private String cnpj;
	private String senha;
	
	public Main(){
		
		JFrame janela = new JFrame();
		
		JPanel Login = new JPanel(new FlowLayout());

		
		Font LoginTitle = new Font("Serif", Font.PLAIN,30);
		
		JLabel Wellcome = new JLabel("Login");
		Wellcome.setFont(LoginTitle);
		Wellcome.setBounds(220 , 80 , 200, 50);
		
		JLabel cnpjLabel = new JLabel("CNPJ : ");
		cnpjLabel.setBounds(160 , 150 , 200, 50);
		
		JLabel passwordLabel = new JLabel("Senha : ");
		passwordLabel.setBounds(160 , 220 , 200, 50);
		
		JTextField cnpjInput = new JTextField();
		cnpjInput.setBounds(160, 200, 200,20);
		
		JTextField passwordInput = new JTextField();
		passwordInput.setBounds(160, 260, 200,20);
		
		JButton Entrar = new JButton();
		Entrar.setText("Entrar");
		Entrar.setBounds(220, 300, 70, 20);
		
		
		Entrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cnpj = cnpjInput.getText();
				senha = passwordInput.getText();
				
				Conexao con = new Conexao();
				
				Connection conn = con.Conexao();

				try {
					String sql = "select * from comissao where cnpj = ? and senha = ?";
					PreparedStatement stmt = conn.prepareStatement(sql);
					stmt.setString(1, cnpj);
					stmt.setString(2, senha);
					ResultSet rs = stmt.executeQuery();
					if(rs.next()) {
						Evento evento = new Evento(cnpj);
						janela.setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null,"Usuário ou senha incorretos");
					}
				} catch (SQLException err) {
					JOptionPane.showMessageDialog(null,err.getMessage());
				}
			}
		});
		
		JButton criarConta = new JButton();
		criarConta.setText("Criar conta");
		criarConta.setBounds(205, 350, 100, 20);
		criarConta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				janela.setVisible(false);
				Comissao comissao = new Comissao();
			}
		});
		
		Login.setLayout(null);
		Login.add(Wellcome);
		Login.setSize(500,500);
		Login.setLocation(0, 0);
		Login.add(cnpjLabel);
		Login.add(passwordLabel);
		Login.add(cnpjInput);
		Login.add(passwordInput);
		Login.add(Entrar);
		Login.add(criarConta);
		janela.setSize(500,500);
		janela.setLayout(null);
		janela.setTitle("Agenda Científica");
		janela.add(Login);
		janela.setVisible(true);
		
		
	}
	public static void main(String[] args) {
		Main main = new Main();
	}
}
