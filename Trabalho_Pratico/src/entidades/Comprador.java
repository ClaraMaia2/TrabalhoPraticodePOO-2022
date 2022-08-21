package entidades;
import java.util.Scanner;
import entidades.Produto;
import entidades.Vendedor;

public class Comprador 
{
	Scanner sc = new Scanner(System.in);
	/*atributos da classe Comprador:
	 * nome -> nome do comprador
	 * usuario -> usuario do compradorq										
	 * telefone -> telefone do comprador
	 * endereco -> endereco de entrega do comprador
	 * produtos -> produto(s) que o comprador escolher
	 */
	private String nome; 	
	private String usuario; 	
	private String telefone; 	
	private String endereco; 	
	public Produto produtos = new Produto(); 	
	public Vendedor vendedor = new Vendedor();
	
	//cadastra um comprador novo
	public void cadastrarComprador()
	{
		/*variaveis do metodo:
		 * nom -> nome do comprador
		 * usu -> nome de usuario do comprador
		 * tel -> telefone para contato do comprador
		 * end -> endereco de cobranca do comprador
		 * resposta -> resposta do usuario para se cadastrar
		 */
		String nom, usu, tel, end, resposta;
		
		System.out.println("Deseja se cadastrar no site? ");
		resposta = sc.next();
		
		if (resposta.equals("sim"))
		{
			System.out.println("Digite seu nome completo: ");
			nom = sc.next();
			this.setNome(nom);
			
			System.out.println("Digite seu nome de usuario: (pode conter letras e numeros)");
			usu = sc.next();
			this.setUsuario(usu);
			
			System.out.println("Digite seu numero de telefone: (com DDD)");
			tel = sc.next();
			this.setTelefone(tel);
			
			System.out.println("Digite o endereco que deseja receber sua encomenda: (voce pode mudar mais tarde nas configuracoes)");
			end = sc.next();
			this.setEndereco(end);
		}
		else if (resposta.equals("nao"))
		{
			System.out.println("OK");
		}
	}

	//metodos get e set do atributo Nome
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	//metodos get e set do atributo Usuario
	public String getUsuario() 
	{
		return usuario;
	}
	public void setUsuario(String usuario) 
	{
		this.usuario = usuario;
	}

	//metodos get e set do atributo Telefone
	public String getTelefone() 
	{
		return telefone;
	}
	public void setTelefone(String telefone) 
	{
		this.telefone = telefone;
	}

	//metodos get e set do atributo Endereco
	public String getEndereco() 
	{
		return endereco;
	}
	public void setEndereco(String endereco) 
	{
		this.endereco = endereco;
	}
	
	//metodo em que o comprador faz a escolha do produto
	public String escolherProduto()
	{
		/*variaveis do metodo:
		 * resposta -> armazena a resposta do comprador para a pergunta de comeco de compras
		 * nom -> armazena o nome do produto que o comprador deseja comprar
		 */ 	
		String nom = "nada", resposta; 	
		
		//mostra na tela do usuario opcoes para que ele escolha se quer comecar as compras ou nao
		System.out.println("Vamos comecar as compras?");
		resposta = sc.next();
		
		
		/*utiliza a resposta para iniciar o processo de repeticao 
		 * enquanto resposta = sim -> inicia as compras do comprador e muda o valor da variavel nom
		 */
		if (resposta.equals("sim")) 
		{
			System.out.println("Digite o nome do produto que voce deseja procurar: ");
			nom = sc.next();
			
			if (vendedor.produtos.getNome() != nom)
			{
				System.out.println("Esse produto não existe.");
			}
			else if (vendedor.produtos.getNome() == nom)
			{
				return nom;
			}
		} 
		else if (resposta.equals("nao"))
		{
			System.out.println("ok!");
		}
		
		return nom; 	//o metodo retorna o nome do produto como tipo String
	}
	
	//metodo em que o comprador faz a escolha da quantidade do produto que ele escolheu
	public int escolherQuantidade()
	{
		/*variaveis do metodo:
		 * quant -> armazena a quantidade do produto que o comprador escolher
		 * escolha -> armazena o nome do produto que o comprador quer
		 */
		int quant = 0; 	
		String escolha = escolherProduto(); 	
		
		//realizando uma comparacao com a variavel produtos no metodo getNome() 
		if (escolha == produtos.nome)
		{
			System.out.println("Qual a quantidade que voce deseja desse produto?");
			quant = sc.nextInt();
			produtos.setQuantidade(quant); 	//a variavel quant muda de 0 para o valor digitado pelo comprador
		}
		
		/*se o if acima retornar falso, o metodo retorna a quantidade 0
		 *se ele retornar verdadeiro, o metodo retorna a quantidade digitada pelo comprador
		 */
		return quant; 	
	}
	
	//metodo que junta os metodos anteriores para que ele seja adicionado no pedido de maneira organizada e retorna como String
	public String fazerPedido()
	{
		escolherQuantidade();
		
		int quant = escolherQuantidade();
		String pedido;
		
		pedido = "Nome do produto: " + escolherProduto();
		pedido = pedido + "Quantidade do produto: " + quant;
		
		return pedido;
	}
	
	//metodo que mostra o nome e o endereco do comprador
	public String toString()
	{
		String comprador;
		
		comprador = "Nome: " + this.getNome();
		comprador = comprador + "Endereco: " + this.getEndereco();
		
		return comprador;
	}
}

