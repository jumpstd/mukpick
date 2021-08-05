package com.jumpstd.mukpick.admin.mapper;

import com.jumpstd.mukpick.admin.domain.SearchMntDomain;
import com.jumpstd.mukpick.admin.dto.SearchRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchMntMapper {
    SearchMntDomain findOne(String searchText);

    List<SearchMntDomain> findList(SearchRequestDto searchRequestDTO);

    long save(String searchText);

    long delete(Long searchNo);

    long deleteAll();
}
