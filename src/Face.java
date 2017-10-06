import java.util.ArrayList;

public class Face
{
    protected String name;
    protected Edge outerBound;
    protected ArrayList<Edge> innerBounds;

    public Face(String name,Edge outerBound, ArrayList<Edge> innerBounds)
    {
        this.name=name;
        this.innerBounds=innerBounds;
        this.outerBound=outerBound;
    }
}
