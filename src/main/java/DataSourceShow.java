import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @auther SyntacticSugar
 * @data 2019/3/27 0027下午 11:20
 */


@Component
public class DataSourceShow  implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        DataSource bean = applicationContext.getBean(DataSource.class);
        System.out.println("bean = " + bean.getClass().getName());
    }
}
