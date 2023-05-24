package com.demo.api.enumeration;

public enum FileExtensionType {
    JSON("json"),
    YAML("yaml"),
    CSV("csv"),
    TXT("txt"),
    ZIP("zip"),
    EXCEL("xlsx");

    private final String extensionTypeValue;

    private FileExtensionType(String extensionType) {
        this.extensionTypeValue = extensionType;
    }

    public String extensionTypeValue() {
        return this.extensionTypeValue;
    }
}
