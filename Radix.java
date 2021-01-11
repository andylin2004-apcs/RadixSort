import java.lang.Math;

class Radix{
  public static int nth(int n, int col){
    return Math.abs((n/(int)(Math.pow(10, col)))%(int)(Math.pow(10, col)));
  }
  public static int length(int n){
    return (int)(Math.log10(Math.abs(n))+1);
  }
  public static void main(String[] args) {
    System.out.println(length(-123));
  }
}
