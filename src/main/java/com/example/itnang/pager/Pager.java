package com.example.itnang.pager;

import java.util.ArrayList;
import java.util.List;

public class Pager {
	private int page = 1;
	private int perPage = 10;
	private float total;
	private int perGroup = 5;
	
	private int search;
	private String keyword;
	
	public String getQuery() {
		String queryString = "";
		
		if(search > 0)
			queryString += "&search=" + search + "&keyword" + keyword;
		
		return queryString;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getPerGroup() {
		return perGroup;
	}
	public void setPerGroup(int perGroup) {
		this.perGroup = perGroup;
	}
	public int getSearch() {
		return search;
	}
	public void setSearch(int search) {
		this.search = search;
	}
	public String getKeyword() {
		if(search < 1)
			keyword = "";
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	// 처음페이지
	public int getFirst() {
		return 1;
	}
	
	// 마지막페이지
	public int getLast() {
		return (int)Math.ceil(total / perPage);
	}
	
	// 다음페이지
	public int getNext() {
		if((int)Math.ceil(page) < (int)Math.ceil(total / perPage))
			return (int)Math.ceil(page + 1);
		else
			return (int)Math.ceil(total / perPage);
	}
	
	// 다다음페이지
	public int getNext2() {
		int next2 = (((page - 1) / perGroup) + 1) * perGroup + 1;
		int last = getLast();
		
		return next2 < last ? next2 : last;
		// 다음 그룹의 첫번째 페이지
	}
	
	//이전페이지
	public int getBack() {
		if((int)Math.ceil(page) > getFirst())
			return (int)Math.ceil(page - 1);
		else
			return 1;
	}
	
	//이이전페이지
	public int getBack2() {
		return page <= perGroup ? 1 : (((page - 1) / perGroup) - 1) * perGroup + 1;
		// 이전 그룹의 첫번째 페이지
	}
	
	// 페이지 리스트
	public List<Integer> getList() {
		List<Integer> list = new ArrayList<Integer>();
		
		int startPage = (((page - 1) / perGroup) + 0) * perGroup + 1;
		
		for(int i = startPage; i < (startPage + perGroup) && i <= getLast(); i++) {
			list.add(i);
		}
		
		// 페이지가 없다면 포문이 작동하지 않기떄문에 기본적으로 1값을 넣어줌
		if(list.isEmpty()) {
			list.add(1);
		}
		
		return list;
	}
	
}
