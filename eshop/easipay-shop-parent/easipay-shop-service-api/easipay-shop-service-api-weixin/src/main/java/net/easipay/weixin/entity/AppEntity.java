package net.easipay.weixin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author fli
 * @version 1.0
 * @date 2020/3/1 17:42
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@AllArgsConstructor
public class AppEntity {

    /**
     * 应用id
     */
    private String appId;
    /**
     * 应用密钥
     */
    private String appSecret;
}
