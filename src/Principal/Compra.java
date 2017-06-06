package Principal;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;


public class Compra {
	
	// NÃO TOTALMENTE IMPLEMENTADO
	
	private static String stringPessoa(String cpfPessoa){
		
		String str = "";
		
		try {
			
			FileReader fr = new FileReader(cpfPessoa + ".txt");
			BufferedReader br = new BufferedReader(fr);
			String nome = br.readLine();
			String endereco = br.readLine();
			br.close();
			fr.close();
			
			str = nome + "\nEndereço: " + endereco;
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return str;
		
	}
 
	private static String stringProdutos(HashMap<Integer, String> produtos, HashMap<Integer, Float> valores){
		
		String str = "";
		
		for(int i = 0; i < produtos.size(); i++)
			str += produtos.get(i) + "      ------      R$ " + valores.get(i) + "\n";
		
		return str;
		
	}
	
	private static String totalCompra(HashMap<Integer, Float> valores){
		
		String str = "";
		float total = 0;
		
		for(int i = 0; i < valores.size(); i++)
			total += valores.get(i);
		
		str = Float.toString(total);
		
		return str;
		
	}
	
	public float coletarValor(String barra){
		
		String valorStr = "0";
		float valor = 0;
		
		try {
			
			FileReader fr = new FileReader(barra + ".txt");
			BufferedReader br = new BufferedReader(fr);
			
			for(int i = 0; i < 3; i++){
				
				br.readLine();
				
				if(i == 1)
					valorStr = br.readLine();
				
			}
			
			br.close();
			fr.close();
			
			valor = Float.parseFloat(valorStr);
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return valor;
		
	}
	public String compra(HashMap<Integer, String> produtos, HashMap<Integer, Float> valores,String vendedor, String cliente){
		String msg = "";
		
		FileWriter arq;
		
		java.util.Date d = new Date();
		String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
		
		try {	
			
			arq = new FileWriter("Historicodevendas.txt",true);
			PrintWriter gravarArq = new PrintWriter(arq);
			
			String conteudo = "\n\n###################################\n\nData da compra: " + dStr
							+ "\n\nVendedor: " + stringPessoa(vendedor) 
							+ "\n\nCliente: " + stringPessoa(cliente)
							+ "\n\n" + stringProdutos(produtos, valores) 
							+ "\n\nTotal: R$" + totalCompra(valores)
							+ "\n\n###################################";
					
		    
			gravarArq.write(conteudo);
		    gravarArq.close();
		    System.out.println("salvo com sucesso !");
			    
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}	
		
		return msg;
	}
	
	public static void main(String[] args) {
		
		String str = stringPessoa("01785466402");
		System.out.println(str);
		
	}

}