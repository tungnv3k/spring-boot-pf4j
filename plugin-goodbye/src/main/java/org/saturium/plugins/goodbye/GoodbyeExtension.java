package org.saturium.plugins.goodbye;

import org.pf4j.Extension;
import org.saturium.appmain.MyPlugin;

@Extension
public class GoodbyeExtension implements MyPlugin {

    @Override
    public void performAction() {
        System.out.println("Goodbye from the PF4J plugin!");
    }
}
