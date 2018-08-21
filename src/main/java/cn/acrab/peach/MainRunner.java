package cn.acrab.peach;

import cn.acrab.peach.aop.Log;
import cn.acrab.peach.autoconfig.Computer;
import cn.acrab.peach.conditional.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainRunner implements CommandLineRunner {
    @Autowired
    private Computer computer;

    @Autowired
    private BeanFactory beanFactory;

    Logger log= LoggerFactory.getLogger(MainRunner.class);

    @Override
    public void run(String... args) throws Exception {
        testAutoConfig();
        testAutowiredConditional();
    }

    // 测试根据配置文件注入实体类
    public void testAutoConfig(){
        log.info(computer.buy());
    }

    // 测试按条件装配
    public void testAutowiredConditional(){
        Factory factory=beanFactory.getBean(Factory.class);
        factory.createProduct();
    }
}
