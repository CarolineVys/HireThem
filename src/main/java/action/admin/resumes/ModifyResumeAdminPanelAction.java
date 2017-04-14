package action.admin.resumes;

import action.interceptor.AuthorizeAs;
import action.resumes.ModifyResumeAction;

@AuthorizeAs(admin = true)
public class ModifyResumeAdminPanelAction extends ModifyResumeAction {
}
