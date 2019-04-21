package lottery.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import lottery.bean.PerceptionTestUnit;

/**
 * @author mingjun
 * @date 2019/4/21 22:26
 * @description Perception算法工具类
 */
public class PerceptionUtil {
	//训练样本数量
	static int nTrain=7;  
	//训练样本维度
	static int nInput=3; 
	//学习速率
	static double delta=0.1; 
	//测试样本数量
	static int nTest=1; 
	static int maxItre =100;
	//赋值权重，最后一位是偏移
	static double[] weights={0.0,0.0,0.0,0.4};  
	
	/**
	 * @param input,weight
	 * @return double
	 * @author mingjun
	 * @date 2019/4/21 22:26
	 * @description 计算输出
	 */
	public static double comOutput(int[] input,double[] weight) {
		double sum=0.0;
		for(int i=0;i <nInput;i++){
			sum= sum + (input[i] * weight[i]);
		}
		sum=sum - weight[nInput]*1.0;
		return sum;
	}

	/**
	 * @param output
	 * @return int
	 * @author mingjun
	 * @date 2019/4/21 22:26
	 * @description 分类函数
	 */
	public static int classOutPerceptron(double output)
	{
		if (output >= 0) {
			return 1 ;
		}
		else {
			return -1;
		}
	}
	
	/**
	 * @param perceptionTestUnit,weight
	 * @return int
	 * @author mingjun
	 * @date 2019/4/21 22:26
	 * @description 计算误差
	 */
	public static int comErr(PerceptionTestUnit[] perceptionTestUnit,double[] weight) {
		int err=0,i;
		for(i=0;i<nTrain;i++)
		{
			err = err+ perceptionTestUnit[i].getOutput() - classOutPerceptron(comOutput(perceptionTestUnit[i].getInput(),weight));
		}
		return err;
		
	}
	/**
	 * @param perceptionTestUnit,weight
	 * @return int
	 * @author mingjun
	 * @return 
	 * @throws FileNotFoundException 
	 * @date 2019/4/21 22:26
	 * @description 更新权参数weight
	 */
	public static void updateWeight(String fileName) throws FileNotFoundException {
		//获取样本集
        Scanner in = new Scanner(new FileInputStream(new File(fileName)));
        
        ArrayList<int[]> testInputList = new ArrayList<int[]>();
        ArrayList<Integer> testOutputList = new ArrayList<Integer>(); 
		int i ,j,k,tempResu ;

		int temp;
		int tempCount = 0;
		int[] tempInput = new int[3];
		while(in.hasNext()) {
			temp = in.nextInt();
			if(tempCount<3) {
				tempInput[tempCount] = temp;
			}else if(tempCount == 3) {
				testInputList.add(tempInput);
				testOutputList.add(temp);
			}
			tempCount = tempCount++%4;
		}
		nTrain = testOutputList.size();
		PerceptionTestUnit[] perceptionTestUnit = new PerceptionTestUnit[testOutputList.size()];
		for(int z = 0; z < perceptionTestUnit.length; ++z) {
			perceptionTestUnit[z] = new PerceptionTestUnit(testInputList.get(z), testOutputList.get(z));
		}

		for(k=0;k<maxItre;k++){
			for(i=0;i<nTrain;i++){
				tempResu = classOutPerceptron(comOutput(perceptionTestUnit[i].getInput(),weights));
	
				for (j=0;j<nInput;j++){
					weights[j] = weights[j] + ( delta*(perceptionTestUnit[i].getOutput() - tempResu)*perceptionTestUnit[i].getInput()[j]);
				}
				weights[nInput] = weights[nInput] + delta*(perceptionTestUnit[i].getOutput() - tempResu);
			}
		}
		//System.out.println("weight更新完成");
	}
	/**
	 * @param input
	 * @return int
	 * @author mingjun
	 * @date 2019/4/21 22:26
	 * @description 使用最新的weight计算perception输出
	 */
	public static int comPerc(int[] input) {
		return classOutPerceptron(comOutput(input,weights));
	}
	/**
	 * @author mingjun
	 * @param args
	 * @throws FileNotFoundException
	 * @description 测试
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "./test/PerceptionTestData.txt";
        PerceptionUtil.updateWeight(fileName);
        int[] input = {0,0,0};
        System.out.println(comPerc(input));
	}

}
