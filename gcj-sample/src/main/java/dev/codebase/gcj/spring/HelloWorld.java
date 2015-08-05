package dev.codebase.gcj.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloWorld {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);
    
    public static void main(String[] args) {
        
        FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(args);
        
        // Lookup by bean id
        GreeterService g = (GreeterService) ctx.getBean("helloWorldGreeter");
        LOGGER.info(g.provideGreeting());
        
        // Lookup by interface type...
        // ...not possible now more than 1 bean of required type in context
        //g = ctx.getBean(GreeterService.class);
        //LOGGER.info(g.provideGreeting());
        
        // Lookup by bean id and interface type
        g = ctx.getBean("helloWorldGreeter", GreeterService.class);
        LOGGER.info(g.provideGreeting());
        
        ctx.close();
    }
}