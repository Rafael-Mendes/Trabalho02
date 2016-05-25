

import java.util.Locale;
import java.util.Scanner;

public class Trabalho2 {


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));

		

		int N,i,vetTipo[],contador=0;
		String vetNomes[],vetNumero[];
		double vetTempo[],vetValor[],mat[][],valorTotal=0;
		
		
		
		System.out.print("Quantas Pessoas deseja digitar: ");
		N = sc.nextInt();
		
		vetNomes = new String [N];
		vetNumero = new String [N];
		vetTempo = new double [N];
		vetTipo = new int[N];
		vetValor = new double[N];
		mat = new double [3][2];
		System.out.println();
		System.out.println("       Digite os Dados dos Clientes: ");
		System.out.println("  Nomes		Telefone	Tipo	Minutos");
		for(i=0;i<N;i++){
			System.out.print(+(i+1)+"º ");
			vetNomes[i] = sc.next();
			vetNumero[i] = sc.next();
			vetTipo[i]= sc.nextInt();
			vetTempo[i] = sc.nextDouble();
		}
		System.out.println("   Digite os valores do plano: ");
		System.out.println("       Basico | Excedente  ");
		for(i=0;i<3;i++){
			System.out.print("Plano "+i+" ");
			for(int j=0;j<2;j++){
				mat[i][j]= sc.nextDouble();
			}
			
		}
		double vetmaior90[];
		vetmaior90 = new double [N];
		for(i=0;i<N;i++){
			if(vetTipo[i]==0 && vetTempo[i]<= 90){
				vetValor[i]=mat[0][0];
			   }
			if(vetTipo[i]==0 && vetTempo[i]> 90){
				vetmaior90[i] = vetTempo[i]-90;
				vetValor[i]=mat[0][0]+vetmaior90[i]*mat[0][1];
			   }
			if(vetTipo[i]==1 && vetTempo[i]<= 90){
				vetValor[i]=mat[1][0];
			   }
			if(vetTipo[i]==1 && vetTempo[i]> 90){
				vetmaior90[i]=vetTempo[i]-90;
				vetValor[i]=mat[1][0]+vetmaior90[i]*mat[1][1];
			   }
			if(vetTipo[i]==2 && vetTempo[i]<= 90){
				vetValor[i]=mat[2][0];
			   }
			if(vetTipo[i]==2 && vetTempo[i]> 90){
				vetmaior90[i]= vetTempo[i]-90;
				vetValor[i]= mat[2][0]+vetmaior90[i]*mat[2][1];
			   }
			
		}
		System.out.println();
		/*impressao da tabela*/
		
		System.out.println("NOME\t\tTELEFONE\t\tTIPO\t\tMINUTOS\t\tVALOR DA CONTA");
		System.out.println();
		for (i = 0; i < N; i++) {
			System.out.println("" + vetNomes[i] + "\t\t" + vetNumero[i] + "\t\t" + vetTipo[i] + "\t\t" + vetTempo[i] + "\t\t"
					+ vetValor[i]);
		}
		System.out.println();
		System.out.println();
		
		
		/*A receita total da empresa telefônica (soma de todas as contas).*/
		System.out.println("RECEITA TOTAL DA EMPRESA");
		for(i=0;i<N;i++){
			valorTotal = valorTotal +vetValor[i];
		}
		System.out.println("A Receita Total da Empresa: "+valorTotal);
		System.out.println("");
		
		/*Nome e telefone do cliente do qual a conta foi mais barata (supor não haver empates).*/
		System.out.println("MENOR CONTA:");
		double menor=0;
		menor=vetValor[0];
			for(i=0;i<N;i++){
				if(vetValor[i]<menor){
					menor =vetValor[i];
					contador = i;
				}
			}
			System.out.println("A menor conta é do : "+vetNomes[contador]+" Telefone: "+ vetNumero[contador]);
			System.out.println("");
			/*Média de minutos consumidos por clientes de conta tipo 1.*/
			
			double div1=0;
			double SomaMin=0;
			contador=0;
			System.out.println("MEDIA DOS MINUTOS CONSUMIDOS PLANO TIPO 1 :");
			for(i=0;i<N;i++){
				if (vetTipo[i] == 1) {
					SomaMin = SomaMin + vetTempo[i];
					contador=contador+1;
				}
			}
			div1 = (double)SomaMin/contador;
			System.out.println("A media do Tipo 1 é = "+div1);
			System.out.println("");
			/*Nomes e telefones dos clientes que não consumiram minutos excedentes.*/
			System.out.println("CLIENTES QUE NÃO EXCEDERAM OS MINUTOS: ");
			
			for (i = 0; i < N; i++) {
				if (vetTempo[i] < 91.0) {
					System.out.println("Nome : " + vetNomes[i]+" Telefone : " + vetNumero[i]);
				}
			}
			System.out.println("");
			
			/*A quantidade de clientes que consumiu acima de 120 minutos.*/
			System.out.println("CLIENTES QUE CONSUMIRAM ACIMA  DE 120 MINUTOS: ");
			contador=0;
			for (i = 0; i < N; i++) {
				if (vetTempo[i] > 120.0) {
					contador=contador+1;
				}

			}
			System.out.println("A quantidade foi = " + contador);
			System.out.println("");
			
			/*A porcentagem de clientes que possuem conta tipo 2, em relação ao total de clientes.*/
			
			System.out.println("PORCENTAGEM DOS CLIENTES DO PLANO TIPO 2 ");
			contador=0;
			double porc=0;
			for (i = 0; i < N; i++) {
				if (vetTipo[i] == 2) {
					contador=contador+1;
				}
			}

			porc = (double) (contador * 100) / N;
			System.out.printf("A porcentagem é de %.2f %%", porc);
			
			

			
		      
		
		sc.close();
	}

}