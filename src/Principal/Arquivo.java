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
/*
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
	*/
	public String salvarCadastro(String arquivo, String conteudo){
		
		FileWriter arq;
		String msg = "Erro arq";
		
		try {
				
			arq = new FileWriter(arquivo);
			PrintWriter gravarArq = new PrintWriter(arq);
		    gravarArq.write(conteudo);
		    gravarArq.close();
		    msg = "salvo com sucesso !";
		
			//FileOutputStream foo = new FileOutputStream(arquivo);
			//ObjectOutputStream oos = new ObjectOutputStream(foo);
			//oos.writeObject(map);
			//oos.close();
			
			//File arq = new File(arquivo);
			//write(arq, map);
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		return msg;
		
	}
	
	public boolean verificarArquivoJaExistente(String arquivo) {
		System.out.println(arquivo);
		boolean existe = false;
		
		try {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			br.close(); 
			existe = true;
		} catch (FileNotFoundException e) {
			return existe;
		} catch (IOException e){
			return existe;
		} catch (NullPointerException e){
			return existe;
		}
		
		return existe;
		
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
	
	// TESTE DO ERRO NULL POINTER EXCEPTION
	/*public static void main(String[] args) {
		
		Arquivo arquivo = new Arquivo();
		Venda venda = new Venda();
		
		boolean var = arquivo.verificarArquivoJaExistente("12345678909" + "_" + "123456" + ".txt");
		System.out.println(var);
		String cpf = "";
		// ERRO AQUI 
		try{
		cpf = venda.entrarComCpfVendedor();
		//****
		} catch (NullPointerException e){
			System.out.println("erro");
		}
		System.out.println(cpf);
		
		 
	}*/
	
}
