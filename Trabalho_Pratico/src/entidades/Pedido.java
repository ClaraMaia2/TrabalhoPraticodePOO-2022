package entidades;
import java.util.Scanner;
import entidades.Produto;

public class Pedido extends Comprador 	//herdeira da classe Comprador
{
	Scanner sc = new Scanner(System.in);
	/*atributos da classe Pedido:
	 * codigo -> codigo do pedido
	 * produtos -> produto(s) cadastrados pelo vendedor
	 */
	public int codigo; 
	public Produto produtos = new Produto();
	
	//construtor da classe Pedido
	public Pedido(int cod)
	{
		this.codigo = cod;
	}
	
	//metodo que faz o calculo do total a pagar pelo pedido
	public double precoTotal()
	{
		/*variaveis:
		 *total1 -> total a pagar bruto
		 *total2 -> total a pagar se dividir o total1 em parcelas
		 *resposta -> armazena a resposta do comprador se deseja parcelar
		 */
		double total1 = 0, total2 = 0;
		String resposta;
		
		//calculo do total a pagar e mostrando na tela
		total1 = produtos.preco * produtos.quantidade;
		System.out.println("O total a pagar sera: " + total1);
		
		//pergunta ao comprador se deseja dividir
		System.out.println("Deseja dividir?");
		resposta = sc.next();
		
		/*compara a resposta:
		 *se resposta = sim -> faz o calculo do preco para cada parcela
		 *se resposta = nao -> mostra o valor original a se pagar
		 */
		if (resposta.equals("Sim"))
		{
			int dividir; 	//varivel que recebera a resposta de quantas vezes deseja dividir
			
			System.out.println("De quantas vezes? (ate 3x sem juros)");
			dividir = sc.nextInt();
			
			//calculo do valor a se pagar em cada parcela e mostrando na tela
			total2 = total1 / dividir;
			System.out.println("O novo total a pagar sera: " + total2 + " por " + dividir + " meses");
			
			return total2;
		}
		else if (resposta.equals("Nao"))
		{
			System.out.println("O total a pagar continuara sendo: " + total1);
		}
	
		sc.close();
		
		return total1;
	}
	
	//metodo toString() que retorna as informacoes do pedido em String
	public String toStringPedido()
	{
		String produto = fazerPedido(), pedidoTotal;
		double total = precoTotal();
		
		precoTotal();
		
		pedidoTotal = "Nome do produto: " + produto;
		pedidoTotal = pedidoTotal + total;
		pedidoTotal = pedidoTotal + toString();
		
		return pedidoTotal;
	}
}
