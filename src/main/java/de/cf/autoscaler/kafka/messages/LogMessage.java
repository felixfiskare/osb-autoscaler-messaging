package de.cf.autoscaler.kafka.messages;

import de.cf.autoscaler.kafka.protobuf.ProtobufLogMessageWrapper;

/**
 * Created by reneschollmeyer, evoila on 07.03.18.
 */
public class LogMessage {

    private long timestamp;
    private String logMessage;
    private String logMessageType;
    private String appId;

    public LogMessage(ProtobufLogMessageWrapper.ProtoLogMessage protoLogMessage) {
        this(protoLogMessage.getTimestamp(), protoLogMessage.getLogMessage(),
                protoLogMessage.getLogMessageType(), protoLogMessage.getAppId());
    }

    public LogMessage(LogMessage other) {
        this(other.getTimestamp(), other.getLogMessage(), other.getLogMessageType(),
                other.getAppId());
    }

    public LogMessage(long timestamp, String logMessage, String logMessageType, String appId) {
        this.timestamp = timestamp;
        this.logMessage = logMessage;
        this.logMessageType = logMessageType;
        this.appId = appId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public String getLogMessageType() {
        return logMessageType;
    }

    public void setLogMessageType(String logMessageType) {
        this.logMessageType = logMessageType;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

}
