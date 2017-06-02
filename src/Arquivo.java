import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *@date 1 de jun de 2017
 *@author  Neto
 *@time	19:01:25
 */

/**
 * @author Neto
 *
 */
public class Arquivo {

	public static String salvarObjeto(Compra compra){
		String msg = "";
		String nome = compra.Usuario.PrimeiroNome.toString();
		try {
			FileOutputStream fos = new FileOutputStream(nome+".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(compra);
			
			oos.close();
			fos.close();
			msg = "Arquivo Salvo com sucesso";
			
		} 
		
		 catch (IOException e) {
			// TODO Auto-generated catch block
			 msg = "Falha no salvamento do arquivo";
		}
		
		
		
		return msg;
	}
	public static Compra lerObjeto(String nome){
		
		Compra novo = null;
		try {
			FileInputStream fis = new FileInputStream(nome+".ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			novo = (Compra) ois.readObject();
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
			
			
		
		
		
		return novo;
}
		
	}


