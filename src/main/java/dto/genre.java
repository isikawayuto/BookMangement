package dto;

public class genre {
	
	private int genre_id;
	private String name;
	
	public genre(int genre_id, String name) {
		super();
		this.genre_id = genre_id;
		this.name = name;
	}

	public int getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
