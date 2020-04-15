package mehmetgul.mylib.xxxothers;



class Data{
	public void A() {
		B();
		System.out.println("public access modifier");
	}
	private void B() {

		System.out.println("private access modifier");
	}
	void C() {
		A();
		B();
		System.out.println("default access modifier");
	}
}


public class practice2  {
	public static void main(String[] args) {
		Data dt=new Data();
		dt.A();
		dt.C();
		//dt.B();private method not visible outside of the class
	}

}