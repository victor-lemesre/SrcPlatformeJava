package exercice3.business;

import javax.ejb.Stateless;

import exercice3.LoginBean;
import exercice3.Dao.LoginDao;
import exercice3.Dao.LoginDaoImpl;

@Stateless
public class LoginBusinessImpl implements LoginBusiness {

    private LoginDao login;

    public LoginBusinessImpl() {
        this.login = new LoginDaoImpl();
    }

    @Override
    public Boolean isUserValid(LoginBean user) {

        return login.isUserValid(user);
    }

}
