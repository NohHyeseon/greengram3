package com.green.greengram3.feed;


import com.green.greengram3.common.Const;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FeedService {
    private final FeedMapper mapper;
    private final FeedPicsMapper pmapper;

    public ResVo postFeed(FeedInsDto dto) {
        FeedInsProcDto dto1 = new FeedInsProcDto(dto);
        mapper.insFeed(dto1);
        FeedPicProcDto pic = new FeedPicProcDto(dto1);
        pmapper.insPic(pic);
        ResVo vo = new ResVo(pic.getIfeed());
        return vo;
    }

    public List<FeedSelVo> selFeed(int page) {
        FeedSelProcVo vo = new FeedSelProcVo();
        vo.setStarIdx((page - 1) * Const.FEED_COUNT_PER_PAGE);
        vo.setRow(Const.FEED_COUNT_PER_PAGE);

        List<FeedSelVo> feeds = (mapper.selFeed(vo));
        for(FeedSelVo feed: feeds ){ //왼쪽이 하나값 오른쪽이 여러개피드
            List<String> pics = pmapper.selFeedPic(feed.getIfeed());
            // 피드에 사진 넣어야됨
            // 넣음 당해야 되는 피드 : feed
            // 넣어 져야 하는 사진 : pics
            feed.setPics(pics);
            //전체 피드를 가져온후 여러개 피드에 ifeed값이 매칭되는 사진들을 하나씩 넣어준다
            //feed가 끝날때까지 List<String> pic = pmapper.selFeedPic(feed.getIfeed());

        }

//        -- 1page 0~19 (20ㄱㅐ) 2page 20~49 (20개)
//        -- (page-1)*20
        return feeds;
    }
}
