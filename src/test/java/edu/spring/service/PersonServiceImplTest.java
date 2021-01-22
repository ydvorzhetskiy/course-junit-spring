package edu.spring.service;

import edu.spring.repostory.PersonRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Collections.emptyList;
import static org.mockito.Mockito.*;

@DisplayName("Сервис PersonServiceImpl")
@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @InjectMocks
    private PersonServiceImpl service;
    @Mock
    private PersonRepository repository;

    @DisplayName("должен вызывать репозиторий при findAll()")
    @Test
    void shouldCallRepositoryOnFindAll() {
        when(repository.findAll()).thenReturn(emptyList());

        service.findAll();

        verify(repository, times(1)).findAll();
    }
}
