import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Todo_Delete {

    public static List<Note> Delete() throws IOException {

        System.out.println("Edit TODO number :");
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(rd.readLine());
        List<Note> noted = ReadWriterPrint.readData();
        for (int i = 0; i < noted.size(); i++) {
            if (i == number-1) {noted.remove(i);}
        }
   ReadWriterPrint.writer(noted);
        List<Note> newNote2 = ReadWriterPrint.readData();
        return newNote2;
    }

}
