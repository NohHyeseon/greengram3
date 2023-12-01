package com.green.greengram3.feed.model;

import lombok.Data;

import java.util.List;

@Data
public class FeedSelVo { //전체피드 가져오기
    private int ifeed;
    private String contents;
    private String location;
    private String createdAt;
    private String writerIuser;
    private String writerNm;
    private String writerPic;
    private List<String> pics;
}
