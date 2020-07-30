package com.ssafy.emp;


public class EmpMgrImpl {
	
    /** 직원정보를 저장하기 위한 배열 */
	private Employee[] emps= new Employee[100];
	/** 저장된 직원 정보의 갯수를 기억하는 변수 */
	private  int index=0;
	
	/** 직원 정보를 저장하는 메서드 */
	public void add(Employee b) {


    	// 구현 하세요.
    	
	}

	/** 모든 직원 정보를 리턴하는 메서드 */
    public Employee[]  search(){
    	Employee[]  newemps=new Employee[index];


    	// 구현 하세요.
    	
    	return newemps;
    }

	/** 저장된 직원정보 중 직원번호를 검색하여 리턴하는 메서드 */
	public Employee search(int empNo) {


    	// 구현 하세요.
    	
		
		return null;	
	}
    
	/** 저장된 직원정보 중 직원이름을 검색하여 리턴하는 메서드 */
	public Employee[]  search(String name){
    	Employee[]  newemps=null;


    	// 구현 하세요.
    	
		
	    return newemps;
	}
    
	/** 저장된 직원정보 중 직원번호를 검색하여 부서를 수정하는 메서드 */
	public boolean update(int empNo, String dept)  {


    	// 구현 하세요.
    	
		
		return false;
	}

	/** 저장된 직원정보 중 직원번호를 검색하여 직원을 삭제하는 메서드 */
	public boolean delete(int empNo) {


    	// 구현 하세요.
    	
		
		return false;
	}
}
