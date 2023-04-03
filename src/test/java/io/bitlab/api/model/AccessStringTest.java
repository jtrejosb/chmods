/**
 * @author JohnnyTB (jtrejosb@live.com)
 * gitlab.com/iolinker | github.com/jtrejosb
 *
 * Licenses GNU GPL v3.0 and Eclipse Public License 2.0
 * Date: 03/04/2023, Time: 16:23:26
 */
package io.bitlab.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AccessStringTest {
  private AccessString acc=new AccessString();

  @Test
  void shouldBeEquals441() {
    String val="441";
    String expected="r--r----x";
    String actual=acc.getAccessString(val);
    assertEquals(expected,actual);
  }

  @Test
  void shouldBeEquals043() {
    String val="43";
    String expected="---r---wx";
    String actual=acc.getAccessString(val);
    assertEquals(expected,actual);
  }

  @Test
  void shouldBeEquals664() {
    String val="644";
    String expected="rw-r--r--";
    String actual=acc.getAccessString(val);
    assertEquals(expected,actual);
  }

  @Test
  void shouldBeEquals563() {
    String val="563";
    String expected="r-xrw--wx";
    String actual=acc.getAccessString(val);
    assertEquals(expected,actual);
  }

  @Test
  void shouldBeNull() {
    String val="8";
    String expected=null;
    String actual=acc.getAccessString(val);
    assertEquals(expected,actual);
  }
}
