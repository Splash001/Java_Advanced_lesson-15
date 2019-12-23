package ua.lviv.lgs.hbm.xml;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comments")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "author_name")
	private String authorName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "post_id", nullable = false)
	private Post post;

	public Comment() {
	}

	public Comment(String authorName) {
		this.authorName = authorName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Comment comment = (Comment) o;
		return authorName.equals(comment.authorName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorName);
	}

	@Override
	public String toString() {
		return "Comment{" + "id=" + id + ", authorName='" + authorName + '\'' + '}';
	}
}
