package entidades;

import java.sql.SQLException;


import dao.DaoImportacao;


public class Operador extends Funcionario{

	
	public Operador() {
		
	}
	
	public Operador(int id, String cpf, String nome, float salario) {
	
		super.setId(id);
		super.setCpf(cpf);
		super.setNome(nome);
		super.setSalario(salario);

	}
	
	public void gerarImportacao(Importacao importacao) throws SQLException {
		
		DaoImportacao dimport = new DaoImportacao();

		dimport.cadastrar(importacao);
		

	}	
	
}
