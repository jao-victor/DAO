package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


import entidades.Operador;

public class DaoOperador {

	public int cadastrar(Operador operador) throws SQLException {
			
			Connection conexao = GenerateConnection.getConexao();
			
			String sql = "insert into operador (nome, cpf, salario) values (?, ?, ?)";
			
			PreparedStatement ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		
			ps.setString(1, operador.getNome());
			ps.setString(2, operador.getCpf());
			ps.setFloat(3, operador.getSalario());		
			ps.executeUpdate();
			

			ResultSet result = ps.getGeneratedKeys();

			int idGerado = 0;
			if(result.next()) {
				idGerado = result.getInt(1);
			}
			
            // RETORNA O ID DO OPERADOR PARA USAR NO CRUD DE UMA OPERACAO
            return idGerado;
			
		}
	
	public List<Operador> listar() throws SQLException {
		
		Connection conexao = GenerateConnection.getConexao();
		
		String sql = "select * from operador";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet resultSet = ps.executeQuery();
		List<Operador> operadores = new ArrayList<Operador>();
		
		while(resultSet.next()) {
			
			int id = resultSet.getInt("id");
			String cpf = resultSet.getString("cpf");
			String nome = resultSet.getString("nome");
			float salario = resultSet.getFloat("salario");
			
			Operador operador = new Operador(id, cpf, nome, salario);
			
			operadores.add(operador);
		}
		
		return operadores;
		
	}
	
	public boolean atualizar(Operador operador) throws SQLException {
		
		Connection conexao = GenerateConnection.getConexao();
		
		String sql = "update operador set cpf = ?, nome = ?, salario = ? where id = ?";
		
		PreparedStatement ps = conexao.prepareStatement(sql);
		
		ps.setString(1, operador.getCpf());
		ps.setString(2, operador.getNome());
		ps.setFloat(3, operador.getSalario());
		ps.setInt(4, operador.getId());
		
		if(ps.executeUpdate()==1)
			return true;
		
		
		return false;
		
	}
		
	
	public int delete(int id) throws SQLException {
		
		Connection conexao = GenerateConnection.getConexao();
		String sql = "delete from operador where id = ?";
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
