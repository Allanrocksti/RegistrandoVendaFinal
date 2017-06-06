package Principal;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Cadastro.Pessoa;
import Cadastro.Produto;

/**
 *@date 1 de jun de 2017
 *@author  Neto
 *@time	19:01:25
 */

/**
 * @author Aluízio Barbosa Maciel Neto
 *
 */
public class Arquivo {

	private static class AppendableObjectOutputStream extends ObjectOutputStream {

        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            // do not write a header
        }
    }
	
	private static ObjectOutputStream getOOS(File storageFile) throws IOException {
        if (storageFile.exists()) {
            // this is a workaround so that we can append objects to an existing file
            return new AppendableObjectOutputStream(new FileOutputStream(storageFile, true));
        } else {
            return new ObjectOutputStream(new FileOutputStream(storageFile));
        }
    }
	
	private static void write(File storageFile, Map<String, String> o) throws IOException {
        ObjectOutputStream oos = getOOS(storageFile);
        oos.writeObject(o);
        oos.close();
    }
	
	private static void read(ObjectInputStream ois, Map<String, String> expected) throws ClassNotFoundException, IOException {
        Object actual = ois.readObject();
        assertEquals(expected, actual);
    }
	
	private static void assertEquals(Object o1, Object o2) {
        if (!o1.equals(o2)) {
            throw new AssertionError("\n expected: " + o1 + "\n actual:   " + o2);
        }
    }
	
	public String salvarCadastro(HashMap<String, String> map, String arquivo){
		
		//FileWriter arq;
		String msg = "Erro arq";
		
		try {
			//arq = new FileWriter(arquivo,true);
			//PrintWriter gravarArq = new PrintWriter(arq);
		    //gravarArq.append(map);
		    //gravarArq.close();
			//FileOutputStream foo = new FileOutputStream(arquivo);
			//ObjectOutputStream oos = new ObjectOutputStream(foo);
			//oos.writeObject(map);
			//oos.close();
			
			File arq = new File(arquivo);
			write(arq, map);
			
		    msg = "Produto cadastrado com sucesso!!!";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
		
	}
	
	
	private static HashMap<String, String> lerCadastro(String arquivo){
		
		HashMap<String, String> hM = new HashMap<String, String>();
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
			hM = (HashMap<String, String>) ois.readObject();
			ois.close();
			
		} catch (Exception e) {
			System.out.println("oi");
		}
		
		return hM;
		
	}
	
	public boolean verificarChaveIgual(String chave, String arquivo){
		
		boolean igual = false;
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map = lerCadastro(arquivo);
		System.out.println(map);
		
		for(int i = 0; i < map.size(); i++){
			
			if(map.get(i) == chave)
				igual = true;
			
		}
		
		return igual;
		
	}
	
	
	public static void main(String[] args) {
		HashMap<String, String> hM = new HashMap<String, String>();
		hM = lerCadastro("Produto.txt");
		System.out.println("OI");
		System.out.println(hM);
		System.out.println(hM.get(0));
		System.out.println(hM.get(1));
		System.out.println(hM.get(2));
		System.out.println(hM.get(3));
		System.out.println(hM.get(4));
		
	}
	
}
