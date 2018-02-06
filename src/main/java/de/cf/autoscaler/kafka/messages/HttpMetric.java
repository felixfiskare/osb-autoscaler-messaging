package de.cf.autoscaler.kafka.messages;

import de.cf.autoscaler.kafka.protobuf.ProtobufHttpMetricWrapper.ProtoHttpMetric;

/**
 * Wrapper class to store information about the http requests of an application.
 * @author Marius Berger
 *
 */
public class HttpMetric implements AutoscalerMetric{
	
	private int requests;
	private int latency;
	
	private long timestamp;
	
	private String appId;
	private String metricName;
	private String description;
	
	
	/**
	 * Constructor for processing a {@linkplain ProtoHttpMetric}.
	 * @param metric Protobuf http metric to get fields from
	 */
	public HttpMetric(ProtoHttpMetric metric) {
		this(metric.getTimestamp(), metric.getMetricName(), metric.getAppId(), metric.getRequests(), metric.getLatency(), metric.getDescription());
	}
	
	/**
	 * Constructor with all fields.
	 * @param timestamp {@linkplain #timestamp}
	 * @param metricName {@linkplain #metricName}
	 * @param appId {@linkplain #appId}
	 * @param requests {@linkplain #requests}
	 * @param latency {@linkplain #latency}
	 * @param description {@linkplain #description}
	 */
	public HttpMetric(long timestamp, String metricName, String appId, int requests, int latency, String description) {
		this.timestamp = timestamp;
		this.metricName = metricName;
		this.appId = appId;
		this.requests = requests;
		this.latency = latency;
		this.description = description;
	}
	
	/**
	 * Copy constructor
	 * @param other metric to copy
	 */
	public HttpMetric(HttpMetric other) {
		this(other.getTimestamp(), other.getMetricName(), other.getAppId(), other.getRequests()
				, other.getLatency(), other.getDescription());
	}
	
	/**
	 * Returns a String representation of the http metric type.
	 */
	@Override
	public String getType() {
		return AutoscalerMetric.TYPE_HTTP;
	}

	/**
	 * Throws an {@linkplain InvalidMetricTypeException} as this is not a {@linkplain ContainerMetric}.
	 */
	@Override
	public ContainerMetric getContainerMetric() throws InvalidMetricTypeException {
		throw new InvalidMetricTypeException("This metric is not from type "+AutoscalerMetric.NAME_CONTAINER+".");
	}
	
	/**
	 * Throws an {@linkplain InvalidMetricTypeException} as this is not a {@linkplain ApplicationMetric}.
	 */
	@Override
	public ApplicationMetric getApplicationMetric() throws InvalidMetricTypeException {
		throw new InvalidMetricTypeException("This metric is not from type "+AutoscalerMetric.NAME_APPLICATION+".");
	}

	/**
	 * Returns this object.
	 */
	@Override
	public HttpMetric getHttpMetric() {
		return this;
	}
	
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMetricName() {
		return metricName;
	}

	public void setMetricName(String metricName) {
		this.metricName = metricName;
	}

	public int getRequests() {
		return requests;
	}

	public void setRequests(int requests) {
		this.requests = requests;
	}

	public int getLatency() {
		return latency;
	}

	public void setLatency(int latency) {
		this.latency = latency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * Creates and returns a String representation of this metric, mostly used for debugging.
	 */
	@Override
	public String toString() {
		String output = "{"
				+ "\"timestamp\" : \"" + timestamp + "\""
				+ " , "
				+ "\"metricName\" : \"" + metricName + "\""
				+ " , "
				+ "\"appId\" : \"" + appId + "\""
				+ " , "
				+ "\"requests\" : \"" + requests + "\""
				+ " , "
				+ "\"latency\" : \"" + latency + "\""
				+ " , "
				+ "\"description\" : \"" + description + "\""
				+ "}";
		return output;
	}
	
	/**
	 * Checks for equality based on {@linkplain #timestamp}, {@linkplain #metricName}, {@linkplain #appId} and {@linkplain #requests}, 
	 * {@linkplain #latency}.
	 * @param other {@code ContainerMetric} to check for equality
	 * @return true if the other metric is equal, otherwise returns false
	 */
	public boolean equals(HttpMetric other) {
		return (timestamp == other.getTimestamp()) && (metricName.equals(other.getMetricName()))  && (appId.equals(other.getAppId()))
				&& (requests == other.getRequests()) && (latency == other.getLatency());
	}
	
	/**
	 * Checks whether this metric is older than the maximum age a metric is allowed to have.
	 * @param maxMetricAge maximum age allowed to have
	 * @return true if this metric is younger than the maximum age
	 */
	public boolean isTooOld(long maxMetricAge) {
		return System.currentTimeMillis() - getTimestamp() > maxMetricAge;
	}
}
