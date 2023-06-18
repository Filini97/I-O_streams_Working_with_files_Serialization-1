import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static final String LOCATION = "D:/Idea/Games";

    public static void main(String[] args) {

        File game = new File(LOCATION);
        folderCreator(game);

        folderOrFile(LOCATION, "src", "res", "savegames", "temp");

        folderOrFile(LOCATION + "/src", "main", "test");

        folderOrFile(LOCATION + "/src/main", "Main.java", "Utils.java");

        folderOrFile(LOCATION + "/res", "drawables", "vector", "icons");

        folderOrFile(LOCATION + "/temp", "temp.txt");


        try (FileWriter writer = new FileWriter(LOCATION + "/temp/temp.txt", false)) {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void folderOrFile(String file, String... folderOrFile) {
        for (String s : folderOrFile) {
            File newFile = new File(file, s);
            if (s.contains("."))
                fileCreator(newFile);
            else
                folderCreator(newFile);
        }
    }

    private static void fileCreator(File mainJava) {
        try {
            if (mainJava.createNewFile())
                sb.append(mainJava).append(" - Файл успешно создан\n");
            else if (mainJava.isFile())
                sb.append(mainJava).append("- Файл уже существует\n");
            else
                sb.append(mainJava).append(" - Файл не был создан\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void folderCreator(File game) {
        if (game.mkdir())
            sb.append(game).append(" - Папка успешно создана\n");
        else if (game.isDirectory())
            sb.append(game).append(" - Папка уже существует\n");
        else
            sb.append(game).append(" - Папка не была создана\n");
    }
}

