package Banco;
import java.util.Scanner;
public class Programa {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		
		operacoes();
		
	}
	
	public static void operacoes(){
		System.out.println("----------------------------------------------");
		System.out.println("-----------------Bem vindo--------------------");
		System.out.println("## Selecione a operação que deseja realizar ##");
		System.out.println("----------------------------------------------");
		System.out.println("| Opção 1 -    Criar cliente        |");
		System.out.println("| Opção 2 -   Listar clientes       |");
		System.out.println("| Opção 3 -  Consultar por CPF      |");
		System.out.println("| Opção 4 -   Remover cliente       |");
		System.out.println("| Opção 5 -     Criar conta         |");
		System.out.println("| Opção 6 -    Listar contas        |");
		System.out.println("| Opção 7 -   Associar conta        |");
		System.out.println("| Opção 8 -     Depositar           |");
		System.out.println("| Opção 9 -       Sacar             |");
		System.out.println("| Opção 10-   Remover conta         |");
		System.out.println("| Opção 11-  Consultar saldo        |");
		System.out.println("| Opção 12-       Sair              |");
		try{
			int opcoes = entrada.nextInt();
		
		switch(opcoes) {
			case 1:
				CriarCliente();
				operacoes();
				break;
				
			case 2:
				Cliente.listarClientes();
				operacoes();
				break;
				
			case 3:
				listarPorCpf();
				operacoes();
				break;
		
			case 4:
				removerCliente();
				operacoes();
				break;
				
			case 5:
				criarConta();
				operacoes();
				break;
				
			case 6:
				
				Conta.listar();
				operacoes();
				break;
				
			case 7:
				vincularContaAoCliente();
				operacoes();
				break;
				
			case 8:
				depositar();
				operacoes();
				break;
				
			case 9:
				sacar();
				operacoes();
				break;
				
				
			case 10:
				removerConta();
				operacoes();
				break;
				
			case 11:
				consultarSaldo();
				operacoes();
				break;
			
				
			case 12: 
				System.out.println("Thanks!!");
				System.exit(0);
				break;
		
			default:
				System.err.println("Opção inválida");
				operacoes();
		
				
			}
		} catch(Throwable Exception) {
			System.err.println("Você digitou algum caractere incorreto!!");
	}
		
		
		
}
	
	public static void depositar() {
		System.out.println("Digite o número da conta: ");
		int numeroConta = entrada.nextInt(); 
		Conta conta = Conta.localizarConta(numeroConta);
		if(conta != null) {
			if(conta.getStatus() == true) {
				System.out.println("Digite o valor do depósito: ");
				double valorDeposito = entrada.nextDouble();
				conta.depositar(valorDeposito);
				System.out.println("Depósito realizado com Sucesso!!");}
			else {System.err.println("Conta não está ativa!!");}
		}else {System.err.println("Conta não localizada!!");}
		
	}
	
	public static void sacar() {
		System.out.println("Digite o número da conta: ");
		int numeroConta = entrada.nextInt(); 
		Conta conta = Conta.localizarConta(numeroConta);
		if(conta != null) {
			if(conta.getStatus() == true) {
				System.out.println("Digite o valor do saque: ");
				double valorSaque = entrada.nextDouble();
				if(conta.getSaldo() >= valorSaque) {
					conta.sacar(valorSaque);
					System.out.println("Saque realizado com Sucesso!!");}
				else {System.err.println("O valor do saque é maior que o saldo da conta!!");}
			}else {System.err.println("Conta não está ativa!!");}
		}else {System.err.println("Conta não localizada!! ");}
	}
	
	public static void CriarCliente() {
		System.out.println("Digite seu nome: ");
		String nome = entrada.next();
		System.out.println("Digite seu CPF");
		String cpf = entrada.next();
		Cliente clienteComparar = Cliente.encontrarCpf(cpf);
		if(clienteComparar == null) {
			Cliente cliente = new Cliente(nome,cpf);
			Cliente.clientes.add(cliente);
			System.out.println("Cliente cadastrado com sucesso!!");
			}else {System.err.println("Cliente já cadastrado!!");}
	}
	
	public static void listarPorCpf() {
		System.out.println("Digite o CPF da conta que você deseja localizar");
		String cpfLocalizar = entrada.next();
		Cliente temp = Cliente.encontrarCpf(cpfLocalizar);
		
		if(temp != null) {
			System.out.println(temp);
			Conta.retornarContas(cpfLocalizar);
		}else {
			System.err.println("O Cpf não foi localizado!!");}
		}
	public static void removerCliente() {
		System.out.println("Digite o cpf do cliente: ");
		String localizar = entrada.next();
		Cliente temp = Cliente.encontrarCpf(localizar);
		if (temp != null) {
			Cliente.removerCliente(temp);
			Conta.removerMultiplasContas(temp);
		}else {System.err.println("Cliente não existe!!");}
	}
	
	public static void removerConta() {
		System.out.println("Digite o número da conta");
		int numeroConta = entrada.nextInt();
        Conta conta = Conta.localizarConta(numeroConta);
        if(conta != null) {
        	Conta.removerConta(conta);
        	System.out.println("Conta removida com sucesso!!");
        }else {System.err.println("Conta já removida ou inexistente");}
	}

		
	
	public static void criarConta() {
		
		Conta conta = new Conta();
		Conta.contas.add(conta);
		System.out.println("Conta criada com sucesso!!");
		

	}
	
	public static void vincularContaAoCliente() {
		System.out.println("Digite o numero do cpf");
		String entradaCpf = entrada.next();
		
		Cliente temp = Cliente.encontrarCpf(entradaCpf);
		System.out.println("Digite o número da conta: ");
		int numeroConta = entrada.nextInt();
		Conta conta = Conta.localizarConta(numeroConta);
		if(temp != null && conta != null) {
			Conta.modificarCpf(conta,temp.getCpf());
			System.out.println("Conta associada com sucesso!!");
			
			
		}else {System.err.println("Cliente ou conta não existe!!");}
	}
	
	public static void consultarSaldo() {
		System.out.println("Digite o número da conta que você deseja saber o saldo: ");
		int numeroConta = entrada.nextInt();
		Conta conta = Conta.localizarConta(numeroConta);
 		if(conta != null) {
 			Conta.consultarSaldo(conta);
 		}else {System.err.println("Conta não localizada!!");}
	}


}
