package com.bdlugosz.fleeter.bff.security;

import com.bdlugosz.fleeter.bff.model.Address;
import com.bdlugosz.fleeter.bff.model.BillingData;
import com.bdlugosz.fleeter.bff.model.DrivingLicence;
import com.bdlugosz.fleeter.bff.model.User;
import com.bdlugosz.fleeter.bff.repository.UserRepository;
import com.google.api.core.ApiFuture;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Component
public class FirebaseAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private FirebaseAuth firebaseAuth;

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean supports(Class<?> authentication) {
        return (FirebaseAuthenticationToken.class.isAssignableFrom(authentication));
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        final FirebaseAuthenticationToken authenticationToken = (FirebaseAuthenticationToken) authentication;

        ApiFuture<FirebaseToken> task = firebaseAuth.verifyIdTokenAsync(authenticationToken.getToken());
        try {
            FirebaseToken token = task.get();
            Optional<User> user = userRepository.findById(token.getUid());
            user.orElseGet(() -> createUser(token));

            return new FirebaseUserDetails(token.getEmail(), token.getUid());
        } catch (InterruptedException | ExecutionException e) {
            throw new SessionAuthenticationException(e.getMessage());
        }
    }

    private User createUser(FirebaseToken token) {
        Address userAddress = getAddress();
        BillingData billingData = getBillingdata();
        Address contactAddress = getAddress();
        DrivingLicence licence = getLicence();

        User user = User.builder()
                .email("kowal@gmail.com")
                .userAddress(userAddress)
                .billingData(billingData)
                .contactAddress(contactAddress)
                .firstName("Jan")
                .lastName("Kowalski")
                .licence(licence)
                .phoneNumber("666333666")
                .id(token.getUid())
                .build();
        User saved = userRepository.save(user);
        return saved;
    }

    private DrivingLicence getLicence() {
        return DrivingLicence.builder()
                .licenceNumber("NR546435468574")
                .expirationDate(LocalDate.now().plusMonths(100))
                .categoryList(Arrays.asList("A","B","C"))
                .build();
    }

    private BillingData getBillingdata() {
        return BillingData.builder()
                .bankName("Bank Name")
                .iban("PL24545346785342675865")
                .swift("KOD SWIFT")
                .name("Jan Kowalski")
                .build();
    }

    private Address getAddress() {
        return Address.builder()
                .city("City")
                .name("Imie Nazwisko")
                .street("ul. Kowalska 1 m.1")
                .build();
    }
}
