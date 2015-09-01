package com.deswaef.shadowfury.battlenet.api.auctions.model;

import java.util.List;

public class AuctionResponse {

    private List<AuctionResponseFile> files;

    public List<AuctionResponseFile> getFiles() {
        return files;
    }

    public void setFiles(List<AuctionResponseFile> files) {
        this.files = files;
    }

    public static class AuctionResponseFile{
        private String url;
        private Long lastModified;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Long getLastModified() {
            return lastModified;
        }

        public void setLastModified(Long lastModified) {
            this.lastModified = lastModified;
        }
    }
}
