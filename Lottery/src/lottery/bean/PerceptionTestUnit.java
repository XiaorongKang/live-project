package lottery.bean;

/**
 * 
 * @author MingJun
 * @date 2019/4/21 22:23
 * 样本数据类
 */
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
