package crudPostgreSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class UsuariosDAO implements IUsuarioDAO {
	
	//Faz com que o Java se molde a uma estrutura relacional que é o banco de dados
	
	//CRUD
	
	//criar metodos do crud 
	 
	public void salvar(Usuario usuario) {
		
		//médoto cadastrar usuario
		
		//Query
		String sql = "INSERT INTO cadastro_usuario(nome, sobrenome, login, senha, email, telefone) VALUES (?, ?, ?, ?, ?, ?)";
		
		//acionar a conexão
		Connection conn = null;
		//Prepara uma estrutura para poder executar a estrutura de java com o BD
		PreparedStatement pst = null;
		
		try {
			//criar uuma conexao com o BD
			conn = ConexãoPostgreSQL.createConnectionToPostgreSQL();
			
			//criar uma PreparedStatement para executar a Query
			pst = conn.prepareStatement(sql);
			//Adiconar os valores que são esperados pela query
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getSobrenome());
			pst.setString(3, usuario.getLogin());
			pst.setString(4, usuario.getSenha());
			pst.setString(5, usuario.getEmail());
			pst.setString(6, usuario.getTelefone());
			
			//executar a query
			pst.execute();
			
			//System.out.println("Usuario cadastrado com sucesso!");
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//fechar as conexoes
			try {
				if(pst  != null) {
					pst.close();
				}
				if(conn != null) {
					conn.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

	
	public void atualizar(Usuario usuario) {
		
		String sql = "UPDATE cadastro_usuario SET nome = ?, sobrenome = ?, login = ?, senha = ?, email = ?, telefone = ? " + 
			    "WHERE id = ? ";
		
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			
			//criar uam conexao com o BD
			conn = ConexãoPostgreSQL.createConnectionToPostgreSQL();
			
			//adicionar os valores para atualizar
			pst = conn.prepareStatement(sql);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getSobrenome());
			pst.setString(3, usuario.getLogin());
			pst.setString(4, usuario.getSenha());
			pst.setString(5, usuario.getEmail());
			pst.setString(6, usuario.getTelefone());
			
			//Qual o ID do registro que deseja atualizar
			pst.setInt(7, usuario.getId());
			
			//executar a query
			pst.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pst != null) {
					pst.close();
				}
				if(conn != null) {
					conn.close();
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}

	@Override
	//deletar por id por ser um atributo unico
	public void deletarPorID(int id) {
		
		String sql = "DELETE FROM cadastro_usuario WHERE id = ?";
		
		Connection conn = null;
		
		PreparedStatement pst = null;
		
		try {
			conn = ConexãoPostgreSQL.createConnectionToPostgreSQL();
			
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, id);
			
			pst.execute();
			
			//System.out.println("Usuário Deletado com sucesso!");	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pst != null) {
					pst.close();
				}
				if(conn != null) {
					conn.close();
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}


	@Override
	//metodo listar usuario
	public ArrayList<Usuario> listarUsuario() {
		
		String sql = "SELECT * FROM cadastro_usuario";
		
		Connection conn = null;
		
		PreparedStatement pst = null;
		//percorre a tabela iniciando na primeira linha
		ResultSet rst = null;
		
		//Pegar as informacoes do BD e montar uma lista
		
		ArrayList<Usuario> lista = new ArrayList<>();
		
		
		try {
			//criar uuma conexao com o BD
			conn = ConexãoPostgreSQL.createConnectionToPostgreSQL();
			//prepara a query
			pst = conn.prepareStatement(sql);
			//percorre as informações da tabela
			rst = pst.executeQuery();
			
			//Como vai ter mais de uma informação, então é necessario um while pra percorrer essa tabela enquanto houver dados
			while(rst.next()){
				Usuario objUsuario = new Usuario();
				//As informações vem do resultset
				objUsuario.setId(rst.getInt("id"));
				objUsuario.setNome(rst.getString("nome"));
				objUsuario.setSobrenome(rst.getString("sobrenome"));
				objUsuario.setLogin(rst.getString("login"));
				objUsuario.setSenha(rst.getString("senha"));
				objUsuario.setEmail(rst.getString("email"));
				objUsuario.setTelefone(rst.getString("telefone"));
				
				//monda uma linda com base no que for obtido no objUsuario
				lista.add(objUsuario);
			};
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		//retorna uma lista de cadastros
		return lista;
	}


	
}

		

