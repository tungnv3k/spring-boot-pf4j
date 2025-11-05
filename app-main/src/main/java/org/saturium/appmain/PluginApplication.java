package org.saturium.appmain;

import org.pf4j.DefaultPluginManager;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.saturium.appmain.MyPlugin;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PluginApplication {

    public static void main(String[] args) {
        SpringApplication.run(PluginApplication.class, args);
    }

    @Bean
    public PluginManager pluginManager() {
        return new DefaultPluginManager();
    }

    @Bean
    public CommandLineRunner runner(PluginManager pluginManager) {
        return args -> {
            pluginManager.loadPlugins();
            pluginManager.startPlugins();

            System.out.println("Loaded plugins:");
            for (PluginWrapper plugin : pluginManager.getPlugins()) {
                System.out.println(" -> " + plugin.getDescriptor().getPluginId());
            }

            pluginManager.getExtensions(MyPlugin.class)
                    .forEach(MyPlugin::performAction);
        };
    }
}
