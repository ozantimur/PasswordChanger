package passwordchanger;

import java.io.File;
import java.util.*;

public class FileReader {

    String filePath;
    ArrayList<String> texts = new ArrayList<>();
    ArrayList<String> infos = new ArrayList<>();

    String[][] matrix = new String[5][2];

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<String> read() {

        File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                texts.add(scanner.nextLine());
            }

            matrix[0][0] = "IP Address:";
            matrix[0][1] = "11";

            matrix[1][0] = "Username:";
            matrix[1][1] = "9";

            matrix[2][0] = "Password:";
            matrix[2][1] = "9";

            matrix[3][0] = "RootPassword:";
            matrix[3][1] = "13";


            scanner.close();


            for (int i = 0 ; i<4; i++) {
                for (String text : texts) {
                    if (text.indexOf(matrix[i][0]) == 0) {
                        String info = text.substring(Integer.parseInt(matrix[i][1]));
                        info = info.trim();
                        infos.add(info);
                        texts.remove(text);
                        break;
                    }
                }
            }

            texts.remove("Users:");

            infos.addAll(texts);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return infos;
        }
    }
}
