import javax.swing.*;

public class gameFrame extends JFrame {
    gameFrame(){
        //gamePanel panel = new gamePanel();
        this.add(new gamePanel());
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }


}
