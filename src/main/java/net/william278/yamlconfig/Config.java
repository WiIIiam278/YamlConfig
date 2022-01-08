package net.william278.yamlconfig;

import org.jetbrains.annotations.NotNull;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Represents a parsable yaml-based config file
 */
public class Config implements ConfigNode {

    protected final Map<String, Object> configData;

    private Config(Map<String, Object> configData) {
        this.configData = configData;
    }

    public static Config loadFile(@NotNull File file) throws FileNotFoundException {
        if (!file.exists()) throw new FileNotFoundException("File not loaded");
        final InputStream fileInputStream = new FileInputStream(file);
        Yaml yamlInput = new Yaml();
        Map<String, Object> configMap = yamlInput.load(fileInputStream);
        return new Config(configMap);
    }

    private Map<String, Object> getChild(String[] parents, int nodeTrawl, Object currentObject) {
        if (currentObject == null) {
            throw new NullPointerException("Invalid object");
        }
        if (currentObject instanceof Map) {
            @SuppressWarnings("unchecked") Map<String, Object> currentMap = (Map<String, Object>) currentObject;
            if (nodeTrawl >= parents.length-1) {
                return currentMap;
            }
            return getChild(parents, (nodeTrawl + 1), currentMap.get(parents[nodeTrawl]));
        }
        throw new IllegalArgumentException("Invalid node path");
    }

    @SuppressWarnings("unchecked")
    private Set<String> getNodes(String path) {
        String[] parentNodes = path.split("\\.");
        int nodeTrawl = 0;
        Map<String, Object> childObject = getChild(parentNodes, nodeTrawl, configData);
        if (childObject.get(path) instanceof Map) {
            return ((Map<String, Object>) childObject.get(path)).keySet();
        }
        throw new IllegalArgumentException("Invalid parent node path");
    }

    @Override
    public Object get(String path) {
        String[] parentNodes = path.split("\\.");
        int nodeTrawl = 0;
        return getChild(parentNodes, nodeTrawl, configData).get(parentNodes[parentNodes.length-1]);
    }

    @Override
    public String getString(String path) {
        return (String) get(path);
    }

    @Override
    public boolean getBoolean(String path) {
        return (Boolean) get(path);
    }

    @Override
    public int getInt(String path) {
        return (Integer) get(path);
    }

    @Override
    public double getDouble(String path) {
        return (Double) get(path);
    }

    @Override
    @SuppressWarnings ("unchecked")
    public ArrayList<String> getStringList(String path) {
        return (ArrayList<String>) get(path);
    }

    @Override
    public Set<String> getChildren(String path) {
        return getNodes(path);
    }

    @Override
    public Set<String> getChildren() {
        return configData.keySet();
    }
}
