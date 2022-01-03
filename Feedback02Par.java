//A. Exibir o percentual de vendas de cada revista; (3,0)
//B. Verificar metas de vendas por estado; (3,5)
//C. Identifique por estado a revista de maior circulação; (3,5)

package Projetos_2SIH;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Feedback02Par {

	// Variavéis globais

	static Scanner entrada = new Scanner(System.in);
	static DecimalFormat formataMoeda = new DecimalFormat(" ###0.00");
	static DecimalFormat numFormatado = new DecimalFormat("#,##0.0");
	static DecimalFormat fPorc = new DecimalFormat("#,##0.00%");

	static String[] revistas = new String[] { "VEJA", "QUATRO RODAS", "VOCÊ S/A" };
	static String[] estados = new String[] { "SP", "MG", "RJ", "ES" };
	static int somaMatriz = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stubF

		// Carregamento da matriz
		int[][] matriz = carregar();

		// Letra A
		porcentagem(matriz);

		// Letra B
		int[] somaEstado = estados(matriz);

		verifica(somaEstado);

		// Letra C
		circulacao(matriz);

	}// main

	// Método com saída e sem parâmetro
	public static int[][] carregar() {

		int[][] matriz = new int[4][3];

		System.out.println("Carregar Matriz");

		for (int e = 0; e < 4; e++) { // [linha]

			for (int r = 0; r < 3; r++) { // [coluna]

				System.out.print("Estado (" + estados[e] + ") - Revista (" + revistas[r] + "): ");
				matriz[e][r] = entrada.nextInt();
				somaMatriz += matriz[e][r];

			}
		}

		return matriz;
	}

	// Método sem retorno com parâmetro
	public static void porcentagem(int[][] matriz) {

		int somaRevista = 0;
		double porc = 0;

		System.out.println("");
		System.out.println("Letra A - Porcentagem");
		System.out.println("");

		for (int r = 0; r < 3; r++) { // [coluna]

			somaRevista = 0;

			for (int e = 0; e < 4; e++) { // [linha]

				// Matriz[linha][coluna
				somaRevista += matriz[e][r];

			}

			porc = (double) somaRevista / somaMatriz;

			System.out.println("Revista (" + revistas[r] + "): " + fPorc.format(porc));

		}

	}

	// Método com o retorno de um vetor
	public static int[] estados(int[][] matriz) {

		int[] somaEstado = new int[4];

		System.out.println("");
		System.out.println("Letra B - Maior e menor Estado");
		System.out.println("");

		for (int e = 0; e < 4; e++) {
			for (int r = 0; r < 3; r++) {

				somaEstado[e] += matriz[e][r];

			}
		}

		return somaEstado;
	}

	// Estado com maior e menor vendas
	public static void verifica(int[] somaEstado) {

		int indMenor = 0, indMaior = 0;
		int maior = 0, menor = 0;

		for (int i = 0; i < 4; i++) {

			if (i == 0) {
				indMenor = i;
				menor = somaEstado[i];

			} else {

				if (somaEstado[i] < menor) {
					indMenor = i;
					menor = somaEstado[i];
				}

				if (somaEstado[i] > maior) {
					indMaior = i;
					maior = somaEstado[i];
				}
			}

		}

		System.out.println("Estado com pior venda (" + estados[indMenor] + "): " + menor);
		System.out.println("Estado com maior venda (" + estados[indMaior] + "): " + maior);

	}

	// C. Identifique por Estado a revista de maior circulação; (3,5)

	public static void circulacao(int[][] matriz) {

		int indMaior = 0;
		int maior = 0;

		System.out.println("");
		System.out.println("Letra C - Maior circulação por Estado");
		System.out.println("");

		for (int e = 0; e < 4; e++) { // fixa
			maior = 0;
			for (int r = 0; r < 3; r++) {// move

				if (matriz[e][r] > maior) {
					maior = matriz[e][r];
					indMaior = r;
				}
			}

			System.out.println(estados[e] + ": " + revistas[indMaior]);
		}

	}
}
