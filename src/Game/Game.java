package Game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Game {

    private JPanel gamePanel;

    public void start() {
        JFrame frame = initFrame();
        JPanel btnPanel = initBtnPanel(frame);
        initGamePanel(frame, btnPanel);
        frame.revalidate();
    }

    private void initGamePanel(JFrame frame, JPanel btnPanel) {
        gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());

        JPanel topMenu = new JPanel();
        topMenu.setBackground(Color.DARK_GRAY);
        topMenu.setLayout(new FlowLayout(FlowLayout.LEFT));
        gamePanel.add(topMenu, BorderLayout.NORTH);

        JButton backBtn = new JButton();
        backBtn.setText("Back");
        backBtn.setBackground(Color.DARK_GRAY);
        backBtn.setForeground(Color.BLACK);
        backBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                switchFromGamePanelToBtnPanel(frame, btnPanel, gamePanel);
            }
        });
        topMenu.add(backBtn);

        DrawingPanel drawingPanel = new DrawingPanel();
        gamePanel.add(drawingPanel, BorderLayout.CENTER);
    }

    private JFrame initFrame() {
        JFrame frame = new JFrame("Drawing");
        frame.setSize(1000, 500);
        frame.setVisible(true);
        BorderLayout layout = new BorderLayout();
        layout.setVgap(10);
        frame.setLayout(layout);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return frame;
    }

    private JPanel initBtnPanel(JFrame frame) {
        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Color.PINK);
        frame.add(btnPanel, BorderLayout.CENTER);
        GridLayout gridLayout = new GridLayout(3, 1);
        gridLayout.setVgap(10);
        btnPanel.setLayout(gridLayout);
        btnPanel.setBorder(new EmptyBorder(150, 350, 150, 350));

        JButton drawBtn = new JButton();
        drawBtn.setBackground(Color.GRAY);
        drawBtn.setForeground(Color.BLACK);
        drawBtn.setText("Draw");
        drawBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                switchFromBtnPanelToGamePanel(frame, btnPanel, gamePanel);
            }
        });
        btnPanel.add(drawBtn);

        JButton exitBtn = new JButton();
        exitBtn.setBackground(Color.GRAY);
        exitBtn.setForeground(Color.BLACK);
        exitBtn.setText("Exit");
        btnPanel.add(exitBtn);

        JButton galleryBtn = new JButton();
        galleryBtn.setBackground(Color.GRAY);
        galleryBtn.setForeground(Color.BLACK);
        galleryBtn.setText("Gallery");
        btnPanel.add(galleryBtn);
        return btnPanel;
    }

    private void switchFromGamePanelToBtnPanel(JFrame frame, JPanel btnPanel, JPanel gamePanel) {
        frame.remove(gamePanel);
        frame.add(btnPanel);
        frame.revalidate();
        frame.repaint();
    }

    private void switchFromBtnPanelToGamePanel(JFrame frame, JPanel btnPanel, JPanel gamePanel) {
        frame.remove(btnPanel);
        frame.add(gamePanel);
        frame.revalidate();
        frame.repaint();
    }
}