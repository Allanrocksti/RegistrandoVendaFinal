package Tratamentos;

/**
 * Classe para tratameto de entrada de codigo barras
 * @author Allan Roque Barbosa da Silva - 1610013738
 *
 */
public class TratamentoBarras {

	/**
	 * Verifica se os caracteres do codigo de barras � v�lido
	 * @param barras 
	 * @return true = inv�lido false = v�lido
	 */
	public static boolean verificarCaracteresInvalidos(String barras){
		
		boolean invalido = false;
		
		try {
			
			for (int i = 0; i < barras.length(); i++) {
				
				if ( Character.isDigit(barras.charAt(i)) == false)
					invalido = true;
				
			}
			
		} catch (NumberFormatException e) {
			invalido = true;
		}catch (Exception e) {
			invalido = true;
		}
		
		return invalido;
	
	}
	
	
}
