package mehmetgul;
class Change{
	long coin2=0;
	long bill5=0;
	long bill10=0; // I am from local
	//hey I am here again 

//This is Serkan from online
	
	//This is continue online

}
public class Solution {
	static Change change = new Change();

	static Change optimalChange(long s){
		if(s==2){ //changed by dev1
			change.coin2=0;
			change.bill5=0;
			change.bill10=0;
		}else if(s%10==0){
			change.bill10=s/10;
			change.bill5=0;
			change.coin2=0;
		}else if(s%5==0){
			change.bill10=0;
			change.bill5=s/5;
			change.coin2=0;
// this is extra online

		}else if(s%2==0){
			if(s/10<0){
				change.bill10=s/10;
				change.bill5=0;
				change.coin2=0;
				return change;
			}else if(s/2>=1 &s<10)
			change.bill10=0;
			change.bill5=0;
			change.coin2=s/2;
		}


// this is also from local changegit

		return change;
	}

	public static void main(String[] args) {
		System.out.println("for 1 euro");
		optimalChange(1);
		System.out.println("Coin(s) 2euro: "+change.coin2 );
		System.out.println("Bill(s) 5euro: "+change.bill5);
		System.out.println("Bill(s) 10euro: "+change.bill10);

		System.out.println("for 6 euro");
		optimalChange(6);
		System.out.println("Coin(s) 2euro: "+change.coin2 );
		System.out.println("Bill(s) 5euro: "+change.bill5);
		System.out.println("Bill(s) 10euro: "+change.bill10);

		System.out.println("for 10 euro");
		optimalChange(10);
		System.out.println("Coin(s) 2euro: "+change.coin2 );
		System.out.println("Bill(s) 5euro: "+change.bill5);
		System.out.println("Bill(s) 10euro: "+change.bill10);

		System.out.println("for 8 euro");
		optimalChange(8);
		System.out.println("Coin(s) 2euro: "+change.coin2 );
		System.out.println("Bill(s) 5euro: "+change.bill5);
		System.out.println("Bill(s) 10euro: "+change.bill10);
	}

}
