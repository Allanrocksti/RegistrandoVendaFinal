package Principal;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Compra {
	
	//Pessoa Vendendor = new Pessoa();
	//Pessoa Usuario = new Pessoa();
	Float ValorLiguido;
	Float Desconto;
 
	public String compra(HashMap<String, Integer> carrinho, String vendedor, String cliente){
		String msg = "";
		FileWriter arq;
		try {			
			arq = new FileWriter("Historicodevendas.txt",true);
			PrintWriter gravarArq = new PrintWriter(arq);
			java.util.Date d = new Date();
			String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
			String conteudo = "Vendedor: "+vendedor+" - Data: "+dStr+"\nProduto | quantidade comprada\n"+carrinho;
		    gravarArq.write(conteudo);
		    gravarArq.close();
		    System.out.println("salvo com sucesso !");
			
				//FileOutputStream foo = new FileOutputStream(arquivo);
				//ObjectOutputStream oos = new ObjectOutputStream(foo);
				//oos.writeObject(map);
				//oos.close();
				
				//File arq = new File(arquivo);
				//write(arq, map);
			    
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		/*public void calcular desconto(){
		 * 
		}*/
		
		
		return msg;
	}
}