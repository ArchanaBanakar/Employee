package Employee.Management.Controller.Exception;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends Exception{
	private long id;
	public EmployeeNotFoundException(long id) {
		super(String.format("Employee is not found with id:'%s'",id));
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}

