package com.webmotech.database_migration_flyway_sample_project.util.map;

import com.webmotech.database_migration_flyway_sample_project.dto.BookDTO;
import com.webmotech.database_migration_flyway_sample_project.entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GlobalMapper {

    BookDTO bookEntityToBookDTO(BookEntity bookEntity);
    BookEntity bookDTOToBookEntity(BookDTO bookDTO);
}
