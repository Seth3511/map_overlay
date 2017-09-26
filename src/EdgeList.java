public class EdgeList
{
    protected Edge head;
    protected int size;

    public EdgeList(Edge [] list)
    {
        size=list.length;
        head=list [0];
        for(int i=0;i<list.length-1;i++)
            for(int j=i+1;j<list.length;j++)
            {
                if(list[i].nextS.equals(list[j].name))
                    list[i].next=list[j];
                if(list[i].prevS.equals(list[j].name))
                    list[i].prev=list[j];
                if(list[j].nextS.equals(list[i].name))
                    list[j].next=list[i];
                if(list[j].prevS.equals(list[i].name))
                    list[j].prev=list[i];
                if(list[i].twinS.equals(list[j].name))
                    list[i].twin=list[j];
                if(list[j].twinS.equals(list[i].name))
                    list[j].twin=list[i];
            }
    }

    public Edge[] toArray()
    {
        Edge p=head;
        Edge[] rtn=new Edge[size];
        int i=0;
        do{
            rtn[i]=p;
            i++;
            p=p.next;
        }while(p!=head);

        return rtn;
    }
}
