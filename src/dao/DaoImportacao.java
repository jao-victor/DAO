package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidades.Importacao;


public class DaoImportacao {
	
	public void cadastrar(Importacao importacao) throws SQLException {
				
		Connection conexao = GenerateConnection.getConexao();
		
		String sql = "insert into importacoes (pesagem, origem, minerio, operador_id) values (?, ? , ? , ?)";
		
		PreparedStatement ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

		ps.setFloat(1, importacao.getPesagem() );
		ps.setString(2, importacao.getOrigem());
		ps.setString(3, importacao.getMinerio());
		ps.setInt(4, importacao.getOperador().getId());
	
		ps.executeUpdate();
		
	}
	
	public List<Importacao> listar() throws SQLException {
		
		Connection conexao = GenerateConnection.getConexao();
		
		String sql = "select * from importacoes";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet resultSet = ps.executeQuery();
		List<Importacao> importacoes = new ArrayList<Importacao>();
		
		while(resultSet.next()) {
			
			int id = resultSet.getInt("id");
			float pesagem = resultSet.getFloat("pesagem");
			String origem = resultSet.getString("origem");
			String minerio = resultSet.getString("minerio");

			Importacao importacao = new Importacao(id, pesagem, origem, minerio);
			
			importacoes.add(importacao);
			
		}
		
		return importacoes;
		
	}
	
	public boolean atualizar(Importacao importacao) throws SQLException {
		
		Connection conexao = GenerateConnection.getConexao();

		String sql = "update importacoes set pesagem = ?, origem = ?, minerio = ? where id = ?";

		PreparedStatement ps = conexao.prepareStatement(sql);
		
		ps.setFloat(1, importacao.getPesagem());
		ps.setString(2, importacao.getOrigem());
		ps.setString(3, importacao.getMinerio());
		ps.setInt(4, importacao.getId());

		if(ps.executeUpdate()==1)
			return true;
		
		return false;
		
		
	}
	
	public int delete(int id) throws SQLException {
		
		Connection conexao = GenerateConnection.getConexao();
		String sql = "delete from importacoes where id = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setInt(1, id);
		
		
		int excluidos = 0;
		try {
			excluidos  = ps.executeUpdate();
		}catch(SQLException e) {
			return -1;
		}
		
		if(excluidos==1)
			return 1;
		
		return 0;
		
	}
	
	

}
