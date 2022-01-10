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

    /**
     * Load the {@link File} as a {@link Config} implementing {@link ConfigNode}
     *
     * @param file The YAML-based {@link File} to load
     * @return The loaded {@link Config} object
     * @throws FileNotFoundException If the file does not exist
     */
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
            if (nodeTrawl >= parents.length - 1) {
                return currentMap;
            }
            return getChild(parents, (nodeTrawl + 1), currentMap.get(parents[nodeTrawl]));
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private Set<String> getNodes(String path) {
        String[] parentNodes = path.split("\\.");
        int nodeTrawl = 0;
        Map<String, Object> deepestNode = getChild(parentNodes, nodeTrawl, configData);
        if (deepestNode != null) {
            if (deepestNode.get(parentNodes[parentNodes.length - 1]) instanceof Map) {
                return ((Map<String, Object>) deepestNode.get(parentNodes[parentNodes.length - 1])).keySet();
            }
        }
        return null;
    }

    @Override
    public Object get(String path) {
        final String[] parentNodes = path.split("\\.");
        int nodeTrawl = 0;
        Map<String, Object> child = getChild(parentNodes, nodeTrawl, configData);
        return child != null ? child.get(parentNodes[parentNodes.length - 1]) : null;
    }

    @Override
    public String getString(String path) {
        final Object object = get(path);
        return object != null ? (String) object : null;
    }

    @Override
    public String getString(String path, String fallback) {
        final String string = getString(path);
        return string != null ? string : fallback;
    }

    @Override
    public Boolean getBoolean(String path) {
        final Object object = get(path);
        return object != null ? (Boolean) object : null;
    }

    @Override
    public boolean getBoolean(String path, boolean fallback) {
        final Boolean bool = getBoolean(path);
        return bool != null ? bool : fallback;
    }

    @Override
    public Integer getInt(String path) {
        final Object object = get(path);
        return object != null ? (Integer) object : null;
    }

    @Override
    public int getInt(String path, int fallback) {
        final Integer integer = getInt(path);
        return integer != null ? integer : fallback;
    }

    @Override
    public Double getDouble(String path) {
        final Object object = get(path);
        return object != null ? (Double) object : null;
    }

    @Override
    public double getDouble(String path, double fallback) {
        final Double doubleNum = getDouble(path);
        return doubleNum != null ? doubleNum : fallback;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<String> getStringList(String path) {
        final Object object = get(path);
        return object != null ? (ArrayList<String>) object : null;
    }

    @Override
    public ArrayList<String> getStringList(String path, ArrayList<String> fallback) {
        return null;
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
