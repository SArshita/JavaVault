package com.example.tictactoe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeSwing {
    private TicTacToeGame game = new TicTacToeGame();
    private JButton[][] buttons = new JButton[3][3];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToeSwing().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 3, 5, 5));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                button.setFont(new Font("Arial", Font.PLAIN, 40));
                button.addActionListener(new ButtonClickListener(i, j));
                buttons[i][j] = button;
                panel.add(button);
            }
        }

        frame.getContentPane().add(panel);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        private int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (game.makeMove(row, col)) {
                updateButtons();
                if (game.checkWinner()) {
                    JOptionPane.showMessageDialog(null, "Player " + game.getCurrentPlayer() + " wins!");
                    resetGame();
                } else if (game.isBoardFull()) {
                    JOptionPane.showMessageDialog(null, "It's a draw!");
                    resetGame();
                } else {
                    game.switchPlayer();
                }
            }
        }
    }

    private void updateButtons() {
        char[][] board = game.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText(Character.toString(board[i][j]));
                buttons[i][j].setEnabled(board[i][j] == ' ');
            }
        }
    }

    private void resetGame() {
        game.reset();
        updateButtons();
    }
}
