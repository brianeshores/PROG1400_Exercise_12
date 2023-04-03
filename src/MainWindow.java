import java.awt.*;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow frame = new MainWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the window frame and set its properties
     */
    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 600);

        //Make our own JPanel
        DrawingPanel drawing = new DrawingPanel();
        drawing.setBackground(Color.WHITE);

        this.add(drawing );
        drawing.setLayout(null);
    }
}
