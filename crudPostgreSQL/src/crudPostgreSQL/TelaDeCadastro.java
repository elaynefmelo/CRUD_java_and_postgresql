package crudPostgreSQL;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;

public class TelaDeCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JTextField txtEmail;
	
	private UsuariosDAO dao;
	private JTextField txtTelefone;
	private JTable tabelaDadosUsuario;
	private JTextField txtId;

	
	public TelaDeCadastro() throws ParseException {
		setResizable(false);
		
		dao = new UsuariosDAO();
		
		setTitle("Usuário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1059, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Cadastrar Usuário");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(188, 91, 200, 34);
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(22, 201, 86, 22);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNome.setBounds(88, 203, 174, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSobrenome.setBounds(272, 206, 98, 13);
		contentPane.add(lblSobrenome);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSobrenome.setBounds(373, 203, 174, 19);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogin.setBounds(22, 243, 71, 22);
		contentPane.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLogin.setBounds(88, 245, 174, 19);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSenha.setBounds(272, 248, 98, 13);
		contentPane.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSenha.setBounds(373, 245, 174, 19);
		contentPane.add(txtSenha);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(22, 285, 71, 22);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setBounds(88, 287, 174, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTelefone.setBounds(269, 290, 101, 13);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTelefone.setBounds(373, 287, 174, 19);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastro();	
				limpar();
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(188, 379, 98, 29);
		contentPane.add(btnSalvar);
		
		JButton btnListarDados = new JButton("Listar");
		btnListarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarDados();
			}
		});
		btnListarDados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListarDados.setBounds(855, 91, 86, 34);
		contentPane.add(btnListarDados);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(235, 162, 45, 19);
		contentPane.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setEnabled(false);
		txtId.setBounds(269, 165, 71, 19);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JButton btnPreencher = new JButton("Preencher");
		btnPreencher.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPreencher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencherCampos();
			}
		});
		btnPreencher.setBounds(625, 376, 114, 34);
		contentPane.add(btnPreencher);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(296, 378, 101, 31);
		contentPane.add(btnLimpar);
		
		JButton btnAtualizar = new JButton("Alterar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
				listarDados();
				limpar();
			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizar.setBounds(749, 377, 101, 33);
		contentPane.add(btnAtualizar);	
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletar();
				listarDados();
				limpar();
			}
		});
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletar.setBounds(860, 377, 114, 33);
		contentPane.add(btnDeletar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(605, 135, 394, 232);
		contentPane.add(scrollPane);
		
		tabelaDadosUsuario = new JTable();
		tabelaDadosUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabelaDadosUsuario.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Nome", "Sobrenome", "Login", "Senha", "Email", "Telefone"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tabelaDadosUsuario);
		
		JLabel Titulo2 = new JLabel("Listar Usuários");
		Titulo2.setFont(new Font("Tahoma", Font.BOLD, 20));
		Titulo2.setBounds(679, 88, 166, 37);
		contentPane.add(Titulo2);
	}
	
	//Método para cadastro
	
	 private void cadastro() {
	    	
	    	dao.salvar(new Usuario(0, txtNome.getText(), txtSobrenome.getText(), txtLogin.getText(), txtSenha.getText(), txtEmail.getText(), txtTelefone.getText()));
			
			JOptionPane.showMessageDialog(null, "Usuário Cadastrado");	
	    }
	 
	//Método para listar
	    private void listarDados(){
		 
		try {
			UsuariosDAO objUsuariosDAO = new UsuariosDAO();
			//Controle de dados do JTable
			DefaultTableModel model = (DefaultTableModel) tabelaDadosUsuario.getModel();
			model.setNumRows(0);
			
			//o objUsuariosDao que vai ter o metodp de listar
			ArrayList<Usuario> lista = objUsuariosDAO.listarUsuario();
			
			//O for vai rodar enquanto o o i for menor que o tamanho da lista
			for(int i = 0; i < lista.size(); i ++) {
				//adicionar linhas pq a oesquisa é feita pelas linhas 
				model.addRow(new Object[]{ 
						
						//adicionar na linha as colunas
						lista.get(i).getId(),
						lista.get(i).getNome(),
						lista.get(i).getSobrenome(),
						lista.get(i).getLogin(),
						lista.get(i).getSenha(),
						lista.get(i).getEmail(),
						lista.get(i).getTelefone()		
				}); 
			} 
	 }
	 catch(Exception e){
		 e.printStackTrace();
	 }
		 
	 }
	       //Metodo para preencher campos
	
	    private void preencherCampos() {
	    	
	    	//percorrer a linha pelo id
	    	//recebe o conteudo da tabela
	    	//SelectdRow seleciona a linha da tabela pelo id pq vc sabendo qual é a linha então é possivel percorrer cada coluna
	    	int selecionar = tabelaDadosUsuario.getSelectedRow();
	    	
	    	//pegar o modelo da tabela  e depois pegar o valor da tabela  pela linha (que vai ser selecionada) e a coluna e depois transformar o objeto em string
	    	//pega da coluna e atribui para o campo de texto
	    	//pega o modelo da tabela e utiliza o getValueAt para trabalhar com a coluna e com a linha
	    	
	    	txtId.setText(tabelaDadosUsuario.getModel().getValueAt(selecionar, 0).toString());
	    	txtNome.setText(tabelaDadosUsuario.getModel().getValueAt(selecionar, 1).toString());
	    	txtSobrenome.setText(tabelaDadosUsuario.getModel().getValueAt(selecionar, 2).toString());
	    	txtLogin.setText(tabelaDadosUsuario.getModel().getValueAt(selecionar, 3).toString());
	    	txtSenha.setText(tabelaDadosUsuario.getModel().getValueAt(selecionar, 4).toString());
	    	txtEmail.setText(tabelaDadosUsuario.getModel().getValueAt(selecionar, 5).toString());
	    	txtTelefone.setText(tabelaDadosUsuario.getModel().getValueAt(selecionar, 6).toString());
	    	 
	    }
	    
	  //Método limpar os dados dos campos após executar os botões
		
	   private void limpar() {
		   
		  txtId.setText("");;
		   txtNome.setText("");
		   txtSobrenome.setText("");
		   txtLogin.setText("");
		   txtSenha.setText("");
		   txtEmail.setText("");
		   txtTelefone.setText("");
		   //foco primeiro elemento
		   txtNome.requestFocus();
		  
	   }
	   
	   private void atualizar() {
		  
		  //precisa saber o id daquilo que ele vai alterar
		   
		  int id = Integer.parseInt(txtId.getText());
		  String nome = txtNome.getText();
		  String sobrenome = txtSobrenome.getText();
		  String login = txtLogin.getText();
		  String senha = txtSenha.getText();
		  String email = txtEmail.getText();
		  String telefone = txtTelefone.getText();
		  
		  
		  //passar essas informações para o model Usuario
		  //se o usuario alterar algo dentro dos campos preenchidos então esse dados volta alterado para a tabela, menos o id
		  Usuario usuario = new Usuario(); 
		  usuario.setId(id);
		  usuario.setNome(nome);
		  usuario.setSobrenome(sobrenome);
		  usuario.setLogin(login);
		  usuario.setSenha(senha);
		  usuario.setEmail(email);
		  usuario.setTelefone(telefone);
	
		  UsuariosDAO usuariodao = new UsuariosDAO();
		  //chama o metodo do dao
		  usuariodao.atualizar(usuario); 
		     
	   }
	   
	   private void deletar() {
		   
		   int id = Integer.parseInt(txtId.getText());
		   
		   Usuario usuario = new Usuario(); 
		   usuario.setId(id);
		   
		   UsuariosDAO usuariodao = new UsuariosDAO();
		   usuariodao.deletarPorID(id);	     
		   
		   JOptionPane.showMessageDialog(null, "Usuário Deletado");
		   
	   }
}












