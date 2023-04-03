package io.bitlab.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CoreTest {
  private Core grant=new Core();
  @Test
  void shouldBeEquals441() {
    String val="441";
    String expected="r--r----x";
    String actual=grant.getGrantString(val);
    assertEquals(expected,actual);
  }

  @Test
  void shouldBeEquals043() {
    String val="43";
    String expected="---r---wx";
    String actual=grant.getGrantString(val);
    assertEquals(expected,actual);
  }

  @Test
  void shouldBeEquals664() {
    String val="644";
    String expected="rw-r--r--";
    String actual=grant.getGrantString(val);
    assertEquals(expected,actual);
  }

  @Test
  void shouldBeEquals563() {
    String val="563";
    String expected="r-xrw--wx";
    String actual=grant.getGrantString(val);
    assertEquals(expected,actual);
  }

  @Test
  void shouldBeNull() {
    String val="8";
    String expected=null;
    String actual=grant.getGrantString(val);
    assertEquals(expected,actual);
  }
}
