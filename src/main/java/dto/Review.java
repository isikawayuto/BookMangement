package dto;
import java.time.LocalDateTime;

public class Review {
	private int review_id;
	private String isbn;
	private String email;
	private String comment;
	private int point;
	private boolean view_flag;
	private LocalDateTime created_at;
	
	public Review(int review_id, String isbn, String email, String comment, int point, boolean view_flag,
			LocalDateTime created_at) {
		super();
		this.review_id = review_id;
		this.isbn = isbn;
		this.email = email;
		this.comment = comment;
		this.point = point;
		this.view_flag = view_flag;
		this.created_at = created_at;
	}
	
	
	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public boolean isView_flag() {
		return view_flag;
	}

	public void setView_flag(boolean view_flag) {
		this.view_flag = view_flag;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}



}
