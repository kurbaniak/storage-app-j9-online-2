package akademia.localStorage.model;

import lombok.*;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class LocalFile {
    private String name;
    private String creationTime;
    private String lastModified;
    private Long size;
    private String deleteUri;
    private String downloadUri;
    private String fileType;

    private LocalFile(Builder builder){
        this.name = builder.name;
        this.creationTime = builder.creationTime;
        this.lastModified = builder.lastModified;
        this.size = builder.size;
        this.deleteUri = builder.deleteUri;
        this.downloadUri = builder.downloadUri;
        this.fileType = builder.fileType;
    }

    public static class Builder{
        private String name;
        private String creationTime;
        private String lastModified;
        private Long size;
        private String deleteUri;
        private String downloadUri;
        private String fileType;

        public Builder(){}

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder creationTime(String creationTime) {
            this.creationTime = creationTime;
            return this;
        }

        public Builder lastModified(String lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        public Builder size(Long size) {
            this.size = size;
            return this;
        }

        public Builder deleteUri(String deleteUri) {
            this.deleteUri = deleteUri;
            return this;
        }

        public Builder downloadUri(String downloadUri) {
            this.downloadUri = downloadUri;
            return this;
        }

        public Builder fileType(String fileType) {
            this.fileType = fileType;
            return this;
        }

        public LocalFile build(){
            return new LocalFile(this);
        }
    }
}
