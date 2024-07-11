import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriterPrint {
    public static void writer(List<Note> lst) {
        try (FileWriter fw = new FileWriter("list.csv");
             BufferedWriter bw = new BufferedWriter(fw))
        {
            for (Note a : lst){
                StringBuilder lb = new StringBuilder();
                lb.append(a.getTitle()).append(',');
                lb.append(a.getTime()).append(',');
                lb.append(a.getStatus());
                bw.write(lb.toString());
                bw.newLine();
            }
        }catch (IOException e) {
            System.out.println("Error reading file");
            System.out.println(e.getMessage());
        }
    }
    public static List<Note> readData(){
        List<Note> notes = new ArrayList<>();
        try (FileReader fr = new FileReader("list.csv");
             BufferedReader br = new BufferedReader(fr)){
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                notes.add(new Note(
                        data[0],
                        data[1],
                        data[2]));
            }
        }catch (IOException e){
            System.out.println("Error reading file");
            System.out.println(e.getMessage());

        }
        return notes;
    }
    public static void PrintInfo() {

        List<Note> newNotes = readData();
        if(newNotes.isEmpty()) {
            System.out.println("You have no more TODO !");
        }
        else {
            System.out.println("You have " + newNotes.size() + " TODO !");
            for (int i = 0; i < newNotes.size(); i++) {
                Note note = newNotes.get(i);
                System.out.println(String.format(
                        "%d. %s %s", i + 1, note.getTitle(),
                        note.getStatus()
                ));

            }
        }
    }
}
