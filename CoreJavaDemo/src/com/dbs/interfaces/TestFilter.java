package com.dbs.interfaces;

import java.util.Arrays;
import java.util.List;

public class TestFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nos=Arrays.asList(10,20,34,67,1,5,4);
		print(nos,(n)->n%2==0);
		print(nos,(n)->n%2!=0);
	}
	public static void print(List<Integer> list,Filter filter) {
		for(Integer no:list) {
			if(filter.find(no))
				System.out.println(no);
		}
	}

}
