import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Application extends Canvas implements MouseListener {

    private int height = 700;
    private int width = 700;
    private int count = 0;
    private int diameter = 30;
    private static TextArea coordinates = new TextArea("Coordinates:", 3, 3, 3);
    private PopupMenu popup = new PopupMenu("Radius");

    Application() {
        addMouseListener(this);


        setSize(width, height);
        setVisible(true);
    }

    public static void main (String[] args) {

        Application application = new Application();

        Frame frame = new Frame("Metrik Version 1.2.0");
        frame.setSize(application.width, application.height);
        frame.setVisible(true);

        coordinates.setEditable(false);
        coordinates.setBounds(application.width / 2 - 40, 40, 100, 35);

        frame.add(coordinates);
        frame.add(application);

        menubuild(frame, application);
    }

    private static void menubuild(Frame frame, Application application){
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


        Menu radius = new Menu("Radius");


        MenuItem radius10 = new MenuItem("10px");
        radius10.addActionListener(e -> application.diameter = 10);
        application.popup.add(radius10);

        MenuItem radius20 = new MenuItem("20px");
        radius20.addActionListener(e -> application.diameter = 20);
        application.popup.add(radius20);

        MenuItem radius30 = new MenuItem("30px");
        radius30.addActionListener(e -> application.diameter = 30);
        application.popup.add(radius30);

        MenuItem radius40 = new MenuItem("40px");
        radius40.addActionListener(e -> application.diameter = 40);
        application.popup.add(radius40);

        MenuItem radius50 = new MenuItem("50px");
        radius50.addActionListener(e -> application.diameter = 50);
        application.popup.add(radius50);

        radius.add(application.popup);


        menu.add(program);
        menu.add(hintergrund);
        menu.add(radius);
        frame.setMenuBar(menu);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        Graphics g = getGraphics();

        if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
            g.drawOval(e.getX(), e.getY(), diameter, diameter);
            count++;
            coordinates.setText("Coordinates:\n" +
                                "X: " + e.getX() + " / Y: " + e.getY());
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