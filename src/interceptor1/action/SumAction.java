package interceptor1.action;

import interceptor1.dao.SumDAO;
import interceptor1.model.NumberForAdd;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class SumAction implements Action, Preparable, ModelDriven{

	NumberForAdd num;
	private int sum = 0;
	
	@Override
	public Object getModel() {		
		return num;
	}

	@Override
	public void prepare() throws Exception {
		num = new NumberForAdd();		
	}

	@Override
	public String execute() throws Exception {
		SumDAO dao = new SumDAO();
		sum = dao.add(num);
		return SUCCESS;
	}
	
	// result.jsp 에서 sum 값을 참조시키기 위해
	public int getSum() {
		return sum;
	}

}
