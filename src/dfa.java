import java.util.ArrayList;
import java.util.List;
import java.lang.*;
public class dfa {
    private ArrayList<Character>  S = new ArrayList<>();
    private ArrayList<state> DFA = new ArrayList<>();

    public void setDFA(ArrayList<state> DFA) {
        this.DFA = DFA;
    }
    public ArrayList<state> getDFA() {
        return DFA;
    }

    public void setS(ArrayList<Character> s) {
        S = s;
    }
    public ArrayList<Character> getS(){return S;}

    public void getQ(){
        for(int i=0;i<DFA.size();i++)
            System.out.print(DFA.get(i).getName() + "\n");
    }
    public void StartState() {
        for (int i = 0; i < DFA.size(); i++) {
            if (DFA.get(i).getStart() == true) {
                DFA.get(i).PrintState();
            }
        }
    }

    public void EndState() {
        for (int i = 0; i < DFA.size(); i++) {
            if (DFA.get(i).getEnd() == true) {
                DFA.get(i).PrintState();
            }
        }
    }

    public void MovingFunction() {
        for (int i = 0; i < DFA.size(); i++) {
            System.out.print("In State " + DFA.get(i).getName() + ":");
            DFA.get(i).FunMov();
        }
    }
    public Type IsAcceptable(String example) {
        int x = 0, A = 0;
        state S = DFA.get(0);
        ArrayList<node> M = new ArrayList<>();
        while (x != example.length()) {
            char c = example.charAt(x);
            A = 0;
            M = S.getMove();
            for (int i = 0; i < M.size(); i++) {
                if (c == M.get(i).getC()) {
                    A = 1;
                    for (int j = 0; j < DFA.size(); j++) {
                        if (DFA.get(j).getName() == M.get(j).getS()) {
                            S = DFA.get(j);
                            x++;
                        }
                    }
                }
            }
            if (A == 0) {
                S.setType(Type.NoThing);
                return S.getType();
            }
        }
        return S.getType();
    }
}