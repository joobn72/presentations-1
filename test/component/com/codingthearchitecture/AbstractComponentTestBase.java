package com.codingthearchitecture;

import com.codingthearchitecture.component.presentations.PresentationsComponent;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AbstractComponentTestBase {

    protected static ApplicationContext applicationContext;

    @BeforeClass
    public static void loadApplicationContext() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    protected static PresentationsComponent getPresentationsComponent() {
        return (PresentationsComponent)applicationContext.getBean("presentationsComponent");
    }

}
