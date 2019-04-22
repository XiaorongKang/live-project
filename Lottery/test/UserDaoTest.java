import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import lottery.dao.UserDao;
import lottery.util.TextUtil;
import org.junit.jupiter.api.Test;

public class UserDaoTest {

    /**
     * @author Oirving
     * @date 2019/4/22 18:32
     * @param args
     * @return void
     * @description 提取用户列表测试
     */
    @Test
	public static void main(String [] args) throws IOException, SQLException {
        UserDao user=new UserDao();
        user.setUser();
    }
}
