package helper;

import io.restassured.internal.RequestSpecificationImpl;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
class ApiHelperTest {

    @Mock
    ApiHelper apiHelper;

    @Test
    void getInstance() {
        var instance = ApiHelper.getInstance();
        assertEquals(ApiHelper.class.getSimpleName(),instance.getClass().getSimpleName() );
    }

    @Test
    void getRequestSpecification() {
        var requestSpecification = ApiHelper.getInstance().getRequestSpecification();
        assertEquals(RequestSpecificationImpl.class.getSimpleName(),requestSpecification.getClass().getSimpleName() );
    }

    @Test
    void setRequestSpecification() {

    }

    @Test
    void init() {
    }

    @Test
    void defineNewRequest() {
    }
}