package net.loobo.grit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;

public interface TmfTransactionRepository extends JpaRepository<TmfTransaction, Long> {

    @Override
    @NonNull
    Page<TmfTransaction> findAll(@NonNull Pageable pageable);

    @NonNull
    Page<TmfTransaction> findByBillingAccountNum(Long query, @NonNull Pageable pageable);


}
