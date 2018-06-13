package com.zzaki.model;

import java.io.Serializable;

/**
 * @Author: Zzaki
 * @Description:
 * @Date: Created on 2018/6/13
 * @Company: DeepWise
 */
public class PaperBean implements Serializable {

    private static final long serialVersionUID = -6244449972936839362L;
    private static final String INDEX_NAME = "deepwise";
    private static final String TYPE = "paper";
    private Long paperId;
    private String paperAuthor;
    private String paperContent;

    public PaperBean(){
        super();
    }

    public PaperBean(Long paperId,String paperAuthor,String paperContent){
        this.paperId = paperId;
        this.paperAuthor = paperAuthor;
        this.paperContent = paperContent;
    }

    public long getPaperId() {
        return paperId;
    }

    public void setPaperId(long paperId) {
        this.paperId = paperId;
    }

    public String getPaperAuthor() {
        return paperAuthor;
    }

    public void setPaperAuthor(String paperAuthor) {
        this.paperAuthor = paperAuthor;
    }

    public String getPaperContent() {
        return paperContent;
    }

    public void setPaperContent(String paperContent) {
        this.paperContent = paperContent;
    }

    @Override
    public String toString() {
        return "PaperBean{" +
                "paperId=" + paperId +
                ", paperAuthor='" + paperAuthor + '\'' +
                ", paperContent='" + paperContent + '\'' +
                '}';
    }
}
