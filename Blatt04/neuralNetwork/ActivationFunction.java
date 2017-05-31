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
	 public static final ActivationFunction FERMI = new ActivationFunction() {
			
		public double calculate(double input) {
			return 1/1*Math.exp(-input);
		}
		
		public double differentiate(double input) {
			return 1;
		}
	};
		
	
	
	
}
