package view;

import javax.swing.*;
import java.awt.*;

public class GameSettingsPanel extends JPanel {

    JLabel playerTurn;
    JLabel scoreLabel;
    JButton resetBtn;
    JButton randBtn;
    JButton interruptBtn;
    JButton playGame;

    public GameSettingsPanel() {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(400,300));
        setBackground(Color.DARK_GRAY);

        GridLayout experimentLayout = new GridLayout(3,2);
        setLayout(experimentLayout);

        add(new JLabel("<html><br><div style='margin: 10; color: white;'>"+"Play as :"+"</div></html>"));

        String[] playsAs = new String[] {"Myself","AI","Kiran"};
        JComboBox<String> playAs = new JComboBox<>(playsAs);
        add(playAs);

        add(new JLabel("<html><br><div style='margin: 10; color: white;'>"+"Gamemode :"+"</div></html>"));
        String[] gameTypes = new String[] {"Reversi","Tic-Tac-Toe"};
        JComboBox<String> gameType = new JComboBox<>(gameTypes);
        add(gameType);

        playGame = new JButton("<html><div style='padding: 0'>"+"Play :"+"</div></html>");
        //playGame.addActionListener(e -> {this.getComponent(0).remove(); this.add(showReversiBoard(), BorderLayout.WEST);});
        add(playGame);

    }

    public void updateSidebarLabelScore(String s) {
        scoreLabel.setText(s);
    }

    public void updateSidebarLabelPlayerTurn(String s) {
        playerTurn.setText(s);
    }
}