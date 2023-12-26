import org.example.testing.task.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.security.NoSuchProviderException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AddressService addressService;

    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository, addressService);
    }

    private User createUser(Integer id) {
        User user = new User();
        user.setUserId(id);
        user.setName("Тарас");
        user.setEmail("zonedd85@gmail.com");

        Address address = new Address();
        address.setAddressId(1);
        address.setCountry("Ukraine");
        address.setCity("Rivne");
        address.setStreet("Soborna");
        address.setBuilding("256");

        user.setAddress(address);
        user.setPhoneNumber("0961256789");
        user.setAge(19);

        return user;
    }

    @Test
    void getUserTest() throws NoSuchProviderException {
        User user = createUser(1);

        //1
        try {
        when(userRepository.findUser(1)).thenReturn(user);
        when(addressService.findAddress(1)).thenReturn(user.getAddress());

        User user1 = userService.getUser(1);

        assertEquals(user, user1 );
        assertEquals(user.getAddress(), user1 .getAddress());

        verify(userRepository, times(1)).findUser(1);
        verify(addressService, times(1)).findAddress(1);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //2
        try {
            User user2 = userService.getUser(null);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //null
        try {
            User user3 = userService.getUser(2);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void deleteUserTest() throws NoSuchProviderException {
        User user = createUser(1);

        //1
        try {
            when(userRepository.findUser(1)).thenReturn(user);
            when(addressService.findAddress(1)).thenReturn(user.getAddress());

            userService.deleteUser(1);

            verify(userRepository, times(1)).findUser(1);
            verify(addressService, times(1)).findAddress(1);
            verify(userRepository, times(1)).deleteUser(1);
            }
        catch (Exception e){
            e.printStackTrace();
        }

        //null
        try {
            userService.deleteUser(null);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void сreateUserTest() throws NoSuchProviderException {
        User user = createUser(1);

        //1
        try {
            when(addressService.addAddress(user.getAddress())).thenReturn(user.getAddress());
            assertThrows(IllegalArgumentException.class, ()->userService.createUser(user));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //null ID
        try {
            User user3 = user;
            user3.setUserId(null);
            when(addressService.addAddress(user3.getAddress())).thenReturn(user3.getAddress());
            assertThrows(IllegalArgumentException.class, ()->userService.createUser(user3));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //null Adress
        try {
            User user4 = new User();

            user4.setUserId(2);
            user4.setName("Тарас");
            user4.setEmail("zonedd85@gmail.com");
            user.setPhoneNumber("0961256789");
            user.setAge(19);

            when(addressService.addAddress(user4.getAddress())).thenReturn(user4.getAddress());
            assertThrows(IllegalArgumentException.class, ()->userService.createUser(user4));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //null Adress ID
        try {
            User user5 = user;

            user.setUserId(3);
            user.setName("Тарас");
            user.setEmail("zonedd85@gmail.com");

            Address address = new Address();
            address.setCountry("Ukraine");
            address.setCity("Rivne");
            address.setStreet("Soborna");
            address.setBuilding("256");

            user.setAddress(address);
            user.setPhoneNumber("0961256789");
            user.setAge(19);

            when(addressService.addAddress(user5.getAddress())).thenReturn(user5.getAddress());
            assertThrows(IllegalArgumentException.class, ()->userService.createUser(user5));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}