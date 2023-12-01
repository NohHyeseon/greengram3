package com.green.greengram3.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.greengram3.common.Const;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FeedSelProcVo { //페이징 객체 /limit 에 사용
    @Schema(title="페이지")
    private int page;
    @Schema(title="로그인한 유저pk")
    private int loginedIuser;
    @JsonIgnore
    private int starIdx; //몇번부터 불러올것인지
    @JsonIgnore
    private int row= Const.FEED_COUNT_PER_PAGE; //몇개를 가져올것인지


    public void setPage(int page){
        this.starIdx=(page-1)*row;
    }


//    private FeedSelProcVo(int page){
//        this.starIdx=(page-1)*row;
//    }
}
