package com.green.greengram3.feed.model;

import com.green.greengram3.common.Const;
import lombok.Data;

@Data
public class FeedSelProcVo { //페이징 객체 /limit 에 사용
    private int starIdx; //몇번부터 불러올것인지
    private int row= Const.FEED_COUNT_PER_PAGE; //몇개를 가져올것인지


//    private FeedSelProcVo(int page){
//        this.starIdx=(page-1)*row;
//    }
}
