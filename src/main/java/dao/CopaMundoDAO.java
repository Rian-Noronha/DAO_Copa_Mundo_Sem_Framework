package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao_jdbc.ConexaoUnica;
import model.CopaMundo;
import model.Jogador;
import model.Partida;
import model.Selecao;

public class CopaMundoDAO {

	private Connection conexao;

	public CopaMundoDAO() {
		this.conexao = ConexaoUnica.retornarConexao();
	}

	public void inserirCopaMundo(CopaMundo copaMundo) {
		try {
			String sql = "insert into tbl_CopaMundo (nome, dataInicio, dataFim, lugar)\n" + "	value(?, ?, ?, ?)";

			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, copaMundo.getNome());
			ps.setString(2, copaMundo.getDataInicio());
			ps.setString(3, copaMundo.getDataFim());
			ps.setString(4, copaMundo.getLugar());

			ps.execute();
			conexao.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public CopaMundo retornarCopaMundo(int idCopaMundo) throws SQLException {
		
		CopaMundo copaMundo = new CopaMundo();
		String sql = "select * from tbl_CopaMundo where id = " + idCopaMundo;
		
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet resultado = ps.executeQuery();
		
		
		resultado.next();
		
		copaMundo.setNome(resultado.getString("nome"));
		copaMundo.setDataFim(resultado.getString("dataFim"));
		copaMundo.setDataInicio(resultado.getString("dataInicio"));
		copaMundo.setLugar(resultado.getString("lugar"));
		copaMundo.setId(resultado.getInt("id"));
		
		return copaMundo;
		
	}
	
	public void atualizarCopaMundo(CopaMundo copaMundo) {
		try {
			String sql = "update tbl_CopaMundo set nome = ? where id = " + copaMundo.getId();
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, copaMundo.getNome());
			ps.execute();
			conexao.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			
			try {
				conexao.rollback();
			} catch (Exception r) {
				
			}
			
		}
	}
	
	public void deletarCopaMundo(int id) {
		try {
			String sql = "delete from tbl_CopaMundo where id = " + id;
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.execute();
			conexao.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			
			try {
				conexao.rollback();
			} catch (Exception e2) {
			
			}
		}
	}

	public void inserirSelecao(Selecao selecao) {
		try {
			String sql = "insert into tbl_Selecao(nome, descricao, idCopa) value(?,?,?)";
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, selecao.getNome());
			ps.setString(2, selecao.getDescricao());
			ps.setInt(3, selecao.getIdCopa());

			ps.execute();
			conexao.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Selecao> listarSelecao() throws SQLException {
		List<Selecao> selecoes = new ArrayList<Selecao>();

		String sql = "select * from tbl_Selecao";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet resultado = ps.executeQuery();

		while (resultado.next()) {
			Selecao selecao = new Selecao();

			selecao.setNome(resultado.getString("nome"));
			selecao.setDescricao(resultado.getString("descricao"));
			selecao.setIdCopa(resultado.getInt("idCopa"));
			selecao.setId(resultado.getInt("id"));

			selecoes.add(selecao);

		}

		return selecoes;

	}
	
	public void atualizarSelecao(Selecao selecao) {
		try {
			String sql = "update tbl_Selecao set nome = ? where id = " + selecao.getId();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, selecao.getNome());
			
			ps.execute();
			conexao.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			
			try {
				conexao.rollback();
			} catch (SQLException r) {
				
				r.printStackTrace();
			}
		}
	}
	
	public void deletarSelecao(int id) {
		try {
			String sql = "delete from tbl_Selecao where id = " + id;
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.execute();
			conexao.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				conexao.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public void inserirJogador(Jogador jogador) {
		try {
			String sql = "insert into tbl_Jogador(nome, descricao, idSelecao) value(?,?,?)";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, jogador.getNome());
			ps.setString(2, jogador.getDescricao());
			ps.setInt(3, jogador.getIdSelecao());
			
			ps.execute();
			conexao.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Jogador> listarJogador()throws SQLException{
		List<Jogador> jogadores = new ArrayList<Jogador>();
		
		
		String sql = "select * from tbl_Jogador";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rt = ps.executeQuery();
		
		
		while(rt.next()) {
			Jogador jogador = new Jogador();
			jogador.setNome(rt.getString("nome"));
			jogador.setDescricao(rt.getString("descricao"));
			jogador.setIdSelecao(rt.getInt("idSelecao"));
			jogador.setId(rt.getInt("id"));
			
			jogadores.add(jogador);
		}
		
		return jogadores;
		
	}
	
	public void atualizarJogador(Jogador jogador) {
		try {
			String sql = "update tbl_Jogador set nome = ? where id = " + jogador.getId();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, jogador.getNome());
			
			ps.execute();
			conexao.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			
			try {
				conexao.rollback();
			} catch (SQLException r) {
				
				r.printStackTrace();
			}
		}
	}
	
	public void deletarJogador(int id) {
		try {
			String sql = "delete from tbl_Jogador where id = " + id;
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
			conexao.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				conexao.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	public void inserirPartida(Partida partida) {
		try {
			String sql = "insert into tbl_Partida(fase, descricao, dataPartida, localPartida, horario, idSelecaoUm, idSelecaoDois)"
					+ "value(?,?,?,?,?,?,?)";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, partida.getFase());
			ps.setString(2, partida.getDescricao());
			ps.setString(3, partida.getData());
			ps.setString(4, partida.getLocal());
			ps.setString(5, partida.getHorario());
			ps.setInt(6, partida.getIdSelecaoUm());
			ps.setInt(7, partida.getIdSelecaoDois());
			
			ps.execute();
			conexao.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Partida> listarPartida()throws SQLException{
		List<Partida> partidas = new ArrayList<Partida>();
		
		String sql = "select * from tbl_Partida";
		
		
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Partida partida = new Partida();
			
			partida.setDescricao(rs.getString("descricao"));
			partida.setData(rs.getString("dataPartida"));
			partida.setFase(rs.getString("fase"));
			partida.setHorario(rs.getString("horario"));
			partida.setLocal(rs.getString("localPartida"));
			partida.setIdSelecaoUm(rs.getInt("idSelecaoUm"));
			partida.setIdSelecaoDois(rs.getInt("idSelecaoDois"));
			partida.setId(rs.getInt("id"));
			
			partidas.add(partida);
			
		}
		
		return partidas;
		
		
	}
	
	public void atualizarPartida(Partida partida) {
		try {
			String sql = "update tbl_Partida set descricao = ? where id = " + partida.getId();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, partida.getDescricao());
			
			ps.execute();
			conexao.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			
			try {
				conexao.rollback();
			} catch (SQLException r) {
				
				r.printStackTrace();
			}
		}
	}
	
	public void deletarPartida(int id) {
		try {
			String sql = "delete from tbl_Partida where id = " + id;
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.execute();
			
			conexao.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				conexao.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}
	
	

}
