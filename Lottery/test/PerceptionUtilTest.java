import lottery.util.PerceptionUtil;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @param args
 * @return void
 * @author mingjun
 * @date 2019/4/21 22:26
 * @description 单类测试
 */
public class PerceptionUtilTest {
	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "Lottery/test/PerceptionTestData.txt";
        PerceptionUtil.updateWeight(fileName);
	}
}





