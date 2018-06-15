package com.zzaki.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Zzaki
 * @Description:
 * @Date: Created on 2018/6/15
 * @Company: DeepWise
 */
public class FileBean implements Serializable {

    private static final long serialVersionUID = -1338554623842004501L;
    private long id;
    private String patientId;
    private String studyId;
    private String instanceId;
    private long instanceNo;
    private String filePath;
    private long fileSize;
    private String fileMd5;
    private Date createTime;
    private Date updateTime;

    public FileBean(long id, String patientId,
                    String studyId, String instanceId, long instanceNo, String filePath,
                    long fileSize, String fileMd5, Date createTime, Date updateTime) {
        this.id = id;
        this.patientId = patientId;
        this.studyId = studyId;
        this.instanceId = instanceId;
        this.instanceNo = instanceNo;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.fileMd5 = fileMd5;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getStudyId() {
        return studyId;
    }

    public void setStudyId(String studyId) {
        this.studyId = studyId;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public long getInstanceNo() {
        return instanceNo;
    }

    public void setInstanceNo(long instanceNo) {
        this.instanceNo = instanceNo;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "FileBean{" +
                "id=" + id +
                ", patientId='" + patientId + '\'' +
                ", studyId='" + studyId + '\'' +
                ", instanceId='" + instanceId + '\'' +
                ", instanceNo=" + instanceNo +
                ", filePath='" + filePath + '\'' +
                ", fileSize=" + fileSize +
                ", fileMd5='" + fileMd5 + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
