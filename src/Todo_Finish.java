import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Todo_Finish {

    public static List<Note> Finish() throws IOException {

        System.out.println("Finish TODO number :");
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(rd.readLine());
        List<Note> noted = Main.readData();
        List<Note> newNote = new ArrayList<>();
        for (int i = 0; i < noted.size(); i++) {
            if (i == number-1) {
                String line = noted.get(i).toString();
                String[] split = line.split(" ");
                newNote.add(new Note(split[0], split[1],"( done )"));
            }
            else {newNote.add(i, noted.get(i));}
        }
        Main.writer(newNote);
        List<Note> newNote2 = Main.readData();
        return newNote2;
    }

}
