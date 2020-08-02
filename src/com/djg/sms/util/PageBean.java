package com.djg.sms.util;

import java.util.List;

public class PageBean<T> {
	private int pageIndex;// ��ǰҳ��
	private int pageSize;// ÿҳ����������
	private int count;// ����������
	private int pageCount;// һ����ҳ��
	private int start;// ��ʼ����λ��
	private int end;// ����
	private List<T> list = null;
	
	public void init() {
		/*
		 * ����count��pageSize ������ҳ��pageCount
		 */
		
		if(count % pageSize == 0)
			pageCount = count / pageSize;
		else
			pageCount = count / pageSize + 1;
				
		// �ж�ҳ���͵�ǰҳ��
		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		if (pageIndex < 1) {
			pageIndex = 1;
		}
		// ���ݵ�ǰҳ������ʼ�ͽ��� �� ��¼��
		this.start = (pageIndex - 1) * pageSize ;
		this.end = pageIndex * pageSize;
	}
	
	public PageBean(int pageIndex, int count, int pageSize) {
		super();
		this.pageIndex = pageIndex;
		this.count = count;
		this.pageSize = pageSize;
	}

	public PageBean(int pageIndex, int count, int pageSize, List<T> list) {
		super();
		this.pageIndex = pageIndex;
		this.count = count;
		this.pageSize = pageSize;
		this.list = list;
	}

	public PageBean() {
		super();
	}

	@Override
	public String toString() {
		return "PageBean [pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", count=" + count + ", pageCount="
				+ pageCount + ", start=" + start + ", end=" + end + ", list=" + list + "]";
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	

}
