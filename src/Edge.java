import java.util.LinkedList;

public class Edge
{
    protected LineSegment line;
    protected Point origin;
    protected String name;
    protected String next;
    protected String twinS;
    protected Edge twin;
    protected LinkedList<Edge> sequence;

    public Edge(String name,Point origin, String next,String twinS)
    {
        this.name=name;
        this.origin=origin;
        this.next=next;
        this.twinS=twinS;
    }

}
