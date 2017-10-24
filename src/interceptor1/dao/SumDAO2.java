package interceptor1.dao;

import interceptor1.model.NumberForAdd2;

public class SumDAO2 {
	public int add(NumberForAdd2 num) {
		int n1 = Integer.parseInt(num.getNum1());
		int n2 = Integer.parseInt(num.getNum2());
		
		return n1+n2;
	}
}
