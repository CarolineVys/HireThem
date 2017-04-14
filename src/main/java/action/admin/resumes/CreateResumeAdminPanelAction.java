package action.admin.resumes;

import action.interceptor.AuthorizeAs;
import action.resumes.CreateResumeAction;

@AuthorizeAs(admin = true)
public class CreateResumeAdminPanelAction extends CreateResumeAction {
}
