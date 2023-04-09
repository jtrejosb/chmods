/**
 * @author JohnnyTB (jtrejosb@live.com)
 * gitlab.com/rootpass | github.com/rootpasss
 *
 * Licenses GNU GPL v3.0 and Eclipse Public License 2.0
 * Date: 03/04/2023, Time: 16:16:35
 */
package io.bitlab.api.model;

public class AccessString {
  public String getAccessString(String input) {
    String str="";
    for(int i=0;i<input.length();i++) {
      switch(input.charAt(i)) {
        case '0': str+="---";break;
        case '1': str+="--x";break;
        case '2': str+="-w-";break;
        case '3': str+="-wx";break;
        case '4': str+="r--";break;
        case '5': str+="r-x";break;
        case '6': str+="rw-";break;
        case '7': str+="rwx";break;
        default:  str=null; i=input.length();
      }
    }
    return input.length()==1&&str!=null?"------"+str:input.length()==2&&str!=null?"---"+str:str;
  }

  public String getChmodValue(String[] array) {
    String stringVal="";
    for(int i=0;i<array.length;i++) {
      int count=0;
      for(int j=0;j<array[i].length();j++) {
        if(array[i].charAt(j)=='r')
          count+=4;
        else if(array[i].charAt(j)=='w')
          count+=2;
        else if(array[i].charAt(j)=='x')
          count++;
      }
      stringVal+=count;
    }

    return stringVal;
  }
}
