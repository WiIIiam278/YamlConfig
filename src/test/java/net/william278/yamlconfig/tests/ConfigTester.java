package net.william278.yamlconfig.tests;

import net.william278.yamlconfig.Config;
import org.jetbrains.annotations.TestOnly;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;

public class ConfigTester {

    @TestOnly
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(ConfigTester.class.getClassLoader().getResource("test-1.yml").getPath());
        Config config = Config.loadFile(file);
        Set<String> configKeys = config.getChildren();
        for (String string : configKeys) {
            System.out.println(string);
        }
    }

}
