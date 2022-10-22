public class Elector extends Users {

    boolean voted = false;

    Elector(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    boolean isVoted() {
        if (!voted) {
            return false;
        } else {
            return true;
        }
    }

    void vote() {
        voted = true;
    }

    String getName() {
        return this.name;
    }



}