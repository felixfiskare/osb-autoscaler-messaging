package de.cf.autoscaler.kafka.messages;

import de.cf.autoscaler.kafka.protobuf.ProtobufApplicationMetricWrapper.ProtoApplicationMetric;

/**
 * Wrapper class to store information about the state of an application in one period.
 * @author Marius Berger
 *
 */
public class ApplicationMetric implements AutoscalerMetric {

	/**
	 * aggregated CPU value of the period
	 */
	private int cpu;
	/**
	 * aggregated RAM value of the period
	 */
	private long ram;
	/**
	 * number of instances running during the period
	 */
	private int instanceCount;
	/**
	 * aggregated number of requests of the period
	 */
	private int requests;
	/**
	 * aggregated latency value of the period
	 */
	private int latency;
	/**
	 * quotient after the period
	 */
	private int quotient;
	
	/**
	 * epoch point of time of creation of this metric
	 */
	private long timestamp;
	
	/**
	 * id of the related application
	 */
	private String appId;
	/**
	 * name of the related application
	 */
	private String metricName;
	/**
	 * optional description of this metric; will not be used for computation
	 */
	private String description;
	
	/**
	 * Constructor with all fields.
	 * @param cpu {@linkplain #cpu}
	 * @param ram {@linkplain #ram}
	 * @param instanceCount {@linkplain #instanceCount}
	 * @param requests {@linkplain #requests}
	 * @param latency {@linkplain #latency}
	 * @param quotient {@linkplain #quotient}
	 * @param timestamp {@linkplain #timestamp}
	 * @param appId {@linkplain #appId}
	 * @param metricName {@linkplain #metricName}
	 * @param description {@linkplain #description}
	 */
	public ApplicationMetric(int cpu, long ram, int instanceCount, int requests, int latency, int quotient, long timestamp,
			String appId, String metricName, String description) {
		this.cpu = cpu;
		this.ram = ram;
		this.instanceCount = instanceCount;
		this.requests = requests;
		this.latency = latency;
		this.quotient = quotient;
		this.timestamp = timestamp;
		this.appId = appId;
		this.metricName = metricName;
		this.description = description;
	}
	
	/**
	 * Constructor for processing a {@linkplain ProtoApplicationMetric}.
	 * @param proto Protobuf application metric to get fields from
	 */
	public ApplicationMetric(ProtoApplicationMetric proto) {
		this(proto.getCpu(), proto.getRam(), proto.getInstanceCount(), proto.getRequests(), proto.getLatency(), proto.getQuotient(),
				proto.getTimestamp(), proto.getAppId(), proto.getMetricName(), proto.getDescription());
	}
	
	/**
	 * Copy constructor
	 * @param other metric to copy
	 */
	public ApplicationMetric(ApplicationMetric other) {
		this(other.getCpu(), other.getRam(), other.getInstanceCount(), other.getRequests(), other.getLatency(), other.getQuotient(),
				other.getTimestamp(), other.getAppId(), other.getMetricName(), other.getDescription());
	}

	/**
	 * Returns a String representation of the application metric type.
	 */
	@Override
	public String getType() {
		return AutoscalerMetric.TYPE_APPLICATION;
	}

	/**
	 * Throws an {@linkplain InvalidMetricTypeException} as this is not a {@linkplain ContainerMetric}.
	 */
	@Override
	public ContainerMetric getContainerMetric() throws InvalidMetricTypeException {
		throw new InvalidMetricTypeException("This metric is not from type "+AutoscalerMetric.NAME_CONTAINER+".");
	}

	/**
	 * Throws an {@linkplain InvalidMetricTypeException} as this is not a {@linkplain HttpMetric}.
	 */
	@Override
	public HttpMetric getHttpMetric() throws InvalidMetricTypeException {
		throw new InvalidMetricTypeException("This metric is not from type "+AutoscalerMetric.NAME_HTTP+".");
	}
	
	/**
	 * Returns this object.
	 */
	public ApplicationMetric getApplicationMetric() throws InvalidMetricTypeException {
		return this;
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

	public int getInstanceCount() {
		return instanceCount;
	}

	public void setInstanceCount(int instanceCount) {
		this.instanceCount = instanceCount;
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
	
	public int getQuotient() {
		return quotient;
	}

	public void setQuotient(int quotient) {
		this.quotient = quotient;
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
				+ "\"cpu\" : \"" + cpu + "\""
				+ " , "
				+ "\"ram\" : \"" + ram + "\""
				+ " , "
				+ "\"requests\" : \"" + requests + "\""
				+ " , "
				+ "\"latency\" : \"" + latency + "\""
				+ " , "
				+ "\"quotient\" : \"" + quotient + "\""
				+ " , "
				+ "\"instanceCount\" : \"" + instanceCount + "\""
				+ " , "
				+ "\"description\" : \"" + description + "\""
				+ "}";
		return output;
	}
	
	/**
	 * Checks for equality based on {@linkplain #timestamp}, {@linkplain #metricName}, {@linkplain #appId}, {@linkplain #cpu}, 
	 * {@linkplain #ram}, {@linkplain #instanceCount}, {@linkplain #requests}, {@linkplain #quotient} and {@linkplain #latency}.
	 * @param other {@code ApplicationMetric} to check for equality
	 * @return true if the other metric is equal, otherwise returns false
	 */
	public boolean equals(ApplicationMetric other) {
		return timestamp == other.getTimestamp() && metricName.equals(other.getMetricName())  && appId.equals(other.getAppId())
				&& cpu == other.getCpu() && ram == other.getRam() && instanceCount == other.getInstanceCount()
				&& requests == other.getRequests() && latency == other.getLatency() && quotient == other.getQuotient();
	}
}
