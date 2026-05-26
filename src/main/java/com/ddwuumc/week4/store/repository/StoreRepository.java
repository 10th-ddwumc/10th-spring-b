package com.ddwuumc.week4.store.repository;

import com.ddwuumc.week4.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
