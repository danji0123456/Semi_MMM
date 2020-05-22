package notice.model.vo;

public class NoticeRecommend {
	private String noticeRecommendId;
	private String noticeRecommendSearchId;
	public NoticeRecommend() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoticeRecommend(String noticeRecommendId, String noticeRecommendSearchId) {
		super();
		this.noticeRecommendId = noticeRecommendId;
		this.noticeRecommendSearchId = noticeRecommendSearchId;
	}
	public String getNoticeRecommendId() {
		return noticeRecommendId;
	}
	public void setNoticeRecommendId(String noticeRecommendId) {
		this.noticeRecommendId = noticeRecommendId;
	}
	public String getNoticeRecommendSearchId() {
		return noticeRecommendSearchId;
	}
	public void setNoticeRecommendSearchId(String noticeRecommendSearchId) {
		this.noticeRecommendSearchId = noticeRecommendSearchId;
	}
	
}
