/**
 * @author JohnnyTB (jtrejosb@live.com)
 * gitlab.com/iolinker | github.com/jtrejosb
 *
 * Licenses GNU GPL v3.0 and Eclipse Public License 2.0
 * Date: 04/04/2023, Time: 11:10:51
 */
package io.bitlab.api.view;

import java.awt.GridLayout;

import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class CheckBoxGroup extends JPanel {
  private JCheckBox ch1=new JCheckBox();
  private JCheckBox ch2=new JCheckBox();
  private JCheckBox ch3=new JCheckBox();
  private EmptyBorder eBorder;
  private String title;

  public CheckBoxGroup(String title) {
    this.title=title;
    setBorder(new TitledBorder(title));
    setLayout(new GridLayout(3,1));
    initComponents();
  }

  private void initComponents() {
    int w=53;
    ch1.setBorder(new EmptyBorder(0,w,0,0));
    ch2.setBorder(ch1.getBorder());
    ch3.setBorder(ch1.getBorder());
    ch1.putClientProperty("JComponent.sizeVariant","large");
    ch2.putClientProperty("JComponent.sizeVariant","large");
    ch3.putClientProperty("JComponent.sizeVariant","large");
    add(ch1);
    add(ch2);
    add(ch3);
  }

  public void putListeners(java.awt.event.ActionListener l) {
    ch1.addActionListener(l);
    ch2.addActionListener(l);
    ch3.addActionListener(l);
  }

  @Override
  public String toString() {
    String output="";
    output+=ch1.isSelected()?"r":"-";
    output+=ch2.isSelected()?"w":"-";
    output+=ch3.isSelected()?"x":"-";
    return output;
  }
}
