package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.or.bit.dto.registerdto;
import kr.or.bit.utils.ConnectionHelper;

public class Mvcregisterdao {
	
	
	//CRUD
	
	public Mvcregisterdao() {
	}

	public int  writeOk(registerdto dto) {
		
		int resutlrow = 0;
		
		
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		String sql = "insert into mvcregister(id,pwd,email) values(?,?,?)";
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getEmail());
			
			resutlrow = pstmt.executeUpdate();
					
			
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		
		return resutlrow;
	}
}
