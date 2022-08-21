/*Trabalho Prático de POO
 * Nome: Clara Araújo Maia
 * Curso: Engenharia de Computaçao
 * Turma: 2021
 * Data: 22/08/2022
 */
package aplicacao;
import java.util.Scanner;
import entidades.Vendedor;
import entidades.Pedido;
import entidades.Comprador;

public class Principal 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		/*atributos da classe Principal
		 * comprador -> variavel que assume todos os metodos da classe Comprador
		 * vendedor -> variavel que assume todos os metodos da classe Vendedor
		 * codigo -> varivel que armazena os codigos para pedido
		 * pedido -> variavel que assume todos os metodos da classe Pedido
		 * resposta -> armazena a resposta do usuario para a pergunta se ele(a) eh comprador ou vendedor
		 */
		Comprador comprador = new Comprador();
		Vendedor vendedor = new Vendedor();
		
		//chama o metodo gerarCodigo(), localizado na classe main
		gerarCodigo(10);
		int codigo = gerarCodigo(10); 	//variavel que armazena o codigo gerado pelo metodo
		Pedido pedido = new Pedido(codigo);
		String resposta;
	
		//cadastrando um produto
		System.out.println("Antes de tudo, o vendedor precisa cadastrar um produto." + "\n" + "Portanto, se voce for comprador, volte novamente mais tarde.");
		vendedor.cadastrarProduto();
		
		//perguntando se eh comprador ou vendedor
		System.out.println("Voce eh comprador ou vendedor? ");
		resposta = scan.next();
		
		if (resposta.equals("comprador"))
		{
			//chamando o metodo cadastrarComprador() da classe Comprador
			comprador.cadastrarComprador();
			pedido.fazerPedido();
		}
		else if (resposta.equals("vendedor"))
		{
			//chamando os metodos cadastrarVendedor() e visualizarPedido() da classe Vendedor
			vendedor.cadastrarVendedor();
			vendedor.visualizarPedido();
		}
	}
	
	//gerando codigo de pedido
	public static int gerarCodigo(int quant)
	{
		Pedido pedido = new Pedido(0);
	
		for (int cont = 0; cont < quant; cont++)
		{
			pedido.codigo = 0;
			pedido.codigo++;
		}
	
		return pedido.codigo;
	}
}
