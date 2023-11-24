package hu.unideb.inf.crud.service;

import hu.unideb.inf.crud.uito.DeveloperUITO;

import java.util.List;

public interface DeveloperService {
    List<DeveloperUITO> getAllDeveloper();

    DeveloperUITO getDeveloper(DeveloperUITO developerUITO);

    public void deleteDepartment(Long id);
}
