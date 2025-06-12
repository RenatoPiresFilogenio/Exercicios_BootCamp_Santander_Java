package src;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		conta conta = new conta(500);
		int option = 0;
		do {
			
			System.out.println("Saldo inicial: " + conta.getSaldo());
			System.out.println("Limite inicial do cheque Especial: " + conta.getLimite());
		
			 	System.out.println("\n=== MENU ===");
	            System.out.println("1 - Consultar saldo");
	            System.out.println("2 - Consultar cheque especial");
	            System.out.println("3 - Depositar dinheiro");
	            System.out.println("4 - Sacar dinheiro");
	            System.out.println("5 - Pagar boleto");
	            System.out.println("6 - Verificar se está usando cheque especial");
	            System.out.println("7 - Sair");
	            System.out.print("Escolha uma opção: ");
	            option = scanner.nextInt();
		
	            switch (option) {
	                case 1:
	                    conta.getSaldo();
	                    break;
	                case 2:
	                	conta.getLimite();
	                	 break;
	                case 3:
	                	System.out.println("Qual valor do deposito?");
	                	double deposito = scanner.nextDouble();
	                	conta.depositarDinheiro(deposito);
	                	 break;
	                case 4:
	                	System.out.println("Qual valor do saque?");
	                	double saque = scanner.nextDouble();
	                	conta.sacarDinheiro(saque);
	                	 break;	 

	                case 5:
	                	System.out.println("Qual valor do boleto?");
	                	double pagamento = scanner.nextDouble();
	                	conta.pagarBoleto(pagamento);
	                	 break;  
	                	 
	               case 6:
	                	conta.consultarCheque();
	                	 break; 
	               case 7:
	            	   System.exit(0);
	                	 break; 
	               default:
	                    System.out.println("Opção inválida.");
	            }
	
		}while(option != 7);
		
		
		scanner.close();
	}
}
