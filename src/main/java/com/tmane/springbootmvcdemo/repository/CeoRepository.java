package com.tmane.springbootmvcdemo.repository;

import com.tmane.springbootmvcdemo.entity.Ceo;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CeoRepository extends BaseRepository<Ceo, UUID> {
}
