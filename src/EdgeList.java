import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
public class EdgeList
{
    protected ArrayList<LinkedList<Edge>> arrayList;
    protected HashMap<String,Edge> hMap;

    public EdgeList(ArrayList<Edge> list, HashMap<String,Edge> hMap)
    {
        this.hMap=hMap;
        arrayList=new ArrayList<>();
        for(int i=0;i<list.size();i++)
            if(list.get(i).sequence==null)
            {
                LinkedList<Edge> sequence=new LinkedList<>();
                Edge p=list.get(i);

                while(p!=sequence.peek()){
                    p.twin=hMap.get(p.twinS);
                    p.line=new LineSegment(p.origin,p.twin.origin);
                    p.sequence=sequence;
                    sequence.add(p);
                    p=hMap.get(p.next);
                }

                arrayList.add(sequence);
            }
    }

    public ArrayList<Edge> toArray()
    {
        ArrayList<Edge> list=new ArrayList<>();
        for(int i=0;i<arrayList.size();i++)
            for(int j=0;j<arrayList.get(i).size();j++)
                list.add(arrayList.get(i).get(j));

        return list;
    }
}
