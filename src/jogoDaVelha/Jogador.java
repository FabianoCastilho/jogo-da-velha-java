/*
 * @author FabianoCastilho
 */
package jogoDaVelha;

public abstract class Jogador {
	
	protected Tabuleiro tabuleiro;

	protected Integer posicaoJogada;

	protected int[] posicao = new int[2];
	
	protected int jogador;

	public Jogador(int jogador) {
		this.jogador = jogador;
	}
	public abstract void jogar(Tabuleiro tabuleiro);
	
	public abstract void jogada(Tabuleiro tabuleiro);
}
