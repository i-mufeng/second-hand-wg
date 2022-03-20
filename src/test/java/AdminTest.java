import com.wuguan.dto.Admin;
import com.wuguan.dto.ResMod;
import com.wuguan.serviceImp.AdminServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author MFMG
 * @data 2022/01/14 20:27
 * @description
 */
public class AdminTest {
    /**
     * 管理员用户登录的测试类
     */
    @Test
    void testLogAdmin() {
        System.out.println("******Admin用户登录测试******");
        Admin admin = new Admin();
        admin.setName("admin");
        admin.setPassWord("admin");
        System.out.println("用于测试的值\n\t--name："+admin.getName()+"\n\t--passWord:"+admin.getPassWord());
        AdminServiceImpl asi = new AdminServiceImpl();
        ResMod resMod = asi.log(admin);
        Assertions.assertEquals(0, resMod.getCode());
        System.out.println(resMod.getMsg() + "返回值为：" + resMod.getCode());
        System.out.println("******Admin测试完毕******\n");
    }
}
