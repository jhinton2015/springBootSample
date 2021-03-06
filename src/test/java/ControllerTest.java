import com.james.Controller.StudentController;
import com.james.Entity.Student;
import com.james.Service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(value = StudentController.class, secure = false)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    Student mockStudent = new Student(76, "Jojo", "Finance");

    @Test
    public void badID() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/76").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse());
        String expected = "{id:76,name:Jojo,course:Finance}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }
}
