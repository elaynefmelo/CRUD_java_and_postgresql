package crudPostgreSQL;

import java.sql.ResultSet;
import java.util.ArrayList;


public interface IUsuarioDAO {
	
	public void salvar(Usuario usuario);
	
	public void atualizar(Usuario usuario);
	
	public void deletarPorID(int id);
	
	public ArrayList<Usuario> listarUsuario();
	

}
