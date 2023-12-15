package com.green.greengram3.dm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.greengram3.common.Const;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
public class DmSelDto {
    private int loginedIuser;
    private int page;


    @JsonIgnore
    private int startIdx;
    @JsonIgnore
    private int rowCount;

}
