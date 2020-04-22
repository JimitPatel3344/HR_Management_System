package model;

public class Task {

	public Task() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer tid;
	private Integer destinationeid;
	private Integer sourceeid;
	private String destinationEname;
	private Integer pid;
	private String pname;
	private String tsdate;
	private String tedate;
	private String tpriority;
	private String tdes;
	private Integer tstatus;


	
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}	
	
	public Integer getDestinationeid() {
		return destinationeid;
	}
	public void setDestinationeid(Integer destinationeid) {
		this.destinationeid = destinationeid;
	}
	
	public Integer getSourceeid() {
		return sourceeid;
	}
	public void setSourceeid(Integer sourceeid) {
		this.sourceeid = sourceeid;
	}
	
		
	public String getDestinationEname() {
		return destinationEname;
	}
	public void setDestinationEname(String destinationEname) {
		this.destinationEname = destinationEname;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public String getTsdate() {
		return tsdate;
	}
	public void setTsdate(String tsdate) {
		this.tsdate = tsdate;
	}
	
	public String getTedate() {
		return tedate;
	}
	public void setTedate(String tedate) {
		this.tedate = tedate;
	}
	
	public String getTpriority() {
		return tpriority;
	}
	public void setTpriority(String tpriority) {
		this.tpriority = tpriority;
	}
	
	public String getTdes() {
		return tdes;
	}
	public void setTdes(String tdes) {
		this.tdes = tdes;
	}
	
	public Integer getTstatus() {
		return tstatus;
	}
	public void setTstatus(Integer tstatus) {
		this.tstatus = tstatus;
	}

}
