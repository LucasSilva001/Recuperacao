package br.com.programa;

import java.util.ArrayList;
import java.util.List;

import br.com.motorista.Motorista;
import br.com.motorista.MotoristaController;
import br.com.veiculo.Veiculo;
import br.com.veiculo.VeiculoController;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		List<Motorista> motoristas = new ArrayList<Motorista>();
		
		VeiculoController veiculoController = new VeiculoController();
		MotoristaController motoristaController = new MotoristaController();
		
		boolean sair = false;
		
		do {
			menu();
			int opcao = veiculoController.leOpcao();
			
			switch (opcao) {
			
			case 1:
				veiculoController.menu(veiculos);
			
			case 2:
				motoristaController.menu(motoristas);
			
			case 0:
				sair = true;
				break;
			
			default:
				System.out.println("Opção Inválida");
				break;
			}
		}while(!sair);
		
		System.out.println("Sistema Finalizado!!");
	}
	
	public static void menu() {
		System.out.println("Menu\n");
		System.out.println("1) Veículo");
		System.out.println("2) Motorista");
		System.out.println("0) Sair do sistema");
		
		System.out.println("Escolha a opção desejada: ");
	}

}
