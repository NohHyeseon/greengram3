package com.green.greengram3.feed;

import com.green.greengram3.common.ResVo;

import com.green.greengram3.feed.model.FeedFavDto;
import com.green.greengram3.feed.model.FeedInsDto;
import com.green.greengram3.feed.model.FeedSelProcVo;
import com.green.greengram3.feed.model.FeedSelVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feed")
public class FeedController {
    private final FeedService service;

    @Operation(summary = " 피드등록 ", description = "피드등록처리")
    @PostMapping
    public ResVo postFeed(@RequestBody FeedInsDto dto) {
        return service.postFeed(dto);
    }

    @GetMapping
    public List<FeedSelVo> selFeed(FeedSelProcVo dto) {
        return service.selFeed(dto);
    }

    @GetMapping("/fav")
    public ResVo toggleFeedFav(FeedFavDto dto) {
        return service.toggleFeedFav(dto);

    }

}
