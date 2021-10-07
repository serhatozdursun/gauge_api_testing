package helperTests;

import enums.RequestInfo;
import helper.ApiHelper;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import utils.StoreApiInfo;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

class ApiHelperTest extends ApiHelper {

    @Test
    void defineNewRequestTest() {
        MockedStatic<StoreApiInfo> storeApiInfoMockedStatic = mockStatic(StoreApiInfo.class);

        storeApiInfoMockedStatic.when(() -> StoreApiInfo.remove(RequestInfo.REQUEST.info))
                .thenReturn(null);
        storeApiInfoMockedStatic.when(() -> StoreApiInfo.remove(RequestInfo.RESPONSE.info))
                .thenReturn(null);

        MockedStatic<RestAssured> restAssuredMockedStatic = mockStatic(RestAssured.class);
        restAssuredMockedStatic.when(() -> RestAssured.given()).thenReturn(null);

        storeApiInfoMockedStatic.when(() -> StoreApiInfo.put(RequestInfo.RESPONSE.info, null)).thenCallRealMethod();

        RequestSpecification result = defineNewRequest();

        assertNull(result);
        storeApiInfoMockedStatic.verify(() -> StoreApiInfo.remove(anyString()), times(2));
        restAssuredMockedStatic.verify(() -> RestAssured.given(), times(1));
        storeApiInfoMockedStatic.close();
    }
}
