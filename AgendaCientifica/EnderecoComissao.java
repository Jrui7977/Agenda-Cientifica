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


public class EnderecoComissao{
	
	private String rua;	
	private String Bairro;	
	private String Cidade;	
	private String CEP;	
	private String complemento;	
	private String Comissao_cnpj;
	
	
	
	public void setEnderecoComissao() {
	
		Conexao connection = new Conexao();
			
		Connection con =  connection.Conexao();
			
		try {
				PreparedStatement stmt  =  con.prepareStatement("INSERT INTO endereco_comissao(rua, Bairro, Cidade , CEP,complemento,Comissao_cnpj) VALUES (?,?,?,?,?,?)");
				stmt.setString(1, this.rua);
				stmt.setString(2, this.Bairro);
				stmt.setString(3, this.Cidade);
				stmt.setString(4,this.CEP);
				stmt.setString(5,this.complemento);
				stmt.setString(6,this.Comissao_cnpj);
				stmt.executeUpdate();
				
				
		}catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
		}	
			
	}
	
	public EnderecoComissao(String cnpj) {
		
		JFrame enderecoComissao = new JFrame();
		enderecoComissao.setSize(500,500);
		enderecoComissao.setTitle("Agenda Cientifica");
		enderecoComissao.setVisible(true);
		
		JPanel EnderecoComissaoPanel = new JPanel(new FlowLayout());
		
		Font LoginTitle = new Font("Serif", Font.PLAIN,20);
		
		JLabel Wellcome = new JLabel("Cadastro de Endereço"); 
		Wellcome.setFont(LoginTitle);
		Wellcome.setBounds(100 , 0 , 300, 50);
		
		JLabel ruaLabel = new JLabel("Rua : "); 
		ruaLabel.setBounds(100 , 50 , 200, 50);
		
		JLabel bairroLabel = new JLabel("Bairro : "); 
		bairroLabel.setBounds(100 , 110 , 200, 50);
		
		JLabel cidadeLabel = new JLabel("Cidade : "); 
		cidadeLabel.setBounds(100 ,160 , 200, 50);
		
		JLabel cepLabel = new JLabel("CEP : "); 
		cepLabel.setBounds(100 , 210 , 200, 50);
		
		JLabel complementoLabel = new JLabel("Complemento : "); 
		complementoLabel.setBounds(100 , 260 , 200, 50);
		
		JTextField ruaInput = new JTextField();
		ruaInput.setBounds(100, 100, 200,20);
		
		JTextField bairroInput = new JTextField();
		bairroInput.setBounds(100,150, 200,20);
		
		JTextField cidadeInput = new JTextField();
		cidadeInput.setBounds(100, 200, 200,20);
		
		JTextField cepInput = new JTextField();
		cepInput.setBounds(100,250, 200,20);
		
		JTextField complementoInput = new JTextField();
		complementoInput.setBounds(100, 300, 200,20);
		
		JButton concluir = new JButton("Concluir");
		concluir.setBounds(150,350, 100, 20);
		
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(50, 550 , 100, 20);
		
		voltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Comissao comissao = new Comissao();
				enderecoComissao.setVisible(false);
			}
		});
		
		concluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Comissao_cnpj = cnpj;
				rua = ruaInput.getText();
				Cidade = cidadeInput.getText();
				complemento = complementoInput.getText();
				Bairro = bairroInput.getText();
				CEP = cepInput.getText();
				setEnderecoComissao();
				JOptionPane.showMessageDialog(null, "Cadastrado!");
				enderecoComissao.setVisible(false);
				Main main = new Main();
			}
		});
		
		EnderecoComissaoPanel.setLayout(null);
		EnderecoComissaoPanel.setSize(500,500);
		EnderecoComissaoPanel.setLocation(50,0);
		EnderecoComissaoPanel.add(Wellcome);
		EnderecoComissaoPanel.add(ruaLabel);
		EnderecoComissaoPanel.add(cidadeLabel);
		EnderecoComissaoPanel.add(bairroLabel);
		EnderecoComissaoPanel.add(complementoLabel);
		EnderecoComissaoPanel.add(cepLabel);
		EnderecoComissaoPanel.add(ruaInput);
		EnderecoComissaoPanel.add(cidadeInput);
		EnderecoComissaoPanel.add(cepInput);
		EnderecoComissaoPanel.add(complementoInput);
		EnderecoComissaoPanel.add(bairroInput);
		EnderecoComissaoPanel.add(concluir);
		EnderecoComissaoPanel.add(voltar);
		enderecoComissao.setLayout(null);
		enderecoComissao.add(EnderecoComissaoPanel);
	}
}