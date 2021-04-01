package day24;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ComplexInterface
{

	@WebMethod	
	public void setEmployee(Employee emp);
	public void setAllEmployee(List<Employee> list);
	public Employee getEmployee(String eid);
	public List<Employee> getAllEmployees();
	
}
