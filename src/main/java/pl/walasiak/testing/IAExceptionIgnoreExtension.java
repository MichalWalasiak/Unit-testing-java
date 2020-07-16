package pl.walasiak.testing;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.io.IOException;
import java.util.logging.Logger;

public class IAExceptionIgnoreExtension implements TestExecutionExceptionHandler {

    private static Logger logger = Logger.getLogger(IAExceptionIgnoreExtension.class.getName());

    @Override
    public void handleTestExecutionException(final ExtensionContext extensionContext, final Throwable throwable) throws Throwable {

        if (throwable instanceof IllegalArgumentException){
            logger.info("just ignore IllegalArgumentException");
        }else{
            throw throwable;
        }
    }
}
