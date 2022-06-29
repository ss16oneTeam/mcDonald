package promotion.minju.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import promotion.minju.domain.PromotionDTO;

public interface PromotionDAO {

    ArrayList<PromotionDTO> selectList(Connection con)throws SQLException;

	
}
