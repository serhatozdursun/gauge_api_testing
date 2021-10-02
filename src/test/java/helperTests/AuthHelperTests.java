package helperTests;

import enums.RequestInfo;
import exceptions.RequestNotDefined;
import helper.AuthHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import utils.StoreApiInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AuthHelperTests {

    @Mock
    static MockedStatic<LogManager> loggerMockedStatic;

    @BeforeEach
    public void mockLogger() {
        Logger mockedLogger = mock(Logger.class);
        loggerMockedStatic = mockStatic(LogManager.class);
        loggerMockedStatic.when(() -> LogManager.getLogger(any(Class.class))).thenReturn(mockedLogger);
        doNothing().when(mockedLogger).info(anyString());
        doNothing().when(mockedLogger).error(anyString());

    }

    @Test
    @Order(0)
    void basicAuthNullRequestTest() {
        StoreApiInfo.remove(RequestInfo.REQUEST.info);
        Exception exception = assertThrows(RequestNotDefined.class,
                () -> new AuthHelper().basicAuth("test", "test"));
        String message = "To run this method, please first define a new request with the define newRequest() method.";
        assertEquals(message, exception.getMessage());
    }

    @AfterEach
    public void logUnInstall() {
        loggerMockedStatic.close();
        validateMockitoUsage();
    }

}
