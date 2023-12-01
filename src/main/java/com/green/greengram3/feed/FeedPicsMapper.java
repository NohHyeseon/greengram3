package com.green.greengram3.feed;


import com.green.greengram3.feed.model.FeedPicProcDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedPicsMapper {
    int insPic(FeedPicProcDto dto);
    List<String> selFeedPic(int ifeed);

}
