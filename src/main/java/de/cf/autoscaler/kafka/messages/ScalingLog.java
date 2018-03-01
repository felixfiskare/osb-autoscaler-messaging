package de.cf.autoscaler.kafka.messages;

import de.cf.autoscaler.kafka.protobuf.ProtobufScalingLogWrapper.ProtoScalingLog;

/**
 * Entity for logging scaling executions.
 * @author Marius Berger
 *
 */
public class ScalingLog {
	
	public static final int UNDEFINED_BASED = -1;
	public static final int HTTP_REQUEST_BASED = 0;
	public static final int HTTP_LATENCY_BASED = 1;
	public static final int CONTAINER_CPU_BASED = 2;
	public static final int CONTAINER_RAM_BASED = 3;
	public static final int PREDICTOR_BASED = 4;
	public static final int LIMIT_BASED = 5;

	/**
	 * time stamp of the scaling event.
	 */
	private long timestamp;
	/**
	 * ID of the application
	 */
	private String appId;
	/**
	 * Name of the application
	 */
	private String appName;
	/**
	 * index of the component which caused the scaling event
	 */
	private int component;
	
	/**
	 * old instance count of the application
	 */
	private int oldInstances;
	/**
	 * new instance count of the application, the scaling event did try to scale to
	 */
	private int newInstances;
	/**
	 * the current maximum for the instance count
	 */
	private int currentMaxInstanceLimit;
	/**
	 * the current minimum for the instance count
	 */
	private int currentMinInstanceLimit;
	
	/**
	 * current value of CPU
	 */
	private int currentCpuLoad;
	/**
	 * the current maximum for the CPU
	 */
	private int currentCpuUpperLimit;
	/**
	 * the current minimum for the CPU
	 */
	private int currentCpuLowerLimit;

	/**
	 * current value of RAM
	 */
	private long currentRamLoad;
	/**
	 * the current maximum for the RAM
	 */
	private long currentRamUpperLimit;
	/**
	 * the current minimum for the RAM
	 */
	private long currentRamLowerLimit;
	
	/**
	 * the current count of requests
	 */
	private int currentRequestCount;
	
	/**
	 * current value of latency
	 */
	private int currentLatencyValue;
	/**
	 * the current maximum for the latency
	 */
	private int currentLatencyUpperLimit;
	/**
	 * the current minimum for the latency
	 */
	private int currentLatencyLowerLimit;
	
	/**
	 * current value of the quotient
	 */
	private int currentQuotientValue;
	
	/**
	 * description of scaling event
	 */
	private String description;
	
	/**
	 * Constructor for creating a ScalingLog out of a {@linkplain ProtoScaling}.
	 * @param sc {@linkplain ProtoScaling} to get fields from
	 */
	public ScalingLog(ProtoScalingLog sc) {
		this(sc.getTimestamp(),
				sc.getAppId(),
				sc.getResourceName(),
				sc.getComponent(),
				sc.getOldInstances(),
				sc.getNewInstances(),
				sc.getCurrentMaxInstanceLimit(),
				sc.getCurrentMinInstanceLimit(),
				sc.getCurrentCpuLoad(),
				sc.getCurrentCpuUpperLimit(),
				sc.getCurrentCpuLowerLimit(),
				sc.getCurrentRamLoad(),
				sc.getCurrentRamUpperLimit(),
				sc.getCurrentRamLowerLimit(),
				sc.getCurrentRequestCount(),
				sc.getCurrentLatencyValue(),
				sc.getCurrentLatencyUpperLimit(),
				sc.getCurrentLatencyLowerLimit(),
				sc.getCurrentQuotientValue(),
				sc.getDescription());
	}

	/**
	 * Constructor for creating a ScalingLog with fields.
	 * See the docs of each field of this class for more information on the parameters of this constructor.
	 */
	public ScalingLog(long timestamp, String appId, String appName, int component, int oldInstances, int newInstances,
			int currentMaxInstanceLimit, int currentMinInstanceLimit, int currentCpuLoad, int currentCpuUpperLimit,
			int currentCpuLowerLimit, long currentRamLoad, long currentRamUpperLimit, long currentRamLowerLimit,
			int currentRequestCount, int currentLatencyValue, int currentLatencyUpperLimit, int currentLatencyLowerLimit,
			int currentQuotientValue, String description) {

		this.timestamp = timestamp;
		this.appId = appId;
		this.appName = appName;
		this.component = component;
		this.oldInstances = oldInstances;
		this.newInstances = newInstances;
		this.currentMinInstanceLimit = currentMinInstanceLimit;
		this.currentMaxInstanceLimit = currentMaxInstanceLimit;
		this.currentCpuLoad = currentCpuLoad;
		this.currentCpuUpperLimit = currentCpuUpperLimit;
		this.currentCpuLowerLimit = currentCpuLowerLimit;
		this.currentRamLoad = currentRamLoad;
		this.currentRamUpperLimit = currentRamUpperLimit;
		this.currentRamLowerLimit = currentRamLowerLimit;
		this.currentRequestCount = currentRequestCount;
		this.currentLatencyValue = currentLatencyValue;
		this.currentLatencyUpperLimit = currentLatencyUpperLimit;
		this.currentLatencyLowerLimit = currentLatencyLowerLimit;
		this.currentQuotientValue = currentQuotientValue;
		this.description = description;
	}
	
