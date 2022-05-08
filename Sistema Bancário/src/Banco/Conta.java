package Banco;
import java.util.Random;
import java.util.Date;
import java.util.Objects;
import java.util.ArrayList;
public class Conta {
	
	private int numeroConta;
	private double saldo = 0.0;
	private boolean status;
	private Date dataAbertura;
	private Cliente cliente;
	private String cpfCliente;
	public static ArrayList<Conta> contas = new ArrayList<>();
	 public Conta(int numero) {
		 this.numeroConta = numero;
	 }
	 
	 public Conta() {
		 this.dataAbertura = new Date();
		 this.status = false;
		 Random random = new Random();
		 this.numeroConta = random.nextInt(100000);
	
	 }
	 

	 public String apresentarStatus() {
		 if(this.getStatus() == true) {
			 return "Conta Ativada";
		 } else {
			 return "Conta Desativada";
		 }
	 }
	 
	 public int getNumeroConta() {
		 return this.numeroConta;
	 }
	 
	 public double getSaldo() {
		 return this.saldo;
	 }
	 
	 private void setSaldo(double valor) {
		 this.saldo = valor;
	 }
	
	 public boolean getStatus() {
		 return this.status;
	 
	 }
	 

	 public String getCpfCliente() {
		 return cpfCliente;
	 }
	 public void setCpfCliente(String numero) {
		 cpfCliente = numero;
	 }

	 
	 public String toString() {
		 return 
				"\n - Dados da conta: \n" +
				"\n - O número da conta: " + this.getNumeroConta() +
				"\n - O saldo da conta: " + this.getSaldo() +
				"\n - O Status da conta: " + this.apresentarStatus() +
				"\n - A data de abertura: " + this.dataAbertura +
				"\n - CPF do cliente associado à conta: " + cpfCliente +
				"\n";
	 }

	 public static void retornarContas(String numero) {
		 Cliente cliente = Cliente.encontrarCpf(numero);
		 
		 if(cliente != null ) {
			 for(Conta c: contas) {
				 if(c.getCpfCliente() != null && c.getCpfCliente().equals(numero)) { 
	                  System.out.println(c);
				 }
			 }
		 }
		
	 }
	 
	 public static void listar() {
		 if(contas.size() > 0) {
			 for(Conta c: contas) {
				 System.out.println(c);
			 }
		 }else {System.err.println("Não há contas para listar!!");}
	 }
				 
	
	 public static void modificarCpf(Conta conta, String numero) {
		 conta.cpfCliente = numero;
		 conta.status = true;
	 }
			 
		 
	 
	 public static Conta localizarConta(int numero) {
		 Conta temp = null;
			if(contas.size() > 0) {
				for( Conta c: contas) {
					 if(c.getNumeroConta() == numero) {
		                    temp = c;
		                  
					 }
				}
			}
			return temp;
		 
	 }
	 
	 
	

	public void depositar(double valor) {
		 if(this.getStatus() == true && valor > 0.0 && this.status == true) {
			 this.setSaldo(this.getSaldo() + valor);
		 }
	 }
	 
	 public void sacar(double valor) {
		 if(this.getStatus() == true && this.getSaldo() > 0.0 && valor > 0.0 && this.status == true)  {
			 this.setSaldo(this.getSaldo() - valor);
			 if(this.getSaldo() < 0.0) {
				 this.setSaldo(0.0);
			 }
		 }else {
			 System.err.println("Saque não realizado!");
		 }
	 }
	 
	
	public int hashCode() {
		return Objects.hash(cliente, cpfCliente, numeroConta, status);
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(cpfCliente, other.cpfCliente)
				&& numeroConta == other.numeroConta && status == other.status;
	}

	public static void removerConta(Conta conta) {
			if(contas.contains(conta)) {
				Conta.contas.remove(conta);
				
			}
			
		}
	 
	 public static void removerMultiplasContas(Cliente cliente) {
		contas.removeIf(Conta -> Conta.getCpfCliente() == cliente.getCpf() );
	 }
	 
	 public static void consultarSaldo(Conta conta) {
		 if(conta.status == true) {
			 System.out.println("- O saldo da conta de número [" + conta.numeroConta + "] é : " + conta.saldo + " R$");
		 }else {System.err.println("A conta não está ativa. Saldo indisponível!!");}
	 }
	

}
