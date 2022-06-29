package promotion.dongwon.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import promotion.dongwon.domain.PromotionDTO;

public interface PromotionDAO {

	// 1. 글목록 : 페이징 처리 X
	List<PromotionDTO> promotionList(Connection con) throws SQLException;

}