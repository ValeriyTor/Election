public interface Registration {
    default Elector reg(String name, String login, String password) {
        return null;
    }
}