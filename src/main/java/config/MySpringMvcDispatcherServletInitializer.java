package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                DemoAppConfig.class,
                ResourceHandlerConfig.class //add resources path
        };
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
