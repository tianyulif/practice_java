package net.easipay.springcloud.repository;

import net.easipay.springcloud.model.Dept;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author fli
 */
public interface DeptRepository extends JpaRepository<Dept, Long> {
}
