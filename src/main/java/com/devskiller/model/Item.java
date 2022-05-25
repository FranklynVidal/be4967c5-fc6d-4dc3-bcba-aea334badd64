package com.devskiller.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 100)
	@NotEmpty
	private String title;

	@Column(length = 200)
	private String description;

//  @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
//  Set<Review> reviews = new HashSet<>();

	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
	@Fetch(FetchMode.SUBSELECT)
	private Set<Review> reviews;

	public Item() {
	}

	public Item(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		reviews.add(review);
		review.setItem(this);
	}

	@Override
	public String toString() {
		return "\nItem{" + "id=" + id + ", title='" + title + '\'' + ", description='" + description + '\''
				+ ", reviews=" + reviews + '}';
	}
}
