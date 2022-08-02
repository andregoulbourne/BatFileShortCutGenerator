package com.utility.models;

import java.util.Objects;

public class ShortCutBATVO {

    private String pathWithEXEFile;

    private String writeOutPath;

    private String shortCutName;

    public String getPathWithEXEFile() {
        return pathWithEXEFile;
    }

    public void setPathWithEXEFile(String pathWithEXEFile) {
        this.pathWithEXEFile = pathWithEXEFile;
    }

    public String getWriteOutPath() {
        return writeOutPath;
    }

    public void setWriteOutPath(String writeOutPath) {
        this.writeOutPath = writeOutPath;
    }

    public String getShortCutName() {
        return shortCutName;
    }

    public void setShortCutName(String shortCutName) {
        this.shortCutName = shortCutName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ShortCutBATVO that = (ShortCutBATVO) o;
        return Objects.equals(pathWithEXEFile, that.pathWithEXEFile) && Objects.equals(writeOutPath, that.writeOutPath)
                && Objects.equals(shortCutName, that.shortCutName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pathWithEXEFile, writeOutPath, shortCutName);
    }

}
