import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws  IOException {
        List<Note> noteList = readData();
        System.out.println("Welcome !");
        if(noteList.isEmpty()) {
            System.out.println("You have no more TODO !");
        }
        else {
            System.out.println("You have " + noteList.size() + " TODO !");
            for (int i = 0; i < noteList.size(); i++) {
                Note note = noteList.get(i);
                System.out.println(String.format(
                        "%d. %s  %s ",
                        i+1,
                        note.getTitle(),
                        note.getStatus()
                ));
            }
            System.out.println();
        }
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("1. Create TODO");
        System.out.println("2. Edit TOTO");
        System.out.println("3. Finish TODO");
        System.out.println("4. Delete TOTO ");
        System.out.println("5. Exit");
        System.out.println();
        System.out.println("Input : ");

        int input = Integer.parseInt(br.readLine());
        if(input == 1) {
            Todo_1.Create();
            List<Note> newNotes = readData();
            for (int i = 0; i < newNotes.size(); i++) {
                Note note = newNotes.get(i);
                System.out.println(String.format(
                        "%d.  %s %s", i + 1, note.getTitle(),
                        note.getStatus()
                ));
            }
        }
        else if(input == 2) {
            Todo_2.Edit();
            List<Note> newNotes = readData();
            for (int i = 0; i < newNotes.size(); i++) {
                Note note = newNotes.get(i);
                System.out.println(String.format(
                        "%d.  %s %s", i + 1, note.getTitle(),
                        note.getStatus()
                ));
            }
        }
    }
    public static void writer(List<Note> lst) {
        try (FileWriter fw = new FileWriter("list.csv");
             BufferedWriter bw = new BufferedWriter(fw))

        {   StringBuilder lb = new StringBuilder();
            String line = lb.toString();
            for (Note a : lst){
            lb.append(a.getTitle()).append(',');
            lb.append(a.getTime()).append(',');
            lb.append(a.getStatus());
            bw.write(line);
            bw.newLine();
        }
        }catch (IOException e) {
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
            System.out.println(e.getMessage());
        }
        return notes;
    }
}
