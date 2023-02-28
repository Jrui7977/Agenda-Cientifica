import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CriarEvento {
	
	public void setEvento(classEvento e) {
		
		Conexao connection = new Conexao();
			
		Connection con =  connection.Conexao();
			
		try {
				PreparedStatement stmt  =  con.prepareStatement("INSERT INTO evento(nome_evento,tipo_evento, area ,data,duracao,horario,sala) VALUES (?,?,?,?,?,?,?)");
				stmt.setString(1, e.nomeEvento);
				stmt.setString(2, e.tipoEvento);
				stmt.setString(3, e.area);
				stmt.setString(4,e.data);
				stmt.setInt(5,e.duracao);
				stmt.setString(6,e.horario);
				stmt.setInt(7,e.sala);
				stmt.executeUpdate();
				
				
		}catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
		}	
			
	}

	
	public CriarEvento(){
		JFrame criarEvento = new JFrame();
		criarEvento.setSize(500,500);
		criarEvento.setLayout(null);
		criarEvento.setVisible(true);
		JPanel eventoPanel = new JPanel(new FlowLayout());
		eventoPanel.setLayout(null);
		eventoPanel.setSize(500,500);
		eventoPanel.setLocation(50,0);
		
		JLabel nomeEvento = new JLabel("Nome do Evento : "); 
		nomeEvento.setBounds(100 , 50 , 200, 50);
		
		JLabel tipoEvento = new JLabel("tipo do Evento : "); 
		tipoEvento.setBounds(100 , 100 , 200, 50);
		
		JLabel areaEvento = new JLabel("Area do evento : "); 
		areaEvento.setBounds(100 , 150 , 200, 50);
		
		JLabel data = new JLabel("data : "); 
		data.setBounds(100, 200 , 220, 50);
		
		JLabel duracao= new JLabel("Duracao :  "); 
		duracao.setBounds(100 , 250 , 200, 50);
		
		JLabel sala = new JLabel("Sala :  "); 
		sala.setBounds(100 , 300 , 200, 50);
		
		JLabel horario = new JLabel("horario"); 
		horario.setBounds(100 , 350 , 200, 50);
		
		JTextField nomeInput = new JTextField();
		nomeInput.setBounds(100, 90, 200,20);
		
		JTextField tipoEventoInput = new JTextField();
		tipoEventoInput.setBounds(100, 140, 200,20);
		
		JTextField areaInput = new JTextField();
		areaInput.setBounds(100, 190, 200,20);
		
		JTextField dataInput = new JTextField();
		dataInput.setBounds(100, 240, 200,20);
		
		JTextField duracaoInput = new JTextField();
		duracaoInput.setBounds(100, 290, 200,20);
		
		JTextField horarioInput = new JTextField();
		horarioInput.setBounds(100, 340, 200,20);
		
		JTextField salaInput= new JTextField();
		salaInput.setBounds(100, 390, 200,20);
		
		JButton concluir = new JButton("Concluir");
		concluir.setBounds(150, 420, 100, 20);
		
		concluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				classEvento evento = new classEvento();
				evento.nomeEvento = nomeInput.getText();
				evento.tipoEvento = tipoEventoInput.getText();
				evento.area = areaInput.getText();
				evento.data = dataInput.getText();
				int aux = Integer.parseInt(duracaoInput.getText());
				evento.duracao = aux;
				evento.horario = horarioInput.getText();
				aux = Integer.parseInt(salaInput.getText());
				evento.sala = aux;
				setEvento(evento);
				criarEvento.setVisible(false);
			}
		});
		
		eventoPanel.add(nomeEvento);
		eventoPanel.add(tipoEvento);
		eventoPanel.add(areaEvento);
		eventoPanel.add(data);
		eventoPanel.add(sala);
		eventoPanel.add(duracao);
		eventoPanel.add(horario);
		eventoPanel.add(nomeInput);
		eventoPanel.add(tipoEventoInput);
		eventoPanel.add(areaInput);
		eventoPanel.add(dataInput);
		eventoPanel.add(duracaoInput);
		eventoPanel.add(horarioInput);
		eventoPanel.add(salaInput);
		eventoPanel.add(concluir);
		criarEvento.add(eventoPanel);
		
	}
}
