import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Todo_Create {
    public static List<Note> Create () throws IOException {
        List<Note> notec = new ArrayList<>();
        System.out.println("Create :");
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Title :");
            String title = rd.readLine();
            System.out.println("Time :");
            String time = rd.readLine();
            String status =" ";
            Note n1 = new Note(title, time, status);
            notec.add(n1);
            System.out.println("Saved !!");
            System.out.println("add more ?? [y/n] : ");
            String hasNext = rd.readLine();
            if (hasNext.equals("n")) {break;
            }
        }
        try(
                FileWriter fw = new FileWriter("list.csv",true);
                 BufferedWriter bw = new BufferedWriter(fw))
                { for (Note a : notec){
                StringBuilder lb = new StringBuilder();
                lb.append(a.getTitle()).append(',');
                lb.append(a.getTime()).append(',');
                lb.append(a.getStatus());

                String line = lb.toString();
                bw.write(line);
                bw.newLine();}
                }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        List<Note> newNote2 = Main.readData();
        return newNote2;
    }
}
