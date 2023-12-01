package com.green.greengram3.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FeedInsDto {
    private int iuser;
    private String contents;
    private String location;
    private List<String> pics;


}
