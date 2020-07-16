package pl.walasiak.testing;

import org.junit.jupiter.api.extension.*;

public class BeforeAfterExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(final ExtensionContext extensionContext) throws Exception {
        System.out.println("inside before each extension");
    }

    @Override
    public void afterEach(final ExtensionContext extensionContext) throws Exception {
        System.out.println("inside after each extension");
    }
}
