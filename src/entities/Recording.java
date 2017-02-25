package entities;

/**
 *
 * @author micke
 */
public class Recording {
    private int sessionID, length;
    private String recID, name, lyrics, url, filePath, status, prevRec;

    public Recording(int sessionID, int length, String recID, String name, String lyrics, String url, String filePath, String status, String prevRec) {
        this.sessionID = sessionID;
        this.length = length;
        this.recID = recID;
        this.name = name;
        this.lyrics = lyrics;
        this.url = url;
        this.filePath = filePath;
        this.status = status;
        
        if (prevRec == null)
            this.prevRec = "N/A";
        else
            this.prevRec = prevRec;
    }

    /**
     * @return the studioID
     */
    public int getsessionID() {
        return sessionID;
    }

    /**
     * @param studioID the studioID to set
     */
    public void setsessionID(int studioID) {
        this.sessionID = sessionID;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the recID
     */
    public String getRecID() {
        return recID;
    }

    /**
     * @param recID the recID to set
     */
    public void setRecID(String recID) {
        this.recID = recID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lyrics
     */
    public String getLyrics() {
        return lyrics;
    }

    /**
     * @param lyrics the lyrics to set
     */
    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath the filePath to set
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the prevRec
     */
    public String getPrevRec() {
        return prevRec;
    }

    /**
     * @param prevRec the prevRec to set
     */
    public void setPrevRec(String prevRec) {
        this.prevRec = prevRec;
    }
    
    
    
    
}
