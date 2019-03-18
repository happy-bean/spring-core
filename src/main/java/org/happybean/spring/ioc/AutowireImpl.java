package org.happybean.spring.ioc;

import org.happybean.controller.SpringController;
import org.happybean.service.SpringService;
import org.happybean.spring.config.SpringAutowiredConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wgt
 * @date 2019-03-18
 * @description
 **/
public class AutowireImpl implements Autowire {

    @Override
    public void autowired() {
        //加载配置类 此时的配置类等同于xml配置文件
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAutowiredConfig.class);
        SpringController controller = applicationContext.getBean(SpringController.class);
        controller.printService();
        controller.getSpringService2();
        //SpringService service = applicationContext.getBean(SpringService.class);
        //System.out.println((controller.getSpringService() == service));
    }
}
