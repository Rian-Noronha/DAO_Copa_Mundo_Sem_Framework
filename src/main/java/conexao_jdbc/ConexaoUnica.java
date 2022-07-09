package conexao_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoUnica {
	
	private final static String BANCO = "jdbc:mysql://127.0.0.1:3306/dbFuncDepart?useTimezone=true&serverTimezone=UTC";
	private final static String USUARIO = "root";
	private final static String SENHA = "I&you123";
	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static Connection conexao = null;
	
	
	static {
		conectar();
	}
	
	public ConexaoUnica() {
		conectar();
	}
	
	private static void conectar() {
		try {
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(BANCO, USUARIO, SENHA);
			
			conexao.setAutoCommit(false);
			
			System.out.println("Tá massa:)");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection retornarConexao() {
		return conexao;
	}
	
	

}
