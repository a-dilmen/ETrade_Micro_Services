package com.dilmen.repository;

import com.dilmen.repository.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends ElasticsearchRepository<User,String> {

}
