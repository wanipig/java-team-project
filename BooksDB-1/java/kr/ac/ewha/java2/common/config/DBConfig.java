package kr.ac.ewha.java2.common.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration // WebConfiguration 클래스를 설정 클래스로 지정
@PropertySource("classpath:/application.properties") // 외부 설정 파일의 위치 저장
public class DBConfig {
	@Bean // Bean이 붙은 메서드들은 Spring 컨테이너에 객체를 등록 
	@ConfigurationProperties(prefix="spring.datasource.hikari") // @Bean이 반환하는 객체에 외부 설정 파일의 값들을 주입
	// DB 접속 위해 필요한 모든 정보를 담는 설정 객체 만들기
	public HikariConfig hikariConfig() { 
		return new HikariConfig();
	}
	
	@Bean // 실제 DB 연결 풀 객체를 생성하고 반환. 이 객체를 통해 DB에 접속
	public DataSource dataSource() throws Exception{
		System.out.println("시작!");
		DataSource dataSource = new HikariDataSource(hikariConfig());
		return dataSource;
	}
}
