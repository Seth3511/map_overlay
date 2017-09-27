import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapOverlayFinder
{
    private EdgeList s1;
    private EdgeList s2;
    private ArrayList<Edge> list;
    private double xMax;
    private double yMax;
    
    public MapOverlayFinder(String filename)throws IOException
    {
        xMax=0;
        yMax=0;
        
        list =new ArrayList<>();
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
            
            if(Double.parseDouble(row[1])>xMax)
               xMax=Double.parseDouble(row[1]);
            if(Double.parseDouble(row[3])>xMax)
               xMax=Double.parseDouble(row[3]);
            if(Double.parseDouble(row[2])>yMax)
               yMax=Double.parseDouble(row[2]);
            if(Double.parseDouble(row[4])>yMax)
               yMax=Double.parseDouble(row[4]);
        }
        F.close();

        list.trimToSize();
        s1=new EdgeList(list.toArray(new Edge[list.size()]));
    }

    public ArrayList<LineSegment> print()
    {
        /*Edge[] elist=s1.toArray();
        ArrayList<LineSegment> list=new ArrayList<>();

        for(int i=0;i<elist.length;i++)
            if(elist[i]!=null)
                list.add(elist[i].line);

        */
        ArrayList<LineSegment> lineList=new ArrayList<>();
        for(int i=0;i<list.size();i++)
            lineList.add(list.get(i).line);
        
        return lineList;
    }

    public double getXMax(){return xMax;}
    public double getYMax(){return yMax;}
}
