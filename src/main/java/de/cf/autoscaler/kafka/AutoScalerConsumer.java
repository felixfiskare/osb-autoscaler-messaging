package de.cf.autoscaler.kafka;

/**
 * Interface for Consumer to read messages from the message broker.
 * @author Marius Berger
 *
 */
public interface AutoScalerConsumer {
	
	/**
	 * String representation of {@code HttpMetric} messages.
	 */
	public static final String TYPE_METRIC_HTTP = "metric_http";
	
	/**
	 * String representation of {@code ContainerMetric} messages.
	 */
	public static final String TYPE_METRIC_CONTAINER = "metric_container";
	
	/**
	 * String representation of {@code Prediction} messages.
	 */
	public static final String TYPE_PREDICTION = "prediction";

	/**
	 * Consume a message from the message broker
	 * @param bytes message in byte from
	 */
	public void consume(byte[] bytes);
	
	/**
	 * Start the consumer.
	 */
	public void startConsumer();
	
	/**
	 * Stop the consumer.
	 */
	public void stopConsumer();
	
	/**
	 * Return the type of message the consumer is consuming.
	 * @return String representation of the type of the message
	 */
	public String getType();
}
