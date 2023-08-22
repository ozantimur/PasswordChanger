package passwordchanger;

import com.jcraft.jsch.ChannelShell;

import java.io.OutputStream;

public class SSHSendCommand {
    public static void sendCommand(ChannelShell channel, String command) throws Exception {
        ChannelShell channelShell = channel;

        OutputStream out = channelShell.getOutputStream();
        out.write((command + "\n").getBytes());
        out.flush();
        Thread.sleep(100);
    }
}
