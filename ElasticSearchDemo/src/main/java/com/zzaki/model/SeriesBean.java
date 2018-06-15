package com.zzaki.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @Author: Zzaki
 * @Description:
 * @Date: Created on 2018/6/15
 * @Company: DeepWise
 */
public class SeriesBean implements Serializable {
    private static final long serialVersionUID = -1167397660077526902L;

    private long seriesId;
    private List<FileBean> fileList;

    public SeriesBean(){
        super();
    }
    public SeriesBean(long seriesId, List<FileBean> fileList) {
        this.seriesId = seriesId;
        this.fileList = fileList;
    }

    public long getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(long seriesId) {
        this.seriesId = seriesId;
    }

    public List<FileBean> getFileList() {
        return fileList;
    }

    public void setFileList(List<FileBean> fileList) {
        this.fileList = fileList;
    }

    @Override
    public String toString() {
        return "SeriesBean{" +
                "seriesId=" + seriesId +
                ", fileList=" + fileList +
                '}';
    }
}
