package com.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.vo.Product;
import com.util.DBUtil;

// Data Access Object
public class ProductDAO {

//	public Product selectProduct(String no) {
//
//		String sql = "select * from product where product_no = '" + no + "'"; // 컬럼명을 하나씩 써주는게 좋다.
//			try (Connection conn = DBUtil.getConnection();
//					Statement stmt = conn.createStatement();
//					ResultSet rs = stmt.executeQuery(sql)) {
//				if (rs.next()) {
//					return new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
//				}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//}

	public Product selectProduct(String no) {

		String sql = "select * from product where product_no = ?"; // 컬럼명을 하나씩 써주는게 좋다.
		try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, no);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> selectProductList() {

		ArrayList<Product> pList = new ArrayList<>();
		String sql = "select * from product";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					pList.add(new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pList;
	}

	public boolean insertProduct(Product p) {
		String sql = "insert into product values (?,?,?,?)";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, p.getNo());
			stmt.setString(2, p.getName());
			stmt.setInt(3, p.getPrice());
			stmt.setInt(4, p.getAmount());

			return stmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 상품 번호 받아서 삭제
	public boolean deleteProduct(String no) {
		String sql = "delete from product where product_no = ?";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, no);

			return stmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 상품 번호 받아와서 상품의 이름, 가격, 수량 업데이트
	public boolean updateProduct(Product p) {
		String sql = "update product set product_name=?, product_price=?, product_amount=? where product_no=?";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, p.getName());
			stmt.setInt(2, p.getPrice());
			stmt.setInt(3, p.getAmount());
			stmt.setString(4, p.getNo());

			return stmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 상품명을 주면 그 상품명을 가지는 모든 제품 가져오기
	public List<Product> selectProductListByName(String name) {

		ArrayList<Product> pList = new ArrayList<>();
		String sql = "select * from product where product_name like ?";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, "%" + name + "%");
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					pList.add(new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pList;
	}

	public void insertProductList(Product[] products) {
		String sql = "insert into product values (?,?,?,?)";

		try (Connection conn = DBUtil.getConnection();) {

			conn.setAutoCommit(false); // 수동커밋
			try (PreparedStatement stmt = conn.prepareStatement(sql);) {
				for (Product p : products) {
					stmt.setString(1, p.getNo());
					stmt.setString(2, p.getName());
					stmt.setInt(3, p.getPrice());
					stmt.setInt(4, p.getAmount());

					stmt.executeUpdate();
				}
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void insertProductListBatch(Product[] products) {
		String sql = "insert into product values (?,?,?,?)";
		
		try (Connection conn = DBUtil.getConnection();) {
			
			conn.setAutoCommit(false); // 수동커밋
			try (PreparedStatement stmt = conn.prepareStatement(sql);) {
				for (Product p : products) {
					stmt.setString(1, p.getNo());
					stmt.setString(2, p.getName());
					stmt.setInt(3, p.getPrice());
					stmt.setInt(4, p.getAmount());
					
					stmt.addBatch();
				}
				stmt.executeBatch();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
