package action.vacancies;

import model.entity.User;
import model.service.CurrentUserService;
import model.service.VacancyService;
import model.service.exception.ServiceException;
import model.util.CsvGenerationUtil;
import model.util.PdfGenerationUtil;
import model.util.XlsGenerationUtil;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class DownloadVacancyAction extends ActionSupport {

    private VacancyService vacancyService = new VacancyService();

    private int vacancyId;
    private InputStream stream;

    public String downloadPdf() {
        try {
            stream = new ByteArrayInputStream(PdfGenerationUtil.getVacancyDocument(vacancyService.getVacancy(vacancyId)).toByteArray());
        } catch (Exception e) {
        }
        return SUCCESS;
    }

    public String downloadCsv() {
        try {
            stream = new ByteArrayInputStream(CsvGenerationUtil.generateVacancyInCSV(vacancyId).toByteArray());
        } catch (Exception e) {
        }
        return SUCCESS;
    }

    public String downloadXls() {
        try {
            stream = new ByteArrayInputStream(XlsGenerationUtil.generateVacancyInXls(vacancyId).toByteArray());
        } catch (Exception e) {
        }
        return SUCCESS;
    }

    public int getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(int vacancyId) {
        this.vacancyId = vacancyId;
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
