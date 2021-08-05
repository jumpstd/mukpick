package com.jumpstd.mukpick.admin.mapper;

import com.jumpstd.mukpick.admin.domain.SearchMntDomain;
import com.jumpstd.mukpick.admin.dto.SearchRequestDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DisplayName("Admin - 검색관리 테스트")
class SearchMntMapperTest {
    @Autowired SearchMntMapper searchMntMapper;

    @BeforeEach
    @DisplayName("초기화 메서드 - 데이터 2개 세팅")
    public void init(){
        String text1 = "라볶이";
        searchMntMapper.save(text1);

        String text2 = "마라탕";
        searchMntMapper.save(text2);

    }

    @AfterEach
    @DisplayName("종료 메서드 - 전체 삭제")
    public void clear(){
        searchMntMapper.deleteAll();
    }

    @Test
    @DisplayName("하나 조회")
    public void findOneTest(){
        // given
        String text = "마라탕";
        // when
        SearchMntDomain result = searchMntMapper.findOne(text);
        // then
        assertThat(result.getSearchText()).isEqualTo(text);

    }

    @Test
    @DisplayName("전체 리스트 조회 - dto의 searchText가 null이면 전체 리스트를 조회해온다.")
    public void findAllTest(){
        // given
        SearchRequestDto dto = new SearchRequestDto();
        // when
        List<SearchMntDomain> searchMntList = searchMntMapper.findList(dto);
        // then
        assertThat(searchMntList.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("검색조회")
    public void searchTest() {
        // given
        SearchRequestDto searchRequestDTO = new SearchRequestDto();
        searchRequestDTO.setSearchText("마라탕");
        // when
        List<SearchMntDomain> searchResult = searchMntMapper.findList(searchRequestDTO);
        // then
        assertThat(searchResult.get(0).getSearchText()).isEqualTo("마라탕");
    }


    @Test
    @DisplayName("저장")
    public void saveTest(){
        // given
        String text = "라볶이";
        SearchRequestDto dto = new SearchRequestDto();
        dto.setSearchText(text);

        // when
        List<SearchMntDomain> result = searchMntMapper.findList(dto);
        // then
        assertThat(result.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    @DisplayName("선택삭제")
    public void deleteOne(){
        // given
        String deleteText = "라볶이";
        SearchMntDomain searchData = searchMntMapper.findOne(deleteText);
        Long searchNo = searchData.getSearchNo();
        // when
        searchMntMapper.delete(searchNo);
        // then
        SearchMntDomain result = searchMntMapper.findOne(deleteText);
        assertThat(result).isEqualTo(null);
    }
}