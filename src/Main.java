import java.io.*;

public class Main {
    public static void main(String[] args) throws  IOException {
        System.out.println("Welcome !");
        ReadWriterPrint.PrintInfo();

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        while(true) {
            System.out.println("________");
            System.out.println("1. Create TODO");
            System.out.println("2. Edit TOTO");
            System.out.println("3. Finish TODO");
            System.out.println("4. Delete TOTO ");
            System.out.println("5. Exit");
            System.out.println();

            System.out.println("Input : ");

            try{
                int input = Integer.parseInt(br.readLine());
                switch (input) {
                case 1: {
                    Todo_Create.Create();
                    ReadWriterPrint.PrintInfo();
                }
                break;
                case 2: {
                    Todo_Edit.Edit();
                    ReadWriterPrint .PrintInfo();
                }
                break;
                case 3: {
                    Todo_Finish.Finish();
                    ReadWriterPrint .PrintInfo();
                }
                break;
                case 4: {
                    Todo_Delete.Delete();
                    ReadWriterPrint .PrintInfo();
                }
                break;
                case 5: {
                    System.exit(0);
                }
                break;
                default:
                    System.out.println("Wrong input. Try again(Input :int 1->5 ");}
            }catch(NumberFormatException e){
                System.out.println("Wrong input. Try again(Input :int 1->5 ");
            }
        }
    }
}
