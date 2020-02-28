package net.easipay.springcloud.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.naming.Name;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @author fli
 */

@NoArgsConstructor
@Data
@Accessors(chain = true)
@Entity
@Table(name = "dept")
public class Dept implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dept_name")
    private String 	deptName;

    /**
     * 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
     */
    @Column(name = "db_source")
    private String 	dbSource;


}
