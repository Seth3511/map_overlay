public class Edge
{
    protected LineSegment line;
    protected String name;
    protected String nextS;
    protected String prevS;
    protected String twinS;
    protected Edge twin;
    protected Edge next;
    protected Edge prev;

    public Edge(String name,LineSegment line, String nextS, String prevS,String twinS)
    {
        this.name=name;
        this.line=line;
        this.nextS=nextS;
        this.prevS=prevS;
        this.twinS=twinS;
    }

}
