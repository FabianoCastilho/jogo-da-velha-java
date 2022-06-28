/*
 * @author FabianoCastilho
 */
package jogoDaVelha;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JogadorHumano extends Jogador {

	Scanner sc = new Scanner(System.in);

	public JogadorHumano(int jogador) {
		super(jogador);
		this.jogador = jogador;
		System.out.println();
		System.out.println("Jogador Humano Criado.");
		
	}
	@Override
	public void jogar(Tabuleiro tabuleiro) {
		jogada(tabuleiro);
		tabuleiro.setPosicao(jogador,posicaoJogada, posicao);
	}
	@Override
	public void jogada(Tabuleiro tabuleiro) {
		do { 
			do {
				try {
					System.out.print("Digite a posição da jogada: ");
					posicaoJogada = sc.nextInt();
					sc.nextLine();
					
					if (posicaoJogada < 1 || posicaoJogada > 9) {
						System.out.println("Posição invalida. Opções de 1 a 9");	
					}
					else if (!tabuleiro.validarJogada(posicaoJogada)) {
						System.out.println("Posicao ja foi macada, tente outra.");
					}			
				}catch (InputMismatchException e) {
					 System.out.println("Você Digitou algum caracter invalido");
		    		 sc.next();	 
				}
			} while (posicaoJogada < 1 || posicaoJogada > 9);
		} while (!tabuleiro.validarJogada(posicaoJogada));
	}
}
