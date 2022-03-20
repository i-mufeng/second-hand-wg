import com.wuguan.dto.Classer;
import com.wuguan.dto.ResMod;
import com.wuguan.serviceImp.ClasserServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MFMG
 * @data 2022/01/15 10:02
 * @description 班级测试
 */
public class ClasserTest {
    @Test
    public void addClasser() {
        System.out.println("******添加班级测试******");
        Classer classer = new Classer();
        classer.setClassId(206);
        classer.setClassName("形体十班");
        System.out.println("用于测试的值\n\t--id："+classer.getClassId()+"\n\t--name:"+classer.getClassName());
        ClasserServiceImpl service = new ClasserServiceImpl();
        ResMod resMod = service.add(classer);
        Assertions.assertEquals(1, resMod.getCode());
        System.out.println(resMod.getMsg() + ",返回值为：" + resMod.getCode());
    }

    @Test
    public void showClasss() {
        System.out.println("******查看班级测试******");
        ResMod resMod;
        ClasserServiceImpl service = new ClasserServiceImpl();
        resMod = service.findAll();
        List<Classer> classers = new ArrayList<Classer>();
        classers.addAll((List<Classer>) resMod.getData());
        System.out.println("所有班级信息：");
        for (Classer c : classers) {
            System.out.println("\t"+c.toString());
        }
    }

    @Test
    public void delClasser() {
        System.out.println("******删除班级测试******");
        int id = 202;
        System.out.println("删除id为：" + id + "的班级");
        ClasserServiceImpl service = new ClasserServiceImpl();
        ResMod resMod = service.delById(id);
        System.out.println(resMod.getMsg());
        Assertions.assertEquals(1, resMod.getCode());
        showClasss();
    }


    @Test
    public void updateClasser() {
        System.out.println("******更新测试开始******");
        Classer classer = new Classer(206,"健美一班");
        System.out.println("测试数据：" + classer);
        ClasserServiceImpl service = new ClasserServiceImpl();
        ResMod resMod = service.update(classer);
        System.out.println(resMod.getMsg());
        Assertions.assertEquals(1, resMod.getCode());
    }
}
