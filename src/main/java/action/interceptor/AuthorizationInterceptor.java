package action.interceptor;

import model.entity.User;
import model.service.CurrentUserService;
import model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.commons.lang3.StringUtils;

public class AuthorizationInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(final ActionInvocation invocation) throws Exception {

        Object action = invocation.getAction();
        Class actionClass = action.getClass();
        AuthorizeAs annotation = (AuthorizeAs) actionClass.getAnnotation(AuthorizeAs.class);

        if (annotation == null) {
            return invocation.invoke();
        } else {
            CurrentUserService service = new CurrentUserService();
            User user = null;
            try {
                user = service.getCurrentUserEntity();
            } catch (ServiceException e) {
                return "loginRedirect";
            }

            if (user.getIsAdmin()) {
                return invocation.invoke();
            }
            if (!user.getIsAdmin() && annotation.admin()) {
                return "loginRedirect";
            }
            if (StringUtils.equals(annotation.userType(), "")) {
                return invocation.invoke();
            }
            if (!StringUtils.equals(annotation.userType(), user.getUserType().name())) {
                return "loginRedirect";
            }
            return invocation.invoke();
        }
    }
}
