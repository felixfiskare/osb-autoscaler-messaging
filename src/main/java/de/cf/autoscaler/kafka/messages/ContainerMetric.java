package de.cf.autoscaler.kafka.messages;

import de.cf.autoscaler.kafka.protobuf.ProtobufContainerMetricWrapper.ProtoContainerMetric;

/**
 * Wrapper class to store information about the state of an instance.
 * @author Marius Berger
 *
 */
public class ContainerMetric implements AutoscalerMetric{
	
	private int cpu;
	private long ram;
	private int instanceIndex;
	
	private long timestamp;
	
	private String appId;
	private String metricName;
	private String description;
	
	
	/**
	 * Constructor for processing a {@linkplain ProtoContainerMetric}.
	 * @param metric Protobuf container metric to get fields from
	 */
	public ContainerMetric(ProtoContainerMetric metric) {
		this(metric.getTimestamp(), metric.getMetricName(), metric.getAppId()
				, metric.getCpu(), metric.getRam(), metric.getInstanceIndex()
				, metric.getDescription());
	}
	
	/**
	 * Constructor with all fields.
	 * @param timestamp {@linkplain #timestamp}
	 * @param metricName {@linkplain #metricName}
	 * @param appId {@linkplain #appId}
	 * @param cpu {@linkplain #cpu}
	 * @param ram {@linkplain #ram}
	 * @param instanceIndex {@linkplain #instanceIndex}
	 * @param description {@linkplain #description}
	 */
	public ContainerMetric(long timestamp, String metricName, String appId, int cpu, long ram, int instanceIndex,
			String description) {
		this.timestamp = timestamp;
		this.metricName = metricName;
		this.appId = appId;
		this.cpu = cpu;
		this.ram = ram;
		this.instanceIndex = instanceIndex;
		this.description = description;
	}
	
	/**
	 * Copy constructor
	 * @param other metric to copy
	 */
	public ContainerMetric(ContainerMetric other) {
		this(other.getTimestamp(), other.getMetricName(), other.getAppId(), other.getCpu()
				, other.getRam(), other.getInstanceIndex(), other.getDescription());
	}

	/**
	 * Returns a String representation of the container metric type.
	 */
	@Override
	public String getType() {
		return AutoscalerMetric.TYPE_CONTAINER;
	}

	/**
	 * Returns this object.
	 */
	@Override
	public ContainerMetric getContainerMetric() {
		return this;
	}

	/**
	 * Throws an {@linkplain InvalidMetricTypeException} as this is not a {@linkplain HttpMetric}.
	 */
	@Override
	public HttpMetric getHttpMetric() throws InvalidMetricTypeException {
		throw new InvalidMetricTypeException("This metric is not from type "+AutoscalerMetric.NAME_HTTP+".");
	}
	 
	/**
	 * Throws an {@linkplain InvalidMetricTypeException} as this is not a {@linkplain ApplicationMetric}.
	 */
	@Override
	public ApplicationMetric getApplicationMetric() throws InvalidMetricTypeException {
		throw new InvalidMetricTypeException("This metric is not from type "+AutoscalerMetric.NAME_APPLICATION+".");
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

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public int getCpu() {
		return cpu;
	}

	public void setCpu(int cpu) {
		this.cpu = cpu;
	}

	public long getRam() {
		return ram;
	}

	public void setRam(long ram) {
		this.ram = ram;
	}

	public int getInstanceIndex() {
		return instanceIndex;
	}

	public void setInstanceIndex(int instanceIndex) {
		this.instanceIndex = instanceIndex;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
				+ "\"cpu\" : \"" + cpu + "\""
				+ " , "
				+ "\"ram\" : \"" + ram + "\""
				+ " , "
				+ "\"instanceIndex\" : \"" + instanceIndex + "\""
				+ " , "
				+ "\"description\" : \"" + description + "\""
				+ "}";
		return output;
	}
	
	/**
	 * Checks for equality based on {@linkplain #timestamp}, {@linkplain #metricName}, {@linkplain #appId}, {@linkplain #cpu}, 
	 * {@linkplain #ram} and {@linkplain #instanceIndex}.
	 * @param other {@code ContainerMetric} to check for equality
	 * @return true if the other metric is equal, otherwise returns false
	 */
	public boolean equals(ContainerMetric other) {
		return (timestamp == other.getTimestamp()) && (metricName.equals(other.getMetricName()))  && (appId.equals(other.getAppId()))
				&& (cpu == other.getCpu()) && (ram == other.getRam()) && (instanceIndex == other.getInstanceIndex());
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
