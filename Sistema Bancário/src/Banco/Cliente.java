package Banco;

import java.util.ArrayList;
import java.util.Objects;

//import model.Cliente;

public class Cliente {
	
	private String nome;
	private String cpf;
	public static ArrayList<Cliente> clientes = new ArrayList<>();
	private Conta conta;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String cpf) {

		this.nome = nome;
		this.cpf = cpf;
		
	}
	

	public Cliente(String numero) {
		this.cpf = numero;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	
	
	public static void listarClientes() {
		if(clientes.size() > 0) {
			for(Cliente c: clientes) {
				System.out.println(c);
			}
		}else {System.err.println("Não há clientes para listar!!");}
	}
	
	public String toString() {
		return "\nDados cliente:\n" +
				"\n - Nome do cliente  é: " + this.getNome() + 
				"\n - O CPF do cliente é: " + this.getCpf();
		}
	
	public static Cliente encontrarCpf(String numero) {
		Cliente temp = null;
		if(clientes.size() > 0) {
			for(Cliente c: clientes) {
				 if(c.getCpf().equals(numero)) {
	                    temp = c;
				 }
			}
		}
		return temp;
	}
	
	public void conta(Conta conta) {
		this.conta = conta;
	}
	
	
	public static void adicionarConta(String numero, Cliente cliente) {
		Cliente tempCliente = Cliente.encontrarCpf(numero);
		if(clientes.contains(tempCliente)) {
			int index = clientes.indexOf(tempCliente);
			System.out.println("Cliente existe"
					+ "" + index);
			clientes.add(index, cliente);
			
;
		}
		
	}

	
	
	public int hashCode() {
		return Objects.hash(conta, cpf);
	}




	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(conta, other.conta) && Objects.equals(cpf, other.cpf);
	}




	
	public static void removerCliente(Cliente cliente) {
		if(clientes.contains(cliente)) {
			Cliente.clientes.remove(cliente);
			System.out.println("Cliente removido");
		}else {
			System.out.println("Cliente não localizado!");
		}
		
	}
	
	
	
	
	
}
