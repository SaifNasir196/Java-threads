package Class1.memorymodel;

public class Main {
	public static void main(String[] args) {
		int op1 = 2;
		int op2 = 5;
		String operation = "*";
		
		Operation op = new Operation(op1, op2, operation);
		
		Message message = new Message();
			
		float result = new Evaluator(op).evaluate(message);
		
		System.out.println(result + " " + message.getMessage());
	}
}
