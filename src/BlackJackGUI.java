import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BlackJackGUI {
    private JFrame frame;
    private JPanel gamePanel, buttonPanel;
    private BlackJack game;
    private JButton hitButton, stayButton, newGameButton;

    public BlackJackGUI() {
        game = new BlackJack();
        initializeGUI();
    }

    private void initializeGUI() {
        frame = new JFrame("Black Jack");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600); 
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(new Color(53, 101, 77));
                game.draw(g, getWidth(), getHeight());
            }
        };
        frame.add(gamePanel, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(new Color(53, 101, 77)); // Set background color to match the sample

        hitButton = new JButton("Hit");
        hitButton.setFocusable(false);
        hitButton.addActionListener(this::handleHit);

        stayButton = new JButton("Stay");
        stayButton.setFocusable(false);
        stayButton.addActionListener(this::handleStay);

        newGameButton = new JButton("New Game");
        newGameButton.setFocusable(false);
        newGameButton.addActionListener(this::handleNewGame);
        

        buttonPanel.add(hitButton);
        buttonPanel.add(stayButton);
        buttonPanel.add(newGameButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void handleHit(ActionEvent e) {
        game.hit();
        gamePanel.repaint();
        checkGameState();
    }

    private void handleStay(ActionEvent e) {
        game.stay();
        gamePanel.repaint();
        checkGameState();
    }

    private void handleNewGame(ActionEvent e) {
        game.newGame();
        hitButton.setEnabled(true);
        stayButton.setEnabled(true);
        gamePanel.repaint();
    }

    private void checkGameState() {
        if (game.isGameOver()) {
            hitButton.setEnabled(false);
            stayButton.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BlackJackGUI::new);
    }
}
