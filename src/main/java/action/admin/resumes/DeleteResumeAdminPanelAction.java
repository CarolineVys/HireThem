package action.admin.resumes;

import action.interceptor.AuthorizeAs;
import action.resumes.DeleteResumeAction;

@AuthorizeAs(admin = true)
public class DeleteResumeAdminPanelAction extends DeleteResumeAction {
}
