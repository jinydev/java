package sec04.exam05_cardlayout;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CardLayoutExample extends JFrame {
    private JPanel redCard, greenCard, blueCard;

    public CardLayoutExample() {
        this.setTitle("CardLayoutExample");
        this.setSize(250, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // CardLayout 설정
        this.getContentPane().setLayout(new CardLayout());
        
        // 이름과 함께 패널 추가
        this.getContentPane().add("RedCard", getRedCard());
        this.getContentPane().add("GreenCard", getGreenCard());
        this.getContentPane().add("BlueCard", getBlueCard());
    }

    public JPanel getRedCard() {
        if (redCard == null) {
            redCard = new JPanel();
            redCard.setBackground(Color.RED);
        }
        return redCard;
    }
    public JPanel getGreenCard() {
        if (greenCard == null) {
            greenCard = new JPanel();
            greenCard.setBackground(Color.GREEN);
        }
        return greenCard;
    }
    public JPanel getBlueCard() {
        if (blueCard == null) {
            blueCard = new JPanel();
            blueCard.setBackground(Color.BLUE);
        }
        return blueCard;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            final CardLayoutExample jFrame = new CardLayoutExample();
            jFrame.setVisible(true);
            
            // 1초마다 자동으로 카드 전환하는 스레드
            new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {}
                    
                    SwingUtilities.invokeLater(() -> {
                        CardLayout cardLayout = (CardLayout) jFrame.getContentPane().getLayout();
                        cardLayout.next(jFrame.getContentPane());
                    });
                }
            }).start();
        });
    }
}
