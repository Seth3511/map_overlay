import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapOverlayFinder
{
    EdgeList s1;
    EdgeList s2;

    public MapOverlayFinder(String filename)throws IOException
    {
        ArrayList<Edge> list =new ArrayList<>();
        String delimiter=",";
        String line="";
        BufferedReader F=new BufferedReader(new FileReader(filename));
        F.readLine();

        while((line = F.readLine()) != null)
        {
            String [] row=line.split(delimiter);

            for(int i=0;i<row.length;i++)
                System.out.println(row[i]);

            Edge edge=new Edge(row[0],
                    new LineSegment(
                            new Point(Double.parseDouble(row[1]),Double.parseDouble(row[2])),
                            new Point(Double.parseDouble(row[3]),Double.parseDouble(row[4]))),
                    row[5],row[6],row[7]);

            list.add(edge);
        }
        F.close();

        list.trimToSize();
        s1=new EdgeList(list.toArray(new Edge[list.size()]));
    }

    public ArrayList<LineSegment> print()
    {
        Edge[] elist=s1.toArray();
        ArrayList<LineSegment> list=new ArrayList<>();

        for(int i=0;i<elist.length;i++)
            if(elist[i]!=null)
                list.add(elist[i].line);

        return list;
    }

    public double getXMax(){return 10;}
    public double getYMax(){return 10;}
}
