package net.william278.yamlconfig;

import java.util.ArrayList;
import java.util.Set;

public interface ConfigNode {

    Object get(String path);

    String getString(String path);

    boolean getBoolean(String path);

    int getInt(String path);

    double getDouble(String path);

    ArrayList<String> getStringList(String path);

    Set<String> getChildren(String path);

    Set<String> getChildren();
}
