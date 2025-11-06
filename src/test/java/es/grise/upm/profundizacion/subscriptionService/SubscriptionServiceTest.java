package es.grise.upm.profundizacion.subscriptionService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import net.bytebuddy.asm.Advice.OnMethodEnter;

public class SubscriptionServiceTest {
    @Mock
    User User = mock(User.class);
    
    @Mock
    User LocalEmailUser = mock(User.class);
    
	@Test
    public void testNullUserException() {
        SubscriptionService servicio = new SubscriptionService();
        try {
            servicio.addSubscriber(null);
        } catch (NullUserException e) {
            assertEquals("User cannot be null", e.getMessage());
        }
    }
    @Test
    public void testExistingUserException() {
        SubscriptionService servicio = new SubscriptionService();
        servicio.addSubscriber(User);

        try {
            servicio.addSubscriber(User);
        } catch (ExistingUserException e) {
            assertEquals("User already subscribed", e.getMessage());
        }
    }

    @Test
    public void testLocalUserDoesNotHaveNullEmailException() {
        SubscriptionService servicio = new SubscriptionService();

        when(LocalEmailUser.getDelivery()).thenReturn(Delivery.LOCAL);
        when(LocalEmailUser.getEmail()).thenReturn("Example");

        try {
            servicio.addSubscriber(LocalEmailUser);
        } catch (LocalUserDoesNotHaveNullEmailException e) {
            assertEquals("User delivery is LOCAL and email is not null", e.getMessage());
        }
    }
}
