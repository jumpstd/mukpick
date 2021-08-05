package com.jumpstd.mukpick.admin.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Getter
@RequiredArgsConstructor
@ToString
public class SearchMntDomain {
    private Long searchNo;
    private String searchText;
    private Date validDate;
    private Date registerDate;
    private Long searchCnt;

}