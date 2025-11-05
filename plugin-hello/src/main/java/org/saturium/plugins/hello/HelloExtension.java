package org.saturium.plugins.hello;

import org.pf4j.Extension;
import org.saturium.appmain.MyPlugin;

@Extension
public class HelloExtension implements MyPlugin {

    @Override
    public void performAction() {
        System.out.println("Hello from the PF4J plugin!");
    }
}
