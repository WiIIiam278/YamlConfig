# YamlConfig
[![](https://jitpack.io/v/WiIIiam278/YamlConfig.svg)](https://jitpack.io/#WiIIiam278/YamlConfig)

Library that provides simple methods for reading basic data types from YAML config files for easy configs, inspired by [Bukkit's user-friendly approach](https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/configuration/file/FileConfiguration.html). It does not support writing config  files currently.

## Including
YamlConfig is available on JitPack.

### Maven
To use the library on Maven, in your `pom.xml` file, first add the JitPack repository:
```xml
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
```

Then, add the dependency in your `<dependencies>` section. Remember to replace `Tag` with the current YamlConfig version.
```xml
    <dependency>
        <groupId>com.github.WiIIiam278</groupId>
        <artifactId>YamlConfig</artifactId>
        <version>Tag</version>
        <scope>compile</scope>
    </dependency>
```

### Gradle & others
JitPack has a [handy guide](https://jitpack.io/#WiIIiam278/YamlConfig/#How_to) for how to use the dependency with other build platforms.