package crudPostgreSQL;

import java.awt.EventQueue;

public class Programa {

	public static void main(String[] args) {

		/*UsuariosDAO usuariosDAO = new UsuariosDAO();
		
				Usuario usuario = new Usuario();
				usuario.setNome("Elayne");
				usuario.setSobrenome("Oliveira");
				usuario.setLogin("eric123");
				usuario.setSenha("elayne");
				usuario.setEmail("elayne@gmail.com");
				usuario.setTelefone("8888888888");
				
				usuariosDAO.salvar(usuario); */
				
				
				//Atualizar usuarios
				
				//Usuario u1 = new Usuario();
				//u1.setNome("Maria");
				//u1.setSobrenome("Melo");
				//u1.setLogin("maria124");
				//u1.setSenha("33melo");
				//u1.setEmail("mariamelo@gmail.com");
				//u1.setTelefone("00000000000");
				//u1.setId(2);
				
				//usuariosDAO.atualizar(u1);
				
				//Deletar Usuario pelo ID
				
				//usuariosDAO.deletarPorID(4);
				
				
				//listar os usuarios
				
				//for(Usuario u : usuariosDAO.getUsuarios()) {
					//System.out.println("Usuario: " + u.getNome());
				//}
		
		
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						TelaDeCadastro frame = new TelaDeCadastro();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	
	
}
