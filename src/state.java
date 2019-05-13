import javax.lang.model.type.NullType;
import java.util.ArrayList;
public class state {
    private String name ;
    private boolean start;
    private boolean end;
    private Type type;
    private ArrayList<node> move = new ArrayList<>();
    state(){
        name= "";
        start=false;
        end=false;
        type=Type.NoThing;
    }
    state (String name , boolean start , boolean end , Type type  ,ArrayList<node> move){
        this.name=name;
        this.start=start;
        this.end=end;
        this.type=type;
        this.move=move;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setStart(boolean start){
        this.start=start;
    }
    public void setEnd(boolean end){
        this.end=end;
    }
    public void setType(Type type){
        this.type=type;
    }
    public void setMove(ArrayList<node> move) { this.move = move; }

    public String getName() {
        return name;
    }
    public  boolean getStart(){
        return start;
    }
    public boolean getEnd(){
        return  end;
    }
    public Type getType(){
        return type;
    }
    public ArrayList<node> getMove() {
        return move;
    }

    public void FunMov() {
        for(int i=0;i<move.size();i++)
        {
            System.out.print("In Language symbol :" + move.get(i).getC() + "It Move To State" + move.get(i).getS()+"\n");
        }
    }

    public void PrintState(){
        System.out.print("State Name :" + name +"\n" + "Start:" + start + "\n" + "End :" + end +"\n" );
        if (end==true)
            System.out.print("Type End" + type + "\n");
        System.out.print("function moving To This State: \n");
        FunMov();
    }
}