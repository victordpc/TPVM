package TPMV;

public class CPU {

    private final Memory memory;
    private final OperandStack stack;
    private boolean halt;

    public CPU() {
        this.memory = new Memory();
        this.stack = new OperandStack();
        this.halt=false;
    }

    public boolean execute(ByteCode instruction) {
        boolean success = false;
        int value1;
        int value2;
        switch (instruction.getName()) {
            case PUSH:
                stack.push(instruction.getParam());
                success = true;
                break;
            case STORE:
                int value = stack.pop();
                success = memory.write(instruction.getParam(), value);
                break;
            case LOAD:
                memory.read(instruction.getParam());
                success = true;
                break;
            case ADD:
                value2 = stack.pop();
                value1 = stack.pop();
                stack.push(value1 + value2);
                success = true;
                break;
            case SUB:
                value2 = stack.pop();
                value1 = stack.pop();
                stack.push(value1 - value2);
                success = true;
                break;
            case MUL:
                value2 = stack.pop();
                value1 = stack.pop();
                stack.push(value1 * value2);
                success = true;
                break;
            case DIV:
                value2 = stack.pop();
                value1 = stack.pop();
                stack.push(value1 / value2);
                success = true;
                break;
            case HALT:
            	this.halt=true;
            	break;
            case OUT:
                System.out.println("El último valor en la pila es: " + stack.getLastPosition());
                break;
            default:
                break;
        }
        return success;
    }
    
    @Override
    public String toString() {
		String resultado="Estado de la CPU:\nMemoria: ";
		resultado += this.memory.toString() + "\n";
		resultado += "Pila:" + "\n";
		resultado += this.stack.toString() + "\n\n";
		return resultado;
    }

	public boolean isHalted() {
		return halt;
	}
	
	public void reset() {
		this.stack.reset();
		this.stack.reset();
	}
}