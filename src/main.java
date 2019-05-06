import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class main {
    public static void main(String[] args){
        int E=0,X;
       // JSONObject jsonObject = (JSONObject) readJsonSimpleDemo("example.json");
        Scanner input = new Scanner(System.in);
        while(E==0){
            System.out.print("Press Number You Want To Do : \n"+ "1.To Test the first automata \n 2.Test the second automata \n 3.Test the third automata \n 4.Test the Java automata \n 5.EXIT");
            X=input.nextInt();
            switch (X){
                case 1:

                case 2:

                case 3:

                case 4:

                case 5:
                    E=1;

                default:
            }
        }
    }
}
