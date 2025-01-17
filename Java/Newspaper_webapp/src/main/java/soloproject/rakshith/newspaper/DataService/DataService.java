package soloproject.rakshith.newspaper.DataService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import soloproject.rakshith.newspaper.model.Articles;
import soloproject.rakshith.newspaper.model.Category;
import soloproject.rakshith.newspaper.model.Role;
import soloproject.rakshith.newspaper.model.EndUser;
import soloproject.rakshith.newspaper.repository.ArticlesRepository;
import soloproject.rakshith.newspaper.repository.CategoryRepository;
import soloproject.rakshith.newspaper.repository.UserRepository;


@Service
public class DataService {

	@Autowired private UserRepository userRepository;
	@Autowired private PasswordEncoder encoder;
	@Autowired private ArticlesRepository artRepo;
	@Autowired private CategoryRepository catRepo;

	public void createUsers() {

		Role roleAdmin = new Role("Admin");
		Role roleEditor = new Role("Editor");
		Role roleContributor = new Role("Contributor");
		Role roleCustomer = new Role("Customer");

		EndUser admin = new EndUser("admin", encoder.encode("1234"), roleAdmin);
		userRepository.save(admin);

		EndUser editor = new EndUser("editor", encoder.encode("1234"), roleEditor);
		userRepository.save(editor);

		EndUser contributor = new EndUser("contributor", encoder.encode("1234"), roleContributor);
		userRepository.save(contributor);

		EndUser customer = new EndUser("customer", encoder.encode("1234"), roleCustomer);

		List<Category> category = new ArrayList<>();
		category.add(new Category("UK"));
		category.add(new Category("WORLD"));
		category.add(new Category("BUSINESS"));
		category.add(new Category("SPORTS"));
		category.add(new Category("HEALTH"));

		customer.setSubscriptions(category);
		userRepository.save(customer);

	}

