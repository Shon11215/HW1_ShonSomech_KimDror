public class File {
    String fileName, fileType;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException("The fyle name must contain at least one character.");
        }
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        if (fileType == null) {
            throw new IllegalArgumentException("The file type must contain at least one character.");
        }
        this.fileType = fileType;
    }

    public File(String fileType, String fileName) {
        setFileName(fileName);
        setFileType(fileType);
    }

    @Override
    public String toString() {
        return "File { fileName='" + fileName + "', fileType='" + fileType + "' }";
    }
}
