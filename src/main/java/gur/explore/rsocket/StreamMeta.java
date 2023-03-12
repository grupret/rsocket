package gur.explore.rsocket;



import java.io.Serializable;

public class StreamMeta implements Serializable {
    private static final long serialVersionUID = -835936196980163629L;
    private String streamId;
    private String type;
    private String component;

    public StreamMeta() {
    }

    public String getStreamId() {
        return this.streamId;
    }

    public String getType() {
        return this.type;
    }

    public String getComponent() {
        return this.component;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof StreamMeta)) {
            return false;
        } else {
            StreamMeta other = (StreamMeta)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$streamId = this.getStreamId();
                    Object other$streamId = other.getStreamId();
                    if (this$streamId == null) {
                        if (other$streamId == null) {
                            break label47;
                        }
                    } else if (this$streamId.equals(other$streamId)) {
                        break label47;
                    }

                    return false;
                }

                Object this$type = this.getType();
                Object other$type = other.getType();
                if (this$type == null) {
                    if (other$type != null) {
                        return false;
                    }
                } else if (!this$type.equals(other$type)) {
                    return false;
                }

                Object this$component = this.getComponent();
                Object other$component = other.getComponent();
                if (this$component == null) {
                    if (other$component != null) {
                        return false;
                    }
                } else if (!this$component.equals(other$component)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof StreamMeta;
    }

    public int hashCode() {
        int result = 1;
        Object $streamId = this.getStreamId();
        result = result * 59 + ($streamId == null ? 43 : $streamId.hashCode());
        Object $type = this.getType();
        result = result * 59 + ($type == null ? 43 : $type.hashCode());
        Object $component = this.getComponent();
        result = result * 59 + ($component == null ? 43 : $component.hashCode());
        return result;
    }

    public String toString() {
        return "StreamMeta(streamId=" + this.getStreamId() + ", type=" + this.getType() + ", component=" + this.getComponent() + ")";
    }
}
