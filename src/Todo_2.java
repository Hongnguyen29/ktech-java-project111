import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Todo_2 {

    public static List<Note> Edit() throws IOException {
        System.out.println("Edit Note :");
        System.out.println("Edit TODO number :");
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(rd.readLine());
        List<Note> noted = Main.readData();
        List<Note> newNote = new ArrayList<>(noted.size());
        System.out.println("Title :");
        String title = rd.readLine();
        System.out.println("Time :");
        String time = rd.readLine();
        System.out.println("Status :");
        String status = rd.readLine();
        Note n1 = new Note(title, time, status);
        for (int i = 0; i < noted.size(); i++) {
            if (i == number) {newNote.add(n1);}
            else {newNote.add(i, noted.get(i));}
        }
        try(
        FileWriter fw = new FileWriter("list.csv");
        BufferedWriter bw = new BufferedWriter(fw)) {
            StringBuilder lb = new StringBuilder();

            for (Note note : newNote) {
                lb.append(note.getTitle()).append(',');
                lb.append(note.getTime()).append(',');
                lb.append(note.getStatus());
                String line = lb.toString();
                bw.write(line);
                bw.newLine();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());

        }
        List<Note> notec2 = new ArrayList<>();
        try
                (FileReader fr = new FileReader("list.csv");
                 BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] elements = line.split(",");
                notec2.add(new Note(
                        elements[0],
                        elements[1],
                        elements[2]));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } return notec2;

    }

}
