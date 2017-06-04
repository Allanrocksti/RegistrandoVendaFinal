import java.util.Scanner;

/**
 *@date 3 de jun de 2017
 *@author  Neto
 *@time	21:41:50
 */

/**
 * @author Neto
 *
 */

public class Cadastros {

	private static Scanner scanner = new Scanner(System.in);

	Arquivo arquivo = new Arquivo();

	Extra extra = new Extra();

	public String produto() {
		Produto produto;
		String msg = "";
		System.out.println("Nome do produto: ");
		String nome = scanner.nextLine();
		System.out.println("Valor do produto: ");
		String dado = scanner.nextLine();
		float valor = extra.verificarF(dado);
		System.out.println("Codigo do produto: ");
		String codigo = scanner.nextLine();

		produto = new Produto(nome, valor, codigo);

		msg = Arquivo.salvarObjeto(produto);

		return msg;
	}
}
