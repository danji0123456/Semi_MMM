package notice.model.vo;

public class NoticeNickname {
	private String noticeCommentWriter;
	private String memberNickname;
	public NoticeNickname() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoticeNickname(String noticeCommentWriter, String memberNickname) {
		super();
		this.noticeCommentWriter = noticeCommentWriter;
		this.memberNickname = memberNickname;
	}
	public String getNoticeCommentWriter() {
		return noticeCommentWriter;
	}
	public void setNoticeCommentWriter(String noticeCommentWriter) {
		this.noticeCommentWriter = noticeCommentWriter;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	
	
	
	
}
