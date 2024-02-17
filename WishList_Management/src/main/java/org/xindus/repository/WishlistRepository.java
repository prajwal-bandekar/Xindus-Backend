package org.xindus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xindus.entity.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer>{

}
