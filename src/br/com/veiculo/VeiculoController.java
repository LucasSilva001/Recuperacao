package br.com.veiculo;

import java.util.List;
import java.util.Scanner;

public class VeiculoController {
		
		private Scanner tec;
		
		public void VeiculoController() {
			tec = new Scanner(System.in);
			
		}
		public int leOpcao() {
			System.out.println("> ");
			return tec.nextInt();
		}
		
		public Veiculo cadastrarVeiculo() {
			Veiculo veiculo = new Veiculo();
			
			System.out.println(" --- Cadastrar Veiculo ---");
			
			System.out.println("Informe o modelo: ");
			veiculo.setModelo(tec.next());
			
			System.out.println("Informe o ano do veiculo: ");
			veiculo.setAno(tec.nextInt());
			
			System.out.println("Informe o tipo de combustível: ");
			veiculo.setTipoCombustivel(tec.next());
			
			System.out.println("Informe a placa: ");
			veiculo.setPlaca(tec.next());
			
			System.out.println("Informe a marca: ");
			veiculo.setMarca(tec.next());
			
			return veiculo;
		}
		
		public List<Veiculo> listarVeiculo(List<Veiculo> veiculos) {
			
			if(veiculos.isEmpty()) {
				System.out.println("Não há dados cadastrados!!");
				return null;
			}
			
		    System.out.println(" --- Veiculos Cadastrados ---");
		    
		    System.out.printf("| %2s | %10s | %6s | %12s | %8s |\n", "Id", "Modelo", "Ano", "Combústivel", "Placa" );
		    
		    for(int i = 0; i < veiculos.size(); i ++) {
		    	System.out.printf("| %2d | %10s | %4d | %12s | %8s |\n",
		    			i + 1,
		    			veiculos.get(i).getModelo(),
		    			veiculos.get(i).getAno(),
		    			veiculos.get(i).getTipoCombustivel(),
		    			veiculos.get(i).getPlaca(),
		    			veiculos.get(i).getMarca());
		    }
		    
			return veiculos;
		}
		
		public List<Veiculo> editarVeiculo(List<Veiculo> veiculos) {
			
			Veiculo veiculo = new Veiculo();
			
			listarVeiculo(veiculos);
			
			if(veiculos.isEmpty()) {
				System.out.println("Não há dados cadastrados!!");
				return null;			
			}
			
			System.out.println("Escolha o Id do veiculo a ser editado: ");
			int idVeiculo = tec.nextInt() - 1;
			
			System.out.println("Menu");
			System.out.println("1) Modelo");
			System.out.println("2) Ano");
			System.out.println("3) Combústivel");
			System.out.println("4) Placa");
			System.out.println("5) Marca");
			System.out.println("> ");
			int opcao = tec.nextInt();
			
			switch(opcao) {
			case 1:
				
				System.out.println("Editar Modelo");
				System.out.println("Insira o novo modelo do veiculo: ");
				veiculo.setModelo(tec.next());
				
				veiculo.setAno(veiculos.get(idVeiculo).getAno());
				veiculo.setTipoCombustivel(veiculos.get(idVeiculo).getTipoCombustivel());
				veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
				veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
			
				veiculos.set(idVeiculo, veiculo);
				
				break;
				
			case 2:
				System.out.println("Editar Ano do veiculo");
				System.out.println("insira o novo Ano do veiculo");
				veiculo.setAno(tec.nextInt());
				
				veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
				veiculo.setTipoCombustivel(veiculos.get(idVeiculo).getTipoCombustivel());
				veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
				veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
			
				veiculos.set(idVeiculo, veiculo);
				
				break;
				
			case 3:
				System.out.println("Editar o tipo de combustível do veiculo");
				System.out.println("Insira o novo combustível: ");
				veiculo.setTipoCombustivel(tec.next());
				
				veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
				veiculo.setAno(veiculos.get(idVeiculo).getAno());
				veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
				veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
				
				veiculos.set(idVeiculo, veiculo);
				
				break;
				
			case 4:
				System.out.println("Editar a placa do veiculo");
				System.out.println("Insira a nova placa: ");
				veiculo.setPlaca(tec.next());
				
				veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
				veiculo.setAno(veiculos.get(idVeiculo).getAno());
				veiculo.setTipoCombustivel(veiculos.get(idVeiculo).getTipoCombustivel());
				veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
			
				veiculos.set(idVeiculo, veiculo);
				
				break;
				
			case 5:
				System.out.println("Editar a marca do veiculo");
				System.out.println("insira a nova marca do veiculo: ");
				veiculo.setMarca(tec.next());
				
				veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
				veiculo.setAno(veiculos.get(idVeiculo).getAno());
				veiculo.setTipoCombustivel(veiculos.get(idVeiculo).getTipoCombustivel());
				veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
				
				veiculos.set(idVeiculo, veiculo);
				
				break;
				
			default:
				System.out.println("Opção inválida!!");
				break;
			}
			
			return veiculos;
		}
		
		public void excluirVeiculo(List<Veiculo> veiculos) {
			
			listarVeiculo(veiculos);
			
			if(veiculos.isEmpty()) {
				return;
			}
			
			System.out.println("Excluir Veiculo");
			System.out.println("Insira o Id do veículo a ser excluído: ");
			int idVeiculo = tec.nextInt() - 1;
			
			if(veiculos.size() <= idVeiculo) {
				System.out.println("Veiculo não cadastrado!!");
				return;
			}
			
			veiculos.remove(idVeiculo);
		}
		
		public void menu(List<Veiculo> veiculos) {
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
					veiculos.add(cadastrarVeiculo());
					break;
				
				case 2:
					listarVeiculo(veiculos);
					break;
					
				case 3:
					editarVeiculo(veiculos);
					break;
					
				case 4:
					excluirVeiculo(veiculos);
					break;
				
				default:
					System.out.println("Opção Inválida!!");
					break;
				}
			}while(!sair);
			
		}

	}


