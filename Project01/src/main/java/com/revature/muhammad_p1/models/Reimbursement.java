package com.revature.muhammad_p1.models;

import java.sql.Timestamp;
import java.util.Arrays;

public class Reimbursement {

	private int id;
	private double reimbAmount;
	private Timestamp reimbSubmitted = new Timestamp(System.currentTimeMillis());
	private Timestamp reimbResolved = null;
	private String reimbDescription = null; 
	private byte[] reimbReceipt = null;
	private int reimbAuthor;
	private int reimbResolver;
	private String reimbAuthorFirstName;
	private String reimbAuthorLastName;
	private String reimbResolverFirstName;
	private String reimbResolverLastName;
	private String reimbStatus;
	private int reimbStatusId;
	private int reimbTypeId;  
	private String reimbType;
	
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement(int id, double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
			String reimbDescription, byte[] reimbReceipt, int reimbAuthor, int reimbResolver,
			String reimbAuthorFirstName, String reimbAuthorLastName, String reimbResolverFirstName,
			String reimbResolverLastName, String reimbStatus, String reimbType) {
		super();
		this.id = id;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbReceipt = reimbReceipt;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbAuthorFirstName = reimbAuthorFirstName;
		this.reimbAuthorLastName = reimbAuthorLastName;
		this.reimbResolverFirstName = reimbResolverFirstName;
		this.reimbResolverLastName = reimbResolverLastName;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}
	public Reimbursement(int id, int reimbAuthor, int reimbResolver, String reimbAuthorFirstName, String reimbAuthorLastName, double reimbAmount,
			String reimbStatus, Timestamp reimbSubmitted, String reimbDescription) {
		super();
		this.id = id;
		this.reimbResolver = reimbResolver;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbDescription = reimbDescription;
		this.reimbAuthorFirstName = reimbAuthorFirstName;
		this.reimbAuthorLastName = reimbAuthorLastName;
		this.reimbStatus = reimbStatus;
	}
	
	public Reimbursement(int id,String reimbAuthorFirstName, String reimbAuthorLastName, double reimbAmount,  
			String reimbStatus, Timestamp reimbSubmitted, String reimbDescription) {
		super();
		this.id = id;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbDescription = reimbDescription;
		this.reimbAuthorFirstName = reimbAuthorFirstName;
		this.reimbAuthorLastName = reimbAuthorLastName;
		this.reimbStatus = reimbStatus;
	}
	
	public Reimbursement(int id, double reimbAmount,  String reimbDescription, int reimbAuthor, int reimbResolver,
			int reimbStatusId ) {
		super();
		this.id = id;
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
	}
	
	public Reimbursement(double reimbAmount,  String reimbDescription, int reimbAuthor, int reimbStatusId, int reimbTypeId ) {
		super();
		
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbStatusId = reimbStatusId;
		this.reimbTypeId = reimbTypeId;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}
	public void setReimbSubmitted(Timestamp reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}
	public Timestamp getReimbResolved() {
		return reimbResolved;
	}
	public void setReimbResolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}
	public String getReimbDescription() {
		return reimbDescription;
	}
	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}
	public byte[] getReimbReceipt() {
		return reimbReceipt;
	}
	public void setReimbReceipt(byte[] reimbReceipt) {
		this.reimbReceipt = reimbReceipt;
	}
	public int getReimbAuthor() {
		return reimbAuthor;
	}
	public void setReimbAuthor(int reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}
	public int getReimbResolver() {
		return reimbResolver;
	}
	public void setReimbResolver(int reimbResolver) {
		this.reimbResolver = reimbResolver;
	}
	public String getReimbAuthorFirstName() {
		return reimbAuthorFirstName;
	}
	public void setReimbAuthorFirstName(String reimbAuthorFirstName) {
		this.reimbAuthorFirstName = reimbAuthorFirstName;
	}
	public String getReimbAuthorLastName() {
		return reimbAuthorLastName;
	}
	public void setReimbAuthorLastName(String reimbAuthorLastName) {
		this.reimbAuthorLastName = reimbAuthorLastName;
	}
	public String getReimbResolverFirstName() {
		return reimbResolverFirstName;
	}
	public void setReimbResolverFirstName(String reimbResolverFirstName) {
		this.reimbResolverFirstName = reimbResolverFirstName;
	}
	public String getReimbResolverLastName() {
		return reimbResolverLastName;
	}
	public void setReimbResolverLastName(String reimbResolverLastName) {
		this.reimbResolverLastName = reimbResolverLastName;
	}
	public String getReimbStatus() {
		return reimbStatus;
	}
	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
	public String getReimbType() {
		return reimbType;
	}
	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}
	
	public int getReimbTypeId() {
		return reimbTypeId;
	}
	public void setReimbTypeId(int reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}
	
	public int getReimbStatusId() {
		return reimbStatusId;
	}
	public void setReimbStatusId(int reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", reimbAmount=" + reimbAmount + ", reimbSubmitted=" + reimbSubmitted
				+ ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription + ", reimbReceipt="
				+ Arrays.toString(reimbReceipt) + ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver
				+ ", reimbAuthorFirstName=" + reimbAuthorFirstName + ", reimbAuthorLastName=" + reimbAuthorLastName
				+ ", reimbResolverFirstName=" + reimbResolverFirstName + ", reimbResolverLastName="
				+ reimbResolverLastName + ", reimbStatus=" + reimbStatus + ", reimbType=" + reimbType + "]";
	}
	
	
	
	
	
	
	
	


	
	
}
