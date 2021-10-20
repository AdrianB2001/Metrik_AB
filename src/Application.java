import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;


public class Application extends Canvas implements MouseListener {
    int height = 700;
    int width = 700;
    int count = 0;

    Application() {
        addMouseListener(this);


        setSize(width, height);
        setVisible(true);
    }

    public static void main (String[] args) {

        Application application = new Application();

        Frame frame = new Frame("Metrik Version 1.0");
        frame.setSize(application.width, application.height);
        frame.setVisible(true);
        frame.add(application);
        menubuild(frame, application);
    }

    public static void menubuild(Frame frame, Application application){
        MenuBar menu = new MenuBar();
        Menu program = new Menu("Program");
        Menu hintergrund = new Menu("Hintergrund");

        MenuItem quit = new MenuItem("Quit");
        quit.addActionListener(e -> System.exit(1));
        program.add(quit);

        MenuItem red = new MenuItem("Red");
        red.addActionListener(e -> application.setBackground(Color.red));
        hintergrund.add(red);

        MenuItem blue = new MenuItem("Blue");
        blue.addActionListener(e -> application.setBackground(Color.blue));
        hintergrund.add(blue);

        MenuItem green = new MenuItem("Green");
        green.addActionListener(e -> application.setBackground(Color.green));
        hintergrund.add(green);

        MenuItem gray = new MenuItem("Gray");
        gray.addActionListener(e -> application.setBackground(Color.gray));
        hintergrund.add(gray);

        MenuItem white = new MenuItem("White");
        white.addActionListener(e -> application.setBackground(Color.white));
        hintergrund.add(white);

        menu.add(program);
        menu.add(hintergrund);
        frame.setMenuBar(menu);
    }



    @Override
    public void paint (Graphics g) {
        Ellipse2D circle = new Ellipse2D.Float(0, 0,
                                                30, 30);
        Graphics2D g2d = (Graphics2D) g;
        //g2d.draw(circle);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Graphics g = getGraphics();

        if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
            g.drawRect(e.getX(), e.getY(), 30, 30);
            count++;
        }


        if (count == 3) {
            g.clearRect(0,0, width, height);
            count = 0;
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}