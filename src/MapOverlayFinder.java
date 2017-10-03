import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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

        HashMap<String,Edge> hMap=new HashMap<>();
        list =new ArrayList<>();
        String delimiter=",";
        String line="";
        BufferedReader F=new BufferedReader(new FileReader(filename));
        F.readLine();

        while((line = F.readLine()) != null)
        {
            String [] row=line.split(delimiter);

            Edge edge=new Edge(row[0],
                    new Point(Double.parseDouble(row[1]),Double.parseDouble(row[2])),
                    row[3],row[4],row[5]);

            list.add(edge);
            hMap.put(edge.name,edge);
            
            if(Double.parseDouble(row[1])>xMax)
               xMax=Double.parseDouble(row[1]);
            if(Double.parseDouble(row[2])>yMax)
               yMax=Double.parseDouble(row[2]);
        }
        F.close();

        list.trimToSize();
        s1=new EdgeList(list,hMap);
    }

    public ArrayList<LineSegment> print()
    {
        ArrayList<LineSegment> lineList=new ArrayList<>();
        /*ArrayList<Edge> edgeArrayList=s1.toArray();
        for(int i=0;i<edgeArrayList.size();i++)
            lineList.add(edgeArrayList.get(i).line);

        return lineList;*/

        for(int i=0;i<list.size();i++)
            lineList.add(list.get(i).line);

        return lineList;
    }

    public double getXMax(){return xMax;}
    public double getYMax(){return yMax;}
}
