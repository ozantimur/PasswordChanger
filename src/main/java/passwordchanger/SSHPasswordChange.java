package passwordchanger;

public class SSHPasswordChange {
    public void changePassword(String username, String newPassword, Session session) {

        SSHSendCommand sshSendCommand = new SSHSendCommand();

        try {
            // Send 'sudo passwd user' command
            sshSendCommand.sendCommand(session.getChannel(), "sudo passwd " + username);

            // Send new password
            sshSendCommand.sendCommand(session.getChannel(), newPassword);

            // Send new password confirmation
            sshSendCommand.sendCommand(session.getChannel(), newPassword);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("password changed for " + username);
    }

}