	public void createArticles(LocalDate date) {

		List<String> category = Arrays.asList("UK", "WORLD", "BUSINESS", "SPORTS", "HEALTH");

		for (String c : category) {

			for (int i = 20; i < 30; i++) {
				Articles article = new Articles();

				if (i % 2 == 0) {
					article.setArticle("  <h2 style=\"color:Tomato; text-align:center;\">Random Heading</h2>\r\n"
							+ "					 					<p style=\"color:DodgerBlue;\">Far far away, behind the word mountains, \r\n"
							+ "					 					far from the countries Vokalia and Consonantia, there live the blind \r\n"
							+ "					 					texts. Separated they live in Bookmarksgrove right at the coast of \r\n"
							+ "					 					the Semantics, a large language ocean. A small river named Duden flows \r\n"
							+ "					 					by their place and supplies it with the necessary regelialia. It is a \r\n"
							+ "					 					paradisematic country, in which roasted parts of sentences fly into \r\n"
							+ "					 					your mouth. Even the all-powerful Pointing has no control about the \r\n"
							+ "					 					blind texts it is an almost unorthographic life One day however a \r\n"
							+ "					 					small line of blind text by the name of Lorem Ipsum decided to leave \r\n"
							+ "					 					for the far World of Grammar. The Big Oxmox advised her not to do so,\r\n"
							+ "					 					because there were thousands of bad Commas, wild Question Marks and \r\n"
							+ "					 					devious Semikoli, but the Little Blind Text didn’t listen. She packed\r\n"
							+ "					 					her seven versalia, put her initial into the belt and made herself on \r\n"
							+ "					 					the way. When she reached the first hills of the Italic Mountains, she \r\n"
							+ "					 					had a last view back on the skyline of her hometown Bookmarksgrove, the \r\n"
							+ "					 					headline of Alphabet Village and the subline of her own road, the Line \r\n"
							+ "					 					Lane. Pityful a rethoric question ran over her cheek, then</p>\r\n"
							+ "					 					<p style=\"color:MediumSeaGreen;\">Far far away, behind the word mountains, \r\n"
							+ "					 					far from the countries Vokalia and Consonantia, there live the blind \r\n"
							+ "					 					texts. Separated they live in Bookmarksgrove right at the coast of the \r\n"
							+ "					 					Semantics, a large language ocean. A small river named Duden flows by \r\n"
							+ "					 					their place and supplies it with the necessary regelialia. It is a \r\n"
							+ "					 					paradisematic country, in which roasted parts of sentences fly into your\r\n"
							+ "					 					mouth. Even the all-powerful Pointing has no control about the blind \r\n"
							+ "					 					texts it is an almost unorthographic life One day however a small line \r\n"
							+ "					 					of blind text by the name of Lorem Ipsum decided to leave for the far \r\n"
							+ "					 					World of Grammar. The Big Oxmox advised her not to do so, because\r\n"
							+ "					 					there were thousands of bad Commas, wild Question Marks and devious\r\n"
							+ "					 					Semikoli, but the Little Blind Text didn’t listen. She packed her seven\r\n"
							+ "					 					versalia, put her initial into the belt and made herself on the way.\r\n"
							+ "					 					When she reached the first hills of the Italic Mountains, she had a \r\n"
							+ "					 					last view back on the skyline of her hometown Bookmarksgrove, the headline\r\n"
							+ "					 					of Alphabet Village and the subline of her own road, the Line Lane. Pityful \r\n"
							+ "					 					a rethoric question ran over her cheek, then</p> \"  ");

					article.setHeadlines(true);
					article.setCategory(catRepo.findByNameIgnoreCase(c).get());
					article.setTitle(c + " title " + i);
					article.setTimeOfPublish(date);
					article.setPublished(true);

				} else {
					article.setArticle("  <h2 style=\"color:Tomato; text-align:center;\">Random Heading</h2>\r\n"
							+ "					 					<p style=\"color:DodgerBlue;\">Far far away, behind the word mountains, \r\n"
							+ "					 					far from the countries Vokalia and Consonantia, there live the blind \r\n"
							+ "					 					texts. Separated they live in Bookmarksgrove right at the coast of \r\n"
							+ "					 					the Semantics, a large language ocean. A small river named Duden flows \r\n"
							+ "					 					by their place and supplies it with the necessary regelialia. It is a \r\n"
							+ "					 					paradisematic country, in which roasted parts of sentences fly into \r\n"
							+ "					 					your mouth. Even the all-powerful Pointing has no control about the \r\n"
							+ "					 					blind texts it is an almost unorthographic life One day however a \r\n"
							+ "					 					small line of blind text by the name of Lorem Ipsum decided to leave \r\n"
							+ "					 					for the far World of Grammar. The Big Oxmox advised her not to do so,\r\n"
							+ "					 					because there were thousands of bad Commas, wild Question Marks and \r\n"
							+ "					 					devious Semikoli, but the Little Blind Text didn’t listen. She packed\r\n"
							+ "					 					her seven versalia, put her initial into the belt and made herself on \r\n"
							+ "					 					the way. When she reached the first hills of the Italic Mountains, she \r\n"
							+ "					 					had a last view back on the skyline of her hometown Bookmarksgrove, the \r\n"
							+ "					 					headline of Alphabet Village and the subline of her own road, the Line \r\n"
							+ "					 					Lane. Pityful a rethoric question ran over her cheek, then</p>\r\n"
							+ "					 					<p style=\"color:MediumSeaGreen;\">Far far away, behind the word mountains, \r\n"
							+ "					 					far from the countries Vokalia and Consonantia, there live the blind \r\n"
							+ "					 					texts. Separated they live in Bookmarksgrove right at the coast of the \r\n"
							+ "					 					Semantics, a large language ocean. A small river named Duden flows by \r\n"
							+ "					 					their place and supplies it with the necessary regelialia. It is a \r\n"
							+ "					 					paradisematic country, in which roasted parts of sentences fly into your\r\n"
							+ "					 					mouth. Even the all-powerful Pointing has no control about the blind \r\n"
							+ "					 					texts it is an almost unorthographic life One day however a small line \r\n"
							+ "					 					of blind text by the name of Lorem Ipsum decided to leave for the far \r\n"
							+ "					 					World of Grammar. The Big Oxmox advised her not to do so, because\r\n"
							+ "					 					there were thousands of bad Commas, wild Question Marks and devious\r\n"
							+ "					 					Semikoli, but the Little Blind Text didn’t listen. She packed her seven\r\n"
							+ "					 					versalia, put her initial into the belt and made herself on the way.\r\n"
							+ "					 					When she reached the first hills of the Italic Mountains, she had a \r\n"
							+ "					 					last view back on the skyline of her hometown Bookmarksgrove, the headline\r\n"
							+ "					 					of Alphabet Village and the subline of her own road, the Line Lane. Pityful \r\n"
							+ "					 					a rethoric question ran over her cheek, then</p> \"  ");

					article.setHeadlines(false);
					article.setCategory(catRepo.findByNameIgnoreCase(c).get());
					article.setTitle(c + " title " + i);
					article.setTimeOfPublish(date);
					article.setPublished(true);

				}
				;
				artRepo.save(article);
			}
		}
	}
}