	// --- start getter and setter ---
	
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}
	
	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public int getComponent() {
		return component;
	}

	public void setComponent(int component) {
		this.component = component;
	}

	public int getOldInstances() {
		return oldInstances;
	}

	public void setOldInstances(int oldInstances) {
		this.oldInstances = oldInstances;
	}

	public int getNewInstances() {
		return newInstances;
	}

	public void setNewInstances(int newInstances) {
		this.newInstances = newInstances;
	}

	public int getCurrentMaxInstanceLimit() {
		return currentMaxInstanceLimit;
	}

	public void setCurrentMaxInstanceLimit(int currentMaxInstanceLimit) {
		this.currentMaxInstanceLimit = currentMaxInstanceLimit;
	}

	public int getCurrentMinInstanceLimit() {
		return currentMinInstanceLimit;
	}

	public void setCurrentMinInstanceLimit(int currentMinInstanceLimit) {
		this.currentMinInstanceLimit = currentMinInstanceLimit;
	}

	public int getCurrentCpuLoad() {
		return currentCpuLoad;
	}

	public void setCurrentCpuLoad(int currentCpuLoad) {
		this.currentCpuLoad = currentCpuLoad;
	}

	public int getCurrentCpuUpperLimit() {
		return currentCpuUpperLimit;
	}

	public void setCurrentCpuUpperLimit(int currentCpuUpperLimit) {
		this.currentCpuUpperLimit = currentCpuUpperLimit;
	}

	public int getCurrentCpuLowerLimit() {
		return currentCpuLowerLimit;
	}

	public void setCurrentCpuLowerLimit(int currentCpuLowerLimit) {
		this.currentCpuLowerLimit = currentCpuLowerLimit;
	}

	public long getCurrentRamLoad() {
		return currentRamLoad;
	}

	public void setCurrentRamLoad(long currentRamLoad) {
		this.currentRamLoad = currentRamLoad;
	}

	public long getCurrentRamUpperLimit() {
		return currentRamUpperLimit;
	}

	public void setCurrentRamUpperLimit(long currentRamUpperLimit) {
		this.currentRamUpperLimit = currentRamUpperLimit;
	}

	public long getCurrentRamLowerLimit() {
		return currentRamLowerLimit;
	}

	public void setCurrentRamLowerLimit(long currentRamLowerLimit) {
		this.currentRamLowerLimit = currentRamLowerLimit;
	}

	public int getCurrentRequestCount() {
		return currentRequestCount;
	}

	public void setCurrentRequestCount(int currentRequestCount) {
		this.currentRequestCount = currentRequestCount;
	}

	public int getCurrentLatencyValue() {
		return currentLatencyValue;
	}

	public void setCurrentLatencyValue(int currentLatencyValue) {
		this.currentLatencyValue = currentLatencyValue;
	}

	public int getCurrentLatencyUpperLimit() {
		return currentLatencyUpperLimit;
	}

	public void setCurrentLatencyUpperLimit(int currentLatencyUpperLimit) {
		this.currentLatencyUpperLimit = currentLatencyUpperLimit;
	}

	public int getCurrentLatencyLowerLimit() {
		return currentLatencyLowerLimit;
	}

	public void setCurrentLatencyLowerLimit(int currentLatencyLowerLimit) {
		this.currentLatencyLowerLimit = currentLatencyLowerLimit;
	}

	public int getCurrentQuotientValue() {
		return currentQuotientValue;
	}

	public void setCurrentQuotientValue(int currentQuotientValue) {
		this.currentQuotientValue = currentQuotientValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	// --- end getter and setter ---

	@Override
	public String toString() {
		return "ScalingLog [timestamp=" + timestamp + ", appId=" + appId + ", appName=" + appName + ", component="
				+ component + ", oldInstances=" + oldInstances + ", newInstances=" + newInstances
				+ ", currentMaxInstanceLimit=" + currentMaxInstanceLimit + ", currentMinInstanceLimit="
				+ currentMinInstanceLimit + ", currentCpuLoad=" + currentCpuLoad + ", currentCpuUpperLimit="
				+ currentCpuUpperLimit + ", currentCpuLowerLimit=" + currentCpuLowerLimit + ", currentRamLoad="
				+ currentRamLoad + ", currentRamUpperLimit=" + currentRamUpperLimit + ", currentRamLowerLimit="
				+ currentRamLowerLimit + ", currentRequestCount=" + currentRequestCount + ", currentLatencyValue="
				+ currentLatencyValue + ", currentLatencyUpperLimit=" + currentLatencyUpperLimit
				+ ", currentLatencyLowerLimit=" + currentLatencyLowerLimit + ", currentQuotientValue="
				+ currentQuotientValue + ", description=" + description + "]";
	}
}
