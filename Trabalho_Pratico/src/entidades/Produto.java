package entidades;

public class Produto 
{
	/*atributos da classe Produto:
	 *codigo -> codigo do produto
	 *nome -> nome do produto
	 *preco -> preco do produto
	 *estoque -> qual a quantidade do produto que esta em estoque
	 *quantidade -> quantidade do produto que o comprador vai querer
	 *tipo -> tipo de produto
	 */
	public int codigo; 	
	public String nome; 	
	public double preco; 	
	public int estoque; 	
	public int quantidade; 	
	public String tipo;
	
	public int getCodigo()
	{
		return codigo;
	}
	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}
	
	public String getNome()
	{
		return nome;
	}
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public double getPreco()
	{
		return preco;
	}
	public void setPreco(double preco)
	{
		this.preco = preco;
	}
	
	public int getEstoque()
	{
		return estoque;
	}
	public void setEstoque(int estoque)
	{
		this.estoque = estoque;
	}
	
	public int getQuantidade()
	{
		return quantidade;
	}
	public void setQuantidade(int quantidade)
	{
		this.quantidade = quantidade;
	}
	
	public String getTipo()
	{
		return tipo;
	}
	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}
}

