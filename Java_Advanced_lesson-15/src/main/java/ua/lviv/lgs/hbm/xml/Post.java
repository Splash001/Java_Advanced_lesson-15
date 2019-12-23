package ua.lviv.lgs.hbm.xml;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String title;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL, CascadeType.PERSIST,
			CascadeType.MERGE }, mappedBy = "post")
	@Column(nullable = false)
	private Set<Comment> comments;

	public Post() {
	}

	public Post(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Post post = (Post) o;
		return title.equals(post.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title);
	}

	@Override
	public String toString() {
		return "Post{" + "id=" + id + ", title='" + title + '\'' + '}';
	}
}
