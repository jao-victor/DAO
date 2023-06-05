package main;


import java.util.List;
import java.util.Scanner;
import dao.DaoImportacao;
import dao.DaoOperador;
import java.sql.SQLException;
import entidades.Importacao;
import entidades.Operador;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Scanner imp = new Scanner(System.in);
		Operador operador = new Operador();
		DaoOperador doperador = new DaoOperador();
		Importacao importacao = new Importacao();
		DaoImportacao dimportacao = new DaoImportacao();
		
		
        int opcao;
        int opcao2;
        
		do {
			System.out.println("----- Menu de Operadores -----");
            System.out.println("1. Criar Operador");
            System.out.println("2. Listar Operadores");
            System.out.println("3. Atualizar Operador");
            System.out.println("4. Excluir Operador");
            System.out.println("----- Menu de Importações -----");
            System.out.println("5. Listar Importação");
            System.out.println("6. Atualizar Importação");
            System.out.println("7. Excluir Importação");
            System.out.println("0. Sair");
            System.out.println();

            opcao = imp.nextInt();

            switch (opcao) {
                case 1:
                	System.out.println("---Criando Operador----\n");
            		System.out.println("Nome: ");
            		operador.setNome(imp.next());
            		System.out.println("CPF: ");
            		operador.setCpf(imp.next());
            		System.out.println("Salario");
            		operador.setSalario(imp.nextFloat());
            		
            		//o ID do operador é retornado caso ele seja criado com sucesso
                	operador.setId(doperador.cadastrar(operador));

                	
                	
                	System.out.println("---Criando Importacao----\n");
            		System.out.println("1. Criar importação: ");
                    System.out.println("Digite qualquer número para Sair");
                    System.out.print("Escolha uma opção: ");
                    System.out.print("");
                    opcao2 = imp.nextInt();
                    
                    
                    while(opcao2 == 1) {
                    	System.out.println("Pesagem: \n");
                		importacao.setPesagem(imp.nextFloat());
                		System.out.println("Origem: \n");
                		importacao.setOrigem(imp.next());
                		System.out.println("Minerio: \n");
                		importacao.setMinerio(imp.next());
                		importacao.setOperador(operador);
                		operador.gerarImportacao(importacao);
                		
                        System.out.print("Escolha uma opção(1-continuar/0..-Sair): ");
                        opcao2 = imp.nextInt();
                    }
                    
                    break;
                    
                case 2:
                	System.out.println();
                	System.out.println("-------Lista de Operadores-------");
                	List<Operador> operadores = doperador.listar();
                	
                	for(int i=0; i < operadores.size(); i++) {
                		Operador oper = operadores.get(i);                	
        				System.out.println("ID:"+ oper.getId() + "   CPF:"+oper.getCpf()+"   Nome:"+ oper.getNome()+"   Salario:"+oper.getSalario());
                	}
                	break;

                case 3:
                	System.out.println("");
                	System.out.println("Digite o ID do Operador e em seguida preencha o formulário com as novas senhas: ");
                	int idO = imp.nextInt();
                	System.out.println("Nome: \n");
            		String nome = imp.next();
            		System.out.println("CPF: \n");
            		String cpf = imp.next();
            		System.out.println("salario: \n");
            		float salario = imp.nextFloat();
            		
            		Operador operadorUp = new Operador(idO, nome, cpf, salario);
            		boolean updateOp = doperador.atualizar(operadorUp);
            		
            		if(updateOp) {
            			System.out.println("Atualização realizada com sucesso...");
            		}
            		
  
            		break;
                case 4:
                	System.out.println("");
                	System.out.println("Digite o ID do Operador que deseja excluir: ");
                	int idDo = imp.nextInt();
                	int deleteO = doperador.delete(idDo);
                	System.out.println(deleteO);
                	if(deleteO == 1) {
                		System.out.println("Operador com ID "+idDo+" deletado...");
                	}
                	break;
                	
                case 5:
                	System.out.println();
                	System.out.println("-------Lista de Importacoes-------");
                	
            		List<Importacao> importacoes = dimportacao.listar() ;
                	
                	for(int i=0; i < importacoes.size(); i++) {
                		
                		Importacao impor = importacoes.get(i);                	
        				System.out.println("ID:"+ impor.getId() + "   " +"Pesagem:"+ impor.getPesagem() +"   "+"Origem: "+ impor.getOrigem()+"Minerio:"+ impor.getMinerio());
        			}
                	
                	System.out.println();
                	break;
                	
                case 6:
                	System.out.println("");
                	System.out.println("Digite o ID da importação e em seguida preencha o formulário com as novas senhas: ");
                	int id = imp.nextInt();
                	System.out.println("Pesagem: \n");
            		float pesagem = imp.nextFloat();
            		System.out.println("Origem: \n");
            		String origem = imp.next();
            		System.out.println("Minerio: \n");
            		String minerio = imp.next();

            		Importacao importacaoUp = new Importacao(id, pesagem, origem, minerio);
            		
            		boolean update = dimportacao.atualizar(importacaoUp);
            		
            		if(update) {
            			System.out.println("Atualização realizada com sucesso...");
            		}
            		break;
            		
                case 7:
                	System.out.println("");
                	System.out.println("Digite o ID da importação que deseja excluir: ");
                	int idD = imp.nextInt();
                	int delete = dimportacao.delete(idD);
                	System.out.println(delete);
                	if(delete == 1) {
                		System.out.println("Importacao com ID "+idD+" deletado...");
                	}
                	
                	break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
            System.out.println();
        } while (opcao != 0);
         
	}

}
