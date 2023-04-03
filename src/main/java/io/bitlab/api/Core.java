package io.bitlab.api;

public class Core {
  public String getGrantString(String value) {
    String str="";
    for(int i=0;i<value.length();i++) {
      switch(value.charAt(i)) {
        case '0': str+="---";break;
        case '1': str+="--x";break;
        case '2': str+="-w-";break;
        case '3': str+="-wx";break;
        case '4': str+="r--";break;
        case '5': str+="r-x";break;
        case '6': str+="rw-";break;
        case '7': str+="rwx";break;
        default:  str=null; i=value.length();
      }
    }
    return value.length()==1&&str!=null?"------"+str:value.length()==2&&str!=null?"---"+str:str;
  }
}
