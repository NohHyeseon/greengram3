package com.green.greengram3.feed;

import com.green.greengram3.common.ResVo;

import com.green.greengram3.feed.model.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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
        log.info("dto = {}", dto);
        return service.selFeed(dto);
    }

    @GetMapping("/fav")
    public ResVo toggleFeedFav(FeedFavDto dto) {
        return service.toggleFeedFav(dto);

    }

    @DeleteMapping
    public ResVo delFeed(FeedDelDto dto) {
        log.info("dto: {}", dto);
        return service.delFeed(dto);
    }

}
