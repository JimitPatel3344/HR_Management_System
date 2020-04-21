package model;

public class Payroll
{
	
	private Long payrollid;
	private Integer eid;	
	private String payrolltype;
	private Integer amount;
	private String payrolldate;
	private String payrollmonth;
	
	public Long getPayrollid() {
		return payrollid;
	}
	public void setPayrollid(Long payrollid) {
		this.payrollid = payrollid;
	}
	
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	
	public String getPayrolltype() {
		return payrolltype;
	}
	public void setPayrolltype(String payrolltype) {
		this.payrolltype = payrolltype;
	}
	
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public String getPayrolldate() {
		return payrolldate;
	}
	public void setPayrolldate(String payrolldate) {
		this.payrolldate = payrolldate;
	}
	
	public String getPayrollmonth() {
		return payrollmonth;
	}
	public void setPayrollmonth(String payrollmonth) {
		this.payrollmonth = payrollmonth;
	}
		
}
