package action.admin.vacancies;

import action.interceptor.AuthorizeAs;
import model.entity.User;
import model.service.CurrentUserService;
import model.service.exception.ServiceException;
import model.util.CsvGenerationUtil;
import model.util.PdfGenerationUtil;
import model.util.XlsGenerationUtil;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@AuthorizeAs(admin = true)
public class DownloadVacanciesReportAction extends ActionSupport {

    private InputStream stream;

    public String downloadPdf() {
        try {
            stream = new ByteArrayInputStream(PdfGenerationUtil.getVacanciesReport().toByteArray());
            return SUCCESS;
        } catch (Exception e) {
            return INPUT;
        }
    }

    public String downloadCsv() {
        try {
            stream = new ByteArrayInputStream(CsvGenerationUtil.generateVacanciesInCSV().toByteArray());
            return SUCCESS;
        } catch (Exception e) {
            return INPUT;
        }
    }

    public String downloadXls() {
        try {
            stream = new ByteArrayInputStream(XlsGenerationUtil.generateVacanciesInXls().toByteArray());
            return SUCCESS;
        } catch (Exception e) {
            return INPUT;
        }
    }

    public InputStream getStream() {
        return stream;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }
}
