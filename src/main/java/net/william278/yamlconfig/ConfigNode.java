package net.william278.yamlconfig;

import java.util.ArrayList;
import java.util.Set;

/**
 * A config file with multiple nodes that may contain different data types
 */
public interface ConfigNode {

    /**
     * Get the {@link Object} at the desired path
     *
     * @param path Path to the object, represented by a {@link String}; nesting is represented by a period ({@code .}) character (e.g. {@code parent.child.subchild})
     * @return The {@link Object} at the path; {@code null} if the path is invalid
     */
    Object get(String path);

    /**
     * Get the {@link String} at the desired path
     *
     * @param path Path to the object, represented by a {@link String}; nesting is represented by a period ({@code .}) character (e.g. {@code parent.child.subchild})
     * @return The {@link String} at the path; {@code null} if the path is invalid
     * @throws ClassCastException if the {@link Object} at the path is not a {@link String}
     */
    String getString(String path);

    /**
     * Get the {@link String} at the desired path
     *
     * @param path     Path to the object, represented by a {@link String}; nesting is represented by a period ({@code .}) character (e.g. {@code parent.child.subchild})
     * @param fallback Fallback to return if the path is invalid
     * @return The {@link String} at the path, or the fallback if the path is invalid
     * @throws ClassCastException if the {@link Object} at the path is not a {@link String}
     */
    String getString(String path, String fallback);

    /**
     * Get the {@link Boolean} at the desired path
     *
     * @param path Path to the object, represented by a {@link String}; nesting is represented by a period ({@code .}) character (e.g. {@code parent.child.subchild})
     * @return The {@link Boolean} at the path; {@code null} if the path is invalid
     * @throws ClassCastException if the {@link Object} at the path is not a {@link Boolean}
     */
    Boolean getBoolean(String path);

    /**
     * Get the {@link Boolean} at the desired path
     *
     * @param path     Path to the object, represented by a {@link String}; nesting is represented by a period ({@code .}) character (e.g. {@code parent.child.subchild})
     * @param fallback Fallback to return if the path is invalid
     * @return The {@link Boolean} at the path, or the fallback if the path is invalid
     * @throws ClassCastException if the {@link Object} at the path is not a {@link Boolean}
     */
    boolean getBoolean(String path, boolean fallback);

    /**
     * Get the {@link Integer} at the desired path
     *
     * @param path Path to the object, represented by a {@link String}; nesting is represented by a period ({@code .}) character (e.g. {@code parent.child.subchild})
     * @return The {@link Integer} at the path; {@code null} if the path is invalid
     * @throws ClassCastException if the {@link Object} at the path is not a {@link Integer}
     */
    Integer getInt(String path);

    /**
     * Get the {@link Integer} at the desired path
     *
     * @param path     Path to the object, represented by a {@link String}; nesting is represented by a period ({@code .}) character (e.g. {@code parent.child.subchild})
     * @param fallback Fallback to return if the path is invalid
     * @return The {@link Integer} at the path, or the fallback if the path is invalid
     * @throws ClassCastException if the {@link Object} at the path is not a {@link Integer}
     */
    int getInt(String path, int fallback);

    /**
     * Get the {@link Double} at the desired path
     *
     * @param path Path to the object, represented by a {@link String}; nesting is represented by a period ({@code .}) character (e.g. {@code parent.child.subchild})
     * @return The {@link Double} at the path; {@code null} if the path is invalid
     * @throws ClassCastException if the {@link Object} at the path is not a {@link Double}
     */
    Double getDouble(String path);

    /**
     * Get the {@link Double} at the desired path
     *
     * @param path     Path to the object, represented by a {@link String}; nesting is represented by a period ({@code .}) character (e.g. {@code parent.child.subchild})
     * @param fallback Fallback to return if the path is invalid
     * @return The {@link Double} at the path, or the fallback if the path is invalid
     * @throws ClassCastException if the {@link Object} at the path is not a {@link Double}
     */
    double getDouble(String path, double fallback);

    /**
     * Get the {@link ArrayList} of {@link String}s at the desired path
     *
     * @param path Path to the object, represented by a {@link String}; nesting is represented by a period ({@code .}) character (e.g. {@code parent.child.subchild})
     * @return The {@link ArrayList} of {@link String}s  at the path; {@code null} if the path is invalid
     * @throws ClassCastException if the {@link Object} at the path is not an {@link ArrayList}
     */
    ArrayList<String> getStringList(String path);

    /**
     * Get the {@link ArrayList} of {@link String}s at the desired path
     *
     * @param path     Path to the object, represented by a {@link String}; nesting is represented by a period ({@code .}) character (e.g. {@code parent.child.subchild})
     * @param fallback Fallback to return if the path is invalid
     * @return The {@link ArrayList} of {@link String}s at the path, or the fallback if the path is invalid
     * @throws ClassCastException if the {@link Object} at the path is not an {@link ArrayList}
     */
    ArrayList<String> getStringList(String path, ArrayList<String> fallback);

    /**
     * Returns a list of nodes at the specified path. Does not return the children of nodes (i.e. nested nodes).
     *
     * @param path Path to fetch children of, represented by a {@link String}; nesting is represented by a period ({@code .}) character (e.g. {@code parent.child.subchild})
     * @return a {@link Set} of child {@link String} nodes at the specified node
     */
    Set<String> getChildren(String path);

    /**
     * Returns a list of nodes at the root of the file. Does not return the children of nodes (i.e. nested nodes).
     *
     * @return a {@link Set} of child {@link String} nodes at the root of the config file
     */
    Set<String> getChildren();
}
