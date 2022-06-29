package promotion.dongwon.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.JdbcUtil;

import promotion.dongwon.domain.PromotionDTO;

public class PromotionDAOImpl implements PromotionDAO {
	
	// 1. 싱글톤
	private PromotionDAOImpl() {}
	private static PromotionDAO instance = new PromotionDAOImpl();
	public static PromotionDAO getInstance() {
		return instance;
	}

	@Override
	public List<PromotionDTO> promotionList(Connection con) throws SQLException {
		String sql = " select P_title, IMGVD_PATH , i.P_CODE " + 
				" from promotion p join PROMOTION_IMG i on p.P_CODE = i.P_CODE " + 
				" where (REGEXP_LIKE(i.P_CODE,'^P') and TO_CHAR(SYSDATE, 'MM/dd') <= TO_CHAR(P_ENDDATE, 'MM/dd')) OR i.P_CODE LIKE 'E%';";
		
		ArrayList<PromotionDTO> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				list = new ArrayList<PromotionDTO>();
				PromotionDTO dto = null;
				do {
					dto = new PromotionDTO();
					
					dto.setP_CODE(rs.getString("P_CODE"));
					dto.setP_title(rs.getString("P_title"));
					dto.setIMGVD_PATH(rs.getString("IMGVD_PATH"));
					
					list.add(dto);
				} while (rs.next());
			}
			
		} catch (Exception e) {
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		
		
		return null;
	}

}
