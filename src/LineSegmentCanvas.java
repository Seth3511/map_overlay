import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.ArrayList;

public class LineSegmentCanvas extends JApplet
{
    private ArrayList points;
    private ArrayList lines;
    private double scale;
    private double yMax;
    private ArrayList<Face> f1;
    private ArrayList<Face> f2;
    private ArrayList<GeneralPath> pathList1;
    private ArrayList<GeneralPath> pathList2;
    

    public LineSegmentCanvas(ArrayList<Face> f1, ArrayList<Face> f2,ArrayList points, ArrayList lines, double scale, double yMax)
    {
        super();
        this.points=points;
        this.lines=lines;
        this.scale=scale;
        this.yMax=yMax*scale+20;
        this.f1=f1;
        this.f2=f2;
        pathList1=new ArrayList<>();
        pathList2=new ArrayList<>();
    }

    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        super.paint(g);
        
        
        for(int i=0;i<f1.size();i++)
        {
            Face f=f1.get(i);
            
            Edge p=f.outerBound.head;
            Edge q=p.next;
            GeneralPath outer = new GeneralPath();
            LineSegment s=p.line;
            outer.moveTo(s.p1.x*scale+10,(yMax-(s.p1.y*scale))-10);
            p=p.next;
            do{
                s=p.line;
                outer.lineTo(s.p1.x*scale+10,(yMax-(s.p1.y*scale))-10);
                p=p.next;
            }while(q!=p);
            outer.closePath();
            g2.setColor(Color.blue);
            g2.fill(outer);
            pathList1.add(outer);
            
            g2.setColor(Color.red);
            for(int j=0;j<f.innerBounds.size();j++){
                p=f.innerBounds.get(j).head;
                q=p.next;
                GeneralPath inner = new GeneralPath();
                s=p.line;
                inner.moveTo(s.p1.x*scale+10,(yMax-(s.p1.y*scale))-10);
                do{
                    s=p.line;
                    inner.lineTo(s.p1.x*scale+10,(yMax-(s.p1.y*scale))-10);
                }while(q!=p);
                inner.closePath();
                g2.fill(inner);
            }
        }
        
        
        for(int i=0;i<f2.size();i++)
        {
            Face f=f2.get(i);
            
            Edge p=f.outerBound.head;
            Edge q=p.next;
            GeneralPath outer = new GeneralPath();
            LineSegment s=p.line;
            outer.moveTo(s.p1.x*scale+10,(yMax-(s.p1.y*scale))-10);
            p=p.next;
            do{
                s=p.line;
                outer.lineTo(s.p1.x*scale+10,(yMax-(s.p1.y*scale))-10);
                p=p.next;
            }while(q!=p);
            outer.closePath();
            g2.setColor(Color.red);
            g2.fill(outer);
            pathList2.add(outer);
            
            for(int j=0;j<f.innerBounds.size();j++){
                p=f.innerBounds.get(j).head;
                q=p.next;
                GeneralPath inner = new GeneralPath();
                s=p.line;
                inner.moveTo(s.p1.x*scale+10,(yMax-(s.p1.y*scale))-10);
                do{
                    s=p.line;
                    inner.lineTo(s.p1.x*scale+10,(yMax-(s.p1.y*scale))-10);
                }while(q!=p);
                inner.closePath();
                g2.setColor(Color.blue);
                g2.fill(inner);
            }
        }
        
        g2.setColor(new Color(255/2,0,255/2));
        for(int i=0;i<pathList1.size();i++)
            for(int j=0;j<pathList2.size();j++)
            {
               Area a1=new Area(pathList1.get(i));
               a1.intersect(new Area(pathList2.get(j)));
               g2.fill(a1);
            }
        
        g2.setColor(Color.black);
        if(points!=null)
            for(int i=0;i<points.size();i++)
            {
                Point point=(Point)points.get(i);
                Point2D.Double p = new Point2D.Double((point.x*scale+10), (yMax-(point.y*scale))-10);
                g2.fill(new Ellipse2D.Double(p.x-3,p.y-3,7,7));
            }

        for(int i=0;i<lines.size();i++)
        {
            LineSegment s=(LineSegment)lines.get(i);
            g2.draw(new Line2D.Double((s.p1.x*scale+10), (yMax-(s.p1.y*scale))-10,(s.p2.x*scale+10), (yMax-(s.p2.y*scale))-10));
        }
    }
}