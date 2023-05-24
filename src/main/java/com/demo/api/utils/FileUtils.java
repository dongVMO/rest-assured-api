package com.demo.api.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
    private FileUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static File getFile(String rootDataFolder, String dataFolderPath, String fileName, String extensionType) {
        return new File(getFilePath(rootDataFolder, dataFolderPath, fileName, extensionType).toString());
    }

    public static String getFilePathString(String rootDataFolder, String dataFolderPath, String fileName, String extensionType) {
        return getFilePath(rootDataFolder, dataFolderPath, fileName, extensionType).toString();
    }

    private static Path getFilePath(String rootDataFolder, String dataFolderPath, String fileName, String fileExtensionType) {
        return Paths.get(System.getProperty("user.dir"), rootDataFolder, dataFolderPath, String.format("%s.%s", fileName, fileExtensionType));
    }

    public static File getFileByPath(String path) {
        return new File(path);
    }

    public static void deleteFile(String rootDataFolder, String dataFolderPath, String fileName, String extensionType) throws IOException {
        Path path = getFilePath(rootDataFolder, dataFolderPath, fileName, extensionType);
        Files.delete(path);
    }
}
