package src;
import java.util.Scanner;
public class Contador {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int parametro1 = scanner.nextInt();
		int parametro2 = scanner.nextInt();
		
		try {
			contar(parametro1,parametro2);
		}catch(ParametrosInvalidosExeception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void contar(int p1,int p2) throws ParametrosInvalidosExeception  {
		if(p1 > p2 ) {
			throw new ParametrosInvalidosExeception("O segundo parametro deve ser maior que o primeiro");
		}
		
		for(int i=1; p1 < p2; i++ ,p1++) {
			System.out.println("Imprimindo o numero "+ i);
		}
	}

}
