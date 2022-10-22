import java.util.ArrayList;

public class Users implements Enter, Registration {
    String name;
    String login;
    String password;

    public boolean enter(String login, String password)
    {
        if (this.login.equals(login) && this.password.equals(password))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    String getName()
    {
        return this.name;
    }

    public Elector reg(String name, String login, String password)
    {
        return new Elector(this.name = name, this.login = login, this.password = password);
    }
}
