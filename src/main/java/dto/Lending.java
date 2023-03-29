package dto;
import java.time.LocalDate;


public class Lending {
	
	private int lending_id;
	private String email;
	private int book_id;
	private LocalDate lending_date;
	private LocalDate deadline;
	private LocalDate return_date;
	
	public Lending(int lending_id, String email, int book_id, LocalDate lending_date, LocalDate deadline,
			LocalDate return_date) {
		super();
		this.lending_id = lending_id;
		this.email = email;
		this.book_id = book_id;
		this.lending_date = lending_date;
		this.deadline = deadline;
		this.return_date = return_date;
	}

	public int getLending_id() {
		return lending_id;
	}

	public void setLending_id(int lending_id) {
		this.lending_id = lending_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public LocalDate getLending_date() {
		return lending_date;
	}

	public void setLending_date(LocalDate lending_date) {
		this.lending_date = lending_date;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public LocalDate getReturn_date() {
		return return_date;
	}

	public void setReturn_date(LocalDate return_date) {
		this.return_date = return_date;
	}

}
