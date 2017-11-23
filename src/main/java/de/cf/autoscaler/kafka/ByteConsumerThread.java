package de.cf.autoscaler.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Thread subscribing to a Kafka topic and returning messages in byte form to its consumer.
 * @author Marius Berger
 *
 */
public class ByteConsumerThread extends Thread{
	
	/** 
	 * Serial number for thread naming purposes.
	 */
    private static int serial = 1;
	
    /**
     * Logger of this class.
     */
	private Logger log = LoggerFactory.getLogger(ByteConsumerThread.class);
	
	/**
	 * Topic to subscribe to.
	 */
	private String topicName;
    /**
     * Id of the group to join.
     */
	private String groupId;
    /**
     * IP or URL of the host plus the port.
     */
    private String host;
    
    /**
     * Consumer of incoming messages. For every message, the consumers consume method will be called.
     * @see AutoScalerConsumer
     */
    private AutoScalerConsumer consumer;
    /**
     * Underlying KafkaConsumer for connection to Kafka.
     */
    private KafkaConsumer<String,byte[]> kafkaConsumer;
    
    /**
     * Constructor with all necessary fields.
     * @param topicName {@linkplain #topicName}
     * @param groupId {@linkplain #groupId}
     * @param hostname {@linkplain #host}
     * @param port {@linkplain #host}
     * @param consumer {@linkplain #consumer}
     */
    public ByteConsumerThread(String topicName, String groupId, String hostname, int port, AutoScalerConsumer consumer){
    	super("CThr "+(serial++)+" - "+consumer.getType());
        this.topicName = topicName;
        this.groupId = groupId;
        this.host = hostname +":"+ port;
        this.consumer = consumer;
    }
    
    /**
     * Create a Kafka Consumer and start polling for messages until a wake up call on the Kafka Consumer is made.
     * @see KafkaConsumer
     */
    public void run() {
    	
        Properties configProperties = new Properties();
        configProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, host);
        configProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        configProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        configProperties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        //configProperties.put(ConsumerConfig.CLIENT_ID_CONFIG, "simple");

        kafkaConsumer = new KafkaConsumer<String, byte[]>(configProperties);
        kafkaConsumer.subscribe(Arrays.asList(topicName));

        try {
            while (true) {
                ConsumerRecords<String, byte[]> records = kafkaConsumer.poll(100);
                for (ConsumerRecord<String, byte[]> record : records) {
                	consumer.consume(record.value());
                }
            }
        } catch(WakeupException ex) {
        } finally {
            kafkaConsumer.close();
            log.info("Closed the KafkaConsumer "+Thread.currentThread().getName()+".");
        }
    }
    
    /**
     * Returns the underlying Kafka Consumer mainly for waking it up.
     * @return Kafka Consumer of this thread
     * @see KafkaConsumer
     */
    public KafkaConsumer<String,byte[]> getKafkaConsumer(){
       return this.kafkaConsumer;
    }
}

