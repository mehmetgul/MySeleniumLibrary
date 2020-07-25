package mehmetgul.mylib.xxxothers.test;

import java.io.IOException;

class MyException extends RuntimeException{}

public class OCA1 {
	public static void main(String[] args) {
		try
		{
			method1();
		}catch (MyException ne) {
			System.out.println("A");
		}

	}
	public static void method1()  {
		try{
			throw 3<10?new MyException():new IOException();
		}catch(IOException ie){
			System.out.println("I");
		}catch (Exception re){
			System.out.println("B");
		}

	}
}
/**
 * Burada method 1 icerisinde error catch edildigi icin
 * main metod icindeki try block hatasiz calismis oluyor.
 * eger metod1 hata verip termina etmis olsaydi ozaman main
 * metod daki catch blok devreye girecekti.
 * < isareti kullanilsayfi ozaman B yazdirirdi.
 */
