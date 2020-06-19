package login;

import javax.swing.*;
import java.awt.*;
public class IsBannedGUI extends JFrame {
    private JLabel reason = new JLabel("text");
    private JButton cancel = new JButton("Cancel");

    public IsBannedGUI()
    {
        addComponents();
        setProperties();
    }

    public void initPositions()
    {
        reason.setBounds(10,10,500,20);
        cancel.setBounds(200,60,100,20);
    }

    public void setProperties()
    {
        setTitle("You have been banned!");
        setSize(500,125);
        setLayout(null);
        setResizable(false);
        reason.setFont(new Font("arial",Font.BOLD,16));
        reason.setBorder(BorderFactory.createLineBorder(Color.BLACK));


    }

    public void addComponents()
    {
        initPositions();
        add(reason);
        add(cancel);
    }

    public JLabel getReason() {
        return reason;
    }

    public void setReason(JLabel reason) {
        this.reason = reason;
    }

    public JButton getCancel() {
        return cancel;
    }

    public void setCancel(JButton cancel) {
        this.cancel = cancel;
    }
}
