package io.pivotal.example.stream.elasticsearch.sink;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.validation.annotation.Validated;


import static org.springframework.integration.handler.LoggingHandler.Level.INFO;

@ConfigurationProperties("elasticsearch")
@Validated
public class ElasticsearchSinkProperties {

	private String expression = "payload";
	private String url="es-kibana.pcf-demo.net:9200";

	/**
	 * The level at which to log messages.
	 */
	private LoggingHandler.Level level = INFO;


	@NotBlank
	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	@NotBlank
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	@NotNull
	public LoggingHandler.Level getLevel() {
		return level;
	}

	public void setLevel(LoggingHandler.Level level) {
		this.level = level; 
	}		
	
	
}
