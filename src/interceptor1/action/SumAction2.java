// staticParams 인터셉터 이용하기
package interceptor1.action;

import interceptor1.dao.SumDAO2;
import interceptor1.model.NumberForAdd2;
import com.opensymphony.xwork2.Action;

import java.util.Map;
import com.opensymphony.xwork2.config.entities.Parameterizable;

public class SumAction2 implements Action, Parameterizable {

	NumberForAdd2 num;
	private int sum = 0;
	Map<String, Object> params;
	
	@Override
	public String execute() throws Exception {
		num = new NumberForAdd2();	
		num.setNum1(params.get("num1").toString());
		num.setNum2(params.get("num2").toString());
		SumDAO2 dao = new SumDAO2();
		sum = dao.add(num);
		return SUCCESS;
	}
	
	// result.jsp 에서 sum 값을 참조시키기 위해
	public int getSum() {
		return sum;
	}

	@Override
	public void addParam(String arg0, Object arg1) 	{	}
	@Override
	public Map<String, Object> getParams() 			{	return params;	}
	@Override
	public void setParams(Map<String, Object> arg0) {	this.params = arg0;	}

}
