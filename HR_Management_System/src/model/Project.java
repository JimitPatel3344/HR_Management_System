package model;

public class Project {

	
		private Integer pid;
		private Integer pmid;
		private String pname;
		private String clientname;
		private String programminglanguage;
		private String databasetechnology;
		private Double pcost;
		private String psdate;
		private String pedate;
		private String pdes;
		
		// Getters and Setters
		
		public Integer getPid() {
			return pid;
		}
		public void setPid(Integer pid) {
			this.pid = pid;
		}
		
		public Integer getPmid() {
			return pmid;
		}
		public void setPmid(Integer pmid) {
			this.pmid = pmid;
		}
		
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		
		public String getClientname() {
			return clientname;
		}
		public void setClientname(String clientname) {
			this.clientname = clientname;
		}
		
		public String getProgramminglanguage() {
			return programminglanguage;
		}
		public void setProgramminglanguage(String programminglanguage) {
			this.programminglanguage = programminglanguage;
		}
		
		public String getDatabasetechnology() {
			return databasetechnology;
		}
		public void setDatabasetechnology(String databasetechnology) {
			this.databasetechnology = databasetechnology;
		}
		
		public Double getPcost() {
			return pcost;
		}
		public void setPcost(Double pcost) {
			this.pcost = pcost;
		}
		
		public String getPsdate() {
			return psdate;
		}
		public void setPsdate(String psdate) {
			this.psdate = psdate;
		}
		
		public String getPedate() {
			return pedate;
		}
		public void setPedate(String pedate) {
			this.pedate = pedate;
		}
		
		public String getPdes() {
			return pdes;
		}
		public void setPdes(String pdes) {
			this.pdes = pdes;
		}		
}
