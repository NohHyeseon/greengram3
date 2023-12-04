package com.green.greengram3.feed;


import com.green.greengram3.common.Const;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.green.greengram3.common.Const.FEED_COMMENT_FIRST_CNT;

@Slf4j
@RequiredArgsConstructor
@Service
public class FeedService {
    private final FeedMapper mapper;
    private final FeedPicsMapper pmapper;
    private final FeedFavMapper fmapper;
    private final FeedCommentMapper cmapper;

    public ResVo postFeed(FeedInsDto dto) {
        FeedInsProcDto dto1 = new FeedInsProcDto(dto);
        mapper.insFeed(dto1);
        FeedPicProcDto pic = new FeedPicProcDto(dto1);
        pmapper.insPic(pic);
        ResVo vo = new ResVo(pic.getIfeed());
        return vo;
    }

    public List<FeedSelVo> selFeed(FeedSelProcVo dto) {
        List<FeedSelVo> feeds = (mapper.selFeed(dto));
        FeedCommentSelDto fcDto = new FeedCommentSelDto();
        fcDto.setStartIdx(0);
        fcDto.setRowCount(4);
        for (FeedSelVo feed : feeds) { //왼쪽이 하나값 오른쪽이 여러개피드
            List<String> pics = pmapper.selFeedPic(feed.getIfeed());
            // 피드에 사진 넣어야됨
            // 넣음 당해야 되는 피드 : feed
            // 넣어 져야 하는 사진 : pics
            feed.setPics(pics);

            fcDto.setIfeed(feed.getIfeed());
            List<FeedCommentSelVo> comments = cmapper.selFeedCommentAll(fcDto);
            feed.setComments(comments);

            if(comments.size()==FEED_COMMENT_FIRST_CNT){
                feed.setIsMoreComment(1);
                comments.remove(comments.size()-1);
            }


            //전체 피드를 가져온후 여러개 피드에 ifeed값이 매칭되는 사진들을 하나씩 넣어준다
            //feed가 끝날때까지 List<String> pic = pmapper.selFeedPic(feed.getIfeed());

        }

//        -- 1page 0~19 (20ㄱㅐ) 2page 20~49 (20개)
//        -- (page-1)*20
        return feeds;
    }

    public ResVo toggleFeedFav(FeedFavDto dto) {
        //ResVo - resutl 값은 삭제했을 시(좋아요 취소) 0, return 등록했을시 1이 return
        //좋아요가 눌려져있으면 del 아니면 insert
        int del = fmapper.delFeedFav(dto);
        if (del == 1) {
            return new ResVo(0);
        } else {
            return new ResVo(fmapper.insFeedFav(dto));
        }
    }

    public ResVo delFeed(FeedDelDto dto){

        FeedDelDto iuser=mapper.selOneFeed(dto.getIfeed());

        if(iuser==null || dto.getIuser() != iuser.getIuser()){
            return new ResVo(0);
        }
        if(dto.getIuser()==iuser.getIuser()){
            mapper.delPic(dto.getIfeed());
            mapper.delComment(dto.getIfeed());
            mapper.delFav(dto.getIfeed());
            mapper.delFeed(dto.getIfeed());
            return new ResVo(1);
        }
        return new ResVo(1);
    }


}
