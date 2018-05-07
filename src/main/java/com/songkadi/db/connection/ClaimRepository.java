package com.songkadi.db.connection;

import com.songkadi.db.entity.Claim;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ClaimRepository extends CrudRepository<Claim, String> {

    Collection<Claim> findAll();
}
