package work.chenc.indevent;

import cn.dev33.satoken.SaTokenManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@MapperScan(basePackages = { "work.chenc.*.mapper" })
public class IndeventApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndeventApplication.class, args);
		System.out.println("启动成功：sa-token配置如下：" + SaTokenManager.getConfig());
	}

}
