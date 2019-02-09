
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.fragmadata.IplProblem.service.IPLService;

@ComponentScan(basePackages = "com")
@SpringBootApplication
@EntityScan("com")
@PropertySource("classpath:application.properties")
public class IplProblemApplication implements CommandLineRunner {
	@Autowired
	private IPLService iplService;

	public static void main(String[] args) throws Exception {

		SpringApplication app = new SpringApplication(IplProblemApplication.class);
		app.run(args);

		/*
		 * new SpringApplicationBuilder(Application.class) .web(WebApplicationType.NONE)
		 * // .REACTIVE, .SERVLET .run(args);
		 *
		 * ApplicationContext ctx = SpringApplication.run(IplProblemApplication.class,
		 * args); IPLService bean = ctx.getBean(IPLService.class); bean.getResponse();
		 */

	}

	@Bean
	public IPLService getHelloService() {
		return new IPLService();
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(iplService.getResponse());
		System.out.println("Question : 1");
		System.out.println(iplService.getQuestion1Response());
		System.out.println("Question : 2");
		System.out.println(iplService.getQuestion2Response());
		System.out.println("Question : 3");
		System.out.println(iplService.getQuestion3Response());
		System.out.println("Question : 4");
		System.out.print(iplService.getQuestion4Response());

		// getHelloService().hello();
		// TODO Auto-generated method stub
		// System.out.println("Spring boot standalone application is working...");
	}

}
