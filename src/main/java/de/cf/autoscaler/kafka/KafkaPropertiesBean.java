package de.cf.autoscaler.kafka;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * A bean for storing properties dedicated to Kafka.
 * Spring fills the fields at the start of the Autoscaler with values out of the properties file.
 * @author Marius Berger
 *
 */
@ConfigurationProperties(prefix = "kafka")
public class KafkaPropertiesBean {

	/**
	 * IP or URL of the Kafka host
	 */
	private String host;
	
	/**
	 * Port to connect to Kafka
	 */
	private int port;
	
	/**
	 * Topic for HTTP metrics
	 */
	private String metricHttpTopic;
	
	/**
	 * Topic for Container metrics
	 */
	private String metricContainerTopic;
	
	/**
	 * Topic for Application metrics
	 */
	private String metricApplicationTopic;
	
	/**
	 * Topic for Scaling logs
	 */
	private String scalingTopic;
	
	/**
	 * Topic for predictions
	 */
	private String predicTopic;

	/**
	 * Topic for binding notifications
	 */
	private String bindingTopic;
	
	/**
	 * Count of Container consumers to start
	 */
	private int containerConsumerCount;
	
	/**
	 * Count of HTTP consumers to start
	 */
	private int requestConsumerCount;
	
	/**
	 * Id of the group for producers
	 */
	private String producerGroupId;
	
	/**
	 * Id of the group for Container consumers
	 */
	private String containerConsumerGroupId;
	
	/**
	 * Id of the group for HTTP consumers
	 */
	private String httpConsumerGroupId;
	
	/**
	 * Id of the group for prediction consumers
	 */
	private String predictionConsumerGroupId;

	/**
	 * Constructor for Spring to inject the bean.
	 */
	public KafkaPropertiesBean() { }
	

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public String getPredicTopic() {
		return predicTopic;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setPredicTopic(String predicTopic) {
		this.predicTopic = predicTopic;
	}

	public String getMetricHttpTopic() {
		return metricHttpTopic;
	}

	public void setMetricHttpTopic(String metricHttpTopic) {
		this.metricHttpTopic = metricHttpTopic;
	}

	public String getMetricContainerTopic() {
		return metricContainerTopic;
	}

	public void setMetricContainerTopic(String metricContainerTopic) {
		this.metricContainerTopic = metricContainerTopic;
	}
	
	public String getMetricApplicationTopic() {
		return metricApplicationTopic;
	}

	public void setMetricApplicationTopic(String metricApplicationTopic) {
		this.metricApplicationTopic = metricApplicationTopic;
	}

	public String getScalingTopic() {
		return scalingTopic;
	}

	public void setScalingTopic(String scalingTopic) {
		this.scalingTopic = scalingTopic;
	}

	public String getBindingTopic() {
		return bindingTopic;
	}

	public void setBindingTopic(String bindingTopic) {
		this.bindingTopic = bindingTopic;
	}

	public int getContainerConsumerCount() {
		return containerConsumerCount;
	}

	public void setContainerConsumerCount(int containerConsumerCount) {
		this.containerConsumerCount = containerConsumerCount;
	}

	public int getRequestConsumerCount() {
		return requestConsumerCount;
	}

	public void setRequestConsumerCount(int requestConsumerCount) {
		this.requestConsumerCount = requestConsumerCount;
	}

	public String getProducerGroupId() {
		return producerGroupId;
	}

	public void setProducerGroupId(String producerGroupId) {
		this.producerGroupId = producerGroupId;
	}


	public String getContainerConsumerGroupId() {
		return containerConsumerGroupId;
	}

	public void setContainerConsumerGroupId(String containerConsumerGroupId) {
		this.containerConsumerGroupId = containerConsumerGroupId;
	}

	public String getHttpConsumerGroupId() {
		return httpConsumerGroupId;
	}

	public void setHttpConsumerGroupId(String httpConsumerGroupId) {
		this.httpConsumerGroupId = httpConsumerGroupId;
	}
	
	public String getPredictionConsumerGroupId() {
		return predictionConsumerGroupId;
	}
	
	public void setPredictionConsumerGroupId(String predictionConsumerGroupId) {
		this.predictionConsumerGroupId = predictionConsumerGroupId;
	}
}