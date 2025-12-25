public interface UserService {

    User register(User user);

    User findByEmail(String email);

    String login(String email, String password); // ✅ ADD THIS
}
