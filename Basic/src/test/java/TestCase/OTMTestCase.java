package TestCase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Basic.Model.OTMcollege;
import com.Basic.Model.OTMcollege_employee;
import com.Basic.Model.OTMuniversity;
import com.Basic.Repository.OTMrepository;
import com.Basic.ServiceImpl.OTMserviceimpl;

@ExtendWith(MockitoExtension.class)
public class OTMTestCase {

    @Mock
    private OTMrepository otmrepository;

    @InjectMocks
    private OTMserviceimpl otMserviceimpl;

    @Test
    void testSaveData_success() {

        // -------- Arrange --------
        OTMuniversity university = new OTMuniversity();
        university.setUniversityname("ABC University");
        university.setUniversityrank(1);
        university.setUniversitylocation("India");

        OTMcollege_employee employee = new OTMcollege_employee();

        OTMcollege college = new OTMcollege();
        college.setOtmcollege_employee(List.of(employee)); // OK (not modified)

        // IMPORTANT: Mutable list
        List<OTMcollege> collegeList = new ArrayList<>();
        collegeList.add(college);
        university.setOtmcollege(collegeList);

        when(otmrepository.save(any(OTMuniversity.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // -------- Act --------
        OTMuniversity savedUniversity = otMserviceimpl.savedata(university);

        // -------- Assert --------
        assertNotNull(savedUniversity);
        assertEquals("ABC University", savedUniversity.getUniversityname());

        assertEquals(1, savedUniversity.getOtmcollege().size());
        assertEquals(savedUniversity, college.getOtmuniversity());
        assertEquals(college, employee.getOtmcollege());

        verify(otmrepository, times(1)).save(savedUniversity);
    }
}
