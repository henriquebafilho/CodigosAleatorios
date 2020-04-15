/*Conversor de Decimal para Algarismo Romano*/

import java.util.*;

public class ConversorAlgarismosRomanos {

	public static void main(String[] args) {
		System.out.println(converteRomano(4000));
	}

	public static String converteRomano(int numero) {
		int qtd = contaAlgarismos(numero);
		String palavra = new String();
		String[][] letras = new String[5][1001];

		letras[1][0] = "";
		letras[1][1] = "I";
		letras[1][4] = "IV";
		letras[1][5] = "V";
		letras[1][9] = "IX";
		letras[2][10] = "X";
		letras[2][40] = "XL";
		letras[2][50] = "L";
		letras[2][90] = "XC";
		letras[3][100] = "C";
		letras[3][400] = "CD";
		letras[3][500] = "D";
		letras[3][900] = "CM";
		letras[4][1000] = "M";

		// 1 algarismo
		if (qtd == 1) {
			if (numero == 0) {
				palavra = palavra.concat(letras[1][0]);
			}
			else if (numero < 4) {
				for (int i = 0; i < numero; i++) {
					palavra = palavra.concat(letras[1][1]);
				}
			}
			else if (numero >= 4 && numero <= 5) {
				palavra = letras[qtd][numero];
			}
			else if (numero > 5 && numero < 9) {
				palavra = palavra.concat(letras[1][5]);
				for (int i = 0; i < numero % 5; i++) {
					palavra = palavra.concat(letras[1][1]);
				}
			}
			else {
				palavra = palavra.concat(letras[1][9]);
			}
		}
		// 2 algarismos
		else if (qtd == 2) {
			if (numero >= 10 && numero < 40) {
				palavra = palavra.concat(letras[2][10]);
				for (int i = 10; i < numero - (numero % 10); i += 10) {
					palavra = palavra.concat(letras[2][10]);
				}
			}
			else if (numero >= 40 && numero < 50) {
				palavra = palavra.concat(letras[2][40]);
			}
			else if (numero >= 50 && numero < 90) {
				palavra = palavra.concat(letras[2][50]);
				for (int i = 50; i < numero - (numero % 10); i += 10) {
					palavra = palavra.concat(letras[2][10]);
				}
			}
			else /* se tiver entre 90 e 99 */ {
				palavra = palavra.concat(letras[2][90]);
			}
			palavra = palavra.concat(converteRomano(numero % 10));
		}
		// 3 algarismos
		else if (qtd == 3) {
			if (numero >= 100 && numero <= 399) {
				palavra = palavra.concat(letras[3][100]);
				for (int i = 100; i < numero - (numero % 100); i += 100) {
					palavra = palavra.concat(letras[3][100]);
				}
			}
			else if (numero >= 400 && numero <= 499) {
				palavra = palavra.concat(letras[3][400]);
			}
			else if (numero >= 500 && numero <= 899) {
				palavra = palavra.concat(letras[3][500]);
				for (int i = 500; i < numero - (numero % 100); i += 100) {
					palavra = palavra.concat(letras[3][100]);
				}
			}
			else if (numero >= 900 && numero <= 999) {
				palavra = palavra.concat(letras[3][900]);
			}
			palavra = palavra.concat(converteRomano(numero % 100));
		}
		// 4 algarismos
		else if (qtd == 4) {
			if (numero >= 1000 && numero <= 3999) {
				palavra = palavra.concat(letras[4][1000]);
				for (int i = 1000; i < numero - (numero % 1000); i += 1000) {
					palavra = palavra.concat(letras[4][1000]);
				}
			}
			else {
				System.out.println("Insira um número menor que 3999");
			}
			palavra = palavra.concat(converteRomano(numero % 1000));
		}

		return palavra;
	}

	public static int contaAlgarismos(int numero) {
		int qtd = 0;

		while (numero >= 1) {
			numero = numero / 10;
			qtd += 1;
		}
		return qtd;
	}
}
