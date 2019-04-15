package dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import dbConnection.MyConnection;
import entity.Usuario;



public class UsuarioDAOImpl implements UsuarioDAO{
	
	Connection myConnection = MyConnection.getConnection();

	@Override
	public int create(Usuario usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Usuario> findUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findUsuario(Usuario usuario) {
	
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = myConnection;
			ps = con.prepareStatement(
					"SELECT nombre, pass FROM `usuarios` WHERE nombre = ?");//***********
			ps.setString(1, usuario.getNombre());
			rs = ps.executeQuery();

			Usuario miUsuario;
			
			if (rs.next()) {
				
				
				
					if (rs.getString(2).equals(usuario.getPassword())) {
					
					    miUsuario = new Usuario();
					
						miUsuario.setNombre(rs.getString(1));
						miUsuario.setPassword(rs.getString(2));
					    
						return miUsuario;
						
					} else {
						
						return null;
						
					}
				
			}
			
		} catch (SQLException e) {		
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}										
		}
		
		return null;
	}
	
	public String stringAMD5(String password) {

		String hashtext = null;

		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(password.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			hashtext = bigInt.toString(16);
			// Now we need to zero pad it if you actually want the full 32
			// chars.
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hashtext;
	}

	@Override
	public int cambiarPassword(Usuario user, String pass) {

		Connection con = null;
		PreparedStatement ps = null;
		int r = 0;
		
		try {
			con = myConnection;
			ps = con.prepareStatement("UPDATE `usuarios` SET `pass`= ? WHERE `nombre`= ?");
			ps.setString(1, pass);
			ps.setString(2, user.getNombre());
		
			r = ps.executeUpdate();

		
		} catch (SQLException e) {		
			e.printStackTrace();
		} finally {
			try {
				
				ps.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}										
		}

		return r;
	}

}
