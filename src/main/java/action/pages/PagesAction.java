package action.pages;

import com.opensymphony.xwork2.ActionSupport;

public class PagesAction extends ActionSupport {

    public String about() {
        return "about";
    }

    public String contact() {
        return "contact";
    }

    public String faq() {
        return "faq";
    }

}
