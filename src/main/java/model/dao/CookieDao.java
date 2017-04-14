package model.dao;

import model.service.exception.ServiceException;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;

public class CookieDao {

    public String get(String key) throws ServiceException {
        try {
            for (Cookie cookie : ServletActionContext.getRequest().getCookies()) {
                if (cookie.getName().equals(key)) {
                    return cookie.getValue();
                }
            }
        } catch (NullPointerException e ) {
            throw new ServiceException("Cookie not found", e);
        }
        throw new ServiceException("Cookie not found");
    }

    public void add(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        ServletActionContext.getResponse().addCookie(cookie);
    }

    public void remove(String key) {
        Cookie cookie = new Cookie(key, "");
        cookie.setMaxAge(0);
        ServletActionContext.getResponse().addCookie(cookie);
    }
}
