package de.cf.autoscaler.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * A bean for storing properties dedicated to Kafka.
 * Spring fills the fields at the start of the Autoscaler with values out of the properties file.
 * @author Marius Berger
 *
 */
@Service
public class KafkaPropertiesBean {

	/**
	 * IP or URL of the Kafka host
	 */
	@Value("${kafka.host}")
	private String host;
	
	/**
	 * Port to connect to Kafka
	 */
	@Value("${kafka.port}")
	private int port;
	
	/**
	 * Topic for HTTP metrics
	 */
	@Value("${kafka.metric_http_topic}")
	private String metricHttpTopic;
	
	/**
	 * Topic for Container metrics
	 */
	@Value("${kafka.metric_container_topic}")
	private String metricContainerTopic;
	
	/**
	 * Topic for Application metrics
	 */
	@Value("${kafka.metric_application_topic}")
	private String metricApplicationTopic;
	
	/**
	 * Topic for Scaling logs
	 */
	@Value("${kafka.scaling_topic}")
	private String scalingTopic;
	
	/**
	 * Topic for predictions
	 */
	@Value("${kafka.predic_topic}")
	private String predicTopic;

	/**
	 * Topic for binding notifications
	 */
	@Value("${kafka.binding_topic}")
	private String bindingTopic;
	
	/**
	 * Count of Container consumers to start
	 */
	@Value("${kafka.container_consumer_count}")
	private int containerConsumerCount;
	
	/**
	 * Count of HTTP consumers to start
	 */
	@Value("${kafka.request_consumer_count}")
	private int requestConsumerCount;
	
	/**
	 * Id of the group for producers
	 */
	@Value("${kafka.producer_groupId}")
	private String producerGroupId;
	
	/**
	 * Id of the group for Container consumers
	 */
	@Value("${kafka.container_consumer_groupId}")
	private String containerConsumerGroupId;
	
	/**
	 * Id of the group for HTTP consumers
	 */
	@Value("${kafka.http_consumer_groupId}")
	private String httpConsumerGroupId;
	
	/**
	 * Id of the group for prediction consumers
	 */
	@Value("${kafka.prediction_consumer_groupId}")
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