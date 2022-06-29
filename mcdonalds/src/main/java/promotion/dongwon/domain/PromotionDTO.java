package promotion.dongwon.domain;

public class PromotionDTO {

		private String P_CODE;
		private String P_title;
		private String IMGVD_PATH;
		
		public PromotionDTO() {
			super();
		}
		
		public PromotionDTO(String p_CODE, String p_title, String iMGVD_PATH) {
			super();
			P_CODE = p_CODE;
			P_title = p_title;
			IMGVD_PATH = iMGVD_PATH;
		}

		public String getP_CODE() {
			return P_CODE;
		}

		public void setP_CODE(String p_CODE) {
			P_CODE = p_CODE;
		}

		public String getP_title() {
			return P_title;
		}

		public void setP_title(String p_title) {
			P_title = p_title;
		}

		public String getIMGVD_PATH() {
			return IMGVD_PATH;
		}

		public void setIMGVD_PATH(String iMGVD_PATH) {
			IMGVD_PATH = iMGVD_PATH;
		}
		
		
		
}
