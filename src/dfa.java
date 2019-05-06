import java.util.ArrayList;
import java.util.List;

public class dfa {
    int Q; //need apdate
    public void getQ (int Q){this.Q=Q;}
    ArrayList<state> DFA=new ArrayList<>() ;

    public void setDFA(ArrayList<state> DFA){
        this.DFA=DFA;
    }

    public ArrayList<state> getDFA() {
        return DFA;
    }

    public void setQ(int q) {
        Q = q;
    }

    public int getQ() {
        return Q;
    }
    public void StartState (state Start) {
         for(int i=0;i<DFA.size();i++)
         {
             if (DFA.get(i).getStart()==true) {
                 Start = DFA.get(i);
                 break;
             }
         }
         Start.PrintState();
    }
    public void EndState (state End) {
        for(int i=0;i<DFA.size();i++)
        {
            if (DFA.get(i).getEnd()==true) {
                End = DFA.get(i);
                End.PrintState();
            }
        }
    }
    public void MovingFunction(){
        for(int i=0;i<DFA.size();i++)
        {
            System.out.print("In State "+DFA.get(i).getName()+":");
            DFA.get(i).FunMov();
        }
    }


    public void IsAcceptable (String example) {
        int x=0,A=0 ;
       // int v; //number of states
        state S=DFA.get(0);
        ArrayList<node> M = new ArrayList<>();
        char c=example.charAt(x);
        while (x!=example.length())
        {
             M=S.getMove();
            for (int i=0;i<M.size();i++)
            {
                if(c==M.get(i).getC())
                {
                    A=1;
                    for(int j=0;j<DFA.size();j++)
                    {
                        if(DFA.get(j).getName()==M.get(j).getS())
                        {
                            S=DFA.get(j);
                            x++;
                        }
                    }
                }
            }
            if(A!=1)
                S.setEnd(false);
        }
        if(S.getEnd()==true) {
            System.out.print("the word is accept and from type" + S.getType());
        }
        else {
            System.out.print("the word is NOT accept ");
        }
    }
}