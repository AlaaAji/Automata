import java.io.*;
import java.lang.Object;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class main {
    public static void main(String[] args) throws Exception {
        int E = 0, X;
        dfa MyDFA = new dfa();
        Scanner input = new Scanner(System.in);
        while (E == 0) {
            System.out.print("Press Number You Want To Do : \n" + "1.To Test the first automata \n 2.Test the second automata \n 3.Test the third automata \n 4.Test the Java automata \n 5.EXIT");
            X = input.nextInt();
            switch (X) {
                case 1:
                    ReadFile("src/Divide on 4.json", MyDFA);
                    Test(MyDFA);
                case 2:
                    ReadFile("src/contain 011.json", MyDFA);
                    Test(MyDFA);
                case 3:
                    ReadFile("src/Start with aa and end with bb.json", MyDFA);
                    Test(MyDFA);
                case 4:
                    ReadFile("src/Example Java test.json", MyDFA);
                    Test(MyDFA);
                case 5:
                    E = 1;

                default:
                    System.out.print("Wrong choice >_< , Plese choice from  selected numbers");
            }
        }
    }

    public static void ReadFile(String name, dfa MyDFA) {
        try {
            Object obj = new JSONParser().parse(new FileReader(name));
            //obj.createNewFile();
            JSONObject MyObj = (JSONObject) obj;

            //ArrayList<state> st = new ArrayList<>();
            JSONArray js = (JSONArray) MyObj.get("S");
            JSONArray jd = (JSONArray) MyObj.get("DFA");

            MyDFA.setDFA(jd);
            MyDFA.setS(js);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void Test(dfa MyDFA) {
        int F = 0, y;
        String example;
        while (F == 0) {
            System.out.print("what you want ? \n 1.See the primitive status \n 2.See the final statuses \n 3.See the transition \n 4.Seeing statuses \n 5.See symbols for the alphabet \n 6.Test Strings if Belong To Automata \n 7.EXIT");
            Scanner input = new Scanner(System.in);
            y = input.nextInt();
            switch (y) {
                case 1:
                    MyDFA.StartState();
                case 2:
                    MyDFA.EndState();
                case 3:
                    MyDFA.MovingFunction();
                case 4:
                    MyDFA.getQ();
                case 5:
                    MyDFA.getS();
                case 6:
                    try {
                        Type t = Type.NoThing;
                        example = input.nextLine();
                        t = MyDFA.IsAcceptable(example);
                        if (t == Type.NoThing)
                            System.out.print("the word is NOT accept");
                        else
                            System.out.print("the word is accept and from type" + t);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        input.close();
                    }
                case 7:
                    F = 1;
                default:
                    System.out.print("Wrong choice >_< , Plese choice from  selected numbers");
            }
        }
    }
}