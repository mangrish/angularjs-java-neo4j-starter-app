package com.mydomain.product.web.api.v1.config;

import javax.ws.rs.NameBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by markangrish on 13/04/2016.
 */
@NameBinding
@Retention(RetentionPolicy.RUNTIME)
public @interface Gzip
{
}
