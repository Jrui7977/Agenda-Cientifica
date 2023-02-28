import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Evento {

	
	public List<classEvento>ListarTodos(){
		
		List<classEvento> listaEventos = new ArrayList<classEvento>();
		
		Conexao connection = new Conexao();
		
		Connection con =  connection.Conexao();
		
		
		try {
			String sql = "SELECT * FROM evento";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet res = stmt.executeQuery();
			
			while(res.next()) {
				
				classEvento evento = new classEvento();
				
				evento.nomeEvento = res.getString("nome_evento");
				evento.tipoEvento = res.getString("tipo_evento");
				evento.area = res.getString("area");
				evento.data = res.getString("data");
				evento.duracao = res.getInt("duracao");
				evento.horario = res.getString("horario");
				
				listaEventos.add(evento);
				
			}
			
		}catch(SQLException e) {
			e.getMessage();
		}
		return listaEventos;
	}
	
	public Evento(String cnpj) {
		
		List<classEvento> Eventos = new ArrayList();
		
		Eventos = ListarTodos();
		
		JButton eventosBtn = new JButton("Eventos");
		eventosBtn.setBounds(20, 10, 100, 30);
		
		JButton salasBtn = new JButton("Salas");
		salasBtn.setBounds(150,10,100,30);
		
		JButton criarEvento = new JButton("Criar Evento");
		criarEvento.setBounds(50,60,150,30);
		
		JButton voltar = new JButton("Voltar");
		voltar.setBounds(150,10,100,30);
		
		JPanel eventosPanel = new JPanel();
		eventosPanel.setSize(600,600);
		eventosPanel.setBackground(Color.LIGHT_GRAY);
		eventosPanel.setLayout(null);
		eventosPanel.setLocation(100,100);
		int i = 50 ;
		for(classEvento e : Eventos){
			i = i + 50;
			JTextArea dado = new JTextArea("Nome do evento : " + e.nomeEvento +  "\nArea : "  + e.area + "\nTipo : " + e.tipoEvento + "\ndata : " + e.data + "\nDuracao : " + e.duracao + "\nHorario : " + e.horario);
			dado.setBounds(i,50,200,100);
			eventosPanel.add(dado);
		}
		
		JPanel salasPanel = new JPanel();
		salasPanel.setSize(600,600);
		salasPanel.setBackground(Color.DARK_GRAY);
		salasPanel.setLayout(null);
		salasPanel.setLocation(100,100);
		salasPanel.setVisible(false);
			
		JFrame janelaEvento = new JFrame();
		JPanel bar = new JPanel();
		bar.setLayout(null);
	
		bar.add(eventosBtn);
		bar.add(voltar);
		bar.setBounds(0,0,800,50);
		bar.setBackground(Color.LIGHT_GRAY);
		janelaEvento.setSize(1280,720);
		janelaEvento.setTitle("Agenda Cientifica");
		janelaEvento.setVisible(true);
		JPanel painel = new JPanel(new FlowLayout());
		painel.setBorder(BorderFactory.createTitledBorder("Bem vindo")); 
		painel.setLayout(null);
		painel.setSize(800,800);
		painel.setLocation(200,20);
		painel.add(bar);
		painel.add(eventosPanel);
		painel.add(salasPanel);
		painel.add(criarEvento);
;		janelaEvento.setLayout(null);
		janelaEvento.add(painel);
		
		eventosBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				salasPanel.setVisible(false);
				eventosPanel.setVisible(true);
				
			}
		});
		salasBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				salasPanel.setVisible(true);
				eventosPanel.setVisible(false);
			}
		});
		criarEvento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CriarEvento evento = new CriarEvento();
			}
		});
		voltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
			}
		});
	}
}
