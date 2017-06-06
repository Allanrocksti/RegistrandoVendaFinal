package Principal;
/**
 *@date 3 de jun de 2017
 *@author  Neto
 *@time	17:36:41
 */


import java.util.Scanner;

/**
 * @author Neto
 *
 */
public class Extra {
	
	Scanner leitor = new Scanner(System.in);
	public int verificarI(String ch){
		
		boolean key = true;
		
		try {
			
			while(key){
				
				if(validar(ch)){
					
					int codigo = Integer.parseInt(ch);
					
					if(codigo < 0){
						System.out.println("O Numero pedido é inteiro não negativo no formato(99, 01,2,3435): ");
			    		ch = leitor.nextLine();
					}else{
						return codigo;
					}
					
		        }else{
		            System.out.println("O Numero pedido é inteiro não negativo no formato(99, 01,2,3435): ");
		    		ch = leitor.nextLine();
		        }

			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
		
	}
	
	public float verificarF(String ch){
		
		boolean key = true;
		float valorVenda = 0.0f;
		
		try {
			
			while(key){
				
				if(validar(ch)){
					
					valorVenda = Float.parseFloat(ch);
					
					if(valorVenda < 0){
						System.out.println("O Valor da venda tem que ser maior que 0: ");
			    		ch = leitor.nextLine();
					}else{
						return valorVenda;
					}
					
		        }else{
		            System.out.println("O Numero pedido é Float não negativo no formato(99, 01,2,3435,34.55): ");
		    		ch = leitor.nextLine();
		        }
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	public static boolean validar(String texto) {
        String valor = texto;
        boolean valido = true;
        try{
	        for (int i = 0; i < valor.length(); i++) {
	            Character caractere = valor.charAt(i);
	            if (!Character.isDigit(caractere)) {
	                //É String
	                valido = false;
	            }
	        }
        }catch (Exception e) {
			// TODO: handle exception
        	System.out.println("problema aqui arrombs");
		}
        
        //É numero
        return valido == true;
		}
}
