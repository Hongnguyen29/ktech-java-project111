import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Todo_Edit {

    public static List<Note> Edit() throws IOException {
        System.out.println("Edit Note :");
        System.out.println("Edit TODO number :");
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(rd.readLine());
        List<Note> noted = ReadWriterPrint.readData();
        List<Note> newNote = new ArrayList<>(noted.size());
        System.out.println("Title :");
        String title = rd.readLine();
        System.out.println("Time :");
        String time = rd.readLine();
        String status = " ";
        Note n1 = new Note(title, time, status);
        for (int i = 0; i < noted.size(); i++) {
            if (i == number-1) {newNote.add(n1);}
            else {newNote.add(i, noted.get(i));}
        }
        ReadWriterPrint.writer(newNote);
        List<Note> newNote2 = ReadWriterPrint.readData();
        return newNote2;
    }

}
