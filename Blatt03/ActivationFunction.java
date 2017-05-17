
public interface ActivationFunction {

	public static final ActivationFunction BIAS = new ActivationFunction() { 
		public double calculate(double input){
		return input;
		}
	};

	public double calculate(double input);

}
