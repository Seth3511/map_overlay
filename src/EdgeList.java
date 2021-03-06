import java.util.ArrayList;
import java.util.HashMap;
public class EdgeList
{
    protected ArrayList<Edge> list;
    protected HashMap<String,Edge> hMap;

    public EdgeList(ArrayList<Edge> list, HashMap<String,Edge> hMap)
    {
        this.hMap=hMap;
        this.list=new ArrayList<>();
        for(int i=0;i<list.size();i++)
            if(list.get(i).cycle==null)
            {
                Edge p=list.get(i);
                Edge q=p;
                Cycle cycle=new Cycle(p);

                do{
                    p.twin=hMap.get(p.twinS);
                    p.line=new LineSegment(p.origin,p.twin.origin);
                    p.next=hMap.get(p.nextS);
                    p.next.prev=p;
                    p.cycle=cycle;
                    p=p.next;
                }while(q!=p);

                this.list.add(list.get(i));
            }
    }

    public ArrayList<Edge> toArray()
    {
        ArrayList<Edge> ret=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            Edge p=list.get(i);
            Edge q=p;

            do{
                ret.add(p);
                p=p.next;
            }while(q!=p);
        }

        return ret;
    }
}
