package bytecode.arithmetics;

import bytecode.ByteCode;
import elements.CPU;
import exceptions.DivByZeroException;
import exceptions.ExecutionErrorException;
import exceptions.StackException;

/**
 * Clase que representa la instrución <code>DIV</code>
 * 
 */
public class Div extends Arithmetics {

	/**
	 * Constructor de la clase
	 */
	public Div() {
		super();
	}

	@Override
	public String toString() {
		return "DIV" + System.getProperty("line.separator");
	}

	@Override
	protected boolean executeAux(CPU cpu, int par1, int par2) throws DivByZeroException, StackException {
		if (par1 != 0) {
			return cpu.push(par2 / par1);
		}else {
			throw new DivByZeroException("Excepcion-bytecode DIV: No se puede dividir por cero");
		}
	}

	@Override
	protected ByteCode parseAux(String com) {
		if (com.compareToIgnoreCase("DIV") == 0)
			return new Div();
		return null;
	}

}
