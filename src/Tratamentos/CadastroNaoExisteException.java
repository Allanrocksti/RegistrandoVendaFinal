/**
 *@date 7 de jun de 2017
 *@author  Neto
 *@time	18:58:41
 */
package Tratamentos;

/**
 * @author Neto
 *
 */
public class CadastroNaoExisteException extends Exception {

	private int codigo;

	

	public CadastroNaoExisteException(String message, int codigo) {
		super(message);
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
