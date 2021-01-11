import java.lang.Math;

class Radix{
  public static int nth(int n, int col){
    return (n/(int)(Math.pow(10, col)))%(int)(Math.pow(10, col));
  }
  
}
