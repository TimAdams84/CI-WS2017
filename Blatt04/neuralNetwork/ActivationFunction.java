package neuralNetwork;

public interface ActivationFunction extends Function {
	 public double differentiate(double input);
	 
	 public static final ActivationFunction LINEAR = new ActivationFunction() {
		
		public double calculate(double input) {
			return input;
		}
		
		public double differentiate(double input) {
			return 1;
		}
	};
	
	
	
	
}
