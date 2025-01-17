package soloproject.rakshith.newspaper.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import soloproject.rakshith.newspaper.model.Category;
import soloproject.rakshith.newspaper.model.EndUser;
import soloproject.rakshith.newspaper.repository.CategoryRepository;
import soloproject.rakshith.newspaper.repository.UserRepository;



@Service
public class DefaultUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private CategoryRepository catRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		EndUser user = repository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));
		return new UserPrincipal(user);
	}
	
	public Optional<EndUser> findByUsername(String username){
		return repository.findByUsername(username);
	}
	
	public EndUser save(EndUser user) {
		return repository.save(user);
	}

	public void saveSubscriptions(EndUser subscriber, String[] subscriptions) {
		
		List<Category> subscriptionList = new ArrayList<Category>();
		
		for (String category : subscriptions) {
			
			Category c = catRepo.findByNameIgnoreCase(category).get();
			subscriptionList.add(c);
			}
		
		subscriber.setSubscriptions(subscriptionList);
		repository.saveAndFlush(subscriber);
		
	}
}
