package lottery.bean;

public class PerceptionTestUnit {

	int input[] = new int[3];
	int output;
	public PerceptionTestUnit(int[] input,int output) {
		this.input = input;
		this.output = output;
	}
	public int[] getInput() {
		return input;
	}
	public void setInput(int[] input) {
		this.input = input;
	}
	public int getOutput() {
		return output;
	}
	public void setOutput(int output) {
		this.output = output;
	}
}
