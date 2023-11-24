package hu.unideb.inf.crud.utility;

import hu.unideb.inf.crud.service.DeveloperService;
import hu.unideb.inf.crud.uito.DeveloperUITO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Service
public class DeveloperConverter implements Converter {

    @Autowired
    private DeveloperService developerService;
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        DeveloperUITO developerUITO = new DeveloperUITO();
        developerUITO.setName(s);
        developerUITO = developerService.getDeveloper(developerUITO);

        return developerUITO;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o instanceof DeveloperUITO) {
            DeveloperUITO developerUITO = (DeveloperUITO) o;
            return developerUITO.getName();
        } else {
            StringBuilder sbError = new StringBuilder("Saját error - Object of class: ");
            sbError.append(o.getClass().getName()).append(" is not of DeveloperUITO");
            throw new ClassCastException(sbError.toString());
        }
    }
}
