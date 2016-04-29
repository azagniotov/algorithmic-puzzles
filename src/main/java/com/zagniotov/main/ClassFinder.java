package com.zagniotov.main;


import java.io.File;
import java.net.URL;
import java.util.*;

final class ClassFinder {

    private static final char PKG_SEPARATOR = '.';
    private static final char DIR_SEPARATOR = '/';
    private static final String CLASS_FILE_SUFFIX = ".class";
    private static final String BAD_PACKAGE_ERROR = "Unable to get resources from path '%s'. Are you sure the package '%s' exists?";

    private final String rootPackage;
    private final Set<String> packagesToSkip;

    ClassFinder(final String rootPackage, final Set<String> packagesToSkip) {
        this.rootPackage = rootPackage;
        this.packagesToSkip = packagesToSkip;
    }

    public Set<String> find() {
        final String scannedPath = this.rootPackage.replace(PKG_SEPARATOR, DIR_SEPARATOR);
        final URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(scannedPath);
        if (scannedUrl == null) {
            throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR, scannedPath, this.rootPackage));
        }
        final File scannedDir = new File(scannedUrl.getFile());
        final Set<String> classes = new HashSet<>();
        for (File file : scannedDir.listFiles()) {
            if (!packagesToSkip.contains(file.getName())) {
                classes.addAll(find(file, this.rootPackage));
            }
        }
        return classes;
    }

    private List<String> find(final File file, final String currentPackage) {
        final List<String> classes = new ArrayList<>();
        final String resource = currentPackage + PKG_SEPARATOR + file.getName();
        if (file.isDirectory()) {
            for (final File child : file.listFiles()) {
                classes.addAll(find(child, resource));
            }
        } else if (resource.endsWith(CLASS_FILE_SUFFIX)) {
            int endIndex = resource.length() - CLASS_FILE_SUFFIX.length();
            try {
                final Class<?> clazzor = Class.forName(resource.substring(0, endIndex));
                classes.add(clazzor.getCanonicalName().replaceAll("(.*)Take([0-9])", "$1").replaceAll(this.rootPackage + ".", ""));
            } catch (ClassNotFoundException ignore) {

            }
        }
        return classes;
    }
}
