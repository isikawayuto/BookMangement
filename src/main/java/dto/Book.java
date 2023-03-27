package dto;

public class Book {
	private int book_id;
	private String isbn;
	private int genre_id;
	private String title;
	private String author;
	private String publisher;
	private boolean new_old;
	private String title_kana;
	private String author_kana;
	
	
	public Book(int book_id, String isbn, int genre_id, String title, String author, String publisher,
			boolean new_old, String title_kana, String author_kana) {
		super();
		this.book_id = book_id;
		this.isbn = isbn;
		this.genre_id = genre_id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.new_old = new_old;
		this.title_kana = title_kana;
		this.author_kana = author_kana;
	}
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public boolean getNew_old() {
		return new_old;
	}
	public void setNew_old(boolean new_old) {
		this.new_old = new_old;
	}
	public String getTitle_kana() {
		return title_kana;
	}
	public void setTitle_kana(String title_kana) {
		this.title_kana = title_kana;
	}
	public String getAuthor_kana() {
		return author_kana;
	}
	public void setAuthor_kana(String author_kana) {
		this.author_kana = author_kana;
	}
	

}
