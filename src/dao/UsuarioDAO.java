package dao;

import java.util.List;

import entity.Usuario;


public interface UsuarioDAO {

	int create(Usuario usuario);

	List<Usuario> findUsuarios();

	Usuario findUsuario(Usuario usuario);
	
	public String stringAMD5(String password);
	
	public int cambiarPassword(Usuario user, String pass);
	
}
