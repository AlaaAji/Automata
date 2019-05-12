import java.io.*;
import java.lang.Object;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org. json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class main {
    public static void main(String[] args) {
        int E = 0, X;
        dfa MyDFA = new dfa();
        String example;
        Type t = Type.NoThing ;
        Scanner input = new Scanner(System.in);
        while (E == 0) {
            System.out.print("Press Number You Want To Do : \n" + "1.To Test the first automata \n 2.Test the second automata \n 3.Test the third automata \n 4.Test the Java automata \n 5.EXIT");
            X = input.nextInt();
            switch (X) {
                case 1:
                    try {
                        File file = new File("Example Java test.json");
                        System.out.println(file.getAbsolutePath());
                        Object obj = new JSONParser().parse(new FileReader(file));

                        JSONObject MyObj = (JSONObject) obj;

                        ArrayList<state> st = new ArrayList<>();
                        JSONArray js = (JSONArray) MyObj.get("S");
                        JSONArray jq = (JSONArray) MyObj.get("Q");
                        JSONArray jd = (JSONArray) MyObj.get("S");

                        MyDFA.setDFA(jd);
                        MyDFA.setQ(jq);
                        MyDFA.setS(js);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    try {
                        example = input.nextLine();
                        t=MyDFA.IsAcceptable(example);
                        if(t==Type.NoThing)
                            System.out.print("the word is NOT accept");
                        else
                            System.out.print("the word is accept and from type" + t);
                    }catch (Exception e){
                        System.out.print(e.toString());
                    }
                    finally {
                        input.close();
                    }
                case 2:

                case 3:

                case 4:

                case 5:
                    E = 1;

                default:
                    System.out.print("Wrong choice >_< , Plese choice from  selected numbers");
            }
        }
    }
}
