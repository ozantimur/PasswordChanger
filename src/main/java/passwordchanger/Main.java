package passwordchanger;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String filePath = args[0];
        ArrayList<String> arrayList;

        String host;
        String username;
        String userPassword;
        String rootPassword;

        FileNameChanger fileNameChanger = new FileNameChanger();
        filePath = fileNameChanger.change(filePath);

        FileReader fileReader = new FileReader(filePath);
        arrayList = fileReader.read();

        host = arrayList.remove(0);
        username = arrayList.remove(0);
        userPassword = arrayList.remove(0);
        rootPassword = arrayList.remove(0);

        String[][] usernameList = new String[arrayList.size()][2];

        for (int i = 0; i < arrayList.size(); i++) {
            int index = arrayList.get(i).indexOf(":");
            String name = arrayList.get(i).substring(0, index);
            String password = arrayList.get(i).substring(index+1);
            usernameList[i][0] = name;
            usernameList[i][1] = password;
        }

        Session session = new Session(username, host, userPassword);
        session.connect();

        RootAccess rootAccess = new RootAccess();
        rootAccess.root(rootPassword, session);

        SSHPasswordChange sshPasswordChange = new SSHPasswordChange();
        for (String[] user : usernameList) {
            sshPasswordChange.changePassword(user[0], user[1], session);
        }

        session.disconnect();
    }
}
