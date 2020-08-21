package com.hw;


public class EmpTest {
	public static void main(String[] args) {
		EmpMgrImpl eMgr = EmpMgrImpl.getInstance(); // Singleton Pattern
		
		System.out.println("=== add ===");
		eMgr.add(new Employee(1, "Kim", "p1", "d1"));
		eMgr.add(new Employee(2, "Lee", "p2", "d2"));
		eMgr.add(new Employee(3, "Park", "p3", "d3"));
		eMgr.add(new Employee(4, "Kay", "p4", "d4"));
		System.out.println("=== complete add ===");
		
		System.out.println();

		System.out.println("=== search all ===");
		for (Employee emp : eMgr.search()) {
			System.out.println(emp);
		}
		System.out.println("=== complete search all ===");
		
		System.out.println();
		
		System.out.println("=== search empNo ===");
		System.out.println(eMgr.search(3)); // Park
		System.out.println("=== complete search empNo ===");
		
		System.out.println();

		System.out.println("=== search name ===");
		for (Employee emp : eMgr.search("K")) {
			System.out.println(emp); // Kim, Park, Kay
		}
		System.out.println("=== complete search name ===");
		
		System.out.println();

		System.out.println("=== update ===");
		eMgr.update(4, "d5");
		System.out.println("=== complete update ===");
		for (Employee emp : eMgr.search()) {
			System.out.println(emp);
		}
		
		System.out.println();

		System.out.println("=== delete ===");
		eMgr.delete(2); // delete Lee
		System.out.println("=== complete delete ===");
		for (Employee emp : eMgr.search()) {
			System.out.println(emp);
		}


		
	}
}
