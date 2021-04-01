package day24;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService(endpointInterface = "day24.ComplexInterface")
@HandlerChain(file="day24/handler-chain.xml")
public class ComplexService implements ComplexInterface{
	Employee emp;
	List<Employee> list=new ArrayList<>();
		public ComplexService()
		{
			emp=new Employee(1,"ramu",1000);
			list.add(emp);
			emp=new Employee(2,"somu",2000);
			list.add(emp);
		}
	
		
		@WebMethod
	public void setEmployee(Employee emp) {
		System.out.println("new employee added...:"+emp.getEid()+":"+emp.getEname());
		this.emp=emp;
		list.add(emp);
	}
	
		@WebMethod
	public void setAllEmployee(List<Employee> list) {
		System.out.println("all employees are added...."+list);
		this.list=list;
	}
	
		@WebMethod
	public Employee getEmployee(String eid) {
		Iterator<Employee> iter=list.iterator();
		int eidnum=Integer.parseInt(eid);
		while(iter.hasNext()) {
			Employee e=iter.next();
			if(e.getEid()==eidnum) {
				return e;
			}
			else {
				return null;
			}
		}
		return null;
	}
	
		@WebMethod
	public List<Employee> getAllEmployees(){
		return this.list;
	}
}
