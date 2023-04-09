/**
 * @author JohnnyTB (jtrejosb@live.com)
 * gitlab.com/rootpass | github.com/rootpasss
 *
 * Licenses GNU GPL v3.0 and Eclipse Public License 2.0
 * Date: 02/04/2023, Time: 18:42:52
 */
package io.bitlab.api.launch;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import io.bitlab.api.controller.ApplicationController;
import io.bitlab.api.model.AccessString;
import io.bitlab.api.view.ApplicationView;

public class Chmods {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          if(System.getProperty("os.name").equals("Linux"))
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
          else
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

          ApplicationView apv=new ApplicationView();
          AccessString acc=new AccessString();
          new ApplicationController(apv,acc);
        } catch(Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}
