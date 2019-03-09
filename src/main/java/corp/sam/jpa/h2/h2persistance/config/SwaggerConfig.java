package corp.sam.jpa.h2.h2persistance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Tag;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() { 
		return new Docket(DocumentationType.SWAGGER_2)
				.select()                                  
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.tags(
						new Tag("Projects Service", "Manages all the operations related to projects at account level"),
						new Tag("Task Service", "Manages all the operations related to tasks at account level")) ;                                           
	}

	@Bean
	public Docket tasks() { 
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("tasks")
				.select()                                  
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/tasks/**"))
				.build()
				.tags(
						new Tag("Task Service", "Manages all the operations related to tasks at account level")) ;                                           
	}
	
	@Bean
	public Docket projects() { 
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("projects")
				.select()                                  
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/projects/**"))
				.build()
				.tags(
						new Tag("Projects Service", "Manages all the operations related to projects at account level")
						) ;                                           
	}
	
}
