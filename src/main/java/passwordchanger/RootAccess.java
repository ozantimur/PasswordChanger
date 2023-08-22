package passwordchanger;

public class RootAccess {
    public void root(String rootPassword, Session session) {

        SSHSendCommand sshSendCommand = new SSHSendCommand();

        try {
            // Send 'su' command
            sshSendCommand.sendCommand(session.getChannel(), "su");

            // Send root password
            sshSendCommand.sendCommand(session.getChannel(), rootPassword);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("root accessed");

    }
}
