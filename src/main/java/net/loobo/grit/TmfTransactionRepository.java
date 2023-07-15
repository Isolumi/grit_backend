package net.loobo.grit;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;

public interface TmfTransactionRepository extends JpaRepository<TmfTransaction, Long> {
    @NonNull
    Page<TmfTransaction> findByOrderByCreateTs(@NonNull Pageable pageable);

    @NonNull
    Page<TmfTransaction> findByBillingAccountNumOrderByCreateTs(Long query, @NonNull Pageable pageable);
}
