package view;

import controller.ClientController;

import javax.swing.*;
import java.awt.*;

public class GameSettingsPanel extends JPanel {

    JLabel introLabel;
    JLabel connectionLabel;
    JLabel playerTurn;
    JLabel scoreLabel;
    JLabel opponentLabel;
    JButton playGame;
    JComboBox<String> playAs;
    JComboBox<String> playAgainst;

    public GameSettingsPanel(ClientController clientController) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.DARK_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout layout = new GridBagLayout();
        this.setLayout((layout));

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        connectionLabel = new JLabel("<html><br><div style='color: white; margin-bottom: 20px; font-size: 20px;'>" + "Play Offline" + "</div></html>");
        add(connectionLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 20;
        add(new JLabel("<html><br><div style='color: white;'>" + "You:" + "</div></html>"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        String[] playsAs = new String[]{"AI lv. 1", "AI lv. 2", "Human"};
        playAs = new JComboBox<String>(playsAs);
        add(playAs, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 20;
        add(opponentLabel = new JLabel("<html><br><div style='color: white;'>" + "Opponent:" + "</div></html>"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        String[] playsAgainst = new String[]{"AI lv. 1", "AI lv. 2", "Human"};
        playAgainst = new JComboBox<String>(playsAgainst);
        add(playAgainst, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("<html><br><div style='color: white;'>" + "Game:" + "</div></html>"), gbc);

        // TODO DIT MOET NIET HIER
        String[] gameTypes = new String[]{"Reversi", "Tic-Tac-Toe"};

        JComboBox<String> gameType = new JComboBox<String>(gameTypes);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(gameType, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;

        playGame = new JButton("<html><div style='padding: 0'>" + "Start game" + "</div></html>");
        playGame.addActionListener(e -> {
            if (!clientController.getLoggedInStatus()) {
                clientController.startGame(gameType.getSelectedItem().toString(), playAs.getSelectedItem().toString());
            } else clientController.getServerCommander().sendSubscribeCommand(gameType.getSelectedItem().toString());
        });
        add(playGame, gbc);

    }

    public String getPlayAs() {
        return playAs.getSelectedItem().toString();
    }

    public String getPlayAgainst() {
        return playAgainst.getSelectedItem().toString();
    }

    public void updateSidebarLabelScore(String s) {
        scoreLabel.setText(s);
    }

    public void updateSidebarLabelPlayerTurn(String s) {
        playerTurn.setText(s);
    }

    public void setPlayButton() {
        playGame.setText("Subscribe");
        remove(opponentLabel);
        remove(playAgainst);
    }

    public void setConnectionLabel() {
        connectionLabel.setText("<html><br><div style=' margin-bottom: 20px; font-size: 20px;'>" + "Play Online" + "</div></html>");
        connectionLabel.setForeground(Color.green);
    }
}
