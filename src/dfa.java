import java.util.ArrayList;
import java.util.List;
import java.lang.*;
public class dfa {
    private ArrayList<Integer> Q = new ArrayList<Integer>(); //need apdate
    private ArrayList<Integer>  S = new ArrayList<Integer>();
    private ArrayList<state> DFA = new ArrayList<>();

    public void setDFA(ArrayList<state> DFA) {
        this.DFA = DFA;
    }

    public ArrayList<state> getDFA() {
        return DFA;
    }

    public void setQ(ArrayList<Integer> q) {
        Q = q;
    }

    public ArrayList<Integer> getQ() {
        return Q;
    }

    public void setS(ArrayList<Integer> s) {
        S = s;
    }
    private ArrayList<Integer> getS(){return S;}


    public void StartState(state Start) {
        for (int i = 0; i < DFA.size(); i++) {
            if (DFA.get(i).getStart() == true) {
                Start = DFA.get(i);
                break;
            }
        }
        Start.PrintState();
    }

    public void EndState(state End) {
        for (int i = 0; i < DFA.size(); i++) {
            if (DFA.get(i).getEnd() == true) {
                End = DFA.get(i);
                End.PrintState();
            }
        }
    }

    public void MovingFunction() {
        for (int i = 0; i < DFA.size(); i++) {
            System.out.print("In State " + DFA.get(i).getName() + ":");
            DFA.get(i).FunMov();
        }
    }

    public boolean IsLineComment(String example) {
        char ch, ch1;
        int r = 0;
        boolean b = true;
        ch = example.charAt(0);
        ch1 = example.charAt(1);
        if (ch == '/' && ch1 == '/') {
            while (r < example.length()) {
                if (example.charAt(r) != '\n') {
                    b = false;
                    break;
                }
                r++;
            }
        }
        return b;
    }

    public boolean IsLongComment(String example) {
        char ch, ch1;
        int l = 0, r = 0;
        boolean b = false;
        //ch=example.charAt(0);
        //ch1=example.charAt(1);
        //l=example.length();
        if (example.charAt(0) == '/' && example.charAt(1) == '*' && example.charAt(example.length()) == '/' && example.charAt(example.length()) == '*')
            b = true;
        return b;
    }

    /*public ArrayList IsNameVariable(state S, String e, int x) {
        ArrayList<int> h = new ArrayList<>(1);
        int o = 0, y = 0;
        if (S.getName() == "q93") {
            o = 1;
            if (Character.isLetter(e.charAt(x))) {
                y = 1;
                x++;
                while (e.charAt(x) != '=')
                    x++;
            }
        }
        if (o == 0) {
            h.add(0,1);
            h.add(1,x);
            return h;
        } else if (o == 1 && y == 0) {
            h.add(0,2);
            h.add(1,x);
            return h;
        } else { //o=1&y=1
            h.add(0,3);
            h.add(1,x);
            return h;
    }}*/

    public Type IsAcceptable(String example) {
        int x = 0, A = 0;
        state S = DFA.get(0);
        if (IsLineComment(example)) {
            S.setType(Type.LineComment);
            return S.getType();
        }
        if (IsLongComment(example)) {
            S.setType(Type.LongComment);
            return S.getType();
        }
        ArrayList<node> M = new ArrayList<>();
        char c = example.charAt(x);
        while (x != example.length()) {
            A = 0;
            M = S.getMove();
            for (int i = 0; i < M.size(); i++) {
                if (c == M.get(i).getC()) {
                    A = 1;
                    for (int j = 0; j < DFA.size(); j++) {
                        if (DFA.get(j).getName() == M.get(j).getS()) {
                            S = DFA.get(j);
                            x++;
                            /*ArrayList<int> z=new ArrayList<int>();
                            z=IsNameVariable(S,example,x;
                            if (z.get(0)==1)
                                continue;
                            if (z.get(0)==2){
                                S.setType(Type.NoThing);
                                return S.getType();
                            }
                            if(z.get(0)==3){
                                S.setType(Type.DefineVariable);
                            */
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
        /*if (A != 1)
            S.setEnd(false);*/
        /*if(S.getEnd()==true) {
            System.out.print("the word is accept and from type" + S.getType());
        }
        else {
            System.out.print("the word is NOT accept ");
        }*/
    }
}