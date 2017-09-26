import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
public class Driver
{
    public static void main(String [] args)throws IOException
    {
        Scanner kb=new Scanner(System.in);
        System.out.println("Name of file to scan:");
        String filename=kb.nextLine();

        MapOverlayFinder finder=new MapOverlayFinder(filename);
        ArrayList<LineSegment> list=finder.print();

        System.out.print("Enter scale factor: ");
        double scale = kb.nextDouble();
        System.out.println("");

        JFrame f = new JFrame("LineSegmentCanvas");
        f.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        JApplet applet = new LineSegmentCanvas(null, list, scale, finder.getYMax());
        f.getContentPane().add("Center", applet);
        applet.init();
        f.pack();
        f.setSize(new Dimension((int) Math.round(scale * finder.getXMax() + scale), (int) Math.round(scale * finder.getYMax() + scale)));
        f.setVisible(true);
    }
}