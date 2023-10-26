package jaeh.decoratorspring;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

@ConfigurationPropertiesScan(basePackages={"jaeh.decoratorspring.config.properties"})
@SpringBootApplication
@RequiredArgsConstructor
public class DecoratorSpringApplication {
	private final ApplicationContext context;
	public static void main(String[] args) {
		SpringApplication.run(DecoratorSpringApplication.class, args);
		BeanContext.get(ClientService.class).callService();
	}
	@PostConstruct
	public void init(){
		BeanContext.init(context);
	}
}
