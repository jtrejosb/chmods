/**
 * @author JohnnyTB (jtrejosb@live.com)
 * gitlab.com/iolinker | github.com/jtrejosb
 *
 * Licenses GNU GPL v3.0 and Eclipse Public License 2.0
 * Date: 04/04/2023, Time: 11:06:18
 */
package io.bitlab.api.view;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ApplicationView extends JFrame {
  private JPanel contentPane;
  private JPanel groupsPane;
  private CheckBoxGroup cbg1;
  private CheckBoxGroup cbg2;
  private CheckBoxGroup cbg3;
  private String output="000";
  private JButton btnCopy;

  public ApplicationView() {
    super("chmod Calc");
    setSize(470,320);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    contentPane=new JPanel() {
      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
              RenderingHints.VALUE_ANTIALIAS_ON));
        g2.setFont(new Font(getFont().getFontName(),Font.BOLD,40));
        g2.setColor(Color.decode("#3E92ED"));
        g2.drawString(output,197,50);
      }
    };
    contentPane.setLayout(null);
    add(contentPane);

    groupsPane=new JPanel();
    groupsPane.setBounds(0,100,getWidth(),200);
    groupsPane.setLayout(new GridLayout(1,3));

    cbg1=new CheckBoxGroup("Owner Rights");
    cbg2=new CheckBoxGroup("Group Rights");
    cbg3=new CheckBoxGroup("Others Rights");

    btnCopy=new JButton("Copy");
    btnCopy.setFocusPainted(false);
    btnCopy.setBounds(getWidth()/2-55/2,60,58,25);

    groupsPane.add(cbg1);
    groupsPane.add(cbg2);
    groupsPane.add(cbg3);
    contentPane.add(btnCopy);
    contentPane.add(groupsPane);

    setVisible(true);
  }

  public void addCopyListener(ActionListener l) {
    btnCopy.addActionListener(l);
  }

  public void addCheckedListener(ActionListener l) {
    cbg1.putListeners(l);
    cbg2.putListeners(l);
    cbg3.putListeners(l);
  }

  public void updateOutput(String output) {
    this.output=output;
    contentPane.repaint();
  }

  public String[] getGroupSelection() {
    String[]selArray=new String[3];
    selArray[0]=cbg1.toString();
    selArray[1]=cbg2.toString();
    selArray[2]=cbg3.toString();
    return selArray;
  }

  public String getChmodValue() {
    return output;
  }
}
