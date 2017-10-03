import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
public class EdgeList
{
    private ArrayList<LinkedList<Edge>> arrayList;
    private HashMap<String,Edge> hMap;

    public EdgeList(ArrayList<Edge> list, HashMap<String,Edge> hMap)
    {
        this.hMap=hMap;
        arrayList=new ArrayList<>();
        for(int i=0;i<list.size();i++)
            if(list.get(i).sequence==null)
            {
                list.get(i).twin=hMap.get(list.get(i).twinS);
                list.get(i).line=new LineSegment(list.get(i).origin,list.get(i).twin.origin);

                LinkedList<Edge> sequence=new LinkedList<>();
                list.get(i).sequence=sequence;
                sequence.add(list.get(i));
                Edge p=list.get(i);

                do{
                    p=hMap.get(p.next);
                    p.sequence=sequence;
                    sequence.add(p);
                }while(p!=sequence.peek());

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
