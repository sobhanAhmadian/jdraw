package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;

public class DrawingPanel extends JPanel {

    GeneralPath path = new GeneralPath();

    public DrawingPanel() {
        super();

        path.moveTo(0, 0);

        final boolean[] clicked = {false};

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                if (clicked[0]) {
                    path.moveTo(e.getX(), e.getY());
                    clicked[0] = false;
                } else
                path.lineTo(e.getX(), e.getY());
                repaint();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                clicked[0] = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                clicked[0] = true;
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke s = new BasicStroke(
                5.5f,
                BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND);
        g2d.setStroke(s);
        g2d.setColor(Color.BLACK);

        g2d.draw(path);
    }
}
