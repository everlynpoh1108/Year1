public class Rational {
	public int num ;
	public int den ;
	
	public Rational (int numer, int denom) {
		this.num = numer ;
		this.den = denom ;
	}
	
	public Rational (int numer) {
		this.num = numer ;
		this.den = 1 ;
	}
	
	public Rational add(Rational x) {
		int finalden = this.den*x.den ;
		int thisnum = this.num*(finalden/this.den) ;
		int xnum = x.num*(finalden/x.den) ;
		num = thisnum + xnum ;
		den = finalden ;
		simplify() ;
		return new Rational (num, den) ;
	}
	
	public Rational subtract (Rational x) {
		int finalden = this.den*x.den ;
		int thisnum = this.num*x.den ;
		int xnum = x.num*this.den ;
		
		if (xnum > thisnum) {
			num = xnum - thisnum ;
		}
		else {
			num = thisnum - xnum ;
		}
		simplify() ;
		return new Rational (num,finalden) ;
	}
	
	public Rational multiply (Rational x){
		int denom = den * x.den ;
		int numer = num * x.num ;
		simplify() ;
		return new Rational (numer,denom) ;
	}
	
	public Rational divide (Rational x) {
		int denx = x.num ;
		int numx = x.den ;
		den = this.den*denx ;
		num = this.num*numx ;
		simplify() ;
		return new Rational(num,den) ;	
	}
	
	public boolean equals(Rational x) {
		if (this.num == x.num && this.den == x.den)
		{
			return true ;
		}
		else return false ;
	}
	
	public boolean isLessThan (Rational x) {
		if (this.num/this.den < x.num/x.den)
		{
			return true ;
		}
		else
			return false ;
	}
	
	public void simplify() {
		int divisor = Rational.gcd(num,den) ;
		this.num = num / divisor ;
		this.den = den / divisor ;
		
	}
	
	public static int gcd (int num, int den) {
		
		while ( num != den)
		{
			if (num>den)
				num = num-den ;
			else den = den-num ;
		}
		return num ;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getDen() {
		return den;
	}

	public void setDen(int den) {
		this.den = den;
	}

	@Override
	public String toString() {
		if (den==1 ) return num + " ";
		else if (num==0) return 0 + " " ;
		else
			return num + "/" + den ;
	}

	
	
}