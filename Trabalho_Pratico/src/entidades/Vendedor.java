package entidades;
import java.util.Scanner;
import entidades.Produto;
import entidades.Pedido;

public class Vendedor 
{
	Scanner sc = new Scanner(System.in);
	/*atributos da classe Vendedor:
	 * nome -> nome do vendedor
	 * usuario -> usuario do vendedor
	 * codigo -> codigo do vendedor
	 * produtos -> produto(s) fornecido(s) pelo vendedor
	 */
	private String nome; 	
	private String usuario; 	
	private int codigo; 	
	public Produto produtos = new Produto(); 	
	
	//metodo que cadastra um vendedor novo
	public void cadastrarVendedor()
	{
		/* variaveis do metodo
		 * resposta -> resposta para cadastrar novo vendedor
		 * n -> nome do vendedor
		 * u -> usuario do vendedor
		 * cod -> codigo do vendedor
		 */
		String n, u, resposta;
		int cod;
		
		//perguntando se o usuario quer cadastrar um novo vendedor
		System.out.println("Deseja cadastrar um novo vendedor? ");
		resposta = sc.next();
		
		//se a resposta da pergunta acima for "Sim", repetem as perguntas de cadastro
		while (resposta.equals("sim"))
		{
			System.out.println("Nome do vendedor: ");
			n = sc.next();
			this.setNome(n);
			
			System.out.println("Usuario do vendedor: ");
			u = sc.next();
			this.setUsuario(u);
			
			System.out.println("Codigo do vendedor: ");
			cod = sc.nextInt();
			this.setCodigo(cod);
			
			System.out.println("Deseja cadastrar um novo vendedor? ");
			resposta = sc.next();
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

	//metodos get e set do atributo Codigo
	public int getCodigo() 
	{
		return codigo;
	}
	public void setCodigo(int codigo) 
	{
		this.codigo = codigo;
	}

	//metodo em que o vendedor cadastra seu produto
	public void cadastrarProduto()
	{
		/*variaveis do metodo:
		 * resposta -> armazena a resposta do vendedor se ele(a) deseja cadastrar um produto
		 * nom -> nome do produto
		 * tip -> tipo do produto
		 * cod -> codigo do produto
		 * est -> quantidade do produto em estoque
		 * pre -> preco do produto
		 */
		String resp, nom, tip;
		int cod, est;
		double pre;
		
		System.out.println("Deseja cadastrar um produto?");
		resp = sc.nextLine();
		
		/*utiliza a resposta do vendedor para realizar o cadastro do produto
		 *enquanto resposta = sim -> manda perguntas ao vendedor sobre o produto
		 */
		while (resp.equals("sim"))
		{
			System.out.println("Qual o nome do produto?");
			nom = sc.next();
			produtos.setNome(nom);
			
			System.out.println("Qual o codigo do produto?");
			cod = sc.nextInt();
			produtos.setCodigo(cod);
			
			System.out.println("Qual o preco do produto?");
			pre = sc.nextDouble();
			produtos.setPreco(pre);
			
			System.out.println("Quantos produtos " + produtos.nome + " tem em estoque?");
			est = sc.nextInt();
			produtos.setEstoque(est);
			
			System.out.println("Qual o tipo do produto " + produtos.nome + "? (ex. roupa, eletronicos...");
			tip = sc.next();
			produtos.setTipo(tip);
			
			System.out.println("Deseja cadastrar um produto?");
			resp = sc.next();
			
			if (resp.equals("nao"))
			{
				System.out.println("OK");
			}
		}
	}
	
	//metodo que permite o vendedor visualizar o pedido feito pelo comprador
	public void visualizarPedido()
	{
		int cod; 	//variavel do metodo que armazena o codigo do pedido
		
		System.out.println("Digite o codigo do pedido: ");
		cod = sc.nextInt();
		
		Pedido pedido = new Pedido(cod);
		
		//se o codigo digitado for o mesmo do codigo do pedido, chama o metodo toStringPedido() da classe Pedido
		if (cod == pedido.codigo)
		{
			System.out.println(pedido.toStringPedido());
		}
		sc.close();
	}
}

