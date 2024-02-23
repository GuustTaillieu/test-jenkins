package sweetmustard.cronos.hellobe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestHelloBeApplication {

	public static void main(String[] args) {
		SpringApplication.from(HelloBeApplication::main).with(TestHelloBeApplication.class).run(args);
	}

}
