package Projetos_2SIH;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Feedback02Impar {

	// Variavéis globais

	static Scanner entrada = new Scanner(System.in);
	static DecimalFormat formataMoeda = new DecimalFormat(" ###0.00");
	static DecimalFormat numFormatado = new DecimalFormat("#,##0.0");
	static DecimalFormat fPorc = new DecimalFormat("#,##0.00%");

	static String[] revistas = new String[] { "VEJA", "QUATRO RODAS", "VOCÊ S/A", "SUPERINTERESSANTE" };
	static String[] estados = new String[] { "SP", "MG", "RJ" };
	static int somaMatriz = 0;

	static int metas[] = new int[3];
	static int vendas[][] = new int[4][3]; // matriz de vendas
	static int somaVendas = 0;
	static int somaRevista[] = new int[4]; // soma as revistas
	static int somaEstado[] = new int[3]; // somas os estados

	public static void main(String[] args) {
		// TODO Auto-generated method stubF

		// Carregamento da matriz
		int[][] matriz = carregar();

		// Letra A
		porcentagem(matriz);

		// Letra B
		metas(matriz);

		// Letra C
		circulacao(matriz);

	}// main

	// Entrada dos dados
	public static int[][] carregar() {

		int[][] matriz = new int[3][4];

		System.out.println("-------- Feedback 02 --------------");

		for (int e = 0; e < 3; e++) { // [linha]

			for (int r = 0; r < 4; r++) { // [coluna]

				System.out.print("Estado (" + estados[e] + ") - Revista (" + revistas[r] + "): ");
				matriz[e][r] = entrada.nextInt();
				somaMatriz += matriz[e][r];

			}
		}

		return matriz;
	}

	// A. Exibir o percentual de vendas de cada revista; (3,0)
	public static void porcentagem(int[][] matriz) {

		int somaRevista = 0;
		double porc = 0;

		System.out.println("");
		System.out.println("Letra A - Porcentagem");
		System.out.println("");

		for (int r = 0; r < 4; r++) { // [coluna]

			somaRevista = 0;

			for (int e = 0; e < 3; e++) { // [linha]

				// Matriz[linha][coluna
				somaRevista += matriz[e][r];

			}

			porc = (double) somaRevista / somaMatriz;

			System.out.println("Revista (" + revistas[r] + "): " + fPorc.format(porc));

		}

	}

	// B. Verificar metas de vendas por estado; (3,5)

	public static void metas(int[][] matriz) {

		System.out.println("");
		System.out.println("Letra B - Meta de vendas");
		System.out.println("");

		// Soma Estado

		for (int e = 0; e < 3; e++) { // [linha]

			for (int r = 0; r < 4; r++) { // [coluna]

				somaEstado[e] += matriz[e][r];
			}
		}

		// Entrada da meta de vendas

		for (int j = 0; j < 3; j++) { // [linha]

			System.out.print("Digite a meta de vendas do estado (" + estados[j] + "): ");
			metas[j] = entrada.nextInt();
			System.out.println("");

		}

		for (int j = 0; j < 3; j++) {
			if (somaEstado[j] >= metas[j]) {
				System.out.println("O Estado (" + estados[j] + ") atingiu a meta? - [SIM]");
			} else {
				if (somaEstado[j] < metas[j]) {
					System.out.println("O Estado (" + estados[j] + ") atingiu a meta? - [NÃO]");
				}

			}
		}

	}

	// C. Identifique por Estado a revista de maior circulação; (3,5)

	public static void circulacao(int[][] matriz) {

		int indMaior = 0;
		int maior = 0;

		System.out.println("");
		System.out.println("Letra C - Maior circulação por Estado");
		System.out.println("");

		for (int e = 0; e < 3; e++) { // fixa
			maior = 0;
			for (int r = 0; r < 4; r++) {// move

				if (matriz[e][r] > maior) {
					maior = matriz[e][r];
					indMaior = r;
				}
			}

			System.out.println(estados[e] + ": " + revistas[indMaior]);
		}

	}

}
