package com.homains.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "news")
public class News implements Serializable{
	
	private static final long serialVersionUID = 3435816542253090662L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "image")
	private String image;
	
	public News() {
	}
	
	public News(String title, String description, String image) {
		this.title = title;
		this.description = description;
		this.image = image;
	}

	public News(Long id, String title, String description, String image) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", description=" + description + ", image=" + image + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, image, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(image, other.image) && Objects.equals(title, other.title);
	}


}
