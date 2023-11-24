package hu.unideb.inf.crud.service.impl;

import hu.unideb.inf.crud.dto.DeveloperDTO;
import hu.unideb.inf.crud.repository.DeveloperRepository;
import hu.unideb.inf.crud.service.DeveloperService;
import hu.unideb.inf.crud.uito.DeveloperUITO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DeveloperServiceImpl implements DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    @Override
    public List<DeveloperUITO> getAllDeveloper() {
        List<DeveloperUITO> developerUITOList = new ArrayList<>();
        List<DeveloperDTO> developerDTOList = developerRepository.findAll();

        developerDTOList.forEach(dto -> {
            DeveloperUITO tmpUiTO = new DeveloperUITO();

            BeanUtils.copyProperties(dto, tmpUiTO);
            developerUITOList.add(tmpUiTO);
        });

        return developerUITOList;
    }

    @Override
    public DeveloperUITO getDeveloper(DeveloperUITO developerUITO) {
        DeveloperDTO dto = developerRepository.findByName(developerUITO.getName());
        DeveloperUITO uito = new DeveloperUITO();

        BeanUtils.copyProperties(dto, uito);
        return uito;
    }

    @Override
    public void deleteDepartment(Long id) {
        DeveloperDTO dto = developerRepository.getReferenceById(id);

        developerRepository.save(dto);
    }
}
