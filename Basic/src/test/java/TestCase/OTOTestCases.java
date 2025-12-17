package TestCase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Basic.Model.OTOpersonModel;
import com.Basic.Model.OTOparentModel;
import com.Basic.Repository.OTOrepository;
import com.Basic.ServiceImpl.OTOserviceImpl;

@ExtendWith(MockitoExtension.class)
public class OTOTestCases {

    @Mock
    private OTOrepository repo;

    @InjectMocks
    private OTOserviceImpl service;

    @Test
    void testSaveData_success() {
        // Arrange
        OTOparentModel parent = new OTOparentModel();
        parent.setParentid(1);
        parent.setFname("John");

        OTOpersonModel person = new OTOpersonModel(
                1,
                "Alex",
                25,
                "Developer",
                parent
        );

        when(repo.save(person)).thenReturn(person);

        // Act
        OTOpersonModel savedPerson = service.save_data(person);

        // Assert
        assertEquals("Alex", savedPerson.getName());
        assertEquals(25, savedPerson.getAge());
        assertEquals("Developer", savedPerson.getJob());
        assertEquals("John", savedPerson.getOtoparentmodel().getFname());

        verify(repo).save(person);
    }
}
