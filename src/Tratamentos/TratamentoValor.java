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
	 * Verifica se o valor ultrapassa os 9999 reais
	 * @param valorVenda
	 * @return true = se sim false = se não
	 */
	private boolean verificarValorMaximo(float valorVenda) {
		
		boolean valor;
		
		if (valorVenda < 10000)
			valor = false;
		else
			valor = true;
			
		return valor;
		
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
				
				if (verificarValorMenor(valorCusto, valorVenda) == true){
					
					if (verificarValorMaximo(valorVenda) == false)
						msg = "ok";
					else
						msg = "\nNÃO SEJA GANANCIOSO, DEFINA UM VALOR ABAIXO DE R$ 10000,00 \n";
	
				}else{
					msg = "\nVALOR DE VENDA NÃO PODE SER MENOR OU IGUAL AO VALOR DE CUSTO !\n";
				}
				
			}else{
				msg = "\nVALOR DE VENDA NÃO PODEM SER NEGATIVOS OU IGUAL A 0 !\n";
			}
			
		}else{
			msg = "\nVALOR DE CUSTO NÃO PODEM SER NEGATIVOS OU IGUAL A 0 !\n";
		}
		
		return msg;
		
	}
	
}
