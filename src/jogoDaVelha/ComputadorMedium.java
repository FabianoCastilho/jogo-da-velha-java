/*
 * @author FabianoCastilho
 */
package jogoDaVelha;

import java.util.Random;

public class ComputadorMedium extends Jogador{
	
	
	public ComputadorMedium(int jogador) {
		super(jogador);
		this.jogador = jogador;
		System.out.println("Jogador Computador Medium Criado.");
		System.out.println();
		
	}
	@Override
	public void jogar(Tabuleiro tabuleiro) {
		jogada(tabuleiro);
		tabuleiro.setPosicao( jogador, posicaoJogada,  posicao);
	}
	@Override
	public void jogada(Tabuleiro tabuleiro) {
		Random random = new Random();
		do {
			posicaoJogada = random.nextInt(9) + 1;
			
		}while(!tabuleiro.validarJogada(posicaoJogada));
		System.out.println("Posição jogada = " + posicaoJogada);
	}

}
