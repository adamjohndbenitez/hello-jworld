package jfjca.chapter6;

public class ExSixTwo {
    public static void main(String[] args) {
        String str = "7" + 5 + 10;
        str = 7 + 5 + "10";
        str = "7" + (5 + 10);
        System.out.println("str : " + str);

        int m = 50;
        System.out.println("int m = 50; " + m);
        int n = ++m;
        System.out.println("int n = ++m; " + n);
        int o = m--;
System.out.println("int o = m--; " + o);
        int p = --o+m--;
System.out.println("int p = --o+m-- " + p);
        int x = m<n?n<o?o<p?p:o:n:m;
System.out.println("int x = m<n?n<o?o<p?p:o:n:m; " + x);
        System.out.println("m : " + m + ",n : " + n + ",o : " + o + ",p : " + p + ",x : " + x);

        int k = 4;
        boolean flag = k++ == 5;
        flag = !flag;
        System.out.println("flag: " + flag);

        byte b = 1;
        System.out.println("byte b = 1" + b);
//        b = b << 1; //Error - Error:(29, 15) java: incompatible types: possible lossy conversion from int to byte
        System.out.println("b = b << 1" + b);
        int c = b << 1;
        System.out.println("int c = b << 1;" + c);

        //byte d += b;
        //System.out.println("byte d += b" + d);
  
        byte e = 0;
        System.out.println("byte e = 0;" + e);

        e += b;
        System.out.println("e : " + e);
    }
}