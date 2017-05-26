package com.skipper.helper.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ApplicationContext的帮助类 自动装载ApplicationContext.
 * <p>
 * Created by shoujian on 2017/5/12.
 */
@Component
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext context;

    /*
     * 注入ApplicationContext
	 */
    @Override
    public void setApplicationContext(final ApplicationContext context) throws BeansException {
        SpringContext.context = context;
    }

    public static Object getBean(final String beanName) {
        return SpringContext.context.getBean(beanName);
    }

    public static Object getBean(final Class<?> clz) {
        return context.getBean(clz);
    }

}
