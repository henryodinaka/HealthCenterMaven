/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package health.center.config;

import com.sun.faces.config.FacesInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException; 
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext; 

/**
 *
 * @author LEOGOLD
 */
public class HealthCenterInitializer extends FacesInitializer implements WebApplicationInitializer{

    public void onStartup(ServletContext sc) throws ServletException {
        
        AnnotationConfigWebApplicationContext annotationCfg = new AnnotationConfigWebApplicationContext();
        annotationCfg.setConfigLocation("health.center.config"); //register(MovieConfiguration.class,HibernateConfig.class);
        sc.addListener(new ContextLoaderListener(annotationCfg));
      
    }
    
}
