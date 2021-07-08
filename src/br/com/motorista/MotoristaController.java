package br.com.motorista;

import java.util.List;
import java.util.Scanner;

import br.com.veiculo.VeiculoController;

public class MotoristaController {

	private Scanner tec;
	private VeiculoController veiculoController;
	
	public void MotoristaController() {
		tec = new Scanner(System.in);
		veiculoController = new VeiculoController();
	}
	
	public int leOpcao() {
		System.out.println("> ");
		return tec.nextInt();
	}
	
	public Motorista CadastrarMotorista() {
		Motorista motorista = new Motorista();
		
		System.out.println("--- Cadastrar Motorista ---");
		
		System.out.println("Nome: ");
		motorista.setNome(tec.nextLine());
		
		System.out.println("Ano de Nascimento: ");
		motorista.setAnoDeNascimento(tec.nextInt());
		
		System.out.println("Categoria de Habilitação: ");
		motorista.setCategoriaHabilitacao(tec.next());
		
		return motorista;
	}
	
	public List<Motorista> listarMotorista(List<Motorista> motoristas) {
		
		if(motoristas.isEmpty()) {
			System.out.println("não há dados cadastrados");
			return null;
		}
		
		System.out.println("--- Motoristas Cadastrados ---");
		
		System.out.printf("| %2s | %4s | %4s | %6s | %15s |\n", "Id", "Nome", "Ano", "Idade", "CatHabilitação");
		
		for(int i = 0; i <motoristas.size(); i++) {
			System.out.printf("| %2d | %15s | %4s | %6d | %10s |\n",
					i + 1,
					motoristas.get(i).getNome(),
					motoristas.get(i).getAnoDeNascimento(),
					motoristas.get(i).getIdade(),
					motoristas.get(i).getCategoriaHabilitacao(),
					motoristas.get(i).getVeiculo().getModelo(),
					motoristas.get(i).getVeiculo().getAno(),
					motoristas.get(i).getVeiculo().getTipoCombustivel(),
					motoristas.get(i).getVeiculo().getPlaca(),
					motoristas.get(i).getVeiculo().getMarca());
		}
			
		return motoristas;
	}
	
	public List<Motorista> EditarMotorista(List<Motorista> motoristas) {
		Motorista motorista = new Motorista();
		
		listarMotorista(motoristas);
		
		if(motoristas.isEmpty()) {
			System.out.println("Não há dados cadastrados!!");
			return null;
		}
		
		System.out.println("Informe o Id do motorista a ser editado: ");
		int idMotorista = tec.nextInt() - 1;
		
		System.out.println("Menu\n");
		System.out.println("1) Nome");
		System.out.println("2) Ano de Nascimento");
		System.out.println("3) Categoria de Habilitação");
		int opcao = tec.nextInt();
		
		switch(opcao) {
		
		case 1:
			System.out.println("--- Editar Nome ---");
			System.out.println("Informe o novo nome: ");
			motorista.setNome(tec.nextLine());
			
			motorista.setAnoDeNascimento(motoristas.get(idMotorista).getAnoDeNascimento());
			motorista.setCategoriaHabilitacao(motoristas.get(idMotorista).getCategoriaHabilitacao());
			
			motoristas.set(idMotorista, motorista);
			
			break;
			
		case 2:
			System.out.println("--- Editar Ano de Nascimento ---");
			System.out.println("insira o novo ano");
			motorista.setAnoDeNascimento(tec.nextInt());
			
			motorista.setNome(motoristas.get(idMotorista).getNome());
			motorista.setCategoriaHabilitacao(motoristas.get(idMotorista).getCategoriaHabilitacao());
			
			motoristas.set(idMotorista, motorista);
			
			break;
			
		case 3:
			System.out.println("--- Editar Categoria de Habilitação ---");
			System.out.println("insira a nova categoria");
			motorista.setCategoriaHabilitacao(tec.next());
			
			motorista.setNome(motoristas.get(idMotorista).getNome());
			motorista.setAnoDeNascimento(motoristas.get(idMotorista).getAnoDeNascimento());
			
			motoristas.set(idMotorista, motorista);
			
			break;
			
		}
		
		return motoristas;
	}
	
	public void excluirMotorista(List<Motorista> motoristas) {
		
		listarMotorista(motoristas);
		
		if(motoristas.isEmpty()) {
			return;
		}
		
		System.out.println("--- Excluir Motorista ---");
		System.out.println("Insira o id do motorista a ser excluido: ");
		int idMotorista = tec.nextInt() - 1;
		
		if(motoristas.size() <= idMotorista) {
			System.out.println("Motorista não cadastrado!!");
			return;
		}
		
		motoristas.remove(idMotorista);
	}
	
	public void menu(List<Motorista> motoristas) {
		System.out.println("Menu\n");
		System.out.println("1) Cadastrar");
		System.out.println("2) Listar");
		System.out.println("3) Editar");
		System.out.println("4) Excluir");
		System.out.println("> ");
		int opcao = tec.nextInt();
		
		boolean sair = true;
		do {
			switch(opcao) {
			case 1:
				motoristas.add(CadastrarMotorista());
				break;
			
			case 2:
				listarMotorista(motoristas);
				break;
				
			case 3:
				EditarMotorista(motoristas);
				
			case 4:
				excluirMotorista(motoristas);
			
			default:
				System.out.println("Opção Inválida!!");
				break;
			}
		} while(!sair);
		
	}
	
}
