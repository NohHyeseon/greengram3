package com.green.greengram3.feed;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.FeedInsDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.assertArg;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Import({FeedService.class})
class FeedServiceTest {

    @MockBean
    private FeedMapper mapper;

    @MockBean
    private FeedPicsMapper pmapper;

    @MockBean
    private FeedCommentMapper cmapper;

    @MockBean
    private FeedFavMapper fmapper;

    @Autowired
    private FeedService service;

    @Test
    void postFeed() {
        when(mapper.insFeed(any())).thenReturn(1); // mapper메소드에 insfeed를 진짜 실행하지않고 1이return되게 만듬
        when(pmapper.insPic(any())).thenReturn(2);

        FeedInsDto dto = new FeedInsDto();

        ResVo vo = service.postFeed(dto);

        verify(mapper).insFeed(any()); //mapper에서 insFeed를진짜 호출했는지 확인
        verify(pmapper).insPic(any());


    }

    @Test
    void selFeed() {

    }

    @Test
    void toggleFeedFav() {
    }

    @Test
    void delFeed() {
    }
}