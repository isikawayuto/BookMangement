package dto;

public class genre {
	
	private String genre_id;
	private String name;
	
	public genre(String genre_id, String name) {
		super();
		this.genre_id = genre_id;
		this.name = name;
	}

	public String getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(String genre_id) {
		this.genre_id = genre_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
