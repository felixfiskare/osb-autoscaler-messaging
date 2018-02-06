package de.cf.autoscaler.kafka.messages;

/**
 * Exception to indicate a false metric type.
 * @author Marius Berger
 * @see AutoscalerMetric
 * @see Exception
 */
public class InvalidMetricTypeException extends Exception {

	private static final long serialVersionUID = -2299841370802201313L;

	public InvalidMetricTypeException() {
		super();
	}
	
	public InvalidMetricTypeException(String message) {
		super(message);
	}
}
