package ao.nosp.monitoringapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MonitoringapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitoringapiApplication.class, args);
	}

}
