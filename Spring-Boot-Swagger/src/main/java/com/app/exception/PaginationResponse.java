package com.app.exception;

import java.util.List;

import com.app.model.Employee3;

public class PaginationResponse {

	private Integer pageSize;
	private Integer pageNo;
	private Long totalRecords;
	private List<Employee3> emp;

	public PaginationResponse() {
		super();
	}

	public PaginationResponse(Integer pageSize, Integer pageNo, Long totalRecords, List<Employee3> emp) {
		super();
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.totalRecords = totalRecords;
		this.emp = emp;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<Employee3> getEmp() {
		return emp;
	}

	public void setEmp(List<Employee3> emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "PaginationResponse [pageSize=" + pageSize + ", pageNo=" + pageNo + ", totalRecords=" + totalRecords
				+ ", emp=" + emp + "]";
	}

}
