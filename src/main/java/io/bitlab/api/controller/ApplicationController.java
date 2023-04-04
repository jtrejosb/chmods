/**
 * @author JohnnyTB (jtrejosb@live.com)
 * gitlab.com/iolinker | github.com/jtrejosb
 *
 * Licenses GNU GPL v3.0 and Eclipse Public License 2.0
 * Date: 04/04/2023, Time: 11:49:51
 */
package io.bitlab.api.controller;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import io.bitlab.api.model.AccessString;
import io.bitlab.api.view.ApplicationView;

public class ApplicationController {
  private ApplicationView apv;
  private AccessString acc;

  public ApplicationController(ApplicationView apv,AccessString acc) {
    this.apv=apv;
    this.acc=acc;
    apv.addCheckedListener(e->calculate());
    apv.addCopyListener(e->copyToClipboard());
  }

  private void calculate() {
    String output=acc.getChmodValue(apv.getGroupSelection());
    apv.updateOutput(output);
  }

  private void copyToClipboard() {
    String output=acc.getAccessString(apv.getChmodValue());
    StringSelection sel=new StringSelection(output);
    Clipboard clip=Toolkit.getDefaultToolkit().getSystemClipboard();
    clip.setContents(sel,sel);
    System.out.println("Copy ["+output+"]");
  }
}
