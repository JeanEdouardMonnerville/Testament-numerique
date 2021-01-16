
package galerie.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import galerie.entity.Transaction;

public interface TransactionRepository extends JpaRepository <Transaction, Integer> {
    
}
