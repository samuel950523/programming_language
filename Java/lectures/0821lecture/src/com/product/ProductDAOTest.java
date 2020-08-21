package com.product;

import com.model.dao.ProductDAO;
import com.model.vo.Product;

public class ProductDAOTest {
	public static void main(String[] args) {
		ProductDAO pDao = new ProductDAO();
//		Product p = pDao.selectProduct("p0001");
//		Product p = pDao.selectProduct("' or 'a'<'b");
//		System.out.println(p);

		// insert
//		pDao.insertProduct(new Product("p0003", "노트20", 1000000, 1));
//		pDao.insertProduct(new Product("p0004", "노트10", 1000000, 1));

//		Product p = pDao.selectProduct("p0003");
//		System.out.println("insert");
//		System.out.println(p);
//		
//		// update
//		p.setAmount(50);
//		pDao.updateProduct(p);
//		System.out.println("\nupdate");
//		System.out.println(p);
//		
//		System.out.println("==================");
//		// selectAll
//		for (Product pd : pDao.selectProductList()) {
//			System.out.println(pd);
//		}
//		
//		pDao.deleteProduct("p0003");
//		System.out.println("\ndelete");
//		System.out.println("==================");
//		// selectAll
//		for (Product pd : pDao.selectProductList()) {
//			System.out.println(pd);
//		}

//		System.out.println("==================");
//		// selectName
//		for (Product pd : pDao.selectProductListByName("노트")) {
//			System.out.println(pd);
//		}

		Product[] products = { 
				new Product("p0010", "식세기3", 2000000, 10), 
				new Product("p0011", "건조기3", 1500000, 1)
				};
		
		pDao.insertProductListBatch(products);
		
		System.out.println("==================");
		for (Product pd : pDao.selectProductList()) {
			System.out.println(pd);
		}
	}
}
