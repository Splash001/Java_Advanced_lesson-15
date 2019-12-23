package ua.lviv.lgs.hbm.xml;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Arrays;
import java.util.HashSet;

public class Application {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		Session session = config.buildSessionFactory(serviceRegistry).openSession();

		Post post = new Post("Computers");

		Comment com1 = new Comment("Igor");
		Comment com2 = new Comment("Petro");
		Comment com3 = new Comment("Alex");

		post.setComments(new HashSet<>(Arrays.asList(com1, com2, com3)));
		com1.setPost(post);
		com2.setPost(post);
		com3.setPost(post);

		Transaction transaction = session.beginTransaction();

		session.save(post);

		transaction.commit();

		Post postDB = (Post) session.get(Post.class, 1);
		;
		System.out.println(postDB + " - " + postDB.getComments());

		Comment commentDB = (Comment) session.get(Comment.class, 3);
		System.out.println(commentDB + " - " + commentDB.getPost());

	}
}
