package passwordchanger;

import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;

public class Session {

    public Session(String username, String host, String password) {
        this.username = username;
        this.host = host;
        this.password = password;
    }

    String username;
    String host;
    String password;
    com.jcraft.jsch.Session session;
    ChannelShell channel;

    public void connect() {

        try {
            JSch jsch = new JSch();
            session = jsch.getSession(username, host, 3022);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");

            session.connect();

            // Open a shell channel to send multiple commands
            channel = (ChannelShell) session.openChannel("shell");
            channel.connect();
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        channel.disconnect();
        session.disconnect();
        System.out.println("disconnected");
    }

    public ChannelShell getChannel() {
        return channel;
    }
}
