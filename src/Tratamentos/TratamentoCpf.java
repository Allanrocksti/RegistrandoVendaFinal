package Tratamentos;

import java.util.InputMismatchException;

/**
 * Classe para verificar se o CPF � v�lido e para a impress�o personalizada " ***.***.***-** "
 * @author Allan Roque Barbosa da Silva - 1610013738
 *
 */

public class TratamentoCpf {

	/**
	 * M�todo para calcular um somat�rio dos numeros do CPF a partir de um peso
	 * @param cpf CPF em string
	 * @param peso Peso para calculo
	 * @return somatorio calculado
	 */
	private int somatorio(String cpf, int peso){
		
		int indiceStr;
		int somatorio = 0;
		
		for (int i = 0; i<9; i++) {              
        	
			indiceStr = (int)(cpf.charAt(i) - 48); // charAt retorna o indice da string
        	
        	somatorio = somatorio + (indiceStr * peso);
        	
        	peso = peso - 1;
        
        }
		
		return somatorio;
		
	}
	
	/**
	 * M�todo para calcular o d�gito validador do CPF
	 * @param somatorio C�lculo do somat�rio de CPF
	 * @return Retorna o d�gito j� formatado em char 
	 */
	private char calcularDigito(int somatorio) {

		int resto = 11 - (somatorio % 11);
		int digito;
		
	    if ((resto == 10) || (resto == 11))
	    	digito = '0';
	    else 
	    	digito = (char)(resto + 48);
		
		return ( (char)(digito) );
		
	}
	
	/**
	 * M�todo para descobrir se o CPF � v�lido
	 * @param cpf String contendo o CPF
	 * @return Retorna um valor booleano para valida��o True = V�lido False = Inv�lido
	 */
	public boolean cpfValido(String cpf) {

		    if (cpf.equals("00000000000") || cpf.equals("11111111111") ||
		        cpf.equals("22222222222") || cpf.equals("33333333333") ||
		        cpf.equals("44444444444") || cpf.equals("55555555555") ||
		        cpf.equals("66666666666") || cpf.equals("77777777777") ||
		        cpf.equals("88888888888") || cpf.equals("99999999999") ||
		       (cpf.length() != 11))
		       return(false);

		    char dig10,  
		    	 dig11;
		    
		    int somatorio;

		    try {
		    	// Calculo do 1� Digito Verificador

		    	somatorio = somatorio(cpf, 10); 
		    	dig10 = calcularDigito(somatorio);
		    	
		    	// Calculo do 2� Digito Verificador
		    	
		    	somatorio = somatorio(cpf, 11); 
		    	dig11 = calcularDigito(somatorio);

		    	// Verifica se os digitos calculados conferem com os digitos informados.

		    	if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
					return(true);
				else 
					return(false);
		      
		    } catch (InputMismatchException erro) {
		        return(false);
		    }
		    
	}
	
	/**
	 * M�todo para impress�o de CPF formatado com "." e "-"
	 * @param cpf String do CPF
	 * @return Retorna a String CPF formatada 
	 */
	public String imprimeCpf(String cpf) {
	    
		return(cpf.substring(0, 3) 
	    		+ "." + cpf.substring(3, 6) 
	    		+ "." + cpf.substring(6, 9) 
	    		+ "-" + cpf.substring(9, 11));
		
	 }
	
}
