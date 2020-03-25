package com.app.car.rental.backend.mapper;

import com.app.car.rental.backend.domain.Search;
import com.app.car.rental.backend.domain.SearchDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchMapper {

    public Search mapToSearch(SearchDto searchDto){
        return new Search(searchDto.getId(), searchDto.getName());
    }

    public SearchDto mapToSearchDto(Search search){
        return new SearchDto(search.getId(), search.getName());
    }

    public List<Search> mapToListSearch(List<SearchDto> searchDtoList){
        return searchDtoList.stream()
                .map(t -> new Search(t.getId(), t.getName()))
                .collect(Collectors.toList());
    }

    public List<SearchDto> mapToLiastSearchDto(List<Search> searchList){
        return searchList.stream()
                .map(t -> new SearchDto(t.getId(), t.getName()))
                .collect(Collectors.toList());
    }
}
