package afterBeforeTest;

import afterBefore.AfterMethods;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import utils.StoreApiInfo;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

class AfterMethodsTests {

    @Test
    void afterMethodsTest() {
        try (MockedStatic storeApi = mockStatic(StoreApiInfo.class)) {
            storeApi.when(StoreApiInfo::clear).thenCallRealMethod();
            storeApi.when(StoreApiInfo::remove).thenCallRealMethod();
            AfterMethods afterMethods = new AfterMethods();
            afterMethods.removeRequestInfo();
            storeApi.verify(StoreApiInfo::clear, times(1));
            storeApi.verify(StoreApiInfo::remove, times(1));
        }
    }

}
