package Tratamentos;

/**
 * Classe para a verificar entrada de valores válidos
 * @author Allan Roque Barbosa da Silva - 1610013738
 *
 */

public class TratamentoValor {

	/**
	 * Verifica se o valor passado é negativo
	 * @param valor Valor real
	 * @return true = negativo ou 0 false = positivo 
	 */
	private static boolean verificarNegativo(float valor){
		
		boolean negativo;
		
		if(valor <= 0)
			negativo = true;
		else
			negativo = false;
		
		return negativo;
		
	}
	
	/**
	 * Verifica se valor do custo é menor ou igual a 0
	 * @param valorCusto 
	 * @param valorVenda
	 * @return true = Menor que o custo ou igual a 0 // false = Maior que o custo
	 */
	private static boolean verificarValorMenor(float valorCusto, float valorVenda){
		
		boolean menor;
		
		if (valorCusto > valorVenda)
			menor = false;
		else
			menor = true;
		
		return menor;
		
	}
	
	/**
	 * Faz todas as verificações para possiveis erros com os valores
	 * @param valorCusto
	 * @param valorVenda
	 * @return "ok" se estiver correto ou uma mensagem personalizada se estiver errado
	 */
	public String verificarValores(float valorCusto, float valorVenda){
		
		String msg = "";
		
		if(verificarNegativo(valorCusto) == false){
			
			if(verificarNegativo(valorVenda) == false){
				
				if (verificarValorMenor(valorCusto, valorVenda)) 
					msg = "ok";
				else
					msg = "Valor de Venda não pode ser menor ou igual ao valor de custo !\n";
				
			}else{
				msg = "Valor de Venda não podem ser negativos ou igual a 0 !\n";
			}
			
		}else{
			msg = "Valor de custo não podem ser negativos ou igual a 0 !\n";
		}
		
		return msg;
		
	}
	
}
