package crudPostgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;

//Aqui que ocorre a conexão com o BD

public class ConexãoPostgreSQL {
	//nome do usuario do postgresql
	private static final String USERNAME = "postgres";
	
	//senha do usuario do postgresql
	private static final String PASSWORD = "postgres";
	
	//caminho do banco de dados, porta e o nome do banco de dados
	private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/cadastro";
	 
	//metodo de conexao com o banco de dados
	public static Connection createConnectionToPostgreSQL() throws Exception {
		//faz com que a classe seja carregada pela JVM
		Class.forName("org.postgresql.Driver");
		
		//cria a conexao com o BD passando os dados que foram criados anteriormente
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	 public static void main(String[] args) throws Exception {
		
		 //recuperar uma conexao com o banco de dados, para garantir que não vai ter uma conexao alem do necessario por usuario
		 //um usuario so tem uma conexão ativa
		 
		 //recuperar a conexão
		 Connection con = createConnectionToPostgreSQL();
		 
		 //testar se a conexao é nula
		 if(con != null) {
			 System.out.println("Conexão obtida com sucesso!");
			 con.close();
		 }
	}

}
