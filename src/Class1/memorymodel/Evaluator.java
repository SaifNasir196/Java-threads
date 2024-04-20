package Class1.memorymodel;

public class Evaluator {

	private Operation op;
	
	public Evaluator(Operation op) {
		this.op = op;
	}
	public float evaluate(Message message) {
		
		float result = Float.MIN_VALUE;
		
		message.setMessage("NOT_SUPPORTED"); // default message
		
		if (op.getOperator().equals("*")) {
			result = op.getValue1() * op.getValue2();
			message.setMessage("SUCCESS");
		}
		return result;
	}
}
