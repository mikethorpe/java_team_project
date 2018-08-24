package models;

import javax.persistence.*;

@Entity
@Table(name = "sections")
public class Section {

	private int id;
	private String title;

	public Section(String title) {
		this.title = title;
	}

	public Section() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
