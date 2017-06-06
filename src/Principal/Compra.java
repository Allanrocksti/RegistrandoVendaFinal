package Principal;
import java.util.HashMap;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;


public class Compra {
	
	// NÃO TOTALMENTE IMPLEMENTADO
 
	public String compra(HashMap<String, Integer> carrinho, String vendedor, String cliente){
		String msg = "";
		
		FileWriter arq;
		
		try {	
			
			arq = new FileWriter("Historicodevendas.txt",true);
			PrintWriter gravarArq = new PrintWriter(arq);
			
			java.util.Date d = new Date();
			String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
			
			String conteudo = "Vendedor: "+vendedor+" - Data: "+dStr+"\nProduto | quantidade comprada\n"+carrinho;
			
			for( int i = 0; i < carrinho.size(); i++)
				conteudo += carrinho.get(i);
		    
			gravarArq.write(conteudo);
		    gravarArq.close();
		    System.out.println("salvo com sucesso !");
			    
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}	
		
		return msg;
	}

}