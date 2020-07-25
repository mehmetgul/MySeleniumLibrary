package mehmetgul.mylib.xxxothers.test;

import org.testng.annotations.Test;

public class Oca {
	// Bu soruda dikkat edilmesi gerekenler.
//Burada chain kullanarak bu soru yazilmis.
//Once str yi trim edicek. Trim hem bastaki hem sonraki bosluklari siler.
// Concate derken "" kullanmasi bize sagdaki degerin String olmadigini gosterir.
//str nin 6 indeksinde ne var? S var.
//sonra str nin indexof (Sw, 1) demek.
//Sw un basladigi yeri soruyor ama bunu arastirirken binci indexten baslayarak bul diyor.
//dolayisiyla ilk bastaki SW kismini atliyor.
	@Test
	public void Soru14() {
		String str = "Sweet Sweat ";
		String str2 = str.charAt(6) + "" + str.indexOf("Sw", 1);
		System.out.println(str2);
	}

	/**
	 * Bu soru normal bir swithc case sorusu ama burada
	 * dikkat edilmesi gereken iki husus var.
	 * block icin de tanimladigini bir variable sadece block icinde
	 * gecerlidir. Blok disinda bir hukmu yoktur.
	 * Burada color variable swithc blogu icinde tanmli oldugu icin
	 * sorunsuz calisir.
	 * Ama blogun disinda color i yazdirmaya kalktiginizda
	 * compile hatasi verir.
	 * Ayni zamanda bu bu checked expectiondir.
	 * Compile time error oldugu icin.
	 */
	@Test
	public void Soru23() {
		char colorCode = 'y';
		switch ((colorCode)) {
			case 'r':
				int color = 100;
				break;
			case 'b':
				color = 10;
				break;
			case 'y':
				color = 1;
				break;
		}
		//System.out.println(color);
	}

	static double area; //class levelda auto initiliza olur.

	@Test
	public void Soru34() {
		double p, b, h;  //line 1
		if (area == 0) {
			//p=b*h;  //initialize before use
			b = 3;
			h = 4;
			p = 0.5;
			area = p * b * h;   //line 2

		}
		System.out.println("area is " + area);

	}

	/**
	 * Bu soruda da cevap bana gore a sikki olur.
	 * options metod icinde tanimlanmis ve bu demektirki
	 * option i kullanmadan once initialize etmemiz lazim.
	 * Soruda bunu saglayan tek cevap a sikki.
	 */
	@Test
	public void Soru44() {

	}

	public void Soru45() {
		/**
		 * c2 etends c1{}
		 * c3 extends c2{}
		 *
		 * c1
		 * |
		 * c2
		 * |
		 * c3
		 *
		 */
		//C2 obj3 = (C2) new C1(); need to discuss on this
		//A sikki
	}

	@Test
	public void Soru48() {
/**
 * A.	String str = “Java”;  konabilir. Global seviyede tanimliyoruz
 * B.	for(int iVal = 0; iVal <=5; iVal++){} looplar metod icinde yazilmali
 * C.	Test() {} Constructer yazilabilir. default dur bu zaten
 * D.	package p1; Class in ustunde yazilir.
 * E.	import java.io.*; class in ustu package in altinda yazilir.
 *
 */
	}

	@Test
	public void soru70(){
		if(3>2 | 4<=5){
			System.out.println("4");
		}else
			System.out.println("6");
	}
//cevap 12
}

