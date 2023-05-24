package exercice5;

public class ArithmeticBean {
	private int operand1;
	private int operand2;

	public ArithmeticBean() {
		// Default constructor
	}

	public void setOperand1(int operand1) {
		this.operand1 = operand1;
	}

	public void setOperand2(int operand2) {
		this.operand2 = operand2;
	}

	public int getAdditionResult() {
		return operand1 + operand2;
	}

	public int getSubtractionResult() {
		return operand1 - operand2;
	}

	public int getMultiplicationResult() {
		return operand1 * operand2;
	}

	public int getDivisionResult() {
		if (operand2 != 0) {
			return operand1 / operand2;
		} else {
			throw new ArithmeticException("Division by zero");
		}
	}
}
