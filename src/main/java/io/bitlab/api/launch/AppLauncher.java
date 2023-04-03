/**
 * @author JohnnyTB (jtrejosb@live.com)
 * gitlab.com/iolinker | github.com/jtrejosb
 *
 * Licenses GNU GPL v3.0 and Eclipse Public License 2.0
 * Date: 02/04/2023, Time: 18:42:52
 */
package io.bitlab.api.launch;

import io.bitlab.api.model.AccessString;

public class AppLauncher {
  public static void main(String[] args) {
    AccessString acc=new AccessString();
    for(int i=0;i<=777;i++) {
      String output=acc.getAccessString(String.valueOf(i));
      if(output!=null) {
        System.out.printf("chmod value: %s%npermissions: %s%n",i,output);
      } else {
        System.out.printf("Invalid value '%s'%n",i);
      }
    }
  }
}
