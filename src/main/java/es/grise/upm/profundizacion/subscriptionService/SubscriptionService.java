package es.grise.upm.profundizacion.subscriptionService;

import java.util.ArrayList;
import java.util.Collection;

public class SubscriptionService {

	private Collection <User> subscribers;
	
	/*
	 * Constructor
	 */
	public SubscriptionService() {
		this.subscribers = new ArrayList<>();
	}

	/*
	 * Method to code
	 */
	public void addSubscriber(User user) {
        if (user == null)
            throw new NullUserException("User cannot be null");

        if (subscribers.contains(user))
            throw new ExistingUserException("User already subscribed");

        if (user.getDelivery() == Delivery.LOCAL) {
			if (user.getEmail() ==  null) {
				
			} else {
				throw new LocalUserDoesNotHaveNullEmailException("User delivery is LOCAL and email is not null");
			}
		}
			

            
    }
	
	/*
	 * Other setters & getters
	 */
	public Collection <User> getSubscribers() {
		
		return subscribers;
		
	}

}
