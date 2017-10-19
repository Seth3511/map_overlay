import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
public class Driver
{
    public static void main(String [] args)throws IOException
    {
        Scanner kb=new Scanner(System.in);
        System.out.println("Name of 1st file to scan:");
        String filename1=kb.nextLine();
        System.out.println("Name of 2nd file to scan:");
        String filename2=kb.nextLine();

        MapOverlayFinder finder=new MapOverlayFinder(filename1,filename2);
        ArrayList<Point> pointlist=finder.find();
        ArrayList<LineSegment> linelist=finder.print();

        System.out.println("Enter scale factor: ");
        double scale = kb.nextDouble();
        System.out.println("");

        JFrame f1 = new JFrame("Input 1");
        f1.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        JApplet applet1 = new InputCanvas(finder.f1, scale, finder.getYMax(),"blue");
        f1.getContentPane().add("Center", applet1);
        applet1.init();
        f1.pack();
        f1.setSize(new Dimension((int) Math.round(scale * finder.getXMax() + scale), (int) Math.round(scale * finder.getYMax() + scale)));
        f1.setVisible(true);

        JFrame f2 = new JFrame("Input 2");
        f2.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        JApplet applet2 = new InputCanvas(finder.f2, scale, finder.getYMax(),"red");
        f2.getContentPane().add("Center", applet2);
        applet2.init();
        f2.pack();
        f2.setSize(new Dimension((int) Math.round(scale * finder.getXMax() + scale), (int) Math.round(scale * finder.getYMax() + scale)));
        f2.setVisible(true);

        JFrame f = new JFrame("Output");
        f.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        JApplet applet = new LineSegmentCanvas(finder.f1,finder.f2,pointlist, linelist, scale, finder.getYMax());
        f.getContentPane().add("Center", applet);
        applet.init();
        f.pack();
        f.setSize(new Dimension((int) Math.round(scale * finder.getXMax() + scale), (int) Math.round(scale * finder.getYMax() + scale)));
        f.setVisible(true);
    }
}