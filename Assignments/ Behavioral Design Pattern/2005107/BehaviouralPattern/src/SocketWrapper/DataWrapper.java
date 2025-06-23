package SocketWrapper;

import java.io.Serializable;
import java.security.PublicKey;

public class DataWrapper implements Serializable {
    public String command;
    public Object data;
    public DataWrapper(String command, Object data) {
        this.command = command;
        this.data = data;
    }
}
